//Set Order property
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
public class Question207 {
    public static void main(String[] args) {

        // Hashset (arranged in random order)
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(4);
        hs.add(3);
        hs.add(2);
        hs.add(5);
        System.out.println(hs);

        //LinkedHashSet (arranged in order they are putted)
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(4);
        lhs.add(3);
        lhs.add(2);
        lhs.add(5);
        System.out.println(lhs);

        //TreeSet (Sorted in ascending order)
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(4);
        ts.add(3);
        ts.add(2);
        ts.add(5);
        System.out.println(ts);
    }
}
