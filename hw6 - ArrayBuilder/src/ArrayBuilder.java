/**
 * Created by Zach on 10/11/2016.
 */
public class ArrayBuilder {
    private char baseLetter;
    private int n;
    private int m;
    private char[][] letterArray;

    public ArrayBuilder(char baseLetter, int n, int m) {
        this.baseLetter = baseLetter;
        this.n = n;
        this.m = m;
        letterArray = new char[n][m];
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public char getBaseLetter() {
        return baseLetter;
    }

    public void build(){
        int codeP;
        letterArray[0][0] = baseLetter;
        String baseL = Character.toString(baseLetter);
        codeP = baseL.codePointAt(0);
        for (int i =0; i <letterArray.length;i++){
            for (int j=0; j <letterArray[i].length;j++){
                int total = codeP + i + j;
                if ((codeP < 91 && codeP >64) && total >90){
                    total = total -26;
                }

                else if ((codeP <123 && codeP >96) && total >122){
                    total = total -26;
                }

                char[] letterGet = Character.toChars(total);
                char letter = letterGet[0];
                letterArray[i][j] = letter;
            }
        }
    }

    public char[][] getLetterArray(){
        char [][] copy = new char[getN()][getM()];
        for (int i = 0; i < copy.length;i++){
            for (int j = 0; j<copy[i].length; j++){
                copy[i][j] = letterArray[i][j];
            }
        }
        return copy;
    }

    public void printLetterArray(){
        for (int i = 0; i < letterArray.length;i++){
            for (int j = 0; j<letterArray[i].length; j++){
                System.out.print(letterArray[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "y";

        char tes = a.charAt(0);
        char tes2 = b.charAt(0);
        ArrayBuilder test = new ArrayBuilder(tes,5,5);
        ArrayBuilder test2 = new ArrayBuilder(tes2,5,5);

        test.build();
        test2.build();
        test.printLetterArray();
        System.out.println();
        test2.printLetterArray();
    }
}