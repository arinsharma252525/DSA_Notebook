//Count how many times lowercase vowels occurred in a String entered by the user
import java.util.Scanner;
public class Question27 {
    public static void Vowels() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println("vowels: " + count);
    }

    public static void main(String[] args) {
        Vowels();
    }
}