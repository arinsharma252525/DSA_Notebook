//Trapping rainwater
public class Question8 {
    public static int trappingRainwater(int height[]) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        // Calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        } 

        // Calculate right max boundary
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // Trapped Water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void main(String args[]) {
        int height[] = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(trappingRainwater(height));
    }
}