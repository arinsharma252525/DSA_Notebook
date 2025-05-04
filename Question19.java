//Print the number of 7’s that are in the 2d array
public class Question19 {
    public static int numberOf7s(int matrix[][]){
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 7){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int matrix[][]= { {4,7,8}, {7,8,7} }; 
        System.out.println(numberOf7s(matrix));
    }
}
 