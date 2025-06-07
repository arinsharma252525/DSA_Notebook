//Iteration on hashmap
import java.util.HashMap;
import java.util.Set;
public class Question200 {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Russia", 98);
        hm.put("USA", 85);
        hm.put("China", 80);
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("key:" + k + ", value:" + hm.get(k));
        }
    }
}
