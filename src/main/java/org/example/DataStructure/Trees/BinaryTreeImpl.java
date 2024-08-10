package org.example.DataStructure.Trees;

import java.util.Iterator;

public class BinaryTreeImpl<T extends Object & Comparable<T>> implements BinaryTree<T> {
    protected Node<T> root;
    private int size;

    public BinaryTreeImpl() {
        this.root = null;
    }

    @Override
    public void add(T val) {
        Node<T> newN = new Node<>(val, null, null);
        root = _add(root, newN);
        size++;
    }

    @Override
    public T remove(T obj) {
        return null;
    }

    private Node<T> _add(Node<T> root, Node<T> newN) {
        if (root == null) return newN;

        boolean newGreater = root.data.compareTo(newN.data) < 0;
        if (newGreater) {
            if (root.right != null) root.right = _add(root.right, newN);
            else root.right = newN;
        } else { // less || equals
            if (root.left != null) root.left = _add(root.left, newN);
            else root.left = newN;
        }

        return root;
    }

//    private void add(Node<T> root, T obj) {
//        if (root.data.compareTo(obj) < 0) { // if root is less, go to right
//            if (root.right == null)
//                root.right = new Node<>(obj, null, null);
//            else add(root.right, obj);
//        } else { // if root is greater or equals, go to left
//            if (root.left == null)
//                root.left = new Node<>(obj, null, null);
//            else add(root.left, obj);
//        }
//    }


//    public T remove(T val) {
//        return remove(root, val);
//    }
//
//    private T remove(Node<T> current, T val) {
//        if (current == null) return null;
//
//        boolean valIsCurrent = current.data.compareTo(val) == 0;
//
//        // if currentNode is it we want to remove
//        if (valIsCurrent) {
//            Node<T> parent = getParent(current, this.root);
//
//            if (parent == null) { // this.root has no parent
//                if (root.left == null && root.right == null) { // root has no children
//                    T tmp = root.data;
//                    root = null;
//                    size--;
//                    return tmp;
//                }
//                // root has children
//                Node<T> pOrS; // predecessor || successor
//                if (root.left != null) pOrS = getInOrderPredecessor(root);
//                else pOrS = getInOrderSuccessor(root);
//
//                swapData(root, pOrS);
//                return remove(root, pOrS.data);
//            }
//
//            // the node we want remove is a left
//            else if (current.left == null && current.right == null) {
//                if (parent.left == current) parent.left = null;
//                if (parent.right == current) parent.right = null;
//                size--;
//                return current.data; // current is lost, it's gonna be collected by GC
//            }
//
//            // if node we want to delete has a child
//            if (current.right != null) {
//                if (parent.left == current) parent.left = current.left;
//                else parent.right = current.left;
//            }
//        }
//
//        // if val is greater
//        if (current.data.compareTo(val) < 0) return remove(current.right, val);
//        else return remove(current.left, val);
//    }

    private void swapData(Node<T> a, Node<T> b) {
        T tmp = a.data;
        a.data = b.data;
        b.data = tmp;
    }

    private Node<T> getParent(Node<T> node, Node<T> root) {
        if (root == null) return null;

        if (root.left == node) return root;
        if (root.right == node) return root;

        // root < node, then node is in right
        if (root.data.compareTo(node.data) < 0) return getParent(node, root.right);
        else return getParent(node, root.left);
    }


//
//
//    private void remove(Node<T> node, T val) {
//        if (node == null) return;
//
//        if (node.data.compareTo(val) == 0) {
//            Node<T> parent = getParent(node, root);
//            // if node doesn't have parent, then is the Root
//            if (parent == null) {
//                Node<T> sor;
//                if (root.left != null) sor = getInOrderPredecessor(root);
//                else if (root.right != null) sor = getInOrderSuccessor(root);
//                else {
//                    root = null;
//                    return;
//                }
//                swapOfData(sor, root);
//                remove(sor, sor.data);
//                return;
//            }
//
//            // if node parameter is a leaf
//            if (node.left == null && node.right == null) {
//                if (parent.left == node) parent.left = null;
//                if (parent.right == node) parent.right = null;
//                return;
//            }
//
//            //if node parameter has 1 child
//            if (node.left != null || node.right != null) {
//                Node<T> child = null;
//                if (node.left != null) child = node.left;
//                if (node.right != null) child = node.right;
//
//                if (parent.left == node) parent.left = child;
//                if (parent.right == node) parent.right = child;
//                return;
//            }
//
//            //if node parameter has 2 children
//            if (node.left != null && node.right != null) {
//                Node<T> pre = getInOrderPredecessor(node);
//                swapOfData(pre, node);
//                remove(pre, pre.data);
//            }
//
//        }
//        if (node.data.compareTo(val) < 0) remove(node.right, val);
//        else remove(node.left, val);
//    }
    //
//
//private Node<T> getParent(Node<T> node, Node<T> root) {
//    if (root == node) return null;
//    if (root.left == node || root.right == node) return root;
//    if (root.data.compareTo(node.data) < 0) //if root is less
//        return getParent(node, root.right);
//    else // if root is less or equals
//        return getParent(node, root.left);
//}

    @Override
    public boolean contains(T obj) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(EOrder order) {
        if (size < 0) throw new IllegalStateException();
        T[] res = (T[]) new Object[size];

        return switch (order) {
            case IN_ORDER -> {
                inOrderArray(root, res, -1);
                yield res;
            }
            case PRE_ORDER -> {
                preOrderArray(root, res, -1);
                yield res;
            }
            case POST_ORDER -> {
                postOrderArray(root, res, -1);
                yield res;
            }
        };

    }

    // left -> right -> root
    private int postOrderArray(Node<T> root, T[] res, int lastUsedIdx) {
        if (root == null) return lastUsedIdx;

        // left
        lastUsedIdx = postOrderArray(root.left, res, lastUsedIdx);

        // right
        lastUsedIdx = postOrderArray(root.right, res, lastUsedIdx);

        // root
        res[++lastUsedIdx] = root.data;

        return lastUsedIdx;
    }

    // root -> left -> right
    private int preOrderArray(Node<T> root, T[] res, int lastUsedIdx) {
        if (root == null) return lastUsedIdx;

        // root
        res[++lastUsedIdx] = root.data;

        // left
        lastUsedIdx = preOrderArray(root.left, res, lastUsedIdx);

        // right
        lastUsedIdx = preOrderArray(root.right, res, lastUsedIdx);

        return lastUsedIdx;
    }

    // left -> root -> right
    private int inOrderArray(Node<T> root, T[] res, int lastUsedIdx) {
        if (root == null) return lastUsedIdx;

        // Traverse left subtree
        lastUsedIdx = inOrderArray(root.left, res, lastUsedIdx);

        // Visit node
        res[++lastUsedIdx] = root.data;

        // Traverse right subtree
        lastUsedIdx = inOrderArray(root.right, res, lastUsedIdx);

        return lastUsedIdx;
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

//    // [[a],[b,c],[d,e,f,g],[h,i, ,k,l,m, ,o]]
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//
//    }


    public static enum EOrder {
        /**
         * {@code left -> root -> right}
         */
        IN_ORDER,
        /**
         * {@code root -> left -> right}
         */
        PRE_ORDER,
        /**
         * {@code left -> right -> root}
         */
        POST_ORDER
    }

    protected static class Node<R> {
        R data;
        Node<R> left;
        Node<R> right;

        public Node(R data, Node<R> left, Node<R> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
