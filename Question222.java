//Count Unique Substrings
public class Question222 {
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

    public static void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.endOfWord = true;
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

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNode(root.children[i]); 
            }
        }
        return count + 1; 
    }

    public static void main(String[] args) {
        String str = "apple";
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNode(root));
    }
}