import numpy as np


# Tokenize the data.
def tokenize_data(data_path, num_samples, max_input_length, max_target_length):
    # Variable declarations
    input_texts = []
    target_texts = []
    input_tokens = set()
    target_tokens = set()
    with open(data_path + 'pytok', 'r', encoding='utf-8') as f:
        input_lines = f.read().split('\n')
    with open(data_path + 'entok', 'r', encoding='utf-8') as f:
        target_lines = f.read().split('\n')
    input_lines = input_lines[: min(num_samples, len(input_lines) - 1)]
    target_lines = target_lines[: min(num_samples, len(target_lines) - 1)]
    for input_text, target_text in zip(input_lines, target_lines):
        # Throwing out long texts
        if len(input_text) > max_input_length or len(target_text) > max_target_length:
            continue
        # Replace problematic characters that're basically spaces!
        for char in ['\u2009', '\u202f', '\xa0']:
            target_text = target_text.replace(char, ' ')
        input_texts.append(input_text)
        target_texts.append(target_text)
        # Dealing with numbers
        for token in input_text.split():
            if token.isdigit():
                for char in token:
                    token = token.replace(char, char + " ")
                for digit in token.split():
                    input_tokens.add(digit)
            else:
                input_tokens.add(token)
        for token in target_text.split():
            if token.isdigit():
                for char in token:
                    token = token.replace(char, char + " ")
                for digit in token.split():
                    target_tokens.add(digit)
            else:
                target_tokens.add(token)

    # Return desired data, with tokens being sorted and converted to lists
    return sorted(list(input_tokens)), sorted(list(target_tokens)), input_texts, target_texts


# To solve tokenization issues, convert sentences into lists of words
def list_texts(texts):
    lists = []
    # Loop through all the texts
    for txt in texts:
        a_list = []
        # Loop the tokens of a text
        for token in txt.split():
            if token.isdigit():
                # tokenize the digits independently
                for char in token:
                    token = token.replace(char, char + " ")
                for digit in token.split():
                    a_list.append(digit)
            # If not a digit, take token as is
            else:
                a_list.append(token)
        # Append to the list of lists
        lists.append(a_list)
    return lists


# Get data
def retrieve_texts(data_path, num_samples, max_input_length, max_target_length):
    input_tokens, target_tokens, input_texts, target_texts = tokenize_data(data_path, num_samples, max_input_length, max_target_length)
    input_lists = list_texts(input_texts)
    target_lists = list_texts(target_texts)
    # add "<unknown>" token for unknown words during testing, "<sop>" for target start-of-sequence token, and
    # "<eop>" for end-of-sequence token
    input_tokens = ["<pad/unknown>"] + input_tokens
    target_tokens = ["<pad/unknown>"] + target_tokens + ["<sop>", "<eop>"]
    # Add <sop> and <eop> to target lists
    for i in range(len(target_lists)):
        target_lists[i] = ["<sop>"] + target_lists[i] + ["<eop>"]

    return input_texts, target_texts, input_lists, target_lists, input_tokens, target_tokens


class DataObject:
    def __init__(self, input_texts, target_texts, input_lists, target_lists, input_tokens, target_tokens):
        self.input_texts = input_texts
        self.target_texts = target_texts
        self.input_lists = input_lists
        self.target_lists = target_lists
        self.input_tokens = input_tokens
        self.target_tokens = target_tokens

def data_shapes(do):
    num_encoder_tokens = len(do.input_tokens)
    num_decoder_tokens = len(do.target_tokens)
    max_encoder_seq_length = max([len(txt) for txt in do.input_lists])
    max_decoder_seq_length = max([len(txt) for txt in do.target_lists])
    n_input_samples = len(do.input_lists)

    return num_encoder_tokens, num_decoder_tokens, max_encoder_seq_length, max_decoder_seq_length, n_input_samples


def shape_info(n_input_samples, num_encoder_tokens, num_decoder_tokens, max_encoder_seq_length, max_decoder_seq_length):
    print('Number of samples:', n_input_samples)
    print('Number of unique input tokens:', num_encoder_tokens)
    print('Number of unique output tokens:', num_decoder_tokens)
    print('Max sequence length for inputs:', max_encoder_seq_length)
    print('Max sequence length for outputs:', max_decoder_seq_length)


def token_integer_mapping(input_tokens, target_tokens):
    input_token_index = dict([(token, i) for i, token in enumerate(input_tokens)])
    target_token_index = dict([(token, i) for i, token in enumerate(target_tokens)])
    reverse_input_token_index = dict((i, token) for token, i in input_token_index.items())
    reverse_target_token_index = dict((i, token) for token, i in target_token_index.items())
    
    return input_token_index, target_token_index, reverse_input_token_index, reverse_target_token_index


def prepare_model_data(input_lists, target_lists, input_token_index, target_token_index, n_input_samples, max_encoder_seq_length, max_decoder_seq_length, num_decoder_tokens):
    # Define input & output data and initialize them with zeros
    encoder_input_data =  np.zeros((n_input_samples, max_encoder_seq_length), dtype='int32')
    decoder_input_data =  np.zeros((n_input_samples, max_decoder_seq_length), dtype='int32')
    decoder_target_data = np.zeros((n_input_samples, max_decoder_seq_length, num_decoder_tokens), dtype='float32')
    # fill input data & one-hot encode targets
    # Loop samples
    for i, (input_list, target_list) in enumerate(zip(input_lists, target_lists)):
        # Loop input sequences
        for t, token in enumerate(input_list):
            encoder_input_data[i, t] = input_token_index[token] if token in input_token_index.keys() else 0
        # Loop target sequences
        for t, token in enumerate(target_list):
            int_value = target_token_index[token] if token in target_token_index.keys() else 0
            # decoder_target_data is ahead of decoder_input_data by one time step
            decoder_input_data[i, t] = int_value
            if t > 0:
                # decoder_target_data will be ahead by one time step and will not include the start character. Initial value altered.
                decoder_target_data[i, t-1, int_value] = 1.
        decoder_target_data[i, t, 0] = 1.
    
    return encoder_input_data, decoder_input_data, decoder_target_data

