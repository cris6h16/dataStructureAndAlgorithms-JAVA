package org.example.DataStructure.Trees;

public class BinarySearchTreeImpl<T extends Comparable<T>> extends BinaryTreeImpl<T> {

    @Override
    protected Node<T> _add(Node<T> root, T val) {
        if (root == null) return new Node<>(val, null, null);
        // root < val
        if (root.data.compareTo(val) < 0) root.right = _add(root.right, val);
        else root.left = _add(root.left, val);
        return root;
    }



}
