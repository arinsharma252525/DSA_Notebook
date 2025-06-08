//Group Anagrams Together
import java.util.*;
class TrieNode {
    List<String> words;
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        words = new ArrayList<>();
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class Question224 {
    static TrieNode root;
    List<List<String>> resultGroups;

    public List<List<String>> groupAnagrams(String[] inputStrings) {
        resultGroups = new ArrayList<>();
        root = new TrieNode();

        for (String word : inputStrings) {
            buildTrie(word);
        }

        depthFirstSearch(root);
        return resultGroups;
    }

    public void buildTrie(String word) {
        TrieNode currentNode = root;
        char[] characters = word.toCharArray();
        Arrays.sort(characters);

        for (char character : characters) {
            TrieNode childNode = currentNode.children[character - 'a'];
            if (childNode == null) {
                currentNode.children[character - 'a'] = new TrieNode();
            }
            currentNode = currentNode.children[character - 'a'];
        }
        currentNode.isEndOfWord = true;
        currentNode.words.add(word);
    }

    public void depthFirstSearch(TrieNode node) {
        if (node.isEndOfWord) {
            resultGroups.add(node.words);
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                depthFirstSearch(node.children[i]);
            }
        }
    }

    public static void main(String[] args) {
        Question224 solution = new Question224();
        String[] words1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams1 = solution.groupAnagrams(words1);
        System.out.println(groupedAnagrams1);

        Question224 solution2 = new Question224();
        String[] words2 = {""};
        List<List<String>> groupedAnagrams2 = solution2.groupAnagrams(words2);
        System.out.println(groupedAnagrams2);
        
        Question224 solution3 = new Question224();
        String[] words3 = {"a"};
        List<List<String>> groupedAnagrams3 = solution3.groupAnagrams(words3);
        System.out.println(groupedAnagrams3);
    }
}
