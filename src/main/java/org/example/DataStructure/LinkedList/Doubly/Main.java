package org.example.DataStructure.LinkedList.Doubly;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(0);
        list.addLast(-1);

        System.out.println(list);
        /*
            [ (head) 5 <-> 4 <-> 3 <-> 2 <-> 1 <-> 6 <-> 7 <-> 8 <-> 0 <-> -1 (tail) ]
         */

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        System.out.println(list);
        /*
            [ (head) 2 <-> 1 <-> 6 <-> 7 (tail) ]
         */

        list.remove(1);
        list.remove(7);
        System.out.println(list);
        /*
            [ (head) 2 <-> 6 (tail) ]
         */

        list.remove(7);
        list.remove(2);
        System.out.println(list);
        /*
            [ (head) 6 (tail) ]
         */

        list.removeFirst();
        System.out.println(list);
        /*
            [  ]
         */
    }
}
