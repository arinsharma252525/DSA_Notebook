//Zigzag linkedlist
public class Question96 {
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

    // add at first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
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

    // Zigzag linkedlist
    public void zigzag() {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        // merge two half in zigzag fashion
        while (left != null && right != null) {
            Node nextLeft = left.next;
            left.next = right;
            Node nextRight = right.next;
            right.next = nextLeft;
            left = nextLeft;
            right = nextRight;
        }
    }

    public static void main(String[] args) {
        Question96 ll = new Question96();
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        ll.zigzag();
        ll.print();
    }
}
