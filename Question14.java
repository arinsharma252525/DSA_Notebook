//Insertion Sort (Decreasing order)
public class Question14 {
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 3, 2, 5, 6, 1, 4, 7, 9, 8, 10 };
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    } 
}

/*
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */