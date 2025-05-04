//Print number from n to 1 in decreasing order
public class Question43 {
    public static void Decreasing(int n) {
        // base case
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        Decreasing(n - 1);
    }

    public static void main(String[] args) {
        Decreasing(10);
    }
}
