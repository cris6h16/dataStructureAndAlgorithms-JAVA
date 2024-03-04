package org.example.DataStructure.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new QueueCircularArray<>(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
