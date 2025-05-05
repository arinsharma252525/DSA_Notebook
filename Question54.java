//Remove Duplicates
public class Question54 {
    public static void removeDuplicates(String str, int index, StringBuilder newstr, boolean map[]) {
        if (index == str.length()) {
            System.out.println(newstr);
            return;
        }
        char currChar = str.charAt(index);
        if (map[currChar - 'a'] == true) {
            removeDuplicates(str, index + 1, newstr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, index + 1, newstr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
    String str = "arinsharma";
    removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
