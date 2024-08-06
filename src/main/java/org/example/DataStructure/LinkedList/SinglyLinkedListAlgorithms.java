package org.example.DataStructure.LinkedList;

public interface SinglyLinkedListAlgorithms<T extends Comparable<T>> {
    void reverse();

    T getNthFromEnd(int n);

    void removeDuplicatesUnsorted();

    void removeDuplicatesSorted();

    T findStartOfLoop();

    void removeLoop();

    void mergeSort();

    void quickSort();

    /*
    Merge 2 sorted Singly Linked Lists

    l1:     1 -> 3 -> 25
    l2:     2 -> 4 -> 6 -> 10
    res:    1 -> 2 -> 3 -> 4 -> 6 -> 10 -> 25
     */
    void mergeASortedList(SinglyLinkedList<T> list2);
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

    SinglyLinkedList<T> addTwoLists(SinglyLinkedList<T> list2);

}
