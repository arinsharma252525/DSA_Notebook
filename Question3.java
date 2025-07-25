//Search in a sorted Matrix
public class Question3 {
    public static boolean searchMatrix(int arr[][], int target) {
        int row = 0;
        int column = arr[0].length - 1;
        while (row < arr.length && column >= 0) {
            if (arr[row][column] == target) {
                return true;
            } else if (arr[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 5, 9, 11 }, { 14, 20, 21, 26 }, { 30, 34, 43, 50 } };
        int target = 42;
        System.out.println(searchMatrix(arr, target));
    }
}