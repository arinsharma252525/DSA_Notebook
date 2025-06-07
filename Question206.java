//Iteration on Hashset
import java.util.HashSet;
public class Question206 {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Gurugram");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        // Iterator itr = cities.iterator();
        // while (itr.hasNext()) {
        //     System.out.println(itr.next());
        // }

        for(String city : cities){
            System.out.println(city);
        }
    }
}
