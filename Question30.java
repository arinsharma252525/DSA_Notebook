//Get ith bit
public class Question30 {
    public static int getIthBit(int n, int i){
        int bitmask = 1 << i;
        if((n & bitmask) == 0){
            return 0;
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
       int n = 10;
       int i = 2;
       System.out.println(getIthBit(n, i));
    }
}
 