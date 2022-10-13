import os

file_paths = []
for path, subdirs, files in os.walk("v4/CodeExample"):
	for name in files:
		file_paths.append(os.path.join(path, name))

meth_decs = []
c = 0
for file in file_paths:
	with open(file, 'r') as f:
		content = "public class WrapperClass {\n/**\n * This is a JavaDoc\n */\n" + f.read() + "\n}"
	with open(file, 'w') as f:
		f.write(content)
		#if content.split()[0] == "public" or content.split()[0] == "private" or content.split()[0] == "protected":
		#if content.split()[0] == "protected":
		#	meth_decs.append(content)

i = 0
for item in meth_decs:
	print(item.split("\n", 1)[0])
	i += 1
print(i)
