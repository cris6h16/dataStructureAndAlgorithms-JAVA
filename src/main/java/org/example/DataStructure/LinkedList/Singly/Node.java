package org.example.DataStructure.LinkedList.Singly;

/**
 * package-private (no modifier)
 */
class Node<T> {
    protected T data;
    protected Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}