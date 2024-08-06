package org.example.DataStructure.LinkedList;

import java.util.function.Supplier;

public class MAIN {
    public static void main(String[] args) {

        //------------- test remove first, last, and by value, peekFirst, peekLast, contains -------------\\
        SinglyLinkedList<Integer> nums = new SinglyLinkedList<>(1);
        removeAndPrint(nums, true); //first
        removeAndPrint(nums, false); //last
        removeAndPrint(nums, true); //first
        removeAndPrint(nums, 45);
        System.out.println("\npeekFirst: " + nums.peekFirst());
        System.out.println("peekLast: " + nums.peekLast());
        System.out.println("contains 45: " + nums.contains(45));
        /*
            Removed 1 from first
            toString: []
            Size: 0

            Removed null from last
            toString: []
            Size: 0

            Removed null from first
            toString: []
            Size: 0

            Removed null (tried: 45)
            toString: []
            Size: 0

            peekFirst: null
            peekLast: null
            contains 45: false
         */
        //--------

        addAndPrint(nums, 1, true); //first
        addAndPrint(nums, 7, false); //last
        addAndPrint(nums, -72, true); //first
        /*
            Added 1 to first
            toString: [1]
            Size: 1

            Added 7 to last
            toString: [1 -> 7]
            Size: 2

            Added -72 to first
            toString: [-72 -> 1 -> 7]
            Size: 3
         */

        removeAndPrint(nums, 27);
        /*
            Removed null (tried: 27)
            toString: [-72 -> 1 -> 7]
            Size: 3
         */


        //------------- test Iterable<T> & Iterator<T> -------------\\
        for (Integer i : nums) System.out.println(i);
        nums.forEach(System.out::println);
        nums.spliterator().forEachRemaining(System.out::println);
        /*
            -72
            1
            7
            -72
            1
            7
            -72
            1
            7
         */


        //------------- reverse a linked list -------------\\
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(-9999);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(-10);
        list.addFirst(-20);
        list.addFirst(-30);
        System.out.println("\n" + list);
        list.reverse();
        System.out.println(list);
        /*
            [-30 -> -20 -> -10 -> -9999 -> 1 -> 2 -> 3]
            Size: 7
            [3 -> 2 -> 1 -> -9999 -> -10 -> -20 -> -30]
            Size: 7
         */

        //------------- getNthFromEnd -------------\\
        Supplier<String> resultsSupplier = () -> {
            StringBuilder sb = new StringBuilder();
            for (int i = -1; i < 10; i++) {
                sb.append(list.getNthFromEnd(i)).append(", ");
            }
            return sb.toString();
        };

        String results = resultsSupplier.get();

        System.out.printf(
                "\nCurrent list: %s\nCall: %s\nResult: %s\n",
                list,
                "\ngetNthFromEnd(-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9):",
                results
        );
        /*
            Current list: [3 -> 2 -> 1 -> -9999 -> -10 -> -20 -> -30]
            Size: 7
            Call:
            getNthFromEnd(-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9):
            Result: null, null, -30, -20, -10, -9999, 1, 2, 3, null, null,
         */


        System.out.println(
                "\n\n//------------- test removeDuplicates -------------\\\\\n\n"
        );
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>(1);
        System.out.println("Created: " + list2);
        addAndPrint(list2, 1, false);
        addAndPrint(list2, 2, true);
        addAndPrint(list2, 1, false);
        addAndPrint(list2, 1, false);
        addAndPrint(list2, 4, false);
        addAndPrint(list2, 3, true);
        addAndPrint(list2, 3, true);
        addAndPrint(list2, 5, false);
        addAndPrint(list2, 2, true);
        addAndPrint(list2, 4, false);
        addAndPrint(list2, 4, false);
        addAndPrint(list2, 7, true);
        addAndPrint(list2, 7, false);
        addAndPrint(list2, 0, true);
        addAndPrint(list2, 0, false);

        var list2Clone = clonePrintSortPrint(list);

        removeDuplicatesUnsortedAndPrint(list);
        removeDuplicatesSortedAndPrint(list2Clone);



    }

    private static <T extends Comparable<T>> SinglyLinkedList<T> clonePrintSortPrint(SinglyLinkedList<T> list) {
        SinglyLinkedList<T> l = list.clone();
        System.out.println("\nOriginal:     " + list);
        System.out.println("Cloned:       " + l);
        l.mergeSort();
        System.out.println("Merge Sorted: " + l);
        return l;
    }

    private static <T extends Comparable<T>> void removeDuplicatesSortedAndPrint(SinglyLinkedList<T> list) {
        System.out.println("\nBefore removeDuplicatesSorted: " + list);
        list.removeDuplicatesSorted();
        System.out.println("After removeDuplicatesSorted:  " + list);
    }

    private static void removeDuplicatesUnsortedAndPrint(SinglyLinkedList<Integer> list) {
        System.out.println("\nBefore removeDuplicatesUnsorted: " + list);
        list.removeDuplicatesUnsorted();
        System.out.println("After removeDuplicatesUnsorted:  " + list);
    }

    private static <T extends Comparable<T>> void removeAndPrint(SinglyLinkedList<T> list, boolean first) {
        String msg = "\nRemoved %s from %s\ntoString: %s\n";
        T removed = first ? list.removeFirst() : list.removeLast();
        System.out.printf(msg, removed, first ? "first" : "last", list);
    }

    private static <T extends Comparable<T>> void removeAndPrint(SinglyLinkedList<T> list, T val) {
        String msg = "\nRemoved %s (tried: %s)\ntoString: %s\n";
        T removed = list.remove(val);
        System.out.printf(msg, removed, val, list);
    }

    private static <T extends Comparable<T>> void addAndPrint(SinglyLinkedList<T> list, T val, boolean first) {
        String msg = "\nAdded %s to %s\ntoString: %s\n";
        if (first) list.addFirst(val);
        else list.addLast(val);
        System.out.printf(msg, val, first ? "first" : "last", list.toString());
    }
}
