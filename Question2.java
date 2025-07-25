//Largest Element in Array
public class Question2 {
    public static int largestElement(int arr[]) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 8, 7, 56, 90 };
        System.out.println(largestElement(arr));
    }
}
 