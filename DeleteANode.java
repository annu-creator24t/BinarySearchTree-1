public class DeleteANode {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static Node findInorderSuccessor(Node root) {
        Node current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    static Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Node found

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children - use inorder successor
            Node successor = findInorderSuccessor(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println("Original BST (inorder):");
        inorder(root);

        System.out.println("\n\nDeleting node with no child (20):");
        root = delete(root, 20);
        inorder(root);

        System.out.println("\n\nDeleting node with one child (30):");
        root = delete(root, 30);
        inorder(root);

        System.out.println("\n\nDeleting node with two children (50):");
        root = delete(root, 50);
        inorder(root);
    }
}
