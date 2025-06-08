//Insert in a trie
public class Question217 {
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

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };
        for (String word : words) {
            insert(word);
            System.out.println("  Inserted: \"" + word + "\"");
        }
    }
}
