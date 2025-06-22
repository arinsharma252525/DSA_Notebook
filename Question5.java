//Chocolate Distribution Problem
import java.util.ArrayList;
import java.util.Collections;
public class Question5 {
    public static int findMinDifference(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - m; i++) {
            int difference = arr.get(i + m - 1) - arr.get(i);
            if (min > difference) {
                min = difference;
            }
        }
        return min;
    }

    public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(3);
    arr.add(4);
    arr.add(1);
    arr.add(9);
    arr.add(56);
    int m = 5;
    System.out.println(findMinDifference(arr, m));
    }
}
