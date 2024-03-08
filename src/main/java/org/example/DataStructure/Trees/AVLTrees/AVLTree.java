package org.example.DataStructure.Trees.AVLTrees;

public class AVLTree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public void add(T obj) {
        Node<T> forAdd = new Node<>(null, null, null, obj);
        if (root == null) {
            root = forAdd;
            size++;
            return;
        }

        add(root, forAdd);
        size++;
        checkBalance(forAdd);
    }

    private void checkBalance(Node<T> node) {
        if (node == null) return;

        int heightL = height(node.left);
        int heightR = height(node.right);
        if (node.left != null) heightL++;
        if (node.right != null) heightR++;

        if (heightL - heightR > 1 || heightL - heightR < -1) {
            rebalance(node);
        }

        checkBalance(node.parent);
    }

    private void rebalance(Node<T> node) {
        if (height(node.left) > height(node.right)) {
            if (height(node.left.left) > height(node.left.right) || node.left.left != null) {
                 /*

                    NODE
                    /
                NODE.LEFT
                 /
            NODE.LEFT.LEFT

                 */
                rightRotation(node);
            } else {
                /*

                   NODE
                   /
               NODE.LEFT
                   \
                NODE.LEFT.RIGHT

                 */
                leftRotation(node.left);
                rightRotation(node);
            }
        } else {
            if (height(node.right.left) > height(node.right.right)) {
                /*

                NODE
                    \
                    NODE.RIGHT
                    /
            NODE.RIGHT.LEFT

                 */
                rightRotation(node.right);
                leftRotation(node);
            } else {
                  /*

                NODE
                    \
                    NODE.RIGHT
                        \
                        NODE.RIGHT.RIGHT

                 */
                leftRotation(node);
            }

        }
    }

    private void leftRotation(Node<T> node) {
        Node<T> child = node.right;
        //rotate
        node.right = child.left;
        child.left = node;

        //fix parents
        child.parent = node.parent;
        node.parent = child;

        //change former node's parent reference
        if (child.parent != null) {
            if (child.parent.left == node) child.parent.left = child;
            if (child.parent.right == node) child.parent.right = child;
        } else root = child;
    }

    private void rightRotation(Node<T> node) {
        Node<T> child = node.left;
        //rotate
        node.left = child.right;
        child.right = node;

        //fix parents
        child.parent = node.parent;
        node.parent = child;

        //change former node's parent reference
        if (child.parent != null) {
            if (child.parent.left == node) child.parent.left = child;
            if (child.parent.right == node) child.parent.right = child;
        } else root = child;
    }

    private int height(Node<T> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;

        int r = 0;
        int l = 0;
        if (node.left != null) l = ++l + height(node.left);
        if (node.right != null) r = ++r + height(node.right);

        return Math.max(r, l);
    }

    private void add(Node<T> parent, Node<T> newNode) {
        if (parent.data.compareTo(newNode.data) < 0) {// if parent is less, go to right
            if (parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                size++;
                return;
            } else add(parent.right, newNode);// if parent.right isn't null
        } else {
            if (parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
                size++;
                return;
            } else add(parent.left, newNode);// if parent.left isn't null
        }
    }

    private class Node<T> {
        private Node<T> left, right, parent;
        private T data;

        public Node(Node<T> left, Node<T> right, Node<T> parent, T data) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.data = data;
        }
    }
}
