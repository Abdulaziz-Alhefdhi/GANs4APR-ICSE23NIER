import com.github.javaparser.*;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.visitor.TreeVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import support.DirExplorer;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Iterate over all the Javadoc comments and print them together with a description of the commented element.
 */
public class ASTToSBT {

    public static void main(String[] args) {

        String data_dir;
        String write_path;

        for(int file_no = 1; file_no < 10; file_no++){
            data_dir = "/home/aa043/sea/data/td/v3/parser_processing/" + file_no;
            write_path = data_dir + "/draft_ast_seqs"+file_no+".txt";
            System.out.println("Processing file " + file_no);

            File projectDir = new File(data_dir);
            //File projectDir = new File("C:\\Users\\ahh14\\OneDrive\\Documents\\UOW\\docgen\\testartifactname\\src\\main\\java\\thisone");
            StringBuffer codeSB = new StringBuffer();
//        StringBuffer commentSB = new StringBuffer();
//        Set<String> types = new TreeSet<String>();
//        Set<String> values = new TreeSet<String>();
//        StringBuffer currentFileCode = new StringBuffer();
//        StringBuffer currentFileComments = new StringBuffer();
            new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
                System.out.println("Exploring code...");
//        new DirExplorer((level, path, file) -> path.endsWith(".txt"), (level, path, file) -> {
                try {
                    new VoidVisitorAdapter<Object>() {
                        // String to tree sequence method
                        public String sbt(Node node){
                            String seq = "";
                            List<Node> children = node.getChildNodes();
                            String[] type = node.getClass().toString().split("\\.");
                            String tokened = "";
                            if (children.isEmpty())
                                if (type[type.length-1].equals("LineComment") || type[type.length-1].equals("BlockComment") || type[type.length-1].equals("JavadocComment")) {}
                                else {
                                    tokened = tokenize( new JavaParser().parse(ParseStart.INTERFACE_BODY, new StringProvider(node.toString())) );
                                    seq = /*type[type.length-2]+"."*/"("+type[type.length-1]+"_"+tokened+" )"+type[type.length-1]+"_"+tokened+" ";
//                                types.add(type[type.length-1]);
//                                values.add(tokened);
                                }
                            else {
                                seq = /*type[type.length-2]+"."*/"("+type[type.length-1]+" ";
                                for (Node child : children) {
                                    seq += sbt(child);
                                }
                                seq += ")"+type[type.length-1]+" ";
//                            types.add(type[type.length-1]);
                            }

                            return seq;
                        }

                        @Override
                        // Run through all files
                        public void visit(JavadocComment comment, Object arg) {
                            super.visit(comment, arg);
                            Node node = comment.getCommentedNode().get();
                            //if (comment.getCommentedNode().isPresent())
                            if (node instanceof MethodDeclaration) {
                                codeSB.append(sbt(node) + "\n");
//                                commentSB.append(oneLineComment(comment) + "\n");
//                                currentFileCode.append(sbt(node) + "\n");
//                                System.out.println("A code fragment has been parsed...");
//                                currentFileComments.append(oneLineComment(comment) + "\n");
                            }
                        }
                    }.visit(JavaParser.parse(file), null);

                    // Extracting the current file's name in order to use it to create an output file name
                    String toExtractFileName = "";
                    // Looping from end backwards
                    for(int i = path.length() - 1; i >= 0; i--) {
                        if (path.charAt(i) == '/')
                            break;
                        toExtractFileName += path.charAt(i);
                    }
                    String correctFileName = "";
                    for(int i = toExtractFileName.length() - 1; i >= 0; i--) {
                        if (path.charAt(i) == '.')
                            break;
                        correctFileName += toExtractFileName.charAt(i);
                    }

                    //if (writeToDisk("/home/aa043/sea/output/method2javadoc/sequence_code-javadoc/" + correctFileName + "_methods.txt", currentFileCode.toString()))
                    //  System.out.println(correctFileName + "_methods.txt file has been written to disk");
                    //if (writeToDisk("/home/aa043/sea/output/method2javadoc/sequence_code-javadoc/" + correctFileName + "_javadocs.txt", currentFileComments.toString()))
                    //  System.out.println(correctFileName + "_javadocs.txt file has been written to disk");
                    //System.out.println(correctFileName + "_methods.txt:");
//                System.out.println(correctFileName);
                    //System.out.println(path.replace('/', '_'));
//                System.out.println(currentFileCode.toString());
//                if (writeToDisk("C:\\Users\\ahh14\\Desktop\\temp\\docgen\\ast_seqs\\" + path.replace('/', '_'), currentFileCode.toString()))
//                    System.out.println("Code sequences have been written to disk");
//                System.out.println("===============================================");


//                currentFileCode.delete(0, currentFileCode.length());
//                currentFileComments.delete(0, currentFileComments.length());
                }
                catch (IOException e) {
                    new RuntimeException(e);
                }
            }).explore(projectDir);


