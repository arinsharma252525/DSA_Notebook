//Pair sum (2 Pointer Approach) - Find if any pair in a sorted & rotated arraylist has the target sum
import java.util.ArrayList;
public class Question85 {
    public static boolean pairSum(ArrayList<Integer> nums, int target) {
        int pivot = -1;
        int n = nums.size();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        int left = pivot + 1;
        int right = pivot;
        while (left != right) {
            if (nums.get(left) + nums.get(right) == target) {
                return true;
            }
            if (nums.get(left) + nums.get(right) < target) {
                left = (left + 1) % n;
            } else {
                right = (n + right - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(11);
        nums.add(15);
        nums.add(6);
        nums.add(8);
        nums.add(9);
        nums.add(10);
        System.out.println(pairSum(nums, 100));
    }
}
