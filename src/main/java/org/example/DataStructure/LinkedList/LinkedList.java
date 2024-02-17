package org.example.DataStructure.LinkedList;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;
    private int size = 0;
    /*
    size, add(prepend), toString, search, delete.
     */

    public LinkedList(T headVal) {
        Node<T> head = new Node<>(headVal, null);
        this.head = head;
        this.size++;
    }

    public LinkedList(Node<T> headVal) {
        this.head = headVal;
        this.size++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedList<T> prepend(T toHeadVal) {
        Node<T> newHead = new Node<>(toHeadVal, head);
        this.head = newHead;

        size++;
        return this;
    }

    public T search(T val) {
        Node<T> c = head;
        while (c != null) {
            if (c.getData().equals(val)) return c.getData();
            c = c.getNext();
        }

        return null;
    }

    public boolean delete(T val) {
        Node<T> c = head; //current
        Node<T> b = null; //before
        boolean del = false;

        while (c != null) {
            if (c.getData().equals(val)) {
                if (b == null) { //can be the Head
                    this.head = c.getNext();
                } else {
                    b.setNext(c.getNext());
                }
                del = true;
                size--;
            }
            b = c;
            c = c.getNext();
        }

        return del;
    }

    public Node<T> getByIndex(int index) {
        Node<T> c = head;
        int i = 1;
        while (i++ < index) c = c.getNext();

        return c;
    }

    @Override
    public String toString() {
        Node<T> c = this.head;
        String str = "LinkedList{ :nodes }";
        String nodes = "";
        while (c != null) {
            nodes += c + " ";
            c = c.getNext();
        }

        return str.replace(":nodes", nodes);
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
