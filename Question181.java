//Range Sum of BST
import java.util.*;
public class Question181 {

    static class Node {
        int val;
        Node left, right;
    }

    static Node newNode(int item) {
        Node temp = new Node();
        temp.val = item;
        temp.left = temp.right = null;
        return temp;
    }

    static int sum = 0;

    static int rangeSumBST(Node root, int low, int high) {
        if (root == null)
            return 0;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr.val >= low && curr.val <= high) {
                sum += curr.val;
            }

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return sum;
    }

    static Node insert(Node node, int data) {
        if (node == null)
            return newNode(data);
        if (data <= node.val)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
        return node;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 3);
        insert(root, 7);
        insert(root, 18);

        int L = 7, R = 15;
        System.out.print(rangeSumBST(root, L, R));
    }
}
