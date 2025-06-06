//Code to add, peek & remove in a heap
import java.util.ArrayList;
public class Question188 {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Add
        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1;
            int parent = (x - 1) / 2;

            while (x > 0 && arr.get(x) < arr.get(parent)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
                x = parent;
                parent = (x - 1) / 2;
            }
        }

        // Peek
        public int peek() {
            return arr.get(0);
        }

        // Heapify
        private void Heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                Heapify(minIdx);
            }
        }

        // Remove
        public int remove() {
            if (arr.isEmpty()) {
                return -1;
            }
            int data = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);
            Heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.isEmpty();
        }
    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
