//Fast Exponentiation
public class Question38 {
    public static int fastExponentiation(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans *= a;
            }
            a *= a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 6;
        int n = 3;
        System.out.println(fastExponentiation(a, n));
    }
}
