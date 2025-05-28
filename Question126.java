//First non-repeating letter in a stream of character
import java.util.LinkedList;
import java.util.Queue;

public class Question126 {
    public static void printNonRepeating(String str) {
        int frequency[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            frequency[ch - 'a']++;

            while (!q.isEmpty() && frequency[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " " );
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
