package org.example.DataStructure.LinkedList.Doubly;

import org.example.DataStructure.LinkedList.Interfaces.List;
import org.w3c.dom.Node;

public class DoublyLinkedList<T extends Comparable<T>> implements List<T> {
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
        return sb.toString();
    }


    protected class DoublyNode<TN> {
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
