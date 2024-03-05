package org.example.DataStructure.Queue;

import org.example.DataStructure.LinkedList.SinglyLinkedList;

public class QueueLinkedList<T extends Comparable<T>> implements Queue<T> {
    SinglyLinkedList<T> linked;

    public QueueLinkedList() {
        this.linked = new SinglyLinkedList<>(null);
    }

    @Override
    public boolean offer(T val) {
        linked.addFirst(val);
        return true;
    }

    @Override
    public T poll() {
        T tmp = linked.peekFirst();
        linked.removeFirst();
        return tmp;
    }

    @Override
    public T peek() {
        return linked.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return linked.peekFirst() == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Queue<T> clone() {
        throw new UnsupportedOperationException();
    }
}
