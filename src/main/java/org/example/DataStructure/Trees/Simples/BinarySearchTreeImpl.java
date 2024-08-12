package org.example.DataStructure.Trees.Simples;

public class BinarySearchTreeImpl<T extends Comparable<T>> extends BinaryTreeImpl<T> {

    @Override
    protected Node<T> _add(Node<T> c, T val) {
        // best case
        if (c == null) return new Node<>(val, null, null);

        // recursively until hit the best case
        if (c.data.compareTo(val) < 0) c.right = _add(c.right, val); // root < val
        else c.left = _add(c.left, val);
        return c;
    }

    @Override
    protected boolean _contains(Node<T> c, T val) {
        // best cases ( is current || is nothing )
        if (c == null) return false;
        if (c.data.compareTo(val) == 0) return true;

        // recursively until hit any best case
        if (c.data.compareTo(val) < 0) return _contains(c.right, val);
        else return _contains(c.left, val);
    }

    @Override
    protected T _getMax(Node<T> node, T currentMax) {
        if (node == null) return currentMax;
        if (currentMax == null) currentMax = node.data; // executed 1 time ( first call )

        // best case: there's no a right child
        // recursively until hit the best case
        if (node.right == null) currentMax = node.data;
        else currentMax = _getMax(node.right, currentMax);

        return currentMax;
    }

    @Override
    protected T _getMin(Node<T> node, T currentMin) {
        if (node == null) return currentMin;
        if (currentMin == null) currentMin = node.data; // executed 1 time ( first call )

        // best case : there's no left child then current node is the smallest
        // else recursively until hit the best case
        if (node.left == null) currentMin = node.data;
        else currentMin = _getMin(node.left, currentMin);

        return currentMin;
    }
    public boolean isValid() {
        if (root == null) return true;
        return _isValid(root, null, null);
    }


    private boolean _isValid(Node<T> node, T min, T max) {
        if (node == null) return true; // best case: an empty tree is valid

        // base case:
        if ((min != null && node.data.compareTo(min) <= 0) || (max != null && node.data.compareTo(max) > 0)) {
            return false;
        }

        //  check the left and right subtrees
        return _isValid(node.left, min, node.data) && // send just the max for left
                _isValid(node.right, node.data, max);// send just the min for right
    }

}
