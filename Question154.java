//Diameter of tree
public class Question154 {
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
        int diameter;
        int height;

        public Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
                leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(diameter, height);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(diameter(root).diameter);
    }
}
