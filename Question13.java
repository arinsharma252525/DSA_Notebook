//Trapping Rainwater
public class Question13 {
    public static int trappingRainwater(int[] height) {
        int n = height.length;

        int i = 0;
        int j = n - 1;
        int trappedWater = 0;
        int leftMax = 0;
        int rightMax = 0;
  
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] >= leftMax) {
                    leftMax = height[i];
                } else {
                    trappedWater += leftMax - height[i];
                }
                i++;
            } else {
                if (height[j] >= rightMax) {
                    rightMax = height[j];
                } else {
                    trappedWater += rightMax - height[j];
                }
                j--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trappingRainwater(height));
    }
}
