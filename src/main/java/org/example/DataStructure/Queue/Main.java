package org.example.DataStructure.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new QueueCircularArray<>(0);
//        Queue<Integer> queue = new QueueLinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        Queue<Integer> clon = queue.clone();


        try {
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("Clon: ");
            System.out.println(clon.poll());
            System.out.println(clon.poll());
            System.out.println(clon.poll());
            System.out.println(clon.poll());
            System.out.println(clon.poll());
            System.out.println(clon.poll());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
