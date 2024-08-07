package org.example.DataStructure.LinkedList;

import static org.example.DataStructure.LinkedList.SinglyLinkedList.Node;

public final class SinglyLinkedListAlgorithms {
    public static <T extends Comparable<T>> SinglyLinkedList<T> reverse(SinglyLinkedList<T> list) {
        var clone = list.clone();
        Node<T> h = clone.head; // head
        Node<T> t = clone.tail; // tail

        _reverse(null, h);
        Node<T> tmp = h;
        h = t;
        t = tmp;
        return clone;
    }

    private static <T extends Comparable<T>> void _reverse(Node<T> previous, Node<T> c) { // current
        if (c == null) return;
        Node<T> next = c.next;
        c.next = previous;
        _reverse(c, next);
    }

    public static <T extends Comparable<T>> T getNthFromEnd(SinglyLinkedList<T> list, int Nth) {
        var clone = list.clone();
        int size = clone.size;
        Node<T> h = clone.head; // head

        if (Nth > size || Nth < 1) return null;
        int idxFromHead = size - Nth;   // position from head
        Node<T> c = h;
        int i = 0;
        while (idxFromHead != i) {
            c = c.next;
            i++;
        }
        return c.data;
    }

    public static <T extends Comparable<T>> SinglyLinkedList<T> removeDuplicatesUnsorted(SinglyLinkedList<T> list) {

    }

    public static <T extends Comparable<T>> SinglyLinkedList<T> removeDuplicatesSorted(SinglyLinkedList<T> list) {

    }

    public static <T extends Comparable<T>> T findStartOfALoop(SinglyLinkedList<T> list) {

    }

    public static <T extends Comparable<T>> SinglyLinkedList<T> removeLoop(SinglyLinkedList<T> list) {

    }

    public static <T extends Comparable<T>> SinglyLinkedList<T> mergeSort(SinglyLinkedList<T> list) {

    }

    public static <T extends Comparable<T>> SinglyLinkedList<T> quickSort(SinglyLinkedList<T> list) {

    }

    /*
    Merge 2 sorted Singly Linked Lists

    l1:     1 -> 3 -> 25
    l2:     2 -> 4 -> 6 -> 10
    res:    1 -> 2 -> 3 -> 4 -> 6 -> 10 -> 25
     */
    public static <T extends Comparable<T>> SinglyLinkedList<T> mergeASortedList(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

    }
    /*
        ALGORITHM: Add 2 Singly Linked Lists

        Given 2 non-empty linked lists representing 2 non-negative integers.
        The digits are stored in reverse order and each of their nodes
        contains a single digit. Add the 2 numbers and the sum as a linked list.
        You may assume the 2 numbers don't contain any LEADING zero, except
        the number 0 itself.

        EXAMPLE:
            3 4 3
        +   4 6 5
        ------------
            8 0 8

       =
        obj1: 3 -> 4 -> 3
        obj2: 4 -> 6 -> 5
        -------------------
        res:  8 -> 0 -> 8

        Possible:     0 -> null
        Not Possible: 0 -> 1 -> 2 -> 5 ( leading zero )
     */

    public static <T extends Comparable<T>> SinglyLinkedList<T> addTwoLists(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

    }

}
