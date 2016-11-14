/**
 * Created by Zach on 10/13/2016.
 */
import java.util.*;
public class Connect4 {
    private char [][] board;
    private final char RED = 'X';
    private final char YELLOW = 'O';
    private final char EMPTY = ' ';
    private char color = 'X';

    public Connect4(){
        board = new char[6][7];
        for (int i = 0; i<board.length;i++){
            for (int j=0; j<board[i].length;j++){
                board[i][j] = EMPTY;
            }
        }
    }

    public char[][] getBoard(){
        char [][] copy = new char [board.length][board[0].length];
        for (int i = 0; i<board.length;i++){
            for (int j=0; j<board[i].length;j++){
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }


    public int putPiece(int column, char color){
        if (column > 6){
            return 100;
        }
        else {
            int firstAvailable = 100;
            for (int i = board.length - 1; i >= 0; i--) {
                if (Character.compare(board[i][column], EMPTY) == 0) {
                    firstAvailable = i;
                    break;
                }
            }

            if (Character.compare(color, RED) == 0 && firstAvailable < 100) {
                board[firstAvailable][column] = RED;
            } else if (Character.compare(color, YELLOW) == 0 && firstAvailable < 100) {
                board[firstAvailable][column] = YELLOW;
            } else {
                System.out.println("Error");
            }
            System.out.println(firstAvailable);
            return firstAvailable;
        }
    }

    public boolean compare(int a, int b, char c){
        if (Character.compare(board[a][b], c) == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(int col){
        for (int i = 0; i < board.length;i++){
            if (Character.compare(board[i][col], ' ') == 0){
                return false;
            }
        }
        return true;
    }

    public char checkAlignment(int row, int column) {
        int i = row;
        int j = column;

        System.out.println(color);

        char current = board[i][j];
        System.out.println(current);
        //check vertical
        if (board.length - 3 > i && compare(i + 1, j, current) && compare(i + 2, j, current) && compare(i + 3, j, current)) {
            return current;
        } else if (board.length - 2 > i && i > 0 && compare(i - 1, j, current) && compare(i + 1, j, current) && compare(i + 2, j, current)) {
            return current;
        } else if (board.length - 1 > i && i > 1 && compare(i - 2, j, current) && compare(i - 1, j, current) && compare(i + 1, j, current)) {
            return current;
        } else if (board.length > i && i > 2 && compare(i - 3, j, current) && compare(i - 2, j, current) && compare(i - 1, j, current)) {
            return current;
        }
        //check horizontal
        else if (board[i].length - 3 > j && compare(i, j + 1, current) && compare(i, j + 2, current) && compare(i, j + 3, current)) {
            return current;
        } else if (board[i].length - 2 > j && j > 0 && compare(i, j - 1, current) && compare(i, j + 1, current) && compare(i, j + 2, current)) {
            return current;
        } else if (board[i].length - 1 > j && j > 1 && compare(i, j - 2, current) && compare(i, j - 1, current) && compare(i, j + 1, current)) {
            return current;
        } else if (board[i].length > j && j > 2 && compare(i, j - 3, current) && compare(i, j - 2, current) && compare(i, j - 1, current)) {
            return current;
        }
        //check diag topL - botR
        else if (board[i].length - 3 > j && board.length - 3 > i && compare(i + 1, j + 1, current) && compare(i + 2, j + 2, current) && compare(i + 3, j + 3, current)) {
            return current;
        } else if (board[i].length - 2 > j && j > 0 && board.length - 2 > i && i > 0 && compare(i - 1, j - 1, current) && compare(i + 1, j + 1, current) && compare(i + 2, j + 2, current)) {
            return current;
        } else if (board[i].length - 1 > j && j > 1 && board.length - 1 > i && i > 1 && compare(i - 2, j - 2, current) && compare(i - 1, j - 1, current) && compare(i + 1, j + 1, current)) {
            return current;
        } else if (board[i].length > j && j > 2 && board.length > i && i > 2 && compare(i - 3, j - 3, current) && compare(i - 2, j - 2, current) && compare(i - 1, j - 1, current)) {
            return current;
        }
        //check diag botL - topR
        else if (board[i].length -   3 > j && i>2  && board.length    > i && j>-1 && compare(i - 1, j + 1, current) && compare(i - 2, j + 2, current) && compare(i - 3, j + 3, current)) {
            return current;
        } else if (board[i].length - 2 > j && i>1  && board.length -1 > i && j>0  && compare(i + 1, j - 1, current) && compare(i - 1, j + 1, current) && compare(i - 2, j + 2, current)) {
            return current;
        } else if (board[i].length - 1 > j && i>0  && board.length -2 > i && j>1  && compare(i + 2, j - 2, current) && compare(i + 1, j - 1, current) && compare(i - 1, j + 1, current)) {
            return current;
        } else if (board[i].length     > j && i>-1 && board.length -3 > i && j>2  && compare(i + 3, j - 3, current) && compare(i + 2, j - 2, current) && compare(i + 1, j - 1, current)) {
            return current;
        }

        return ' ';
    }

    public void printScreen(){
        System.out.println ("\t 0 \t 1 \t 2 \t 3 \t 4 \t 5 \t 6");
        System.out.println ("--------------------------------");
        System.out.println ("A | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " | " + board[0][6]);
        System.out.println ("--------------------------------");
        System.out.println ("B | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " | " + board[1][6]);
        System.out.println ("--------------------------------");
        System.out.println ("C | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " | " + board[2][6]);
        System.out.println ("--------------------------------");
        System.out.println ("D | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " | " + board[3][6]);
        System.out.println ("--------------------------------");
        System.out.println ("E | " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " | " + board[4][6]);
        System.out.println ("--------------------------------");
        System.out.println ("F | " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " | " + board[5][6]);
        System.out.println ("--------------------------------");
        //System.out.println ("Current Player: ");
        //System.out.println ("Choose a column: ");
    }

    public void play(){
        Scanner scan = new Scanner (System.in);
        boolean gameOver = false;
        boolean validPos = false;
        int col;
        int row;

        while (gameOver == false) {
            System.out.println("Current player: " + color);
            System.out.println("Pick a column: ");
            col = scan.nextInt();

            while (validPos == false){
                if (col < 7 && col >= 0 && (isFull(col) == false)){
                    validPos = true;
                }
                else {
                    System.out.println("Invalid column, pick again: ");
                    col = scan.nextInt();
                }
            }
            row = putPiece(col,color);

            printScreen();
            if (Character.compare(checkAlignment(row, col), color) == 0) {
                System.out.println("The winner is: " + color);
                gameOver = true;
            }

            if (Character.compare(color, RED) == 0){
                this.color = YELLOW;
            }
            else {
                this.color = RED;
            }
        }

    }

    public void setPiece(int col, int row, char color){
        board[row][col] = color;
    }

    public static void main (String []args){

        Connect4 c = new Connect4();

        //char [][] copy = c.getBoard();
        for (int i = 2; i < 6; i++) {
            c.setPiece(i,0,'O');
        }
        c.printScreen();
        char result = c.checkAlignment(0,2);
        //System.out.println(result);
        char [][] copy = c.getBoard();
        System.out.println(copy[0][2]);
        //Connect4 c4 = new Connect4();
        //c4.play();




    }
}

