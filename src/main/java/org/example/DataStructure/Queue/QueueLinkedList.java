package org.example.DataStructure.Queue;

import org.example.DataStructure.LinkedList.Singly.SinglyLinkedList;

import java.util.Iterator;

public class QueueLinkedList<T extends Comparable<T>> implements Queue<T>, Iterable<T> {
    SinglyLinkedList<T> linked;

    public QueueLinkedList() {
        this.linked = new SinglyLinkedList<>();
    }

    // prototype design pattern
    public QueueLinkedList(QueueLinkedList<T> q) {
        this.linked = q.linked.clone();
    }

    @Override
    public void offer(T val) { // enqueue
        linked.addLast(val);
    }

    @Override
    public T poll() { // dequeue
        return linked.removeFirst();
    }

    @Override
    public T peek() {
        return linked.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return linked.getSize() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Queue<T> clone() {
        return new QueueLinkedList<>(this);
    }

    @Override
    public int size() {
        return linked.getSize();
    }

    @Override
    public String toString() {
        return "QueueLinkedList{" +
                "linked=" + linked +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorHelper<>(linked);
    }

    private static class IteratorHelper<T extends Comparable<T>> implements Iterator<T> {

        private SinglyLinkedList<T> l;

        public IteratorHelper(SinglyLinkedList<T> l) {
            this.l = l;
        }

        @Override
        public boolean hasNext() {
            return l.getSize() > 0;
        }

        @Override
        public T next() {
            return l.removeFirst();
        }
    }
}
