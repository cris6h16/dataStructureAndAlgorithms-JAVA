package org.example.DataStructure.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class MIAN {
    public static void main(String[] args) {
//        Stack<Integer> s = new StackArray<>();
        Stack<Integer> s = new StackLinkedList<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(11);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

//        java.util.Stack<String> s2 = new java.util.Stack<String>();
        Queue<String> queue = new LinkedList<>();
        queue.element();

    }
}
