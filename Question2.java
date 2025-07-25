//Matrix Diagonal Sum
public class Question2 {
    public static int diagonalSum(int arr[][]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][i];
            if (i != n - i - 1) {
                sum += arr[i][n - i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
        System.out.println(diagonalSum(arr));
    }
}