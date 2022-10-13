import com.github.javaparser.GeneratedJavaParserConstants;
import com.github.javaparser.JavaParser;
import com.github.javaparser.JavaToken;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import support.DirExplorer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Iterate over all the Javadoc comments and print them together with a description of the commented element.
 */
public class AllJavadocExtractor {

    public static void main(String[] args) {
        File projectDir = new File("source_to_parse/");
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(JavadocComment comment, Object arg) {
                        super.visit(comment, arg);
                        String title = null;
                        if (comment.getCommentedNode().isPresent()) {
                            title = String.format("%s (%s)", describe(comment.getCommentedNode().get()), path);
                        } else {
                            title = String.format("No element associated (%s)", path);
                        }
                        System.out.println(title);
                        System.out.println(Strings.repeat("=", title.length()));
                        System.out.println(comment);
                    }
                }.visit(JavaParser.parse(file), null);
            } catch (IOException e) {
                new RuntimeException(e);
            }
        }).explore(projectDir);
    }

    private static String describe(Node node) {
        if (node instanceof MethodDeclaration) {
            MethodDeclaration methodDeclaration = (MethodDeclaration)node;
            return "Method " + methodDeclaration.getDeclarationAsString();
        }
        if (node instanceof ConstructorDeclaration) {
            ConstructorDeclaration constructorDeclaration = (ConstructorDeclaration)node;
            return "Constructor " + constructorDeclaration.getDeclarationAsString();
        }
        if (node instanceof ClassOrInterfaceDeclaration) {
            ClassOrInterfaceDeclaration classOrInterfaceDeclaration = (ClassOrInterfaceDeclaration)node;
            if (classOrInterfaceDeclaration.isInterface()) {
                return "Interface " + classOrInterfaceDeclaration.getName();
            } else {
                return "Class " + classOrInterfaceDeclaration.getName();
            }
        }
        if (node instanceof EnumDeclaration) {
            EnumDeclaration enumDeclaration = (EnumDeclaration)node;
            return "Enum " + enumDeclaration.getName();
        }
        if (node instanceof FieldDeclaration) {
            FieldDeclaration fieldDeclaration = (FieldDeclaration)node;
            List<String> varNames = fieldDeclaration.getVariables().stream().map(v -> v.getName().getId()).collect(Collectors.toList());
            return "Field " + String.join(", ", varNames);
        }
        return node.toString();
    }

    public static String tokenize(ParseResult result){
        //new JavaParser.parseClassBodyDeclaration()
        //http://static.javadoc.io/com.github.javaparser/javaparser-core/3.1.2/com/github/javaparser/JavaParser.html#parse-com.github.javaparser.ParseStart-com.github.javaparser.Provider-
        //new JavaParser().parse(ParseStart.COMPILATION_UNIT, new StringProvider(cu.toString()));
        //println(result.getResult().get().toString());

        StringBuffer sb = new StringBuffer();

        Optional<List<JavaToken>> temp = result.getTokens();
        //println(temp.get().size());

        for(JavaToken token : temp.get()){
            if(token.kind == GeneratedJavaParserConstants.INTEGER_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.LONG_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.FLOATING_POINT_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.DECIMAL_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.DECIMAL_FLOATING_POINT_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.HEX_LITERAL ||
                    token.kind == GeneratedJavaParserConstants.HEXADECIMAL_FLOATING_POINT_LITERAL){

                sb.append("<NUM> ");
                System.out.print("<NUM> ");
            }
            else if (token.kind == GeneratedJavaParserConstants.STRING_LITERAL){
                sb.append("<STR> ");
                System.out.print("<STR> ");
            }
            else{
                String tokenText = token.text;
                //println("Else:" + token.toString());
                if(!tokenText.equals("\n") && !tokenText.equals(" ") && !tokenText.equals("\t") && !tokenText.equals("\t\t") && !tokenText.equals("\t\t\t") && !tokenText.equals("") ){
                    if(tokenText.toString().contains("\n") && tokenText.toString().contains("//")){
                        //tokenText = tokenText.replace("\n", "");
                    }
                    else if(tokenText.toString().contains("\n") || tokenText.toString().contains("/*")){

                    }
                    else{
                        sb.append(tokenText + " ");
                        System.out.print( tokenText + " ");
                    }
                }

            }
        }
        System.out.print("\n");
        return sb.toString();
    }

}