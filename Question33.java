//Update ith bit
public class Question33 {
    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static int updateIthBit(int n, int i, int newbit) {
        n = clearIthBit(n, i);
        int bitmask = newbit << i;
        return n | bitmask;
    }

    public static void main(String[] args) {
        int n = 10;
        int i = 2;
        int newbit = 1;
        System.out.println(updateIthBit(n, i, newbit));
    }
}
 