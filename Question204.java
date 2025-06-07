//Valid Anagram
import java.util.HashMap;
public class Question204 {
    public static boolean isAnagram(String x, String y) {
        if (x.length() != y.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < y.length(); i++) {
            char ch = y.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String x = "race";
        String y = "care";
        System.out.println(isAnagram(x, y));
    }
}
