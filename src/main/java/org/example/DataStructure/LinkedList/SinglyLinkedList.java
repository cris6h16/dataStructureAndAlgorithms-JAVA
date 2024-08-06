package org.example.DataStructure.LinkedList;

import org.example.DataStructure.LinkedList.Interfaces.List;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

/* Boundaries
Empty List
Single element
Begin Add/Remove
End Add/Remove
Middle some Modification
 */

// todo: add the boundaries on each data structure && add the time units on each method

/**
 * My Singly Linked List Implementation, this is my practice to understand better therefore this is untested ( not ready to be used )
 *
 * @param <T> Generic Type
 * @author <a href="https://www.github.com/cris6h16" target="_blank">Cristian Herrera</a>
 */
public class SinglyLinkedList<T extends Comparable<T>> implements List<T>, Iterable<T>, SinglyLinkedListAlgorithms<T>, Cloneable {
    private Node<T> head, tail;
    private Integer size = 0; // Θ(1)

    /* Time Units: 9 => Θ(1)

     head = tail = n;    // 1 + 1 + 1   (assign, assign, access)
     head.next = tail;   // 1 + 1       (assign, access)
     tail.next = null;   // 1 + 1       (assign, access)
     size++;             // 1 + 1 + 1   (assign, arithmetic operation, access)
     return null;        // 1           (return)

     9 * 1 = 9
     */
    private final Function<Node<T>, Void> _addNodeWhenIsEmpty = (n) -> {
        head = tail = n;
        head.next = tail;
        tail.next = null;
        size++;
        return null;
    };

    /*  Time UNits: 13 => Θ(1)
     Node<T> n = new Node<>(val, null);  // 1 + 1 + 1   (access, new, assign)
     _addNodeWhenIsEmpty.apply(n);       // 9 + 1       (apply, access)
     = 13
    */
    public SinglyLinkedList(T val) {
        Node<T> n = new Node<>(val, null);
        _addNodeWhenIsEmpty.apply(n);
    }

    public SinglyLinkedList() {
    }

    /* Time Units: 17 || 12 => Θ(1)
    Node<T> n = new Node<>(val, null);  // 1 + 1 + 1    (access, new, assign)

    // empty
    if (size == 0) {                    // 1 + 1        (access, comparison)
        _addNodeWhenIsEmpty.apply(n);   // 9 + 1        (apply, access)
        return;                         // 1            (return)
    }

    // single or more
    n.next = head;                      // 1 + 1 + 1    (access, access, assign)
    head = n;                           // 1 + 1        (access, assign)
    size++;                             // 1 + 1 + 1    (access, arithmetic operation, assign)
    */
    @Override
    public void addFirst(T val) {
        Node<T> n = new Node<>(val, null);

        // empty
        if (size == 0) {
            _addNodeWhenIsEmpty.apply(n); // times: 1
            return;
        }

        // single or more
        n.next = head;
        head = n;
        size++;
    }


    /* Time Units: 3 || 9 || 15 => Θ(1)
    // empty
    if (size == 0) return null;             // 1 + 1 + 1        (access, comparison, return)

    T tmp = head.data;                      // 1 + 1 + 1        (access, access, assign)

    // single | begin
    if (size == 1) head = tail = null;      // 1 + 1 + 1 + 1    (comparison, assign, assign, assign)
    else head = head.next;                  // 1 + 1 + 1        (access, access, assign)

    size--;                                 // 1 + 1 + 1        (access, arithmetic operation, assign)
    return tmp;                             // 1 + 1            (access, access, return)
     */
    @Override
    public T removeFirst() {
        // empty
        if (size == 0) return null;

        T tmp = head.data;

        // single | begin
        if (size == 1) head = tail = null;
        else head = head.next;

        size--;
        return tmp;
    }

