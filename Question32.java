//Clear ith bit
public class Question32 {
    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static void main(String[] args) {
        int n = 8;
        int i = 2;
        System.out.println(clearIthBit(n, i));
    }
}
 