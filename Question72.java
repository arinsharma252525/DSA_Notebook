//N Queen - Count Ways
public class Question72 {

    // Checks if queen is safe to place or not
    public static boolean isSafe(char chessBoard[][], int row, int col) {
        // Vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }
        // Diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        // Diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard.length; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueen(char chessBoard[][], int row) {
        // Base case
        if (row == chessBoard.length) {
            count++;
            return;
        }

        // Column loop
        for (int j = 0; j < chessBoard.length; j++) {
            if (isSafe(chessBoard, row, j)) {
                chessBoard[row][j] = 'Q';
                nQueen(chessBoard, row + 1);
                chessBoard[row][j] = 'X';
            }
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        char chessBoard[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = 'X';
            }
        }
        nQueen(chessBoard, 0);
        System.out.println("Total ways: " + count);
    }
}