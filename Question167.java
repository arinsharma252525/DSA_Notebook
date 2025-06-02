//Maximum Path Sum in a Binary Tree
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Res {
    public int val;
}

public class Question167 {
    Node root;

    int findMaxUtil(Node node, Res res) {
        if (node == null)
            return 0;

        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        int max_single = Math.max(Math.max(l, r) + node.data, node.data);

        int max_top = Math.max(max_single, l + r + node.data);

        res.val = Math.max(res.val, max_top);

        return max_single;
    }

    int findMaxSum(Node node) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        findMaxUtil(node, res);
        return res.val;
    }

    public static void main(String args[]) {
        Question167 tree = new Question167();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        System.out.println("maximum path sum is :" +
                tree.findMaxSum(tree.root));
    }
}
