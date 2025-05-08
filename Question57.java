//Recursive program to find all Indices of a Number
public class Question57 {
    public static void allOccurences(int arr[], int key, int i) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.print(i + " ");
        }
        allOccurences(arr, key, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 2, 5};
        int key = 2;
        allOccurences(arr, key, 0);
        System.out.println();
    }
}
