//Pair in array
public class Question5 {
    public static void pairInArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int current = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                int nextElement = arr[j];
                System.out.print("(" + current + "," + nextElement + ")");
            }
            System.out.println();
        } 
    }
    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        pairInArray(numbers);
    }
}