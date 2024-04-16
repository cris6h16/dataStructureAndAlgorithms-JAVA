package org.example.DataStructure.LinkedList;

import org.example.DataStructure.LinkedList.Interfaces.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T extends Comparable<T>> implements List<T>, Iterable<T> {
    private Node<T> head, tail;
    private Integer size = 0;

    public SinglyLinkedList(T head) {
        Node<T> n = new Node<>(head, null);
        this.head = this.tail = n;
        if (head != null) size++;
    }

    @Override
    public void addFirst(T val) {
        Node<T> n = new Node<>(val, head);
        n.next = head;

        if (size == 0) tail = n;// empty
        head = n;// single or more
        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;// empty

        T tmp = head.data;
        if (size == 1) head = tail = null;// single
        else head = head.next;// begin

        size--;
        return tmp;
    }

    @Override
    public void addLast(T obj) {
        Node<T> n = new Node<>(obj, null);

        if (size == 0) {// empty
            addFirst(obj);
            return;
        }

        tail.next = n;// single or more
        tail = n;
        size++;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;// empty
        if (size == 1) return removeFirst();// single

        Node<T> c = head;
        while (c.next != tail) c = c.next;
        c.next = null;

        T tmp = tail.data;
        tail = c;
        size--;

        return tmp;
    }

    @Override
    public T remove(T obj) {

        T tmp = null;
        Node<T> p = null; // previous
        Node<T> c = head; // current

        while (c != null) {
            if (c.data.compareTo(obj) == 0) {//node values
                tmp = c.data;
                if (c == head) return removeFirst();//memory address
                if (c == tail) return removeLast();//memory address
                p.next = c.next;
                size--;
            }
            p = c;
            c = c.next;
        }

        return tmp;
    }

    @Override
    public T contains(T obj) {
        Node<T> c = head;
        while (c != null) {
            if (obj.compareTo(c.data) == 0)
                return c.data;
            c = c.next;
        }
        return null;
    }

    @Override
    public T peekFirst() {
        if (size == 0) return null;
        return head.data;
    }

    @Override
    public T peekLast() {
        if (size == 0) return null;
        return tail.data;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> c = head;
        while (c != null) {
            sb.append(c.data).append(" ");
            c = c.next;
        }
        sb.append("\nsize: ").append(size).append("\n");

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorHelper();
    }


    private class IteratorHelper implements Iterator<T> {
        Node<T> node;

        public IteratorHelper() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();

            T curr = node.data;
            node = node.next;
            return curr;
        }
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

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
}
