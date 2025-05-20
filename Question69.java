//Find Subsets
public class Question69 {
    public static void findSubsets(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // If want to become subset
        findSubsets(str, ans + str.charAt(i), i + 1);
        // If don't want to become subset
        findSubsets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "arin";
        findSubsets(str, "", 0);
    }
}