    /* Time Units: 24 || 13 => Θ(1)
    Node<T> n = new Node<>(val, null);      // 1 + 1 + 1    (access, new, assign)

    // empty
    if (size == 0) {                        // 1 + 1        (access, comparison)
        addFirst(val);                      // 1 + 17       (call, method time units(worst))
        return;                             // 1            (return)
    }

    // single or more
    tail.next = n;                          // 1 + 1 + 1    (access, access, assign)
    tail = n;                               // 1 + 1        (access, assign)
    size++;                                 // 1 + 1 + 1    (access, arithmetic operation, assign)
     */
    @Override
    public void addLast(T val) {
        Node<T> n = new Node<>(val, null);

        // empty
        if (size == 0) {
            addFirst(val);
            return;
        }

        // single or more
        tail.next = n;
        tail = n;
        size++;
    }

    /* Time Units: 3 || 19 || 10 + 7n => O(n)
    // empty | single
    if (size == 0) return null;                             // 1 + 1 + 1                                (access, comparison, return)
    if (size == 1) return removeFirst();                    // 1 + 1 + 1 + 15                           (comparison, call, method time units(worst))

    T tmp = tail.data;                                      // 1 + 1 + 1                                (access, access, assign)

    Node<T> newTail = head;                                 // 1 + 1                                    (access, assign)
    while (newTail.next != tail) {                          // ( n - 1 ) * ( 1 + 1 + 1 + 1 ) => 4n - 4  (comparison, access, access, access)
        newTail = newTail.next;                             // ( n - 1 ) * ( 1 + 1 + 1 )     => 3n - 3  (access, access, assign)
    }
    newTail.next = null;                                    // 1 + 1 + 1                                (access, assign, assign)
    tail = newTail;                                         // 1 + 1                                    (access, assign)

    size--;                                                 // 1 + 1 + 1                                (access, arithmetic operation, assign)
    return tmp;                                             // 1 + 1                                    (access, return)

    17 + ( 4n - 4 ) + ( 3n - 3 ) = 17 + 4n - 4 + 3n - 3 = 10 + 7n
     */
    @Override
    public T removeLast() {
        // empty | single
        if (size == 0) return null;
        if (size == 1) return removeFirst();

        T tmp = tail.data;

        Node<T> newTail = head;
        while (newTail.next != tail) newTail = newTail.next;
        newTail.next = null;
        tail = newTail;

        size--;
        return tmp;
    }

    /*
    Time Units: 7 ||  7 + n ( 65 + ? ) => O(n)
    PD: I assume compareTo() is 1

    T tmp = null;                                       // 1                                            (assign)
    Node<T> p = null;                                   // 1                                            (assign)
    Node<T> c = head;                                   // 1 + 1                                        (assign, access)

    while (c != null) {                                 // 1 + 1 || ( n + 1 ) ( 1 + 1 ) => 2n + 2       (comparison, access)
        if (c.data.compareTo(obj) == 0) {               // ( n ) * ( 1 + 1 + ? + 1 + 1 ) => 4n + ?n     (access, access, access, comparison_impl , comparison)
            tmp = c.data;                               // ( n ) * ( 1 + 1 + 1 ) => 3n                  (access, access, assign)
            if (c == head) return removeFirst();        // ( n ) * ( 1 + 1 + 1 + 1 + 1 + 15 ) => 20n    (access, access, comparison, return, call, method time units)
            if (c == tail) return removeLast();         // ( n ) * ( 1 + 1 + 1 + 1 + 1 + 19 ) => 24n    (access, access, comparison, return, call, method time units)
            p.next = c.next;                            // ( n ) * ( 1 + 1 + 1 + 1 ) => 4n              (access, access, access, assign)
            size--;                                     // ( n ) * ( 1 + 1 + 1 ) => 3n                  (access, arithmetic operation, assign)
        }
        p = c;                                          // ( n ) * ( 1 + 1 ) => 2n                      (access, assign)
        c = c.next;                                     // ( n ) * ( 1 + 1 + 1 ) => 3n                  (access, access, assign)
    }

    return tmp;                                         // 1                                            (return)

    ( 1 + 1 + 1 + 1 ) + ( 2n + 2 ) + ( 4n + ?n ) + 3n + 20n + 24n + 4n + 3n + 2n + 3n + 1
    = 7 + 2n + 4n + ?n + 3n + 20n + 24n + 4n + 3n + 2n + 3n
    = 7 + 65n + ?n                                                                                      ( ? => compareTo() )
    = 7 + n ( 65 + ? )
     */
    @Override
    public T remove(T obj) {
        T tmp = null;
        Node<T> p = null; // previous
        Node<T> c = head; // current

        while (c != null) {
            if (c.data.compareTo(obj) == 0) {// val found
                tmp = c.data;
                //Compare: Memory Address
                if (c == head) return removeFirst();
                if (c == tail) return removeLast();
                p.next = c.next;
                size--;
            }
            p = c;
            c = c.next;
        }

        return tmp;
    }

