package org.example.DataStructure.Trees;

public class SimpleTree<T extends Comparable<T>> {
    private Node<T> root;

    public SimpleTree() {
        this.root = null;
    }

    public void add(T obj) {
        if (root == null) {
            root = new Node<>(obj, null, null);
            return;
        }
        add(root, obj);
    }

    public void remove(T obj) {
        remove(root, obj);
    }

    private void add(Node<T> root, T obj) {
        if (root.data.compareTo(obj) < 0) { // if root is less, go to right
            if (root.right == null)
                root.right = new Node<>(obj, null, null);
            else add(root.right, obj);
        } else { // if root is greater or equals, go to left
            if (root.left == null)
                root.left = new Node<>(obj, null, null);
            else add(root.left, obj);
        }
    }

    private void remove(Node<T> node, T obj) {
        if (node == null) return;

        if (node.data.compareTo(obj) == 0) {
            // if node doesn't have parent, then is the Root
            Node<T> parent = getParent(node, root);
            if (parent == null) {
                Node<T> sor;
                if (root.left != null) sor = getInOrderPredecessor(root);
                else if (root.right != null) sor = getInOrderSuccessor(root);
                else {
                    root = null;
                    return;
                }
                swapOfData(sor, root);
                remove(sor, sor.data);
                return;
            }

            // if node parameter is a leaf
            if (node.left == null && node.right == null) {
                if (parent.left == node) parent.left = null;
                if (parent.right == node) parent.right = null;
                return;
            }

            //if node parameter has 1 child
            if (node.left != null || node.right != null) {
                Node<T> child = null;
                if (node.left != null) child = node.left;
                if (node.right != null) child = node.right;

                if (parent.left == node) parent.left = child;
                if (parent.right == node) parent.right = child;
                return;
            }

            //if node parameter has 2 children
            if (node.left != null && node.right != null) {
                Node<T> pre = getInOrderPredecessor(node);
                swapOfData(pre, node);
                remove(pre, pre.data);
            }

        }
        if (node.data.compareTo(obj) < 0) remove(node.right, obj);
        else remove(node.left, obj);
    }

    private Node<T> getParent(Node<T> node, Node<T> root) {
        if (root == node) return null;
        if (root.left == node || root.right == node) return root;
        if (root.data.compareTo(node.data) < 0) //if root is less
            return getParent(node, root.right);
        else // if root is less or equals
            return getParent(node, root.left);
    }

    private void swapOfData(Node<T> a, Node<T> b) {
        T tmp = a.data;
        a.data = b.data;
        b.data = tmp;
    }

    private Node<T> getInOrderSuccessor(Node<T> root) {
        if (root.right == null) return null;

        Node<T> c = root.right;
        while (c.left != null) c = c.left;
        return c;
    }

    private Node<T> getInOrderPredecessor(Node<T> root) {
        if (root.left == null) return null;

        Node<T> c = root.left;
        while (c.right != null) c = c.right;
        return c;
    }


    private class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
