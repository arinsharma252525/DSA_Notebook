//AVL trees
public class Question179 {
    static class Node {
        int data;
        int height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static int getBalance(Node root) {
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);
    }

    public static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        else // Duplicate keys not allowed
            return root;

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int bf = getBalance(root);

        // Left Left Case
        if (bf > 1 && key < root.left.data)
            return rightRotate(root);

        // Right Right Case
        if (bf < -1 && key > root.right.data)
            return leftRotate(root);

        // Left Right Case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static Node getMinNode(Node root) {
        Node curr = root;
        while (curr.left != null)
            curr = curr.left;
        return curr;
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else { // This is the node to be deleted
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;

                // No child case
                if (temp == null) {
                    temp = root; // 'root' is the node to be deleted, becomes null
                    root = null;
                } else { // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else { // Node with two children
                // Get the inorder successor (smallest in the right subtree)
                Node temp = getMinNode(root.right);

                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor from the right subtree
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If the tree had only one node and it was deleted
        if (root == null)
            return root;

        // Update height of current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get balance factor of this node
        int bf = getBalance(root);

        // Perform rotations if unbalanced

        // Left Left Case
        if (bf > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (bf < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (bf < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }


    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        System.out.println("Preorder traversal of constructed AVL tree is:");
        preorder(root);
        System.out.println(); // For a new line

        // Example deletion
        System.out.println("\nDeleting 30...");
        root = deleteNode(root, 30);
        System.out.println("Preorder traversal after deleting 30:");
        preorder(root);
        System.out.println();
    }
}