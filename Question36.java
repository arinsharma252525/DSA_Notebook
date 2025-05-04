//Check if a number is power of 2 or not
public class Question36 {
    public static boolean isPowerOfTwo(int n){
        return (n & (n - 1)) == 0;
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println(isPowerOfTwo(n));
    }
}
 