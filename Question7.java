//Maximum Subarray Sum
public class Question7 {
    public static int maxSum(int arr[]) {
        int maxSum = arr[0];
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 7, 8 };
        System.out.println(maxSum(arr));
    }
}