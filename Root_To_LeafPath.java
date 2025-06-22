import java.util.*;

public class Root_To_LeafPath{
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) return;

        // Add current node to path
        path.add(root.data);

        // If it's a leaf node, print the path
        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            // Recur left and right
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);
        }

        path.remove(path.size() - 1);
    }

    // BST insert function
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        /*
            Example Tree:
                    5
                   / \
                  3   8
                 / \   \
                1   4   10
        */
        int[] values = {5, 3, 8, 1, 4, 10};
        Node root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println("Root-to-Leaf Paths:");
        printRootToLeaf(root, new ArrayList<>());
    }
}
