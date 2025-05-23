//addFirst, addLast, size, addMiddle, removeFirst, removeLast, iterative search, recursive search, reverse, remove nth node & print a LinkedList
public class Question90 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add at first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // add at last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // add in the middle
    public void addMiddle(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove from first
    public int removeFirst() {
        if (size == 0) {
            System.out.println("linkedlist is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            return value;
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    // remove from last
    public int removeLast() {
        if (head == null) {
            System.out.println("linkedlist is empty");
            return Integer.MIN_VALUE;
        } else if (head == tail) {
            int value = head.data;
            head = tail = null;
            return value;
        }
        Node previous = head;
        while (previous.next != tail) {
            previous = previous.next;
        }
        int value = tail.data;
        previous.next = null;
        tail = previous;
        return value;
    }

    // Iterative Search
    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Recursive Search
    public int recursiveSearch(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int index = recursiveSearch(head.next, key);
        if (index == -1) {
            return -1;
        }
        return index + 1;
    }

    public int Search(int key) {
        return recursiveSearch(head, key);
    }

    // Reverse a linkedlist
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find and remove nth node
    public void removeNth(int n) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == size) {
            head = head.next;
            return;
        }
        int i = 1;
        int indexToFind = size - n;
        Node prev = head;
        while (i < indexToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // print a linkedlist
    public void print() {
        if (head == null) {
            System.out.println("linkedlist is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "=>");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Question90 ll = new Question90();
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.addLast(5);
        ll.print();
        ll.addLast(6);
        ll.print();
        ll.addMiddle(1, 2);
        ll.print();
        System.out.println(ll.size);
        ll.removeFirst();
        ll.print();
        ll.removeLast();
        ll.print();
        System.out.println(ll.iterativeSearch(3));
        System.out.println(ll.recursiveSearch(head, 6));
        ll.reverse();
        ll.print();
        ll.removeNth(3);
        ll.print();
    }
}
