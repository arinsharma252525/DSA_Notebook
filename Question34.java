//Clear last ith bit
public class Question34 {
    public static int clearLastIthBit(int n, int i) {
        int bitmask = (~0) << i;
        return n & bitmask;
    }

    public static void main(String[] args) {
        int n = 15;
        int i = 2;
        System.out.println(clearLastIthBit(n, i));
    }
}