    /*
    Time Units: 7 || 7 + n ( 10 + ? ) => O(n)
    PD: I assume compareTo() is 1

    boolean contains = false;                   // 1                                            (assign)

    Node<T> c = head;                           // 1 + 1                                        (assign, access)
    while (c != null) {                         // 1 + 1 || ( n + 1 ) ( 1 + 1 ) => 2n + 2       (comparison, access)
        if (val.compareTo(c.data) == 0) {       // ( n ) * ( 1 + 1 + 1 + 1 + ? + 1 ) => 5n + n? (access, access, access, access, comparison_impl, comparison)
            contains = true;                    // 1                                            (assign)
            break;                              // 1                                            (break)
        }
        c = c.next;                             // ( n ) * ( 1 + 1 + 1 ) => 3n                  (access, access, assign)
    }
    return contains;                            // 1 + 1                                        (access, return)

    1 + ( 1 + 1 ) + ( 2n + 2 ) + ( 5n + n? ) + 3n + ( 1 + 1 )
    = 7 + 2n + 5n + n? + 3n
    = 7 + 10n + ?n
    = 7 + n ( 10 + ? )
     */
    @Override
    public boolean contains(T val) {
        boolean contains = false;

        Node<T> c = head;
        while (c != null) {
            if (val.compareTo(c.data) == 0) {
                contains = true;
                break;
            }
            c = c.next;
        }
        return contains;
    }

    /* Time Units: 3 || 5 => Θ(1)
    if (size == 0) return null;     // 1 + 1 + 1        ( access, comparison ) ( return )
    return head.data;               // 1 + 1 + 1        ( access, access, return )
     */
    @Override
    public T peekFirst() {
        if (size == 0) return null;
        return head.data;
    }

    /* Time Units: 3 || 5 => Θ(1)
    if (size == 0) return null;     // 1 + 1 + 1        ( access, comparison ) ( return )
    return tail.data;               // 1 + 1 + 1        ( access, access, return )
    */
    @Override
    public T peekLast() {
        if (size == 0) return null;
        return tail.data;
    }

    /* Time Units: 2 => Θ(1)
     */
    public int getSize() {
        return size;
    }

