/**
 * Created by Zach on 10/3/2016.
 */
public class Matrix {
    int [][] matrix;

    public Matrix (int m, int n){
        this.matrix = new int [m][n];
    }
    public Matrix (int n){
        this.matrix = new int [n][n];
    }

    public boolean isSymmetric(int [][] matrix) {
        for (int i =0; i<matrix.length; i++) {
            if (matrix[i][i] != matrix[matrix.length-i][matrix.length-i]){
                return false;
            }
        }
        return true;
    }

    public boolean isDiagonal(int[][]matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (i!=j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIdentity(int[][]matrix){
        for (int i = 0; i<matrix.length; i++){
            if (matrix.length != matrix[i].length){
                return false;
            }
        }

        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (i==j &&matrix[i][j] != 1){
                    return false;
                }
                else if (i!=j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUpperTriangle(int[][]matrix){
        for (int i=0;i<matrix.length;i++){
            if (matrix.length != matrix[i].length){
                return false;
            }
        }

        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (i>j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isTridiagonal(int [][]matrix){
        for (int i=0;i<matrix.length;i++){
            if (matrix.length != matrix[i].length){
                return false;
            }
        }

        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (Math.abs(i-j) >1 && matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

}