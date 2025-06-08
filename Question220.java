//Prefix problem
public class Question220 {
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        int frequency;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            frequency = 0;
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
            current.children[index].frequency++;
            current = current.children[index];
        }
        current.endOfWord = true;
    }

    public static void findPrefix(Node current, String answer) {
        if (current.frequency == 1) {
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < current.children.length; i++) {
            if (current.children[i] != null) {
                findPrefix(current.children[i], answer + (char) (i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = { "zebra", "dog", "duck", "dove" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        
        findPrefix(root, "");
    }
}