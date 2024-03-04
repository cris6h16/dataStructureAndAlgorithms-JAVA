package org.example.DataStructure.LinkedList;

import java.util.Stack;

public class MAIN {
    public static void main(String[] args) {
        // empty
        SinglyLinkedList<Integer> nums = new SinglyLinkedList<Integer>(1);

        nums.removeFirst();
        nums.removeLast();
        nums.removeFirst();
        nums.remove(45);
        nums.peekFirst();
        nums.peekLast();
        nums.contains(45);
        System.out.println(nums);
        //--------

        nums.addLast(27);
        nums.addLast(7);
        nums.addFirst(12);
        // 12 27 7
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
}
