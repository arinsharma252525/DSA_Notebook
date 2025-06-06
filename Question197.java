//Minimum Operations to Halve Array Sum
import java.util.*;
public class Question197 {
    public static int minops(ArrayList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.size(); i++) {
            pq.add(-nums.get(i));
        }

        double temp = sum;
        int cnt = 0;
        while (temp > sum / 2.0) { // Changed to 2.0 to ensure double division
            int x = -pq.peek();
            pq.remove();
            temp -= Math.ceil(x * 1.0 / 2);
            pq.add(-(x / 2)); // Integer division for x/2 then negated
            cnt++;
        }
        return cnt;
    }

    public static void main(String args[]) {
        ArrayList<Integer> nums = new ArrayList<>(
                List.of(1, 5, 8, 19));

        int count = minops(nums);
        System.out.println(count);
    }
}
