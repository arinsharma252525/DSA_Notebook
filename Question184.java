//Two Sum BSTs
import java.util.Stack;
public class Question184 {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static Node root1;
    static Node root2;

    static int countPairs(Node root1, Node root2, int x) {
        if (root1 == null || root2 == null)
            return 0;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        int count = 0;

        Node current1 = root1;
        while (current1 != null) {
            st1.push(current1);
            current1 = current1.left;
        }

        Node current2 = root2;
        while (current2 != null) {
            st2.push(current2);
            current2 = current2.right;
        }

        while (!st1.isEmpty() && !st2.isEmpty()) {
            Node top1 = st1.peek();
            Node top2 = st2.peek();

            int sum = top1.data + top2.data;

            if (sum == x) {
                count++;

                Node popped1 = st1.pop();
                Node temp1 = popped1.right;
                while (temp1 != null) {
                    st1.push(temp1);
                    temp1 = temp1.left;
                }

                Node popped2 = st2.pop();
                Node temp2 = popped2.left;
                while (temp2 != null) {
                    st2.push(temp2);
                    temp2 = temp2.right;
                }
            } else if (sum < x) {
                Node popped1 = st1.pop();
                Node temp1 = popped1.right;
                while (temp1 != null) {
                    st1.push(temp1);
                    temp1 = temp1.left;
                }
            } else {
                Node popped2 = st2.pop();
                Node temp2 = popped2.left;
                while (temp2 != null) {
                    st2.push(temp2);
                    temp2 = temp2.right;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        int x = 16;
        System.out.println("Pairs = " + countPairs(root1, root2, x));
    }
}
