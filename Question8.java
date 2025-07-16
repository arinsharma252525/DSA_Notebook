//Trapping Rain Water
public class Question8 {
    public static int trappedRainwater(int arr[]) {
        int n = arr.length;
        int trappedWater = 0;

        // Calculate leftMax
        int leftMax[] = new int[n];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Calculate rightMax
        int rightMax[] = new int[n];
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Calculate trapped water
        for (int i = 1; i < n - 1; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - arr[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(trappedRainwater(arr));
    }
}