//Pair sum (2 Pointer Approach) - Find if any pair in a sorted arraylist has the target sum
import java.util.ArrayList;
public class Question84 {
    public static boolean pairSum(ArrayList<Integer>nums, int targetSum){
        int left = 0;
        int right = nums.size()-1;
        while (left != right) {
            if(nums.get(left) + nums.get(right) == targetSum){
                return true;
            }
            if(nums.get(left) + nums.get(right) < targetSum){
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println(pairSum(nums, 9));
    }
}
