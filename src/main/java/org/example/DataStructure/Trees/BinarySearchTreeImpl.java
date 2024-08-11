package org.example.DataStructure.Trees;

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

        // if the current is greater
        if (node.data.compareTo(currentMax) < 0) currentMax = node.data;

        // get max from the left && right
        currentMax = _getMax(node.left, currentMax);
        currentMax = _getMax(node.right, currentMax);

        return currentMax;
    }

    @Override
    protected T _getMin(Node<T> node, T min) {

    }
}
