import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import raykernel.apps.readability.eval.Main;

public class ReadScore {


    private static List<String> readFileInList(String fileName) {

        List<String> lines = Collections.emptyList();

        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }


    private static double[] calcReadScores(List codeInputs) {
        Iterator<String> itr = codeInputs.iterator();
        double[] readScores = new double[codeInputs.size()];
        int i = 0;
        while (itr.hasNext()) {
            readScores[i] = Main.getReadability(itr.next());
            i++;
        }

        return readScores;
    }


    private static boolean writeToDisk(String path, String content){
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


    public static void main(String[] args) {

//        double x = Main.getReadability("if ( var . isBleedingFunction ( ) || var . isCatch ( ) ) { continue ; }");
//        System.out.println(x);
//        x = Main.getReadability("if ( ( arg . equals ( \"-fr\" ) || arg . equals ( \"--followRedirect\" ) ) && largs . size ( ) > 1 ) { final String b = largs . get ( 1 ) ; largs . remove ( 0 ) ; largs . remove ( 0 ) ; downloaderSettings . add ( new Func1 < Object , HttpDownloader > ( ) { @ Override public Object apply ( HttpDownloader downloader ) { downloader . setFollowRedirect ( b . equalsIgnoreCase ( \"true\" ) ) ; return null ; } } ) ; requestSettings . add ( new Func1 < Object , HttpRequest > ( ) { @ Override public Object apply ( HttpRequest req ) { req . setFollowRedirect ( b . equalsIgnoreCase ( \"true\" ) ) ; return null ; } } ) ; continue ; }");
//        System.out.println(x);
        // Collect lines from file
        // Paths
        String dataDir = "/home/aa043/sea/data/td/ours/v2/CT/framework_ready/";
        String cvInputPath = dataDir + "codes.txt";
        String tuneInputPath = dataDir + "tune_val/codes.txt";
        String cvReadPath = dataDir + "temp/readability.txt";
        String tuneReadPath = dataDir + "temp/tune_val/readability.txt";

        // Read contents from disk
        List cv_inputs = readFileInList(cvInputPath);
        List tune_inputs = readFileInList(tuneInputPath);
        System.out.println("# collected CV inputs: "+cv_inputs.size());
        System.out.println("# collected tune inputs: "+tune_inputs.size());

        // Calculate readability scores
        double[] cvRs = calcReadScores(cv_inputs);
        double[] tuneRs = calcReadScores(tune_inputs);
        System.out.println("# CV readability scores: " + cvRs.length);
        System.out.println("# tuning readability scores: " + tuneRs.length);

        // Prepare for writing to disk
        String toWriteCV = "";
        for(int i = 0; i < cvRs.length; i++)
            toWriteCV += cvRs[i] + "\n";
        String toWriteTune = "";
        for(int i = 0; i < tuneRs.length; i++)
            toWriteTune += tuneRs[i] + "\n";

        // Write to disk
        if(writeToDisk(cvReadPath, toWriteCV))
            System.out.println("CVR File has been written to disk");
        if(writeToDisk(tuneReadPath, toWriteTune))
            System.out.println("TuneR File has been written to disk");



//        i = 0;
//        for(int j = 0; j < readScores.length; j++)
//            if(0.0 <= readScores[j] && 0.1 >= readScores[j]) {
//                System.out.println(readScores[j]);
//                i++;
//            }
//        System.out.println(i);
//        System.out.println(readScores.length);

    }


}
