//For a given set of Strings, print the largest string
public class Question24 {
    public static String Largest(String fruits[]) {
        String largest = fruits[0];
        for (int i = 0; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        String fruits[] = { "apple", "mango", "banana" };
        System.out.println(Largest(fruits));
    }
}