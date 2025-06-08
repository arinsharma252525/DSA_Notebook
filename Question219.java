//Word Break problem
public class Question219 {
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // Insertion
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }

    // Search
    public static boolean Search(String key) {
        Node current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.endOfWord == true;
    }

    // Word break
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (Search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
