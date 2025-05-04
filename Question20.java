//Print out the sum of the numbers in the second row of the “nums” array.
public class Question20 {
    public static int Sum(int matrix[][]) {
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            sum += matrix[1][j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
        System.out.println(Sum(matrix));
    }
}
 