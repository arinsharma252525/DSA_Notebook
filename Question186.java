//Priority Queue using java collection framework
import java.util.PriorityQueue;
public class Question186 {
   public static void main(String[] args) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      pq.add(3);
      pq.add(4);
      pq.add(1);
      pq.add(7);
      while (!pq.isEmpty()) {
         System.out.println(pq.peek());
         pq.remove();
      }
   }
}
