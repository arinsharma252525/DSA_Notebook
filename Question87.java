//Find All Lonely Numbers in the Arraylist
import java.util.ArrayList;
import java.util.List;
public class Question87 {
    public static List<Integer> findLonely(int[] arr) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (l.contains(arr[i]) || l.contains(arr[i] + 1) || l.contains(arr[i] - 1)) {
                l.remove(Integer.valueOf(arr[i]));
                l.remove(Integer.valueOf(arr[i] + 1));
                l.remove(Integer.valueOf(arr[i] - 1));
            } else {
                l.add(arr[i]);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 6, 5, 8 };
        System.out.println(findLonely(nums));
    }
}