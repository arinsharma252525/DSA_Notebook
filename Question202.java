//Map Order property
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Question202 {
    public static void main(String[] args) {

        // Hashmap (arranged in random order)
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Russia", 98);
        hm.put("USA", 85);
        hm.put("China", 80);
        System.out.println(hm);

        // LinkedHashmap (arranged in order they are putted)
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("Russia", 98);
        lhm.put("USA", 85);
        lhm.put("China", 80);
        System.out.println(lhm);

        // Treemap (arranged in sorted alphabetical order)
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("Russia", 98);
        tm.put("USA", 75);
        tm.put("China", 80);
        tm.put("Australlia", 60);
        System.out.println(tm);

    }
}
