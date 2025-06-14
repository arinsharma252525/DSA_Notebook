//Kth ancestor of node
public class Question161 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int KthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDistance = KthAncestor(root.left, n, k);
        int rightDistance = KthAncestor(root.right, n, k);

        if (leftDistance == -1 && rightDistance == -1) {
            return -1;
        }

        int max = Math.max(leftDistance, rightDistance);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n = 5, k = 1;
        KthAncestor(root, n, k);
    }
}
