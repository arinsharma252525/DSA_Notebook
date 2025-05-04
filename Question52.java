//Print x^n (Optimised)
public class Question52 {
    public static int Power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = Power(x, n / 2);
        int result = halfPower * halfPower;
        if (n % 2 != 0) {
            result = x * result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(2, 10));
    }
}