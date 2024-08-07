package org.example.DataStructure.LinkedList.Singly;

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
public class SinglyLinkedList<T extends Comparable<T>> implements List<T>, Iterable<T>, Cloneable {
    protected Node<T> head;
    protected Node<T> tail;
    protected Integer size = 0; // Θ(1)

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
        return new IteratorHelper<T>(head);
    }


    @Override
    public SinglyLinkedList<T> clone() {
        Node<T> c = head;
        SinglyLinkedList<T> clone = new SinglyLinkedList<>();

        if (head == null) return clone;

        while (c != null) {
            clone.addLast(c.data);
            c = c.next;
        }
        return clone;
    }

    private static  class IteratorHelper <T> implements Iterator<T> {
        Node<T> node;

        public IteratorHelper(Node<T> head) {
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

    // static = no need to create an instance of the class to use it
}
