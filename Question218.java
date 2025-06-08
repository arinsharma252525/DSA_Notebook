//Search in a trie
public class Question218 {
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

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };
        for (String word : words) {
            insert(word);
        }
        System.out.println(Search("the"));
        System.out.println(Search("thor"));
        System.out.println(Search("thee"));
        System.out.println(Search("th")); 
    }
}