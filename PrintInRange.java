public class PrintInRange {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) return;

        // Since the tree is BST, we use its properties
        if (k1 < root.data) {
            printInRange(root.left, k1, k2);
        }

        if (k1 <= root.data && root.data <= k2) {
            System.out.print(root.data + " ");
        }

        if (k2 > root.data) {
            printInRange(root.right, k1, k2);
        }
    }
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Main method
    public static void main(String[] args) {
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        Node root = null;

        for (int val : values) {
            root = insert(root, val);
        }

        int k1 = 5, k2 = 13;
        System.out.println("Nodes between " + k1 + " and " + k2 + ":");
        printInRange(root, k1, k2);
    }
}
