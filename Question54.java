//Remove Duplicates
public class Question54 {
    public static void removeDuplicates(String str, int i, StringBuilder newstr, boolean map[]) {
        if (i == str.length()) {
            System.out.println(newstr);
            return;
        }
        char currChar = str.charAt(i);
        if (map[currChar - 'a'] == true) {
            removeDuplicates(str, i + 1, newstr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, i + 1, newstr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
    String str = "arinsharma";
    removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
