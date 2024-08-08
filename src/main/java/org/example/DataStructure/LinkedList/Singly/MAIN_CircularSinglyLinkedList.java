package org.example.DataStructure.LinkedList.Singly;

public class MAIN_CircularSinglyLinkedList {
    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();
        System.out.println(list);
        /*
            [ ] <size: 0>
         */

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        System.out.println(list);
        /*
            [ ↪ 5 -> 4 -> 3 -> 2 -> 1 (last) ↩ ] <size: 5>
         */

        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(0);
        list.addLast(-1);
        System.out.println(list);
        /*
            [ ↪ 5 -> 4 -> 3 -> 2 -> 1 -> 6 -> 7 -> 8 -> 0 -> -1 (last) ↩ ] <size: 10>
         */

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        System.out.println(list);
        /*
            [ ↪ 2 -> 1 -> 6 -> 7 (last) ↩ ] <size: 4>
         */

        list.remove(1);
        list.remove(7);
        System.out.println(list);
        /*
            [ ↪ 2 -> 6 (last) ↩ ] <size: 2>
         */

        list.remove(7);
        list.remove(2);
        System.out.println(list);
        /*
            [ ] <size: 0>
         */

        list.removeFirst();
        System.out.println(list);
        /*
            [ ] <size: 0>
         */

        list.addFirst(1);
        System.out.println(list);
        /*
            [ ↪ 1 (last) ↩ ] <size: 1>
         */
    }
}
