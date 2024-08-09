package org.example.DataStructure.Stack;

import org.example.DataStructure.LinkedList.Singly.SinglyLinkedList;

import java.util.EmptyStackException;
import java.util.Iterator;

public class StackLinkedList<T extends Comparable<T>> implements Stack<T>, Iterable<T> {
    // Do operations with T which require Comparable<T> implementation
    SinglyLinkedList<T> linkedList;

    public StackLinkedList() {
        this.linkedList = new SinglyLinkedList<>();
    }

    @Override
    public void push(T val) {
        linkedList.addFirst(val);
    }

    @Override
    public T pop() {
        if (size() == 0) throw new EmptyStackException();
        return linkedList.removeFirst();
    }

    @Override
    public T peek() {
        if (size() == 0) throw new EmptyStackException();
        return linkedList.peekFirst();
    }

    @Override
    public int size() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.peekFirst() == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorHelper<>(this.linkedList);
    }

    protected static class IteratorHelper<T extends Comparable<T>> implements Iterator<T> {

        private SinglyLinkedList<T> l;

        public IteratorHelper(SinglyLinkedList<T> l) {
            this.l = l;
        }

        @Override
        public boolean hasNext() {
            return l.getSize() != 0;
        }

        @Override
        public T next() {
            return l.removeFirst();
        }
    }
}
