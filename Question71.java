//N Queen
public class Question71 {

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
            printBoard(chessBoard);
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

    // Print chessBoard
    public static void printBoard(char chessBoard[][]) {
        System.out.println("-------------------");
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        char chessBoard[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = 'X';
            }
        }
        nQueen(chessBoard, 0);
    }
}

/*
 * Time Complexity: O(n!)
 * Space Complexity: O(n²)
 */