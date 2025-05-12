//Search in rotated sorted array
public class Question64 {
    public static int Search(int arr[], int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target <= arr[mid]) {
                return Search(arr, target, start, mid - 1);
            } else {
                return Search(arr, target, mid + 1, end);
            }
        } else {
            if (arr[mid] <= target && target <= arr[end]) {
                return Search(arr, target, mid + 1, end);
            } else {
                return Search(arr, target, start, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6;
        int Index = Search(arr, target, 0, arr.length - 1);
        System.out.println(Index);
    }
}