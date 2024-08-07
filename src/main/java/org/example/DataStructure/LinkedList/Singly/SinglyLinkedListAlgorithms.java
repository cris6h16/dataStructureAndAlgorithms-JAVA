package org.example.DataStructure.LinkedList.Singly;

import static org.example.DataStructure.LinkedList.Singly.SinglyLinkedList.Node;

public final class SinglyLinkedListAlgorithms {
    public static <T extends Comparable<T>> void reverse(SinglyLinkedList<T> list) {
        _reverse(null, list.head);
        // swap head and tail
        Node<T> tmp = list.head;
        list.head = list.tail;
        list.tail = tmp;
    }

    private static <T extends Comparable<T>> void _reverse(Node<T> previous, Node<T> current) { // current
        if (current == null) return;
        Node<T> next = current.next;
        current.next = previous;
        _reverse(current, next);
    }

    public static <T extends Comparable<T>> T getNthFromEnd(SinglyLinkedList<T> list, int Nth) {
        if (Nth > list.size || Nth < 1) return null;
        int idxFromHead = list.size - Nth;   // position from head

        Node<T> c = list.head;
        int i = 0;
        while (idxFromHead != i) {
            c = c.next;
            i++;
        }
        return c.data;
    }

    public static <T extends Comparable<T>> void removeDuplicatesUnsorted(SinglyLinkedList<T> list) {
        Node<T> head = list.head;
        Node<T> tail = list.tail;
        int size = list.size;

        Node<T> firstDistinct = head;

        while (firstDistinct != null) {
            Node<T> previousWalker = firstDistinct;
            Node<T> walker = firstDistinct.next;

            while (walker != null) {
                boolean walkerFirstDistinctEquals = firstDistinct.data.compareTo(walker.data) == 0;
                if (walkerFirstDistinctEquals) {
                    previousWalker.next = walker.next;
                    walker = walker.next;
                    size--;
                    continue;
                }
                previousWalker = walker;
                walker = walker.next;
            }
            if (firstDistinct.next == null) tail = firstDistinct;
            firstDistinct = firstDistinct.next;
        }

        list.head = head;
        list.tail = tail;
        list.size = size;
    }

    public static <T extends Comparable<T>> void removeDuplicatesSorted(SinglyLinkedList<T> list) {
        Node<T> head = list.head;
        Node<T> tail = list.tail;
        int size = list.size;

        Node<T> c = head;
        while (c != null && c.next != null) {
            if (c.data.compareTo(c.next.data) == 0) {
                c.next = c.next.next;
                size--;
                if (c.next == null) tail = c;
                continue;
            }
            c = c.next;
            if (c.next == null) tail = c;
        }

        list.head = head;
        list.tail = tail;
        list.size = size;
    }

    public static <T extends Comparable<T>> T findStartOfALoop(SinglyLinkedList<T> list) {
        Node<T> head = list.head;
        int size = list.size;

        if (size < 1) return null;
        if (head == null) throw new IllegalStateException();

        Node<T> loopNode = new Node<>(null, null);
        Node<T> walker = head;
        Node<T> walkerX2 = head;

        while (walkerX2 != null && walkerX2.next != null) {
            walker = walker.next;
            walkerX2 = walkerX2.next.next;

            if (walker == walkerX2) {
                loopNode = walker;
                break;
            }
        }

        return loopNode.data;
    }

    public static <T extends Comparable<T>> void removeLoop(SinglyLinkedList<T> list) {
        Node<T> walker = list.head;
        Node<T> walkerX2 = list.head;

        while (walkerX2 != null && walkerX2.next != null) {
            walker = walker.next;
            walkerX2 = walkerX2.next.next;
            if (walker == walkerX2) {
                _removeLoop(list.head, walker);
            }
        }
    }

    private static <T> void _removeLoop(Node<T> head, Node<T> loopNode) {
        Node<T> h = head;
        while (h.next != loopNode.next) {
            loopNode = loopNode.next;
            h = h.next;
        }
        loopNode.next = null;
    }

    public static <T extends Comparable<T>> void mergeSort(SinglyLinkedList<T> list) {
        list.head = _sortNode(list.head, list.size);
        list.tail = _getNode(list.head, list.size); // todo: this can be optimized
    }

    private static <T> Node<T> _getNode(Node<T> node, int Nth) {
        for (int i = 1; i < Nth && node != null; i++) {
            node = node.next;
        }
        return node;
    }


    private static <T extends Comparable<T>> Node<T> _sortNode(Node<T> node, int size) {
        if (size < 2) return node;

        int mid = size / 2;
        Node<T> midNode = _getNode(node, mid); // midNode: last node of the left part
        Node<T> left = node;
        Node<T> right = midNode.next;
        midNode.next = null;

        Node<T> leftSorted = _sortNode(left, mid);
        Node<T> rightSorted = _sortNode(right, size - mid);

        return _mergeNodesSortingThem(leftSorted, rightSorted);
    }

    private static <T extends Comparable<T>> Node<T> _mergeNodesSortingThem(Node<T> left, Node<T> right) {
        Node<T> dummyHead = new Node<>(null, null);
        Node<T> c = dummyHead;

        while (left != null && right != null) {
            if (left.data.compareTo(right.data) <= 0) {
                c.next = left;
                left = left.next;
            } else {
                c.next = right;
                right = right.next;
            }
            c = c.next;
        }

        if (left != null) {
            c.next = left;
        } else {
            c.next = right;
        }

        return dummyHead.next;
    }

