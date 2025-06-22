public class MirrorBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void mirror(Node root) {
        if (root == null) return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Inorder of original BST: ");
        inorder(root);
        System.out.println();

        mirror(root);

        System.out.print("Inorder of mirrored BST: ");
        inorder(root);
        System.out.println();
    }
}
