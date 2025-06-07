//Two Sum
import java.util.HashMap;
import java.util.Map;
public class Question214 {
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (visited.containsKey(diff)) {
                return new int[] { i, visited.get(diff) };
            }
            visited.put(arr[i], i);
        }
        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 4};
        int target = 6;
        int[] answer = twoSum(arr, target);
        System.out.println("[" + answer[0] + ", " + answer[1] + "]");
    }
}