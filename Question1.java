public class Question1 {
    public static void spiralMatrix(int arr[][]) {
        int startRow = 0;
        int endRow = arr.length - 1;
        int startCol = 0;
        int endCol = arr[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(arr[startRow][j] + " ");
            }
            startRow++;

            // Right
            for (int i = startRow; i <= endRow; i++) {
                System.out.print(arr[i][endCol] + " ");
            }
            endCol--;

            // Bottom
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    System.out.print(arr[endRow][j] + " ");
                }
            }
            endRow--;

            // Left
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    System.out.print(arr[i][startCol] + " ");
                }
            }
            startCol++;
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        spiralMatrix(arr);
    }
}