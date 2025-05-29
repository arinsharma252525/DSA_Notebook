//Lexicographically smallest string of length N and sum K
import java.util.Arrays;
public class Question146 {

    public static char[] lexo_small(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');

        for (int i = n - 1; i >= 0; i--) {
            k -= 1;

            if (k >= 25) {
                arr[i] = 'z';
                k -= 25;
            } else if (k > 0) {
                arr[i] = (char) ('a' + k);
                k = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int n1 = 5;
        int k1 = 42;
        char[] result1 = lexo_small(n1, k1);
        System.out.println("N = " + n1 + ", K = " + k1 + " -> " + new String(result1));

        int n2 = 3;
        int k2 = 25;
        char[] result2 = lexo_small(n2, k2);
        System.out.println("N = " + n2 + ", K = " + k2 + " -> " + new String(result2));
    }
}