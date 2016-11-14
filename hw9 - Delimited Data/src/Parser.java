
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Zach on 11/5/2016.
 */
public class Parser {
    private String username = "";
    private int numQueries = 0;
    private String[] queries;
    private String[] lines;
    private int numLines;

    public Parser() {
    }

    public void parse(String filePath) throws WrongFileFormatException
            , WrongNumberOfQueriesException, InvalidInputException
            , MalformedQueryException, IOException{

        File f = new File(filePath);
        Scanner sc = new Scanner(f);

        String fromFile= "";
        while(sc.hasNext()) {
            fromFile += sc.nextLine();
            fromFile += "\n";
        }

        lines = fromFile.split("\n", 1000000);
        numLines = lines.length;
        for (int i =0; i<lines.length;i++){
            if (lines[i].equals("q")){
                numLines = i+1;
                i=lines.length;
            }
        }

        if (lines[1] != null){
            username = lines[1];
        }
        queries = new String[numLines-8];

        for (int i=0; i<numLines; i++){
            System.out.println(lines[i]);
        }

        if (!(lines[0].equals("C") && lines[2].equals("c") && lines[3].equals("N") && lines[5].equals("n") && lines[6].equals("Q") && lines[numLines - 1].equals("q"))){
            throw new WrongFileFormatException("");
        }

        int a = Integer.parseInt(lines[4]);
        if (a >= 1) {
            numQueries = a;
        } else {
            throw new InvalidInputException("");
        }

        if (numLines-8 != numQueries) {
            throw new WrongNumberOfQueriesException("");
        }

        for (int i=0; i<numQueries;i++){
            queries[i] = lines[i+7];
            String start = queries[i].substring(0,6);
            if (start.equals("SELECT") || start.equals("UPDATE") || start.equals("INSERT") || start.equals("DELETE")) {
            } else {
                throw new MalformedQueryException("");
            }
        }

    }

    public String getUserName() {
        return username;
    }

    public int getNumQueries() {
        return numQueries;
    }

    public String[] getLines() {
        return lines;
    }

    public String getQueries() {
        String result = "";
        for (int i = 0; i < queries.length; i++) {
            result += queries[i];
            result += "\n";
        }
        return result;
    }

    //public static void main(String[] args) throws MalformedQueryException, InvalidInputException, IOException, WrongFileFormatException, WrongNumberOfQueriesException, ClassNotFoundException {
    //    Parser joe = new Parser();
    //    joe.parse("C:\\Users\\Zach\\Desktop\\Purdue CS\\cs180\\hw9 - Delimited Data\\src\\SampleFiles\\file2.sql");
    //
     //   System.out.println(joe.getUserName());
     //   System.out.println(joe.getNumQueries());
    //}
}

