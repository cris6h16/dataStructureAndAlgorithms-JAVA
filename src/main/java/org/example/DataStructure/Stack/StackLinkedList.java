package org.example.DataStructure.Stack;

import org.example.DataStructure.LinkedList.SinglyLinkedList;

public class StackLinkedList<T extends Comparable<T>> implements Stack<T> {
    SinglyLinkedList<T> linkedList; // Do operations with T which require Comparable<T> implementation

    public StackLinkedList() {
        this.linkedList = new SinglyLinkedList<>(null);
    }


    @Override
    public void push(T val) {
        linkedList.addFirst(val);
    }

    @Override
    public T pop() {
        T tmp = linkedList.peekFirst();
        linkedList.removeFirst();

        return tmp;
    }

    @Override
    public T peek() {
        return linkedList.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.peekFirst() == null;
    }
}
