//Maximum in an Arraylist
import java.util.ArrayList;
public class Question80 {
    public static int findMax(ArrayList<Integer> nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i));
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(91);
        nums.add(29);
        nums.add(320);
        nums.add(49);
        nums.add(58);
        System.out.println(findMax(nums));
    }
}
