package org.example.DataStructure.LinkedList;

import java.util.Stack;

public class MAIN {
    public static void main(String[] args) {
        // empty
        SinglyLinkedList<Integer> nums = new SinglyLinkedList<>(1);

        removeAndPrint(nums, true); //first
        removeAndPrint(nums, false); //last
        removeAndPrint(nums, true); //first
        removeAndPrint(nums, 45);
        System.out.println("peekFirst: " + nums.peekFirst());
        System.out.println("peekLast: " + nums.peekLast());
        System.out.println("contains 45: " + nums.contains(45));
        /*
        Removed 1 from first
        toString:
        size: 0

        Removed null from last
        toString:
        size: 0

        Removed null from first
        toString:
        size: 0

        Removed null (tried: 45)
        toString:
        size: 0

        peekFirst: null
        peekLast: null
        contains 45: false
         */
        //--------

        addAndPrint(nums, 1, true);
        addAndPrint(nums, 7, false);
        addAndPrint(nums, -72, true);

        nums.remove(27);
        System.out.println(nums);
        // 12 7

        // test Iterable<T> & Iterator<T>
        for (Integer i : nums) System.out.println(i);
        nums.forEach(System.out::println);
        nums.spliterator().forEachRemaining(System.out::println);

        Stack<Integer> stack = new Stack<Integer>();
        System.out.println(stack.empty());
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
