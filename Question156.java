//Top view of a tree
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Question156 {
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

    static class Info {
        Node node;
        int horizontalDistance;

        public Info(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    public static void topView(Node root) {
        if (root == null) {
            return;
        }

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0;
        int max = 0;

        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (!map.containsKey(curr.horizontalDistance)) {
                map.put(curr.horizontalDistance, curr.node);
            }

            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.horizontalDistance - 1));
                min = Math.min(min, curr.horizontalDistance - 1);
            }

            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.horizontalDistance + 1));
                max = Math.max(max, curr.horizontalDistance + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Top View of the tree:");
        topView(root);
    }
}