    /* Time Units:
    Worst: 13 + 2? + n ( 14 + 2? ) + a => O(n)
    PD: I'm gonna assume that
            -   append() -> ?
            -   toString() -> a
        require 1 time unit


    StringBuilder sb = new StringBuilder();     // 1 + 1                    => 2                (new, assign)
    Node<T> c = head;                           // 1 + 1                    => 2                (access, assign)
    sb.append("[");                             // 1 + 1 + ?                => 2 + ?            (access, access, append())
    while (c != null) {                         // ( n + 1 ) * ( 1 + 1 )    => 2n + 2           (access, comparison)
        sb.append(c.data);                      // n ( 1 + 1 + 1 + 1 + ? )  => 4n + ?n          (access, access, access, access, append())
        if (c.next != null) {                   // n ( 1 + 1 + 1 )          => 3n               (access, access, comparison)
            sb.append(" -> ");                  // ( n - 1 ) * ( 1 + 1 + ? )=> 2n + ?n - 2 - ?  (access, access, append())
        }
        c = c.next;                             // n ( 1 + 1 + 1 )          => 3n               (access, access, assign)
    }
    sb.append("]\nSize: ").append(size);        // 1 + 1 + ? + 1 + 1 + ?    => 4 + 2?           (access, access, append(), access, access, append())

    return sb.toString();                       // 1 + 1 + a + 1            => 3 + a            (access, access, toString(), return)

    2 + 2 + 2 + ? + 2n + 2 + 4n + ?n + 3n + 2n + ?n - 2 - ? + 3n + 4 + 2? + 3 + a
    = 13 + 2? + 14n + 2?n + a
    = 13 + 2? + n ( 14 + 2? ) + a
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> c = head;
        sb.append("[");
        while (c != null) {
            if (c == head) sb.append("(head)");
            sb.append(c.data);
            if (c == tail) sb.append("(tail)");
            if (c.next != null) {
                sb.append(" -> ");
            }
            c = c.next;
        }
        sb.append("]\nSize: ").append(size);

        return sb.toString();
    }


    /* Time Units: 2 => Θ(1)

    return new IteratorHelper();   // 1 + 1    ( new, return )
     */
    @Override
    public Iterator<T> iterator() {
        return new IteratorHelper();
    }

    @Override
    public void reverse() {
        reverse(null, head);
        Node<T> tmp = head;
        head = tail;
        tail = tmp;
    }

    @Override
    public T getNthFromEnd(int Nth) {
        if (Nth > size || Nth < 1) return null;
        int idxFromHead = size - Nth;   // position from head
        Node<T> c = head;
        int i = 0;
        while (idxFromHead != i) {
            c = c.next;
            i++;
        }
        return c.data;
    } // ASOTI

    // we work with pointers, thats why I not reassign the head
    @Override
    public void removeDuplicatesUnsorted() {
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
    }

    @Override
    public void removeDuplicatesSorted() {
        Node<T> c = head;
        while (c != null && c.next != null) {
            if (c.data.compareTo(c.next.data) == 0) {
                c.next = c.next.next;
                continue;
            }
            c = c.next;
        }
    }

    @Override
    public T findStartOfLoop() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void removeLoop() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void mergeSort() {
        head = mergeSort(head, size);
        tail = getNode(head, size); // todo: this can be optimized
    }

    @Override
    public void quickSort() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private Node<T> mergeSort(Node<T> node, int size) {
        if (size < 2) return node;

        int mid = size / 2;
        Node<T> midNode = getNode(node, mid ); // midNode: last node of the left part
        Node<T> left = node;
        Node<T> right = midNode.next;
        midNode.next = null;

        Node<T> leftSorted = mergeSort(left, mid);
        Node<T> rightSorted = mergeSort(right, size - mid);

        return merge(leftSorted, rightSorted);
    }

    private Node<T> merge(Node<T> left, Node<T> right) {
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

    private Node<T> getNode(Node<T> node, int Nth) {
        for (int i = 1; i < Nth && node != null; i++) {
            node = node.next;
        }
        return node;
    }


    @Override
    public void mergeASortedList(SinglyLinkedList<T> list2) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public SinglyLinkedList<T> addTwoLists(SinglyLinkedList<T> list2) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void reverse(Node<T> previous, Node<T> current) {
        if (current == null) return;
        Node<T> next = current.next;
        current.next = previous;
        reverse(current, next);
    }

    @Override
    protected SinglyLinkedList<T> clone() {
        Node<T> c = head;
        SinglyLinkedList<T> list = new SinglyLinkedList<>();

        if (head == null) return list;

        while (c != null) {
            list.addLast(c.data);
            c = c.next;
        }
        return list;
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
