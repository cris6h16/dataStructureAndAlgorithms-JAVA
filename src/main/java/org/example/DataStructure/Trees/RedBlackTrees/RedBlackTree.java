package org.example.DataStructure.Trees.RedBlackTrees;

public class RedBlackTree<K extends Comparable<K>, V> {
    private Node<K, V> root;
    private int size = 0;

    public void add(K key, V value) {
        Node<K, V> forAdd = new Node<>(key, value);
        if (root == null) {
            root = forAdd;
            root.black = true;
            size++;
            return;
        }

        add(root, forAdd);
        size++;
    }

    private void add(Node<K, V> parent, Node<K, V> newNode) {
        if (parent.key.compareTo(newNode.key) < 0) {// if parent is less, go to right
            if (parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = false;
            } else add(parent.right, newNode);
        } else {
            if (parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = true;
            } else add(parent.left, newNode);
        }
        checkColor(newNode);
    }

    private void checkColor(Node<K, V> node) {
        if (node == root) return;
        if (!node.black && !node.parent.black) correctTree(node);
        checkColor(node.parent);
    }

    private void correctTree(Node<K, V> node) {
        /*

            /            /
           /      or     \

         */
        if (node.parent.isLeftChild) {
            Node<K, V> uncle = node.parent.parent.right;
            if (uncle == null || uncle.black) {//if uncle is black
                rotate(node);
                return;
                //todo: possible we need change colors
            }
            // if uncle is red, color flip
            uncle.black = true;
            node.parent.parent.black = false;
            node.parent.black = true;
            return;
        }
        /*

           \               \
            \      or      /

         */
        Node<K, V> uncle = node.parent.parent.left;
        if (uncle == null || uncle.black) {//if uncle is black
            rotate(node);
            return;
        }
        //if uncle is red, color flip
        uncle.black = true;
        node.parent.parent.black = false;
        node.parent.black = true;
        return;

    }

    private void rotate(Node<K, V> node) {
        if (node.isLeftChild)
            if (node.parent.isLeftChild) {
                /*
                        /
                       /
                 */
                rightRotation(node.parent.parent);
                node.black = false;
                node.parent.black = true;
                if (node.parent.right != null) node.parent.right.black = false;
                return;
            }
        rightLeftRotation(node.parent.parent);
        node.black = true;
        node.right.black = false;
        node.left.black = false;
        return;
    }

    private void rightLeftRotation(Node<K, V> node) {
        rightRotation(node.right);
        rightRotation(node);
    }

    private void rightRotation(Node<K, V> parent) {
        Node<K, V> child = parent.left;
        if (parent.parent == null) { // if it hasn't a parent, is Root
            root = child;
            child.parent = null;
            return;
        }
        if (parent.isLeftChild) parent.parent.left = child;
        else parent.parent.right = child;

        child.parent = parent.parent;

        parent.left = child.right;
        if (child.right != null) child.right.parent = parent;
        child.right = parent;
        parent.parent = child;
    }

    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right, parent;
        boolean black, isLeftChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.black = false;
            this.isLeftChild = false;
        }
    }
}
