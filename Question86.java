//Monotonic Arraylist
import java.util.ArrayList;
public class Question86 {
    public static boolean isMonotonic(ArrayList<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return true;
        }

        int trend = 0;

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) < nums.get(i + 1)) {
                trend = 1;
                break;
            } else if (nums.get(i) > nums.get(i + 1)) {
                trend = -1;
                break;
            }
        }

        if (trend == 0) {
            return true;
        }

        for (int i = 0; i < nums.size() - 1; i++) {
            if (trend == 1) {
                if (nums.get(i) > nums.get(i + 1)) {
                    return false;
                }
            } else {
                if (nums.get(i) < nums.get(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        System.out.println(isMonotonic(nums));
    }
}
