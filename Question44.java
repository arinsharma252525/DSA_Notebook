//Print number from 1 to n in increasing order
public class Question44 {
    public static void Increasing(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        Increasing(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Increasing(15);
    }
}