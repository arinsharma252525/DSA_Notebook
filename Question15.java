//Find all triplets with Zero sum
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question15 {
    public static List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> triplet = Arrays.asList(i, j, k);
                        result.add(triplet);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        System.out.println(findTriplets(arr));
    }
}