    public static <T extends Comparable<T>> SinglyLinkedList<T> quickSort(SinglyLinkedList<T> list) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /*
    Merge 2 sorted Singly Linked Lists

    l1:     1 -> 3 -> 25
    l2:     2 -> 4 -> 6 -> 10
    res:    1 -> 2 -> 3 -> 4 -> 6 -> 10 -> 25
     */
    public static <T extends Comparable<T>> SinglyLinkedList<T> mergeTwoSortedLists(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> clone1 = list1.clone();
        SinglyLinkedList<T> clone2 = list2.clone();

        if (clone2.size == 0) return clone1;
        if (clone1.size == 0) return clone2;

        Node<T> dummyHead = new Node<>(null, null);
        Node<T> c = dummyHead;

        Node<T> n1 = clone1.head;
        Node<T> n2 = clone2.head;

        while (n1 != null && n2 != null) {
            if (n1.data.compareTo(n2.data) <= 0) {
                c.next = n1;
                n1 = n1.next;
            } else {
                c.next = n2;
                n2 = n2.next;
            }
            c = c.next;
        }
        if (n1 != null) c.next = n1;
        if (n2 != null) c.next = n2;

        while (c.next != null) c = c.next; // c is the last node now

        // I'm gonna use the clone1 list to store the result
        clone1.head = dummyHead.next;
        clone1.tail = c;
        clone1.size = clone1.size + clone2.size;

        return clone1;
    }
    /*
        ALGORITHM: Add 2 Singly Linked Lists

        Given 2 non-empty linked lists representing 2 non-negative integers.
        The digits are stored in reverse order and each of their nodes
        contains a single digit. Add the 2 numbers and the sum as a linked list.
        You may assume the 2 numbers don't contain any LEADING zero, except
        the number 0 itself.

        EXAMPLE:
        THE SUM      ||     HOW IT IS STORED
            9 4 7        =  7 -> 4 -> 9
        +     6 5        =  5 -> 6
        ------------       -------------
          1 0 1 2           2 -> 1 -> 0 -> 1

        Possible:     0 -> null
        Not Possible:  1 -> 2 -> 5 -> 0   ( leading zero )

        PD: Solve using the nodes ( avoid peekLast(), removeLast(), etc )
     */

    public static SinglyLinkedList<Integer> addTwoLists(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2) {
        // validation
        for (SinglyLinkedList<Integer> list : (SinglyLinkedList<Integer>[]) new SinglyLinkedList[]{list1, list2}) {
            if (_isSizeLessThan(1, list)) throw new IllegalArgumentException();
            if (_isLeadingZero(list) && _isSizeLessThan(2, list)) throw new IllegalArgumentException();
            if (_containsNegativeIntegers(list)) throw new IllegalArgumentException();
            if (_anyNodeIsGreaterThan9(list))
                throw new IllegalArgumentException(); // means: a not has more than 1 digit
        }

        Node<Integer> dummyHead = new Node<>(null, null);

        Node<Integer> resTail = dummyHead;
        Node<Integer> h1 = list1.head;
        Node<Integer> h2 = list2.head;

        int numForTail;
        int exceedDigit = 0;

        while (h1 != null || h2 != null) {
            int num1 = h1 == null ? 0 : h1.data;
            int num2 = h2 == null ? 0 : h2.data;
            {
                if (h1 != null) h1 = h1.next;
                if (h2 != null) h2 = h2.next;
            }

            numForTail = num1 + num2 + exceedDigit;
            exceedDigit = 0;

            if (numForTail > 9) { // the max/min sum that exceeds the 1 digit of size can be either 9 + 9 + 1 = 19 or 9 + 1 + 0 = 10
                // 10 >= tobeAdded <= 19
                exceedDigit = 1;
                numForTail = numForTail - 10;
                resTail.next = new Node<>(numForTail, null);
                resTail = resTail.next;
                continue;
            }

            resTail.next = new Node<>(numForTail, null);
            resTail = resTail.next;
        }

        // store & return
        SinglyLinkedList<Integer> res = new SinglyLinkedList<>();
        res.head = dummyHead.next;
        res.tail = resTail;
        res.size = _calculateSize(res.head);

        return res;
    }

    private static int _calculateSize(Node<Integer> node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    private static boolean _isSizeLessThan(int size, SinglyLinkedList<Integer> list) {
        return list.size < size;
    }

    private static boolean _isLeadingZero(SinglyLinkedList<Integer> list) {
        return list.tail.data == 0;
    }

    private static boolean _containsNegativeIntegers(SinglyLinkedList<Integer> list) {
        Node<Integer> c = list.head;
        while (c != null) {
            if (c.data < 0) return true;
            c = c.next;
        }
        return false;
    }

    private static boolean _anyNodeIsGreaterThan9(SinglyLinkedList<Integer> list) {
        Node<Integer> c = list.head;
        while (c != null) {
            if (c.data > 9) return true;
            c = c.next;
        }
        return false;
    }

    public static <T extends Comparable<T>> void createLoop(SinglyLinkedList<T> list, int position) {
        if (position == 0) return;
        list.tail.next = _getNode(list.head, position);
    }

}
