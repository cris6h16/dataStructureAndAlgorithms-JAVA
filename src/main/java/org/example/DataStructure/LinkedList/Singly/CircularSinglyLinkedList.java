package org.example.DataStructure.LinkedList.Singly;

import org.example.DataStructure.LinkedList.Doubly.Main;
import org.example.DataStructure.LinkedList.Interfaces.List;

public class CircularSinglyLinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> last;
    private int size;

    public CircularSinglyLinkedList() {
        this.last = null;
        this.size = 0;
    }

    @Override
    public void addFirst(T val) {
        Node<T> newFirst = new Node<T>(val, null);

        if (size == 0) {
            last = newFirst.next = newFirst;
            size++;
            return;
        }
        var formerFirst = last.next;
        last.next = newFirst;
        newFirst.next = formerFirst;
        size++;
    }

    @Override
    public void addLast(T val) {
        if (size == 0) {
            addFirst(val);
            return;
        }

        var first = last.next;
        last.next = new Node<T>(val, first);
        last = last.next;
        size++;
    }

    @Override
    public T removeFirst() {
        T tmp;
        if (size == 0) return null;
        if (last == null) throw new IllegalStateException();
        if (size == 1) {
            tmp = last.data;
            last = null;
            size--;
            return tmp;
        }
        tmp = last.next.data;
        last.next = last.next.next;
        size--;
        return tmp;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        if (size == 1) return removeFirst();

        T val = last.data;
        Node<T> preLast = last;
        while (preLast.next != last) preLast = preLast.next;
        preLast.next = last.next;
        size--;
        last = preLast;
        return val;
    }

    @Override
    public T remove(T val) {
        if (size == 0) return null;
        if (last.data.compareTo(val) == 0) return removeLast();

        // size >= 1 && val != last
        Node<T> first = last.next;

        Node<T> c = first;
        Node<T> preC = last;

        while (c != last) {
            if (c.data.compareTo(val) == 0) {
                if (c == first) removeFirst();
                // size >= 2
                preC.next = c = c.next;
                size--;
                return val;
            }
            preC = preC.next;
            c = c.next;
        }

        return null;
    }

    @Override
    public T peekFirst() {
        if (size == 0) return null;
        return last.next.data;
    }

    @Override
    public T peekLast() {
        if (size == 0) return null;
        return last.data;
    }

    @Override
    public boolean contains(T val) {
        if (size == 0) return false;
        if (val.compareTo(last.data) == 0) return true;
        // reached here is val != last.data
        Node<T> c = last.next;
        while (c != last) {
            if (c.data.compareTo(val) == 0) return true;
            c = c.next;
        }
        return false;
    }

    // { ↪ 1 -> 2 -> 3 -> 4 -> 5 ↩
    @Override
    public String toString() {
        if (size == 0) return "[ ]" + " <size: " + size + ">";
        if (size == 1) return "[ ↪ " + last.data + " (last) ↩ ]" + " <size: " + size + ">";

        StringBuilder sb = new StringBuilder("[ ↪ ");
        Node<T> c = last.next;
        while (c != last) {
            sb.append(c.data);
            sb.append(" -> ");
            c = c.next;
        }
        sb.append(c.data);
        sb.append(" (last)");
        sb.append(" ↩ ]");
        sb.append(" <size: ").append(size).append(">");
        return sb.toString();
    }
}
