public class ValidateBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static boolean isValidBST(Node root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTUtil(Node root, long min, long max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return isValidBSTUtil(root.left, min, root.data) &&
               isValidBSTUtil(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        System.out.println("Is the tree a valid BST? " + isValidBST(root));

        Node invalidRoot = new Node(5);
        invalidRoot.left = new Node(3);
        invalidRoot.right = new Node(7);
        invalidRoot.left.left = new Node(6);
        invalidRoot.left.right = new Node(4);
        System.out.println("Is the tree a valid BST? " + isValidBST(invalidRoot));
    }
}
