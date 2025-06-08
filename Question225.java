//Longest Word in Dictionary
public class Question225 {
    private static class TrieNode {
        private String word;
        private boolean isEnd;
        private TrieNode[] children;

        public TrieNode() {
            this.word = null;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root = new TrieNode();
    private String longestValidWord = "";

    private void insert(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            int childIndex = word.charAt(i) - 'a';
            if (current.children[childIndex] == null) {
                current.children[childIndex] = new TrieNode();
            }
            current = current.children[childIndex];
        }
        current.isEnd = true;
        current.word = word;
    }

    private void dfs(TrieNode node) {
        if (node == null) {
            return;
        }

        if (node.word != null) {
            if (node.word.length() > longestValidWord.length()) {
                longestValidWord = node.word;
            } else if (node.word.length() == longestValidWord.length() && node.word.compareTo(longestValidWord) < 0) {
                longestValidWord = node.word;
            }
        }

        if (node.word != null || node == root) {
            for (TrieNode child : node.children) {
                if (child != null && child.isEnd) {
                    dfs(child);
                }
            }
        }
    }

    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }

        dfs(this.root);
        return longestValidWord;
    }

    public static void main(String[] args) {
        Question225 solution1 = new Question225();
        String[] words1 = {"w","wo","wor","worl","world"};
        System.out.println(solution1.longestWord(words1));

        Question225 solution2 = new Question225();
        String[] words2 = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(solution2.longestWord(words2));
    }
}
