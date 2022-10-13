import com.github.javaparser.*;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.symbolsolver.model.declarations.*;
import com.google.common.base.Strings;
import javassist.expr.MethodCall;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by morakot on 7/04/17.
 */
public class JavaParserMethodCalls {
    private static Map<String, List<String>> functionCalls = null;
    private static Map<String, List<Integer>> functionCallParam = null; //number of paramaeters for function calls
    private static Map<String, String> functionName = null; //wee used the full name of the function as the key, we want the shorten one to ease searching
    private static Map<String, Integer> functionParamNum = null; //number of paramater for functions
    private static Map<String, Boolean> funcExistVar = null;
    private static List<String> tempFunctionCalls = null;
    private static List<Integer> tempFunctionCallParam = null;
    private static String mainClassNode = null;
    private static List<String> definedVariables = null;
    private static int idStart;


    public static void main(String [] args) throws Exception{
        String testDirectory = "/home/swn881/Wee Folder/JavaParserMethodCalls/src";

        println(testDirectory);
        ////FileInputStream in = new FileInputStream("/home/aa043/sea/DySDoc3/testartifactname/originalSourceCode_modified/XSSFWorkbook.java");
        //FileInputStream in = new FileInputStream(testDirectory + "/test.java");
        //Reader in = new FileReader(new File(testDirectory + "/test.java"));

        ////CompilationUnit cu = JavaParser.parse(in);

        ////File idFile = new File("/home/aa043/sea/DySDoc3/testartifactname/output_parse/funcIDs.txt");
        ////FileWriter idWriter = new FileWriter(idFile);
        ////new MethodVisitor(idWriter).visit(cu, null);

        //tokenize(cu);
        ////in.close();
        functionA();
    }

