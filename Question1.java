//Array Search (Linear Search Algorithm)
public class Question1 {
    public static int arraySearch(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        } 
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 8, 30 };
        int x = 6; 
        System.out.println(arraySearch(arr, x));
    }
}

//Time Complexity: O(n)