//Write a program to Find Transpose of a Matrix using for loops.
public class Question21 {
    public static int[][] transposeMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int transpose [][] = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }


    public static void main(String[] args) {
        int[][] matrix = { { 2, 3, 7 }, { 5, 6, 7 } };
        int[][] transposedMatrix = transposeMatrix(matrix);
        System.out.println("Original Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        } 

        System.out.println("Transpose of the Matrix:");
        for (int i = 0; i < transposedMatrix.length; i++) {
            for (int j = 0; j < transposedMatrix[0].length; j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}