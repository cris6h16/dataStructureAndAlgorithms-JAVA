package org.example.DataStructure.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeImpl<T extends Object & Comparable<T>> implements BinaryTree<T> {
    protected Node<T> root;
    protected int size;

    public BinaryTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(T val) {
        this.root = _add(root, val);
        size++;
    }

//   This is my first implementation, but I see the video & get a better way to do it ( see the next method )
//    protected void _add(Node<T> node, Node<T> newN) {
//        if (this.root == null) {
//            this.root = newN;
//            return;
//        }
//
//        boolean right = size < 10; // anything
//
//        if (right) {
//            if (node.right == null) node.right = newN;
//            else _add(node.right, newN);
//        } else {
//            if (node.left == null) node.left = newN;
//            else _add(node.left, newN);
//        }
//    }

    protected Node<T> _add(Node<T> node, T val) {
        if (node == null) return new Node<>(val, null, null);

        boolean right = size < 10; // anything

        if (right) node.right = _add(node.right, val);
        else node.left = _add(node.left, val);

        return node;
    }


    private int calculateHeight(Node<T> root) {
        if (root == null) return 0;
        int hL = calculateHeight(root.left) + 1; // +1 is the current node
        int hR = calculateHeight(root.right) + 1; // +1     is the current node
        return Math.max(hL, hR);
    }

    @Override
    public T remove(T val) {
        val = _remove(root, val);
        size--;
        return val;
    }

    private T _remove(Node<T> current, T val) {
        throw new UnsupportedOperationException("Not implemented yet");
    }


    private void swapData(Node<T> a, Node<T> b) {
        T tmp = a.data;
        a.data = b.data;
        b.data = tmp;
    }


    @Override
    public boolean contains(T obj) {
        return _contains(root, obj);
    }

    private boolean _contains(Node<T> current, T val) {
        if (current == null) return false;

        // best case: current is the val
        if (current.data.compareTo(val) == 0) return true;

        return _contains(current.left, val) || _contains(current.right, val);
    }

    @Override
    public void clear() {
        size = 0;
        this.root = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int height() {
        return calculateHeight(root);
    }


    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray(ETraversalOrder order) {
        if (size < 0) throw new IllegalStateException();
        Queue<T> res = new LinkedList<>();

        Object[] resArray = switch (order) {
            case IN_ORDER -> {
                inOrderArray(root, res);
                yield res.toArray();
            }
            case PRE_ORDER -> {
                preOrderArray(root, res);
                yield res.toArray();
            }
            case PRE_ORDER_STACK -> {
                preOrderArrayStack(root, res);
                yield res.toArray();
            }
            case POST_ORDER -> {
                postOrderArray(root, res);
                yield res.toArray();
            }
            case POST_ORDER_ITERATION -> {
                postOrderArrayIteration(root, res);
                yield res.toArray();
            }
            case LEVEL_ORDER -> {
                levelOrder(root, res);
                yield res.toArray();
            }
        };

        return (T[]) resArray;
    }

    @Override
    public T getMin() {
        return _getMin(root, null);
    }

    private T _getMin(Node<T> node, T min) {
        if (node == null) return min;

        //best case
        if (min == null || node.data.compareTo(min) < 0) {
            min = node.data;
        }

        min = _getMin(node.left, min);
        min = _getMin(node.right, min);

        return min;
    }

    @Override
    public T getMax() {
        return _getMax(root, null);
    }

    private T _getMax(Node<T> node, T max) {
        if (node == null) return max;
        if (max == null) max = node.data;

        //best case
        if (node.data.compareTo(max) > 0) max = node.data;

        max = _getMax(node.left, max);
        max = _getMax(node.right, max);

        return max;
    }

    // Level-order traversal: level by level
    private void levelOrder(Node<T> root, Queue<T> res) {
        if (root == null) return;

        Queue<Node<T>> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node<T> c = q.poll();
            res.offer(c.data);
            if (c.left != null) q.offer(c.left);
            if (c.right != null) q.offer(c.right);
        }
    }
    /* levelOrder
                                     1
                                 /         \
                               -2            3
                            /      \       /   \
                          -4        1     3      5
                          /  \     /              \
                        -7   -2   0                7
                       /   \                      /  \
                    -10     -5                   7    10

     Queue history:                 Processing
     [  1 ]
                                    (queue.poll() ==  1) & save(1)  & offer(1.left)  & offer(1.right)
     [ -2,  3 ]
                                    (queue.poll() == -2) & save(-2) & offer(-2.left) & offer(-2.right)
     [  3, -4, 1 ]
                                    (queue.poll() ==  3) & save(3)  & offer(3.left)  & offer(3.right)
     [ -4,  1, 3,  5 ]
                                    (queue.poll() == -4) & save(-4) & offer(-4.left) & offer(-4.right)
     [  1,  3, 5, -7, -2 ]
                                    (queue.poll() ==  1) & save(1)  & offer(1.left)  & offer(1.right)
     [  3,  5, -7, -2, 0 ]
                                    ...
     [  5, -7, -2,  0 ]
                                    ...
     [ -7, -2,  0, 7 ]
                                    ...

            */

    // todo: doc this is the unique algorithm that I couldn't implement. I'll study it more later...
// Post-order traversal with ITERATION: left -> right -> root
    private void postOrderArrayIteration(Node<T> root, Queue<T> res) {
        Stack<Node<T>> s = new Stack<>();
        Node<T> c = root;

        while (c != null || !s.isEmpty()) {
            if (c != null) {
                s.push(c);
                c = c.left;
            } else { // if there is no left
                Node<T> right = s.peek().right;
                if (right == null) { // if there is a leaf
                    right = s.pop();
                    res.offer(right.data);
                    while (!s.isEmpty() && right == s.peek().right) {
                        right = s.pop();
                        res.offer(right.data);
                    }
                } else {
                    c = right;
                }
            }
        }
    }

    // Post-order traversal: left -> right -> root
    private void postOrderArray(Node<T> root, Queue<T> res) {
        if (root == null) return;

        postOrderArray(root.left, res);
        postOrderArray(root.right, res);
        res.offer(root.data);
    }

    // Pre-order traversal: root -> left -> right
    private void preOrderArray(Node<T> root, Queue<T> res) {
        if (root == null) return;

        res.offer(root.data);
        preOrderArray(root.left, res);
        preOrderArray(root.right, res);
    }

    // Pre-order traversal Stack: root -> left -> right
    private void preOrderArrayStack(Node<T> root, Queue<T> res) {
        if (root == null) return;

        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> c = stack.pop();
            if (c.right != null) stack.push(c.right);
            if (c.left != null) stack.push(c.left);
            res.offer(c.data);
        }
    }

    // In-order traversal: left -> root -> right
    private void inOrderArray(Node<T> root, Queue<T> res) {
        if (root == null) return;

        inOrderArray(root.left, res);
        res.offer(root.data);
        inOrderArray(root.right, res);
    }

    public enum ETraversalOrder {
        /**
         * {@code left -> root -> right}
         */
        IN_ORDER,
        /**
         * {@code root -> left -> right}
         */
        PRE_ORDER,
        PRE_ORDER_STACK,  // using a stack
        /**
         * {@code left -> right -> root}
         */
        POST_ORDER,
        POST_ORDER_ITERATION,
        /**
         * {@code level by level}. also known as {@code breadth-first}
         */
        LEVEL_ORDER
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


//    private Node<T> getInOrderSucce ssor(Node<T> root) {
//        if (root.right == null) return null;
//
//        Node<T> c = root.right;
//        while (c.left != null) c = c.left;
//        return c;
//    }
//
//    private Node<T> getInOrderPredecessor(Node<T> root) {
//        if (root.left == null) return null;
//
//        Node<T> c = root.left;
//        while (c.right != null) c = c.right;
//        return c;
//    }
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


//private T getRightest(Node<T> node, T max) {
//    if (node == null) return null;      // if tree is empty
//
//    max = (node.right == null) ? node.data : getRightest(node.right, max); // the current is the rightest if there is no right child
//    return max;
//}


//private T getLeftest(Node<T> node, T min) {
//    if (node == null) return null;      // if tree is empty
//    min = (node.left == null) ? node.data : getLeftest(node.left, min); // the current is the leftest if there is no left child
//    return min;
//}