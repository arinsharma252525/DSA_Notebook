//Modular Exponentiation
public class Question42 {
    public static int modularExponentiation(int x, int n, int m) {
        int res = 1;
        x = x % m;

        if (x == 0) {
            return 0;
        }

        while (n > 0) {
            if ((n & 1) == 1)
                res = (res * x) % m;

            n = n >> 1;
            x = (x * x) % m;
        }
        return res;
    }

    public static void main(String[] args) {
    int x = 2;
    int n = 6;
    int m = 10;
    System.out.println(modularExponentiation(x, n, m));
    }
}
 