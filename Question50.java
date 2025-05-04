//Write a program to find the last occurrence of an element in an array
public class Question50 {
    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int found = lastOccurence(arr, key, i + 1);
        if (found == -1 && arr[i] == key) {
            return i;
        }
        return found;
    }

    public static void main(String[] args) {
        int arr[] = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        System.out.println(lastOccurence(arr, 5, 0));
    }
}
