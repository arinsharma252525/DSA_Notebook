//Transpose of Matrix 
public class Question4 {
    public static int[][] transpose(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        int[][] transposed = new int[column][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transposed[j][i] = arr[i][j];
            }
        }
        return transposed;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 11, 12, 13 }, { 21, 22, 23 } };

        System.out.println("Original Matrix:");
        printMatrix(arr);

        int[][] transposedMatrix = transpose(arr);

        System.out.println("Transposed Matrix:");
        printMatrix(transposedMatrix);
    }
}