//Container with most water (2 pointer approach)
import java.util.ArrayList;
public class Question83 {
    public static int mostWater(ArrayList<Integer>heights){
        int maxWater = 0;
        int left = 0;
        int right = heights.size()-1;
        while(left < right){
            int h = Math.min(heights.get(left), heights.get(right));
            int width = right - left;
            int currentWater = h * width;
            maxWater = Math.max(maxWater, currentWater);
            if(heights.get(left) < heights.get(right)){
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);
        System.out.println(mostWater(heights));
    }
}
