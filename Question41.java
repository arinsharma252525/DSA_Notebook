//Convert uppercase characters to lowercase using bits
public class Question41 {
    public static void convertToLowerCase() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' '));
        }
    }

    public static void main(String[] args) {
    convertToLowerCase();
    }
}
