public class SearchABinarysearchtree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        } else if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int[] values = {50, 30, 20, 40, 70, 60, 80};

        for (int value : values) {
            root = insert(root, value);
        }

        int key = 60;
        if (search(root, key)) {
            System.out.println(key + " is found in the BST.");
        } else {
            System.out.println(key + " is not found in the BST.");
        }
    }
}
