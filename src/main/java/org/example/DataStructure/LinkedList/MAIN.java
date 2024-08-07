package org.example.DataStructure.LinkedList;

import static org.example.DataStructure.LinkedList.MAIN.POSITION.FIRST;
import static org.example.DataStructure.LinkedList.MAIN.POSITION.LAST;

public class MAIN {
    public static void main(String[] args) {
        final SinglyLinkedList<Integer> bossList = new SinglyLinkedList<>();
        System.out.println("Created: " + bossList);
        // ADD
        addAndPrint(bossList, 1, FIRST);
        addAndPrint(bossList, 2, LAST);
        addAndPrint(bossList, 1, FIRST);
        addAndPrint(bossList, 1, FIRST);
        addAndPrint(bossList, 4, FIRST);
        addAndPrint(bossList, 3, LAST);
        addAndPrint(bossList, 3, LAST);
        addAndPrint(bossList, 45, LAST);
        addAndPrint(bossList, 5, FIRST);
        addAndPrint(bossList, 2, LAST);
        addAndPrint(bossList, 4, FIRST);
        addAndPrint(bossList, 4, FIRST);
        addAndPrint(bossList, 45, LAST);
        addAndPrint(bossList, 7, LAST);
        addAndPrint(bossList, 7, FIRST);
        addAndPrint(bossList, 0, LAST);
        addAndPrint(bossList, 0, FIRST);
        /*
            Created: []
            Size: 0

            Added 1 to first
            toString: [(head)1(tail)]
            Size: 1

            Added 2 to last
            toString: [(head)1 -> 2(tail)]
            Size: 2

            Added 1 to first
            toString: [(head)1 -> 1 -> 2(tail)]
            Size: 3

            Added 1 to first
            toString: [(head)1 -> 1 -> 1 -> 2(tail)]
            Size: 4

            Added 4 to first
            toString: [(head)4 -> 1 -> 1 -> 1 -> 2(tail)]
            Size: 5

            Added 3 to last
            toString: [(head)4 -> 1 -> 1 -> 1 -> 2 -> 3(tail)]
            Size: 6

            Added 3 to last
            toString: [(head)4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3(tail)]
            Size: 7

            Added 45 to last
            toString: [(head)4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45(tail)]
            Size: 8

            Added 5 to first
            toString: [(head)5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45(tail)]
            Size: 9

            Added 2 to last
            toString: [(head)5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2(tail)]
            Size: 10

            Added 4 to first
            toString: [(head)4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2(tail)]
            Size: 11

            Added 4 to first
            toString: [(head)4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2(tail)]
            Size: 12

            Added 45 to last
            toString: [(head)4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2 -> 45(tail)]
            Size: 13

            Added 7 to last
            toString: [(head)4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2 -> 45 -> 7(tail)]
            Size: 14

            Added 7 to first
            toString: [(head)7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2 -> 45 -> 7(tail)]
            Size: 15

            Added 0 to last
            toString: [(head)7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2 -> 45 -> 7 -> 0(tail)]
            Size: 16

            Added 0 to first
            toString: [(head)0 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2 -> 45 -> 7 -> 0(tail)]
            Size: 17
         */

        // REMOVE
        removeAndPrint(bossList, LAST);
        removeAndPrint(bossList, FIRST);
        removeAndPrint(bossList, LAST);
        removeAndPrint(bossList, 45);
        /*
            Removed 0 from last
            toString: [(head)0 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2 -> 45 -> 7(tail)]
            Size: 16

            Removed 0 from first
            toString: [(head)7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2 -> 45 -> 7(tail)]
            Size: 15

            Removed 7 from last
            toString: [(head)7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 45 -> 2 -> 45(tail)]
            Size: 14

            Removed 45 (tried: 45)
            toString: [(head)7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2(tail)]
            Size: 12
         */

        // ADD
        addAndPrint(bossList, 1, FIRST);
        addAndPrint(bossList, 7, LAST);
        addAndPrint(bossList, -72, FIRST);
        /*
            Added 1 to first
            toString: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2(tail)]
            Size: 13

            Added 7 to last
            toString: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14

            Added -72 to first
            toString: [(head)-72 -> 1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 15
         */

        // REMOVE
        removeAndPrint(bossList, FIRST);
        /*
            Removed -72 from first
            toString: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
         */

        // PEEK & CONTAINS
        System.out.println("\npeekFirst: " + bossList.peekFirst());
        System.out.println("peekLast:    " + bossList.peekLast());
        System.out.println("contains 45: " + bossList.contains(45));
        /*
            peekFirst: 1
            peekLast:  7
            contains 45: false
         */


        // Iterable<T> & Iterator<T>
        for (Integer i : bossList) System.out.print(" " + i + " |");
        System.out.println();
        bossList.forEach(e -> System.out.print(" " + e + " |"));
        System.out.println();
        bossList.spliterator().forEachRemaining(e -> System.out.print(" " + e + " |"));
        /*
             1 | 7 | 4 | 4 | 5 | 4 | 1 | 1 | 1 | 2 | 3 | 3 | 2 | 7 |
             1 | 7 | 4 | 4 | 5 | 4 | 1 | 1 | 1 | 2 | 3 | 3 | 2 | 7 |
             1 | 7 | 4 | 4 | 5 | 4 | 1 | 1 | 1 | 2 | 3 | 3 | 2 | 7 |
         */

        // before use in algorithms
        System.out.println("\n\nOriginal: " + bossList);
        /*
            Original: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
         */

        // REVERSE algorithm
        var copy = bossList.clone();
        SinglyLinkedListAlgorithms.reverse(copy);
        System.out.println("\n");
        System.out.println("Before reverse: " + bossList);
        System.out.println("After reverse:  " + copy);
        /*
            Before reverse: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
            After reverse:  [(head)7 -> 2 -> 3 -> 3 -> 2 -> 1 -> 1 -> 1 -> 4 -> 5 -> 4 -> 4 -> 7 -> 1(tail)]
            Size: 14
         */

        // GET Nth FROM END algorithm
        System.out.println("\n");
        System.out.println("getNthFromEnd(3):    " + SinglyLinkedListAlgorithms.getNthFromEnd(bossList, 3));
        System.out.println("getNthFromEnd(1):    " + SinglyLinkedListAlgorithms.getNthFromEnd(bossList, 1));
        System.out.println("getNthFromEnd(0):    " + SinglyLinkedListAlgorithms.getNthFromEnd(bossList, 0));
        System.out.println("getNthFromEnd(100):  " + SinglyLinkedListAlgorithms.getNthFromEnd(bossList, 100));
        System.out.println("getNthFromEnd(-100): " + SinglyLinkedListAlgorithms.getNthFromEnd(bossList, -100));
        /*
            getNthFromEnd(3):    3
            getNthFromEnd(1):    7
            getNthFromEnd(0):    null
            getNthFromEnd(100):  null
            getNthFromEnd(-100): null
        */

        // REMOVE DUPLICATES algorithms
        var copy1 = bossList.clone();
        SinglyLinkedListAlgorithms.removeDuplicatesUnsorted(copy1);
        System.out.println("\n");
        System.out.println("Before removeDuplicatesUnsorted: " + bossList);
        System.out.println("After removeDuplicatesUnsorted:  " + copy1);
        /*
            Before removeDuplicatesUnsorted: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
            After removeDuplicatesUnsorted:  [(head)1 -> 7 -> 4 -> 5 -> 2 -> 3(tail)]
            Size: 6
         */

        // CLONE
        System.out.println("\n");
        System.out.println("Original: " + bossList);
        System.out.println("Cloned:   " + bossList.clone());
        /*
            Original: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
            Cloned:   [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
         */


        // REMOVE DUPLICATES algorithms (sorted)
        var sorted = bossList.clone();
        SinglyLinkedListAlgorithms.mergeSort(sorted);
        var sortedNoDuplicates = sorted.clone();
        SinglyLinkedListAlgorithms.removeDuplicatesSorted(sortedNoDuplicates);
        System.out.println("\n");
        System.out.println("Original List: " + bossList);
        System.out.println("Sorted:        " + sorted);
        System.out.println("After removeDuplicatesSorted:  " + sortedNoDuplicates);
        /*
            Original List: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
            Sorted:        [(head)1 -> 1 -> 1 -> 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> 4 -> 4 -> 5 -> 7 -> 7(tail)]
            Size: 14
            After removeDuplicatesSorted:  [(head)1 -> 2 -> 3 -> 4 -> 5 -> 7(tail)]
            Size: 6
         */

        // REMOVE DUPLICATES algorithms (unsorted)
        var copy3 = bossList.clone();
        SinglyLinkedListAlgorithms.removeDuplicatesUnsorted(copy3);
        System.out.println("\n");
        System.out.println("Before removeDuplicatesUnsorted: " + bossList);
        System.out.println("After removeDuplicatesUnsorted:  " + copy3);
        /*
            Before removeDuplicatesUnsorted: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
            After removeDuplicatesUnsorted:  [(head)1 -> 7 -> 4 -> 5 -> 2 -> 3(tail)]
            Size: 6
         */


        // CREATE LOOP
        var loopList = bossList.clone();
        SinglyLinkedListAlgorithms.createLoop(loopList, 3);
        System.out.println("\n");
        System.out.println("Before creating a loop: " + bossList);
        System.out.println("After creating a loop:  " + "<to do>");
        /*
            Before creating a loop: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
            After creating a loop:  [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
                                                     ^                                                      |
                                                     + ---------------------------------------------------- +
         */

        // FIND START OF A LOOP ( Floyd's Cycle Detection Algorithm )
        System.out.println("\n");
        System.out.println("List with a loop:  " + "<to do>");
        System.out.println("List with a loop  (where the pointers met): " + SinglyLinkedListAlgorithms.findStartOfALoop(loopList));
        System.out.println("List with no loop (where the pointers met): " + SinglyLinkedListAlgorithms.findStartOfALoop(bossList));
        /*
            List with a loop:  [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
                                                ^                                                      |
                                                + ---------------------------------------------------- +
            List with a loop  (where the pointers met): 2
            List with no loop (where the pointers met): null
         */


        // REMOVE LOOP algorithm
        SinglyLinkedListAlgorithms.removeLoop(loopList); // I not use the tail node to remove the loop
        System.out.println("\n");
        System.out.println("Before removing loop: " + "<to do>");
        System.out.println("After removing loop:  " + loopList);
        /*
            Before removing loop: [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
                                                   ^                                                      |
                                                   + ---------------------------------------------------- +
            After removing loop:  [(head)1 -> 7 -> 4 -> 4 -> 5 -> 4 -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> 2 -> 7(tail)]
            Size: 14
         */


        // MERGE TWO SORTED LINKED LISTS && MERGE SORT algorithm
        var copy5 = bossList.clone();
        var copy6 = bossList.clone();
        SinglyLinkedListAlgorithms.mergeSort(copy5);
        SinglyLinkedListAlgorithms.mergeSort(copy6);
        SinglyLinkedList<Integer> mergedList = SinglyLinkedListAlgorithms.mergeTwoSortedLists(copy5, copy6);

        System.out.println("\n");
        System.out.println("List 1: " + copy5);
        System.out.println("List 2: " + copy6);
        System.out.println("Merged: " + mergedList);
        /*
            List 1: [(head)1 -> 1 -> 1 -> 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> 4 -> 4 -> 5 -> 7 -> 7(tail)]
            Size: 14
            List 2: [(head)1 -> 1 -> 1 -> 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> 4 -> 4 -> 5 -> 7 -> 7(tail)]
            Size: 14
            Merged: [(head)1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 2 -> 2 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 4 -> 4 -> 4 -> 4 -> 4 -> 4 -> 5 -> 5 -> 7 -> 7 -> 7 -> 7(tail)]
            Size: 28
         */


        // ADD TWO LINKED LISTS algorithm
        var l1 = new SinglyLinkedList<Integer>();l1.addLast(1);l1.addLast(7);l1.addLast(4);l1.addLast(4);l1.addLast(5);l1.addLast(4);l1.addLast(9);l1.addLast(1);l1.addLast(1);l1.addLast(0);l1.addLast(9);l1.addLast(9);l1.addLast(9);l1.addLast(9);
        var l2 = new SinglyLinkedList<Integer>();l2.addLast(9);l2.addLast(1);l2.addLast(9);l2.addLast(9);l2.addLast(9);l2.addLast(9);l2.addLast(0);
        SinglyLinkedListAlgorithms.reverse(l1);
        SinglyLinkedListAlgorithms.reverse(l2);
        SinglyLinkedList<Integer> res = SinglyLinkedListAlgorithms.addTwoLists(l1, l2); // l1 & l2 are reversed
        System.out.println("\n");
        System.out.println("List 1(reversed): " + l1);
        System.out.println("List 2(reversed): " + l2);
        System.out.println("Result(reversed): " + res);
        System.out.println("Sum Expected:");
        System.out.println("                  (1)(1)   (1)(1)(1)(1)   ");
        System.out.println("    1  7  4  4  5  4  9  1  1  0  9  9  9  9 ");
        System.out.println("+                        9  1  9  9  9  9  0 ");
        System.out.println("-------------------------------------------------");
        SinglyLinkedListAlgorithms.reverse(res); // Reverse the result back to original order
        System.out.println("    1  7  4  4  5  5  0  0  3  0  9  9  8  9 ");
        System.out.println("\nReal Result(reversed again): " + res);
        /*
            List 1(reversed): [(head)9 -> 9 -> 9 -> 9 -> 0 -> 1 -> 1 -> 9 -> 4 -> 5 -> 4 -> 4 -> 7 -> 1(tail)]
            Size: 14
            List 2(reversed): [(head)0 -> 9 -> 9 -> 9 -> 9 -> 1 -> 9(tail)]
            Size: 7
            Result(reversed): [(head)9 -> 8 -> 9 -> 9 -> 0 -> 3 -> 0 -> 0 -> 5 -> 5 -> 4 -> 4 -> 7 -> 1(tail)]
            Size: 14
            Sum Expected:
                                                              (1)(1)   (1)(1)(1)(1)
                                                1  7  4  4  5  4  9  1  1  0  9  9  9  9
                                            +                        9  1  9  9  9  9  0
                                            -------------------------------------------------
                                                1  7  4  4  5  5  0  0  3  0  9  9  8  9

            Real Result(reversed again): [(head)1 -> 7 -> 4 -> 4 -> 5 -> 5 -> 0 -> 0 -> 3 -> 0 -> 9 -> 9 -> 8 -> 9(tail)]
            Size: 14

         */
    }

    private static <T extends Comparable<T>> void removeAndPrint(SinglyLinkedList<T> list, POSITION where) {
        String msg = "\nRemoved %s from %s\ntoString: %s\n";
        T removed = where.equals(FIRST) ? list.removeFirst() : list.removeLast();
        System.out.printf(msg, removed, where.equals(FIRST) ? "first" : "last", list);
    }

    private static <T extends Comparable<T>> void removeAndPrint(SinglyLinkedList<T> list, T val) {
        String msg = "\nRemoved %s (tried: %s)\ntoString: %s\n";
        T removed = list.remove(val);
        System.out.printf(msg, removed, val, list);
    }

    private static <T extends Comparable<T>> void addAndPrint(SinglyLinkedList<T> list, T val, POSITION where) {
        String msg = "\nAdded %s to %s\ntoString: %s\n";
        if (where.equals(FIRST)) list.addFirst(val);
        else list.addLast(val);
        System.out.printf(msg, val.toString(), where.equals(FIRST) ? "first" : "last", list.toString());
    }

    enum POSITION {
        FIRST, LAST
    }
}
