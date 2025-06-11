//Maximum Subarray Sum (Kadane's Algorithm)
public class Question7 {
    public static int maxSubarraySum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currrSum += arr[i];
            if (currrSum > maxSum) {
                maxSum = currrSum;
            }
            if (currrSum < 0) {
                currrSum = 0;
            }
        }
        return maxSum;
    } 

    public static void main(String args[]) {
        int arr[] = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }
}