            if (writeToDisk(write_path, codeSB.toString()))
                System.out.println("Code sequences have been written to disk.");
            //if (writeToDisk("/home/aa043/sea/output/method2javadoc/sequence_code-javadoc/aggregated/all_javadocs.txt", commentSB.toString()))
            //  System.out.println("The full JavaDocs file has been written to disk");

            // terminal and non-terminal tokens
//        StringBuffer typeBuff = new StringBuffer();
//        StringBuffer valBuff = new StringBuffer();
//        for (String s: types)
//            typeBuff.append(s+"\n");
//        for (String s: values)
//            valBuff.append(s+"\n");
//        //if (writeToDisk("/home/aa043/sea/output/method2javadoc/sequence_code-javadoc/aggregated/all_types.txt", typeBuff.toString()))
            //  System.out.println("The full types file has been written to disk");
            //if (writeToDisk("/home/aa043/sea/output/method2javadoc/sequence_code-javadoc/aggregated/all_values.txt", valBuff.toString()))
            //  System.out.println("The full values file has been written to disk");
        }






    }

    public static String tokenize(ParseResult result){
        StringBuffer sb = new StringBuffer();
        Optional<List<JavaToken>> temp = result.getTokens();
        for(JavaToken token : temp.get()){
            //System.out.println(token.getKind());
            if(token.kind == GeneratedJavaParserConstants.INTEGER_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.LONG_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.FLOATING_POINT_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.DECIMAL_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.DECIMAL_FLOATING_POINT_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.HEX_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.HEXADECIMAL_FLOATING_POINT_LITERAL){
                //sb.append("<NUM> ");
                sb.append("<NUM>");
            }
            else if (token.kind == GeneratedJavaParserConstants.STRING_LITERAL){
                //sb.append("<STR> ");
                sb.append("<STR>");
            }
            else{
                String tokenText = token.text;
                if(!tokenText.equals("\n") && !tokenText.equals(" ") && !tokenText.equals("\t") && !tokenText.equals("\t\t") && !tokenText.equals("\t\t\t") && !tokenText.equals("") ){
                    if(tokenText.contains("\n") && tokenText.contains("//")){

                    }
                    else if(tokenText.contains("\n") || tokenText.contains("/*")){

                    }
                    else{
                        //sb.append(tokenText + " ");
                        sb.append(tokenText);
                    }
                }

            }
        }
        //System.out.print("\n");
        return sb.toString();
    }

    public static String oneLineComment(JavadocComment c){
        String cleanComment = c.toString();
        cleanComment = cleanComment.replace("/*", "");
        cleanComment = cleanComment.replace("*/", "");
        cleanComment = cleanComment.replace("*", "");
        cleanComment = cleanComment.replace("\n", " ");
        cleanComment = cleanComment.replace("\t", " ");
        for(int i = 0; i < cleanComment.length(); i++){
            if (cleanComment.charAt(i) != ' '){
                cleanComment = cleanComment.substring(i, cleanComment.length() - 2);
                break;
            }
        }
        boolean stayInLoop = true;
        int matches;
        while(stayInLoop){
            matches = 0;
            for(int i = 0; i < cleanComment.length() - 1; i++)
                if (cleanComment.charAt(i) == ' ' && cleanComment.charAt(i+1) == ' ')
                    matches++;
            if (matches == 0)
                stayInLoop = false;
            else
                cleanComment = cleanComment.replace("  ", " ");
        }
        //System.out.println(cleanComment);
        return cleanComment;
    }

    public static boolean writeToDisk(String path, String content){
        try {
            File codeFile = new File(path);
            Writer codeOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(codeFile), "UTF8"));
            codeOut.append(content);
            codeOut.flush();
            codeOut.close();
        }
        catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            return false;
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }



}

