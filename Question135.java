//Reversing the first K elements of a Queue
import java.util.*;

public class Question135 {
    public static Queue<Integer> reverseFirstKElements(Queue<Integer> q, int k) {
        if (k < 0 || k > q.size()) {
            System.out.println("Error: 'k' is out of bounds. No reversal performed.");
            return q;
        }
        if (k == 0 || k == 1) {
            return q;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        int remainingElements = q.size() - k;
        for (int i = 0; i < remainingElements; i++) {
            q.offer(q.poll());
        }

        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);
        q.offer(60);
        q.offer(70);
        q.offer(80);
        q.offer(90);
        q.offer(100);

        int k = 5;

        System.out.println("Original Queue: " + q);
        Queue<Integer> resultQ1 = reverseFirstKElements(q, k);
        System.out.println("Reversed Queue: " + resultQ1);
    }
}
