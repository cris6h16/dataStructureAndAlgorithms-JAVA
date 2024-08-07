package org.example.DataStructure.LinkedList.Doubly;

import org.example.DataStructure.LinkedList.Interfaces.List;

import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> implements List<T>, Iterable<T>, Cloneable {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T val) {
        DoublyNode<T> valN = new DoublyNode<>(null, val, null);

        if (size == 0) {
            head = tail = valN;
            size++;
            return;
        }
        valN.next = head;
        head.previous = valN;
        head = head.previous;

        size++;
    }

    @Override
    public void addLast(T val) {
        DoublyNode<T> valN = new DoublyNode<>(null, val, null);

        if (size == 0) {
            addFirst(valN.data);
            return;
        }

        valN.previous = tail;
        tail.next = valN;
        tail = tail.next;
        size++;
    }

    @Override
    public T removeFirst() {
        T tmp;

        if (size == 0) return null;
        else if (size == 1) {
            tmp = head.data;
            tail = head = null;
            size--;
            return tmp;
        }

        tmp = head.data;
        head = head.next;
        size--;
        return tmp;
    }

    @Override
    public T removeLast() {
        T tmp;

        if (size == 0 || size == 1) return removeFirst();

        tmp = tail.data;
        tail = tail.previous;
        tail.next = null;
        size--;

        return tmp;
    }

    @Override
    public T remove(T val) {
        DoublyNode<T> c = head;
        while (c != null) {
            if (val.compareTo(c.data) == 0) {
                if (c == head) return removeFirst();
                if (c == tail) return removeLast();

                c.previous.next = c.next;
                size--;
                return val;
            }
            c = c.next;
        }
        return null;
    }

    @Override
    public T peekFirst() {
        return size == 0 ? null : head.data;
    }

    @Override
    public T peekLast() {
        return size == 0 ? null : tail.data;
    }

    @Override
    public boolean contains(T val) {
        DoublyNode<T> c = head;
        while (c != null) {
            if (val.compareTo(c.data) == 0) return true;
            c = c.next;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoublyNode<T> prev;

        sb.append("[ ");
        DoublyNode<T> c = head;
        while (c != null) {
            prev = c.previous;

            if (c == head) sb.append("(head) ");

            if (prev != null && prev.next == c) {
                sb.append(" <-> ");
            } else if (prev == null && c!=head) {
                sb.append(" x-> ");
            }

            sb.append(c.data);

            if (c == tail) sb.append(" (tail)");

            c = c.next;
        }
        sb.append(" ]");
        sb.append(" <<size: ").append(size).append(">>");
        return sb.toString();
    }

    @Override
    protected DoublyLinkedList<T> clone() {
        DoublyLinkedList<T> clone = new DoublyLinkedList<>();
        DoublyNode<T> c = head;
        while (c != null) {
            clone.addLast(c.data);
            c = c.next;
        }
        return clone;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorHelper(head);
    }

    protected class IteratorHelper implements Iterator<T> {

        DoublyNode<T> head;

        public IteratorHelper(DoublyNode<T> head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return this.head != null;
        }

        @Override
        public T next() {
            if (!hasNext()) return null;
            T val = this.head.data;
            this.head = head.next;
            return val;
        }
    }

    protected static class DoublyNode<TN> {
        private DoublyNode<TN> previous;
        private TN data;
        private DoublyNode<TN> next;

        public DoublyNode(DoublyNode<TN> previous, TN data, DoublyNode<TN> next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "DoublyNode{" +
                    "previous=" + (previous == null ? "null" : previous.data) +
                    ", data=" + data +
                    ", next=" + (next == null ? "null" : next.data) +
                    '}';
        }
    }
}
