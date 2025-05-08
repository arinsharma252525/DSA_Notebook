//Write a program to find Length of a String using Recursion
public class Question59 {
    public static int length(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return length(str.substring(1)) + 1;
    }

    public static void main(String[] args) {
        String str = "arinsharma";
        System.out.println(length(str));
    }
}
