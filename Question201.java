//Hashmap Implementation
import java.util.ArrayList;
import java.util.LinkedList;

public class Question201 {

    static class MyHashMap<K, V> {

        private static class Node<K, V> {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private int capacity;
        private LinkedList<Node<K, V>>[] buckets;

        @SuppressWarnings("unchecked")
        public MyHashMap() {
            this.capacity = 4;
            this.buckets = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private void rehash() {
            LinkedList<Node<K, V>>[] oldBuckets = buckets;
            capacity = 2 * capacity;

            @SuppressWarnings("unchecked")
            LinkedList<Node<K, V>>[] newBuckets = new LinkedList[capacity];
            this.buckets = newBuckets;

            for (int i = 0; i < capacity; i++) {
                this.buckets[i] = new LinkedList<>();
            }

            size = 0;

            for (LinkedList<Node<K, V>> linkedList : oldBuckets) {
                for (Node<K, V> node : linkedList) {
                    put(node.key, node.value);
                }
            }
        }

        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % capacity;
        }

        private int searchInBucket(K key, int bucketIndex) {
            LinkedList<Node<K, V>> linkedList = buckets[bucketIndex];
            for (int i = 0; i < linkedList.size(); i++) {
                Node<K, V> node = linkedList.get(i);
                if (node.key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int nodeIndex = searchInBucket(key, bucketIndex);

            if (nodeIndex != -1) {
                Node<K, V> node = buckets[bucketIndex].get(nodeIndex);
                node.value = value;
            } else {
                buckets[bucketIndex].add(new Node<>(key, value));
                size++;
            }

            double loadFactor = (double) size / capacity;
            if (loadFactor > 0.75) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int nodeIndex = searchInBucket(key, bucketIndex);
            return nodeIndex != -1;
        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int nodeIndex = searchInBucket(key, bucketIndex);

            if (nodeIndex != -1) {
                Node<K, V> node = buckets[bucketIndex].remove(nodeIndex);
                size--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int nodeIndex = searchInBucket(key, bucketIndex);

            if (nodeIndex != -1) {
                Node<K, V> node = buckets[bucketIndex].get(nodeIndex);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node<K, V>> linkedList : buckets) {
                for (Node<K, V> node : linkedList) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        map.put("apple", 15);

        System.out.println("Contains apple: " + map.containsKey("apple"));
        System.out.println("Value of banana: " + map.get("banana"));
        System.out.println("Value of grape: " + map.get("grape"));

        System.out.println("Keys: " + map.keySet());

        System.out.println("Removing orange: " + map.remove("orange"));
        System.out.println("Keys after removal: " + map.keySet());

        System.out.println("Map is empty: " + map.isEmpty());

        map.put("grape", 40);
        map.put("kiwi", 50);
        map.put("mango", 60);
        map.put("pear", 70);
        System.out.println("Map size: " + map.size());
        System.out.println("Keys after adding more: " + map.keySet());
    }
}