    public static void functionA() throws Exception{
        File mainDirectory = new File("/home/aa043/sea/DySDoc3/testartifactname/originalSourceCode_modified/");
        File outDirectory = new File("/home/aa043/sea/DySDoc3/testartifactname/output_parse/");
        //String testDirectory = "/local/home/morakot/Wee Folder/JavaParserMethodCalls/src";

        //initialize variables to be used to store function names and calls
        //we need to keep track of all the functions and function calls of a class/file
        functionCalls = new LinkedHashMap<String,List<String>>();
        functionCallParam = new LinkedHashMap<String,List<Integer>>();
        functionName = new LinkedHashMap<String, String>();
        functionParamNum = new LinkedHashMap<String,Integer>();
        definedVariables = new ArrayList<String>();
        funcExistVar = new LinkedHashMap<String,Boolean>();
        idStart = 1;


        //FileInputStream in = new FileInputStream("/home/aa043/sea/DySDoc3/testartifactname/originalSourceCode_modified");
        //FileInputStream in = new FileInputStream(testDirectory + "/test.java");
        //FileInputStream in = new FileInputStream(testDirectory + "/JavaParserMethodCalls.java");
        //CompilationUnit cu = JavaParser.parse(in);
        //new ClassVisitor(null, null).visit(cu, null);

        //gets all declared variable in the class
        //new ClassVariableFieldVisitor(null).visit(cu, null);
        //println(definedVariables);

        //new VariableUsageVisitor().visit(cu, null);

        //println("Parent Node: " + mainClassNode);

        //new MethodVisitor().visit(cu, null);

        //println(functionCalls);
        //println(functionCallParam);
        //println(new ArrayList<String>(functionCalls.keySet()).indexOf("static void println(Object line)"));
        //checkFunctionCalls();

        //processFile(new File("/local/home/morakot/Wee Folder/bagWord/originalSourceCode_modified/crosswords/39/org.eehouse.android.xw4.BoardActivity.java"),
                //"/local/home/morakot/Wee Folder/bagWord/");

        //println(functionCalls.get("public void onPrepareDialog( int id, Dialog dialog )"));

        //everytime we get to a new class we need to clear the variables
        functionCalls.clear();
        functionCallParam.clear();
        functionName.clear();
        functionParamNum.clear();
        definedVariables.clear();
        funcExistVar.clear();
        idStart = 1;


        //int count = 0;
        for(File projectDir : mainDirectory.listFiles()){
            //if(count < 0){
            File outProjectDir = new File(outDirectory + "/" + projectDir.getName());
            if(!outProjectDir.exists())
                outProjectDir.mkdir();
                //println("File Name: "+projectDir.getName());
            processFile(projectDir, outProjectDir.getAbsolutePath());


                /*for(File subDirectories : projectDir.listFiles()){
                    if(subDirectories.isFile()){
                        if(subDirectories.toString().endsWith(".java")){
                            println("----------Current File: " + subDirectories.toString());
                            processFile(subDirectories, outProjectDir.getAbsolutePath());

                        }
                    }
                    else if (subDirectories.isDirectory()){
                        File outVersionDir = new File(outProjectDir + "/" + subDirectories.getName());
                        if(!outVersionDir.exists()){
                            outVersionDir.mkdir();
                        }
                        println(subDirectories.getName());

                        for(File subsubDirectories : subDirectories.listFiles()){


                            if(subsubDirectories.isFile()){
                                if(subsubDirectories.toString().endsWith(".java")){
                                    println("-----------Current File: " + subsubDirectories.toString());
                                    processFile(subsubDirectories, outVersionDir.getAbsolutePath());
                                }
                            }
                        }
                    }
                }
            //}
            //count++;
            */
        }


        //listMethodCalls(new File(testDirectory));
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

    public static void processFile(File subsubDirectories, String outDirectory) throws Exception{
        //println(subsubDirectories.get);
        StringBuffer tokenizedString = new StringBuffer();

        FileInputStream in = new FileInputStream(subsubDirectories);

        //output files, the csv file and the text file
        String currentFilewExtension = "";
        currentFilewExtension = subsubDirectories.getName(); //string to keep track of the current file we working on
        String currentFile = "";
        if(currentFilewExtension.endsWith(".java")){
            currentFile = currentFilewExtension.substring(0, currentFilewExtension.length() - 5 );
        }
        File csvFile = new File(outDirectory + "/" + currentFile + "_funcCalls.csv");
        File idFile = new File(outDirectory + "/" + currentFile + "_funcIDs.txt");
        csvFile.createNewFile();
        idFile.createNewFile();
        FileWriter csvWriter = new FileWriter(csvFile);
        FileWriter idWriter = new FileWriter(idFile);


        CompilationUnit cu = JavaParser.parse(in);

        new ClassVisitor(null).visit(cu, null); //!!change the null when writing to file

        new ClassVariableFieldVisitor(tokenizedString).visit(cu, null);
        //tokenizedstring will have all the variables
        println("ALL VARIABLES: " + tokenizedString.toString());
        idWriter.write(tokenizedString + "\n");
        idStart++; //we keep track of the curr line by how many times we wrote something into a file

        //actual writing of class defined in the class into the file here
        new ClassVisitor(idWriter).visit(cu, null);

        println(idStart);

        new MethodVisitor(idWriter).visit(cu, null);

        println(functionName);

        checkFunctionCalls(csvWriter);

        functionCalls = new LinkedHashMap<String,List<String>>();
        functionCallParam = new LinkedHashMap<String,List<Integer>>();
        functionName = new LinkedHashMap<String, String>();
        functionParamNum = new LinkedHashMap<String,Integer>();
        funcExistVar = new LinkedHashMap<String, Boolean>();
        definedVariables = new ArrayList<String>();
        mainClassNode = null;
        idStart = 1;
        in.close();
        idWriter.flush();
        idWriter.close();
        csvWriter.flush();
        csvWriter.close();
    }


    public static class ClassVisitor extends VoidVisitorAdapter{
        //constructor
        private Writer idWriter;

        public ClassVisitor(Writer w){
            this.idWriter = w;
        }

        @Override
        public void visit(ClassOrInterfaceDeclaration n , Object arg){
            //println(n.toString());
            //due to the syntax in java, it will always be the case that there will only be 1 java class defined
            //classes can be defined inside of the class
            //so whenever we get the first class name, it will be the main class name

            if(mainClassNode == null){
                mainClassNode = n.getNameAsString();
                //println(mainClassNode);
            }
            else{
                //we might call this.visit twice to write it into file lol, once to get the main class node,
                //2nd to write class defined within the class into the file
                if(!n.getNameAsString().equals(mainClassNode)){
                    try{
                        if(idWriter != null){
                            idWriter.write( tokenize( new JavaParser().parse(ParseStart.CLASS_BODY, new StringProvider(n.toString())) ) + "\n");
                            idStart++;
                        }
                    }
                    catch(Exception e){
                        //println("Error occured trying to write into file - CLASS BODY");
                    }

                }
            }

            //println("CLASS: " + n.getName());

            super.visit(n, null);
        }
    }


    //method visitors
    public static class MethodVisitor extends VoidVisitorAdapter<Void>{
        private Writer idWriter;

        public MethodVisitor(Writer w){
            this.idWriter = w;
        }

        //@Override
        public void visit(MethodDeclaration n, Void arg){
            println("Start");
            //System.out.println(n.toString());

            //get function name
            String function = n.getDeclarationAsString(true, true, true);
            String functionNameShortened = n.getName().toString();
            println(">>>>>>>>>Function: " + function);
            //super.visit(n,arg);

            Node node = n.getParentNode().get();
            //println(parentNode);
            Node parentNode = node.getChildNodes().get(0);
            println("Parent node: " + parentNode);

            //make sure we checking functions only under the main class, not any functions for class defined inside the class
            if(parentNode.toString().equals(mainClassNode)){


                functionName.put(function, functionNameShortened);

                tempFunctionCalls = new ArrayList<String>();
                tempFunctionCallParam = new ArrayList<Integer>();

                //get number of parameters
                NodeList<Parameter> parameterNames =  n.getParameters();
                int paramNum = parameterNames.size();
                println("Number of parameters for function: " + paramNum);
                functionParamNum.put(function, paramNum); //the number of parameters for function, NOT FUNCTION CALL

                //get method calls within function
                new MethodCallVisitor().visit(n, null);
                functionCalls.put(function, tempFunctionCalls);
                functionCallParam.put(function, tempFunctionCallParam);

                println("Function calls: " + tempFunctionCalls);

                new VariableUsageVisitor().visit(n, null);
                println("");

                if(idWriter != null){
                    try{
                        idWriter.write( tokenize( new JavaParser().parse(ParseStart.INTERFACE_BODY, new StringProvider(n.toString())) )  + "\n");
                    }
                    catch(Exception e){
                        println("Exception happened when trying to write FUNCTIONS into file");
                    }
                }



            }
            else{
                println("Not part of class " + mainClassNode);
            }
        }

    }

    public static class VariableUsageVisitor extends VoidVisitorAdapter<Void>{
        //for checking variables defined within a function
        @Override
        public void visit(MethodDeclaration n, Void arg){
            Node node = n.getParentNode().get();
            //println(parentNode);
            Node parentNode = node.getChildNodes().get(0);
            //println("Parent node: " + parentNode);

            if(parentNode.toString().equals(mainClassNode)){
                String function = n.getDeclarationAsString(true, true, true);
                n.removeComment();
                if(n.getBody().isPresent()){
                    NodeList<Statement> temp = n.getBody().get().getStatements();
                    boolean isExist = false;
                    for(Statement statement : temp){
                        for(String variable: definedVariables){
                            String compareStatement = statement.removeComment().toString();
                            //println(compareStatement);
                            if(compareStatement.contains(variable)){
                                //println(statement.getBegin());
                                //println("Variable found: " + variable);

                                isExist = true;
                            }
                        }
                    }
                    funcExistVar.put(function, isExist);
                }

            }
            else{
                //println("Not part of main class: " + mainClassNode);
            }


        }

    }


    public static class MethodCallVisitor extends VoidVisitorAdapter<Object>{
        @Override
        public void visit(MethodCallExpr n, Object arg){

            super.visit(n, arg);

            /*
            Node node = n.getParentNode().get();
            Node parentNode = node.getChildNodes().get(0);
            println("Parent for function call: " + parentNode.toString());
            */

            String scope = n.getScope().toString();
            if(scope.equals("Optional[this]") || scope.equals("Optional.empty")){
                println("-----------Function call: " + n);
                println("SCOPE: " + n.getScope().toString());
                //add the func calls into a temp arrylist and then added to the map
                String funcCallName = n.getName().toString();
                tempFunctionCalls.add(funcCallName);
                println("NAME ONLY " + tempFunctionCalls.size() + ": " + funcCallName);

                println("LINE NUMBER: " + n.getBegin());

                NodeList<Expression> variableNames = n.getArguments();
                int functionCallParamNum = variableNames.size();
                println("NUM PARAMETERS: " + functionCallParamNum);
                tempFunctionCallParam.add(functionCallParamNum);
            }
        }
    }

    public static class ClassVariableFieldVisitor extends VoidVisitorAdapter<Object>{
        private StringBuffer allTokenizedFields;

        public ClassVariableFieldVisitor(StringBuffer sb){
            this.allTokenizedFields = sb;
        }

        @Override
        public void visit(FieldDeclaration n, Object arg){

            Node node = n.getParentNode().get();
            Node parentNode = node.getChildNodes().get(0);
            println("Class var parent: " + parentNode);

            if(parentNode.toString().equals(mainClassNode)){
                NodeList<VariableDeclarator> variables = n.getVariables();
                EnumSet<Modifier> modifiers = n.getModifiers();

                println("VARIABLE: " + n.toString());
                definedVariables.add(variables.get(0).getName().toString());
                //println("VARIABLE name: " + variables.get(0).getName().toString());
                n.removeComment();
                if(allTokenizedFields != null){
                    allTokenizedFields.append( tokenize(new JavaParser().parse(ParseStart.VARIABLE_DECLARATION_EXPR, new StringProvider(n.toString()))) );
                }

            }

        }
    }

    public static class AllVariableDeclarationVisitor extends VoidVisitorAdapter<Object>{
        @Override
        public void visit(VariableDeclarationExpr n, Object arg){
            NodeList<VariableDeclarator> temp = n.getVariables();
            for(VariableDeclarator temp1: temp){
                println(temp1.getType());
                println(temp1.getBegin());
                println(temp1.getInitializer());
                println("????????????????????Variables: " + temp1);
            }

        }
    }

    public static void checkFunctionCalls(Writer csvWriter){
        List<String> funcNames = new ArrayList<String>();
        List<Integer> funcParam = new ArrayList<Integer>();
        //setup the IDs
        List<Integer> ids = new ArrayList<Integer>();

        for(Map.Entry<String, String> function : functionName.entrySet()){
            funcNames.add(function.getValue());
            funcParam.add(functionParamNum.get(function.getKey()));
        }

        int currentID = idStart;
        for(String funcName : funcNames){
            ids.add(idStart);
            idStart++;
        }

        //println(funcNames);
        //println(functionCalls);


        for(Map.Entry<String, String> function : functionName.entrySet()){

            //if there was a variable match, write into file
            if(funcExistVar != null && funcExistVar.get(function.getKey()) != null){
                if(funcExistVar.get(function.getKey())){
                    try{
                        csvWriter.write(currentID + "," + "0" + "\n");
                    }
                    catch(Exception e){
                        println("Exception when writing variable existing into file");
                    }
                }
            }


            if(functionCalls != null && functionCalls.get(function.getKey()).size() != 0){
                println(">>>>>>>>>>>>>>>>>>>>>!!Current function: " + function.getValue());
                //println("Theres somehting!");
                List<String> funcCalls = functionCalls.get(function.getKey());
                List<Integer> funcCallsParamNum = functionCallParam.get(function.getKey());


                for(int k = 0; k < funcCalls.size(); k++){
                    List<Integer> hitCount = new ArrayList<Integer>();
                    println(funcCalls.get(k));
                    for(int i = 0; i < funcNames.size(); i++){
                        if(funcCalls.get(k).equals(funcNames.get(i))){
                            //match the number of parameters, match function call and functions
                            if(funcCallsParamNum.get(k) == funcParam.get(i)){
                                hitCount.add(i); //let us know which function, in order, did it call
                            }
                        }
                    }

                    if(hitCount.size() == 1){
                        //println(">>>>We found a match<<<<");
                        //println("Function Call: " + funcCalls.get(k));
                        //println("Matched function: " + funcNames.get(hitCount.get(0)));
                        //println("Function ID: " + ids.get(hitCount.get(0)));

                        try{
                            csvWriter.write(currentID + "," + ids.get(hitCount.get(0)).toString() + "\n");
                        }
                        catch(Exception e){
                            println("Exception found when writing matching function calls");
                        }


                    }
                    else if(hitCount.size() > 1){
                        try{
                            //println("<<<<More than 1 match available>>>>");
                            //println("Function call: " + funcCalls.get(k));
                            csvWriter.write(currentID + ",");
                            for(int j = 0; j < hitCount.size(); j++){
                                csvWriter.write(ids.get(hitCount.get(j)).toString() + ";");
                                //println("Function: " + funcNames.get(hitCount.get(j)));
                                //println("Function ID: " + ids.get(hitCount.get(0)) );
                            }
                            csvWriter.write("\n");
                        }
                        catch(Exception e){
                            println("Exception at multiple matches");
                        }

                    }
                    else if(hitCount.size() == 0){
                        //println("No matches");
                    }
                    else{
                        println("There is something you missed duuuuudeee-> " + hitCount.size());
                    }

                }
            }
            currentID++;
        }
    }

    static void println(Object line) {
        System.out.println(line);
    }

}


/**
 for(TypeDeclaration typeDeclaration : cu.getTypes()){
 List<BodyDeclaration> members = typeDeclaration.getMembers();
 if(members != null){
 for(BodyDeclaration member : members){

 println("!!!" + member.getClass().toString());

 FieldDeclaration field = (FieldDeclaration) member;

 println(field.getElementType());

 println(field.getVariables().get(0).getName());

 println(field.getBegin());

 Object initValue = field.getVariables().get(0).getInitializer();
 if(initValue != null){
 println(field.getVariables().get(0).getInitializer().toString());

 }

 }
 }
 }
 **/