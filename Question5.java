//Pair in array
public class Question5 {
    public static void pairInArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        } 
    }
    public static void main(String[] args) {
        int arr[] = {1, 2};
        pairInArray(arr);
    }
}