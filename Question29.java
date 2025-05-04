//Odd or even
public class Question29 {
    public static void oddOrEven(int n){
        int bitmask = 1;
        if((n & bitmask) == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
    public static void main(String[] args) {
       int n = 29;
       oddOrEven(n); 
    }
} 