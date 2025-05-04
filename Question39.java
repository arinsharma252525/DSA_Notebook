//Swap two numbers without using any third variable.
public class Question39 {
    public static void Swap(int x, int y){
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x = " + x + ", y = " + y);
    }
    public static void main(String[] args) {
        int x = 7;
        int y = 25;
        Swap(x, y);
    }
}
 