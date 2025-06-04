//Red black tree
import java.util.*;

public class Question180 {
    public Node root;

    public Question180() {
        super();
        root = null;
    }

    class Node {
        int data;
        Node left;
        Node right;
        char colour;
        Node parent;

        Node(int data) {
            super();
            this.data = data;
            this.left = null;
            this.right = null;
            this.colour = 'R';
            this.parent = null;
        }
    }

    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        if (x.left != null) {
            x.left.parent = h;
        }
        x.parent = h.parent;
        if (h.parent == null) {
            this.root = x;
        } else if (h == h.parent.left) {
            h.parent.left = x;
        } else {
            h.parent.right = x;
        }
        x.left = h;
        h.parent = x;
        return x;
    }

    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        if (x.right != null) {
            x.right.parent = h;
        }
        x.parent = h.parent;
        if (h.parent == null) {
            this.root = x;
        } else if (h == h.parent.left) {
            h.parent.left = x;
        } else {
            h.parent.right = x;
        }
        x.right = h;
        h.parent = x;
        return x;
    }

    public void insert(int data) {
        Node node = new Node(data);
        Node y = null;
        Node x = this.root;

        while (x != null) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            this.root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.colour = 'B';
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixRedBlackViolations(node);
    }

    private void fixRedBlackViolations(Node k) {
        Node u;
        while (k.parent != null && k.parent.colour == 'R') {
            if (k.parent == k.parent.parent.left) {
                u = k.parent.parent.right;
                if (u != null && u.colour == 'R') {
                    k.parent.colour = 'B';
                    u.colour = 'B';
                    k.parent.parent.colour = 'R';
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        rotateLeft(k);
                    }
                    k.parent.colour = 'B';
                    k.parent.parent.colour = 'R';
                    rotateRight(k.parent.parent);
                }
            } else {
                u = k.parent.parent.left;
                if (u != null && u.colour == 'R') {
                    k.parent.colour = 'B';
                    u.colour = 'B';
                    k.parent.parent.colour = 'R';
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rotateRight(k);
                    }
                    k.parent.colour = 'B';
                    k.parent.parent.colour = 'R';
                    rotateLeft(k.parent.parent);
                }
            }
        }
        this.root.colour = 'B';
    }

    void inorderTraversalHelper(Node node) {
        if (node != null) {
            inorderTraversalHelper(node.left);
            System.out.printf("%d ", node.data);
            inorderTraversalHelper(node.right);
        }
    }

    public void inorderTraversal() {
        inorderTraversalHelper(this.root);
        System.out.println();
    }

    void printTreeHelper(Node root, int space) {
        int i;
        if (root != null) {
            space += 10;

            printTreeHelper(root.right, space);

            System.out.printf("\n");
            for (i = 10; i < space; i++) {
                System.out.printf(" ");
            }
            System.out.printf("%d(%c)", root.data, root.colour);

            printTreeHelper(root.left, space);
        }
    }

    public void printTree() {
        printTreeHelper(this.root, 0);
        System.out.println("\n-----------------------------------------------------");
    }

    public static void main(String[] args) {
        Question180 t = new Question180();
        int[] arr = { 1, 4, 6, 3, 5, 7, 8, 2, 9 };

        System.out.println("Inserting elements and showing tree structure after each insertion:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\nInserting " + arr[i] + "...");
            t.insert(arr[i]);
            System.out.print("Inorder Traversal: ");
            t.inorderTraversal();
            t.printTree();
        }

        System.out.println("\nFinal Inorder Traversal of the tree:");
        t.inorderTraversal();
    }
}