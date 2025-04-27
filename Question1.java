//Linear Search Algorithm
public class Question1 {
    public static boolean linearSearch(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int target = 3;
        System.out.println(linearSearch(arr, target));
    }
}