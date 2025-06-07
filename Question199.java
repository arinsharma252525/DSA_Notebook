//Hashmap operations
import java.util.HashMap;
public class Question199 {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Russia", 98);
        hm.put("USA", 85);
        hm.put("China", 80);
        System.out.println(hm);
        System.out.println(hm.get("India"));
        System.out.println(hm.containsKey("Nepal"));
        hm.remove("China");
        System.out.println(hm);
        System.out.println(hm.size());
    }
}
