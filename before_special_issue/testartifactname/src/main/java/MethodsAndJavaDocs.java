import com.github.javaparser.*;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import support.DirExplorer;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Iterate over all the Javadoc comments and print them together with a description of the commented element.
 */
public class MethodsAndJavaDocs {
    public static void main(String[] args) {
        //File projectDir = new File("/home/aa043/sea/DySDoc3/testartifactname/source_code/");
        File projectDir = new File("/home/aa043/sea/DySDoc3/nmt/testDG/production_model/data/testing_samples");
        StringBuffer codeSB = new StringBuffer();
        StringBuffer commentSB = new StringBuffer();
        StringBuffer currentFileCode = new StringBuffer();
        StringBuffer currentFileComments = new StringBuffer();
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            try {
                new VoidVisitorAdapter<Object>() {
                    int i = 0;
                    String tokenizedMethod = "";
                    String modifiedComment = "";
                    @Override
                    public void visit(JavadocComment comment, Object arg) {
                        super.visit(comment, arg);
                        Node node = comment.getCommentedNode().get();
                        if (comment.getCommentedNode().isPresent())
                            if (comment.getCommentedNode().get() instanceof MethodDeclaration) {
                                tokenizedMethod = tokenize( new JavaParser().parse(ParseStart.INTERFACE_BODY, new StringProvider(node.toString())) );
                                modifiedComment = oneLineComment(comment);
                                codeSB.append(tokenizedMethod + "\n");
                                commentSB.append(modifiedComment + "\n");
                                currentFileCode.append(tokenizedMethod + "\n");
                                currentFileComments.append(modifiedComment + "\n");
                                //System.out.println(++i);
                            }
                    }
                }.visit(JavaParser.parse(file), null);
                String toExtractFileName = "";
                for(int i = path.length() - 1; i >= 0; i--)
                    if (path.charAt(i) != '/')
                        toExtractFileName += path.charAt(i);
                    else
                        break;
                String correctFileName = "";
                for(int i = toExtractFileName.length() - 1; i >= 0; i--)
                    correctFileName += toExtractFileName.charAt(i);
                if (writeToDisk("/home/aa043/sea/DySDoc3/nmt/testDG/production_model/data/" + correctFileName + "_methods.txt", currentFileCode.toString()))
                    System.out.println(correctFileName + "_methods.txt file has been written to disk");
                //if (writeToDisk("/home/aa043/sea/DySDoc3/testartifactname/output_files/" + correctFileName + "javadocs.txt", currentFileComments.toString()))
                  //  System.out.println(correctFileName + "javadocs file has been written to disk");

                currentFileCode.delete(0, currentFileCode.length());
                currentFileComments.delete(0, currentFileComments.length());
            }
            catch (IOException e) {
                new RuntimeException(e);
            }
        }).explore(projectDir);


        //if (writeToDisk("/home/aa043/sea/DySDoc3/testartifactname/output_files/all_codes.txt", codeSB.toString()))
        if (writeToDisk("/home/aa043/sea/DySDoc3/nmt/testDG/production_model/data/all_codes.txt", codeSB.toString()))
            System.out.println("The full Codes file has been written to disk");
        //if (writeToDisk("/home/aa043/sea/DySDoc3/testartifactname/output_files/all_comments.txt", commentSB.toString()))
          //  System.out.println("The full JavaDocs file has been written to disk");

    }

    public static String tokenize(ParseResult result){
        StringBuffer sb = new StringBuffer();
        Optional<List<JavaToken>> temp = result.getTokens();
        for(JavaToken token : temp.get()){
            if(token.kind == GeneratedJavaParserConstants.INTEGER_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.LONG_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.FLOATING_POINT_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.DECIMAL_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.DECIMAL_FLOATING_POINT_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.HEX_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.HEXADECIMAL_FLOATING_POINT_LITERAL){
                sb.append("<NUM> ");
                //System.out.print("<NUM> ");
            }
            else if (token.kind == GeneratedJavaParserConstants.STRING_LITERAL){
                sb.append("<STR> ");
                //System.out.print("<STR> ");
            }
            else{
                String tokenText = token.text;
                if(!tokenText.equals("\n") && !tokenText.equals(" ") && !tokenText.equals("\t") && !tokenText.equals("\t\t") && !tokenText.equals("\t\t\t") && !tokenText.equals("") ){
                    if(tokenText.toString().contains("\n") && tokenText.toString().contains("//")){

                    }
                    else if(tokenText.toString().contains("\n") || tokenText.toString().contains("/*")){

                    }
                    else{
                        sb.append(tokenText + " ");
                        //System.out.print( tokenText + " ");
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
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

}