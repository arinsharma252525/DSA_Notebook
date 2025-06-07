//Operations on Hashset
import java.util.HashSet;
public class Question205 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        System.out.println(hs);
        hs.remove(4);
        System.out.println(hs);
        System.out.println(hs.contains(5));
        hs.clear();
        System.out.println(hs.isEmpty());
    }
}
