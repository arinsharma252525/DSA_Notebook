//Minimum absolute difference pairs
import java.util.Arrays;
public class Question139 {
    public static void main(String[] args) {
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDifference = 0;
        for(int i = 0; i < A.length; i++){
            minDifference += Math.abs(A[i] - B[i]);
        }
        System.out.println("Minimum absolute difference of pairs: " + minDifference);
    }
}
