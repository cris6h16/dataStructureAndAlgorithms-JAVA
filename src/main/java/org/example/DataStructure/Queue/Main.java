package org.example.DataStructure.Queue;

public class Main {
    public static void main(String[] args) {

        // test
        queueCircularArray();
        queueLinkedListArray();

        // algorithms
        generateBinaryNumbersFrom1ToN();

    }

    private static  void generateBinaryNumbersFrom1ToN() {
        int n = 14;
        int[] res = generateBinaryNumbersFrom1ToN(n);
        for (int val : res) System.out.println(val);
        // 128 64 32 16 8 4 2 1
        /*
            1
            10
            11
            100
            101
            110
            111
            1000
            1001
            1010
            1011
            1100
            1101
            1110
         */
    }

    private static int[] generateBinaryNumbersFrom1ToN(int n) {
        QueueLinkedList<Integer> b = new QueueLinkedList<Integer>();
        int i = 1;
        while (i <= n) b.offer(_numToBinary(i++));

        int[] res = new int[b.size()];
        for (int j = 0; j < res.length; j++) res[j] = b.poll();

        return res;
    }

    private static Integer _numToBinary(int n) {
        QueueLinkedList<Integer> q = new QueueLinkedList<Integer>();
        int modRes;
        while (n > 0) {
            modRes = n % 2;
            q.offer(modRes);
            n /= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int val : q) sb.append(val);

        return Integer.parseInt(sb.reverse().toString());
    }

    private static void queueCircularArray() {

        Queue<Integer> queue = new QueueCircularArray<>(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        /*
            QueueCircularArray{arr=[1, 2, 3, null], size=3, headIdx=0, tailIdx=2}
         */

        queue.offer(4);
        System.out.println(queue);
        /*
            QueueCircularArray{arr=[1, 2, 3, 4], size=4, headIdx=0, tailIdx=3}
         */

        queue.offer(5);
        System.out.println(queue);
        /*
            QueueCircularArray{arr=[1, 2, 3, 4, 5, null, null, null], size=5, headIdx=0, tailIdx=4}
         */


        Queue<Integer> clon = queue.clone();
        System.out.println(clon);
        /*
            QueueCircularArray{arr=[1, 2, 3, 4, 5, null, null, null], size=5, headIdx=0, tailIdx=4}
         */


        try {
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue);
            /*
                1
                2
                3
                4
                QueueCircularArray{arr=[null, null, null, null, 5, null, null, null], size=1, headIdx=4, tailIdx=4}
             */
            System.out.println(queue.poll());
            System.out.println(queue);
            /*
                1
                2
                3
                4
                5
                QueueCircularArray{arr=[null, null, null, null, null, null, null, null], size=0, headIdx=-1, tailIdx=-1}
             */
            System.out.println(queue.poll());

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(queue);
            /*
                java.util.NoSuchElementException: Queue is empty.
                QueueCircularArray{arr=[null, null, null, null, null, null, null, null], size=0, headIdx=-1, tailIdx=-1}
             */
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
            System.out.println(clon);
            /*
                Clon:
                1
                2
                3
                4
                5
                java.util.NoSuchElementException: Queue is empty.
                QueueCircularArray{arr=[null, null, null, null, null, null, null, null], size=0, headIdx=-1, tailIdx=-1}
             */
        }

    }

    private static void queueLinkedListArray() {


        Queue<Integer> queue = new QueueLinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        /*
            QueueLinkedList{linked=[(head)1 -> 2 -> 3(tail)]
            Size: 3}
         */

        queue.offer(4);
        System.out.println(queue);
        /*
            QueueLinkedList{linked=[(head)1 -> 2 -> 3 -> 4(tail)]
            Size: 4}
         */

        queue.offer(5);
        System.out.println(queue);
        /*
            QueueLinkedList{linked=[(head)1 -> 2 -> 3 -> 4 -> 5(tail)]
            Size: 5}
         */


        Queue<Integer> clon = queue.clone();
        System.out.println(clon);
        /*
            QueueLinkedList{linked=[(head)1 -> 2 -> 3 -> 4 -> 5(tail)]
            Size: 5}
         */


        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);
            /*
                1
                2
                3
                4
                QueueLinkedList{linked=[(head)5(tail)]
                Size: 1}
             */
        System.out.println(queue.poll());
        System.out.println(queue);
            /*
                5
                QueueLinkedList{linked=[]
                Size: 0}
             */
        System.out.println(queue.poll());
            /*
                null
             */


        System.out.println("Clon: ");
        System.out.println(clon.poll());
        System.out.println(clon.poll());
        System.out.println(clon.poll());
        System.out.println(clon.poll());
        System.out.println(clon.poll());
        System.out.println(clon.poll());
        System.out.println();
            /*
        Clon:
        1
        2
        3
        4
        5
        null
                */


    }
}
