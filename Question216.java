//LRU Cache
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Question216 {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public Question216(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            addNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(head.next.key);
                removeNode(head.next);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
        }
    }

    private void addNode(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        Question216 lruCache = new Question216(2); 
        List<Integer> results = new ArrayList<>();

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        results.add(lruCache.get(1));
        lruCache.put(3, 3);
        results.add(lruCache.get(2));
        lruCache.put(4, 4);
        results.add(lruCache.get(1));
        results.add(lruCache.get(3));
        results.add(lruCache.get(4));

        System.out.print("[null, null, ");
        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i));
            if (i < results.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}