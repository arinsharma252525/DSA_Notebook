//Counting Sort (Decreasing order)
public class Question15 {
    public static void countingSort(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int count[] = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // Sorting
        int j = 0;
        for (int i = count.length-1; i >= 0; i--) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    } 

    public static void main(String args[]) {
        int arr[] = { 3, 2, 5, 6, 1, 4, 7, 9, 8, 10 };
        countingSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
 * Time Complexity: O(n + k)
 * Space Complexity: O(k)
 */