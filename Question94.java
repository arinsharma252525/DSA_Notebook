//Add & Remove using java collection framework
import java.util.LinkedList;
public class Question94 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        //add
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        System.out.println(ll);
        ll.remove(2);
        System.out.println(ll);
    }
}
