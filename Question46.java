//Print sum of first n natural number
public class Question46 {
    public static int Sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + Sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(Sum(5));
    }
}

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */