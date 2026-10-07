package za.ac.cput.partD;

/**
 * Binary Search Tree implementation from scratch.
 * Operations: insert, search, delete, in-order, pre-order, post-order traversals.
 * Average-case complexity: O(log n)
 * Worst-case complexity: O(n) when tree becomes unbalanced (e.g., sorted input)
 */
public class BinarySearchTree {

    /**
     * Node class for the BST.
     */
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts a new value into the BST.
     */
    public void insert(int data) {
        root = insertRec(root, data);
    }

    /**
     * Recursive helper for insert.
     */
    private Node insertRec(Node node, int data) {
        // If the tree is empty, create a new node
        if (node == null) {
            return new Node(data);
        }

        // Recur down the tree
        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        }
        // If data == node.data, we don't insert duplicates

        return node;
    }

    /**
     * Searches for a value in the BST.
     *
     * @return true if found, false otherwise
     */
    public boolean search(int data) {
        return searchRec(root, data);
    }

    /**
     * Recursive helper for search.
     */
    private boolean searchRec(Node node, int data) {
        // Base case: node is null or data is present
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }

        // Data is smaller than node's data, search left
        if (data < node.data) {
            return searchRec(node.left, data);
        }

        // Data is larger than node's data, search right
        return searchRec(node.right, data);
    }

    /**
     * Deletes a value from the BST.
     *
     * @return true if deleted, false if not found
     */
    public boolean delete(int data) {
        if (!search(data)) {
            return false;
        }
        root = deleteRec(root, data);
        return true;
    }

    /**
     * Recursive helper for delete.
     */
    private Node deleteRec(Node node, int data) {
        // Base case: if the tree is empty
        if (node == null) {
            return node;
        }

        // Recur down the tree
        if (data < node.data) {
            node.left = deleteRec(node.left, data);
        } else if (data > node.data) {
            node.right = deleteRec(node.right, data);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: get the inorder successor (smallest in right subtree)
            node.data = minValue(node.right);

            // Delete the inorder successor
            node.right = deleteRec(node.right, node.data);
        }

        return node;
    }

    /**
     * Finds the minimum value in a subtree.
     */
    private int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.data;
            node = node.left;
        }
        return minValue;
    }

    /**
     * In-order traversal (Left, Root, Right).
     * Produces sorted output.
     */
    public void inOrderTraversal() {
        System.out.print("In-order: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    /**
     * Pre-order traversal (Root, Left, Right).
     */
    public void preOrderTraversal() {
        System.out.print("Pre-order: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    /**
     * Post-order traversal (Left, Right, Root).
     */
    public void postOrderTraversal() {
        System.out.print("Post-order: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    /**
     * Checks if the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }
}
