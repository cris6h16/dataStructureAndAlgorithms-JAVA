package org.example.DataStructure.Arrays;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        unidimensional(args);
        multidimensional(args);

        // Algorithms
        removeEvenIntegers();
        findMinimum();
        findSecondGreatest();
        moveAllZerosToTheEnd();
        reverseAnArray();
        findMissingNumber();
        isPalindrome();
        searchIdxValElseWhereItShouldBe(); // O(log n)
        mergeSortedArrays();

        //
        circularArrayContiguous();
    }

    public static void mergeSortedArrays(){
        Integer[] arr1 = {1, 3, 5, 7};
        Integer[] arr2 = {2, 4, 6, 8};
        Integer[] result = AlgorithmsContiguousArray.mergeSortedArrays(arr1, arr2);

        System.out.println(Arrays.toString(result));
    }

    public static void searchIdxValElseWhereItShouldBe() {
        Integer[] arr = {1, 3, 5, 7, 9, 10, 11, 13 , 15 };
        System.out.println(Arrays.toString(arr));
        System.out.printf("0: %s - 1: %s - 2: %s - 3: %s - 4: %s - 5: %s - 6: %s - 7: %s - 8: %s - 9: %s - 10: %s - 11: %s - 12: %s - 13: %s - 14: %s - 15: %s - 16: %s\n",
                AlgorithmsContiguousArray.searchIdxVal(arr, 0),
                AlgorithmsContiguousArray.searchIdxVal(arr, 1),
                AlgorithmsContiguousArray.searchIdxVal(arr, 2),
                AlgorithmsContiguousArray.searchIdxVal(arr, 3),
                AlgorithmsContiguousArray.searchIdxVal(arr, 4),
                AlgorithmsContiguousArray.searchIdxVal(arr, 5),
                AlgorithmsContiguousArray.searchIdxVal(arr, 6),
                AlgorithmsContiguousArray.searchIdxVal(arr, 7),
                AlgorithmsContiguousArray.searchIdxVal(arr, 8),
                AlgorithmsContiguousArray.searchIdxVal(arr, 9),
                AlgorithmsContiguousArray.searchIdxVal(arr, 10),
                AlgorithmsContiguousArray.searchIdxVal(arr, 11),
                AlgorithmsContiguousArray.searchIdxVal(arr, 12),
                AlgorithmsContiguousArray.searchIdxVal(arr, 13),
                AlgorithmsContiguousArray.searchIdxVal(arr, 14),
                AlgorithmsContiguousArray.searchIdxVal(arr, 15),
                AlgorithmsContiguousArray.searchIdxVal(arr, 16)
        );
        /*
            [1, 3, 5, 7, 9, 10, 11, 13, 15]
            0: 0 - 1: 0 - 2: 1 - 3: 1 - 4: 2 - 5: 2 - 6: 3 - 7: 3 - 8: 4 - 9: 4 - 10: 5 - 11: 6 - 12: 7 - 13: 7 - 14: 8 - 15: 8 - 16: 9
         */
    }

    private static void circularArrayContiguous() {
        System.out.println("Creating a Circular Array Contiguous");
        CircularArrayContiguous<Integer> obj = new CircularArrayContiguous<>(5);
        System.out.println(obj);

        appendAndPrint(obj, 1);
        prependAndPrint(obj, -10);
        appendAndPrint(obj, 2);
        appendAndPrint(obj, 3);
        appendAndPrint(obj, 4);
//        appendAndPrint(obj, 5);
//        appendAndPrint(obj, 6);
//        appendAndPrint(obj, 7);

        deleteAndPrint(obj, false);
        deleteAndPrint(obj, true);
        deleteAndPrint(obj, true);
        deleteAndPrint(obj, true);
        deleteAndPrint(obj, false);
        deleteAndPrint(obj, false);
        deleteAndPrint(obj, false);
        deleteAndPrint(obj, true);

        appendAndPrint(obj, 1);
        prependAndPrint(obj, -10);
        appendAndPrint(obj, 2);
        appendAndPrint(obj, 3);
        appendAndPrint(obj, 4);
        appendAndPrint(obj, 5);
        /*

        Creating a Circular Array Contiguous
        Internal Array: [
            null
            null
            null 	<- head 	<- tail
            null
            null
        ]
        Array to expose: [null, null, null, null, null]

        Appending(TAIL): 1
        Internal Array: [
            null
            null
            1 	<- head
            null 	<- tail
            null
        ]
        Array to expose: [1, null, null, null, null]

        Prepending(HEAD): -10
        Internal Array: [
            null
            -10 	<- head
            1
            null 	<- tail
            null
        ]
        Array to expose: [-10, 1, null, null, null]

        Appending(TAIL): 2
        Internal Array: [
            null
            -10 	<- head
            1
            2
            null 	<- tail
        ]
        Array to expose: [-10, 1, 2, null, null]

        Appending(TAIL): 3
        Internal Array: [
            null 	<- tail
            -10 	<- head
            1
            2
            3
        ]
        Array to expose: [-10, 1, 2, 3, null]

        Appending(TAIL): 4
        Internal Array: [
            4
            -10 	<- head 	<- tail
            1
            2
            3
        ]
        Array to expose: [-10, 1, 2, 3, 4]

        Removing First(HEAD):
        Internal Array: [
            4
            null 	<- tail
            1 	<- head
            2
            3
        ]
        Array to expose: [1, 2, 3, 4, null]

        Removing Last(TAIL)
        Internal Array: [
            null 	<- tail
            null
            1 	<- head
            2
            3
        ]
        Array to expose: [1, 2, 3, null, null]

        Removing Last(TAIL)
        Internal Array: [
            null
            null
            1 	<- head
            2
            null 	<- tail
        ]
        Array to expose: [1, 2, null, null, null]

        Removing Last(TAIL)
        Internal Array: [
            null
            null
            1 	<- head
            null 	<- tail
            null
        ]
        Array to expose: [1, null, null, null, null]

        Removing First(HEAD):
        Internal Array: [
            null
            null
            null
            null 	<- head 	<- tail
            null
        ]
        Array to expose: [null, null, null, null, null]

        Removing First(HEAD):
        Internal Array: [
            null
            null
            null
            null 	<- head 	<- tail
            null
        ]
        Array to expose: [null, null, null, null, null]

        Removing First(HEAD):
        Internal Array: [
            null
            null
            null
            null 	<- head 	<- tail
            null
        ]
        Array to expose: [null, null, null, null, null]

        Removing Last(TAIL)
        Internal Array: [
            null
            null
            null
            null 	<- head 	<- tail
            null
        ]
        Array to expose: [null, null, null, null, null]

        Appending(TAIL): 1
        Internal Array: [
            null
            null
            null
            1 	<- head
            null 	<- tail
        ]
        Array to expose: [1, null, null, null, null]

        Prepending(HEAD): -10
        Internal Array: [
            null
            null
            -10 	<- head
            1
            null 	<- tail
        ]
        Array to expose: [-10, 1, null, null, null]

        Appending(TAIL): 2
        Internal Array: [
            null 	<- tail
            null
            -10 	<- head
            1
            2
        ]
        Array to expose: [-10, 1, 2, null, null]

        Appending(TAIL): 3
        Internal Array: [
            3
            null 	<- tail
            -10 	<- head
            1
            2
        ]
        Array to expose: [-10, 1, 2, 3, null]

        Appending(TAIL): 4
        Internal Array: [
            3
            4
            -10 	<- head 	<- tail
            1
            2
        ]
        Array to expose: [-10, 1, 2, 3, 4]

        Appending(TAIL): 5
        Exception in thread "main" org.example.DataStructure.Arrays.ArrayIsFullException
            at org.example.DataStructure.Arrays.CircularArrayContiguous.isNotFull(CircularArrayContiguous.java:43)
            at org.example.DataStructure.Arrays.CircularArrayContiguous.append(CircularArrayContiguous.java:24)
            at org.example.DataStructure.Arrays.Main.appendAndPrint(Main.java:133)
            at org.example.DataStructure.Arrays.Main.circularArrayContiguous(Main.java:52)
            at org.example.DataStructure.Arrays.Main.main(Main.java:21)

         */
    }

    private static <T> void prependAndPrint(CircularArrayContiguous<T> obj, T val) {
        System.out.println("\nPrepending(HEAD): " + val);
        obj.prepend(val);
        System.out.println(obj);
    }

    static <T> void appendAndPrint(CircularArrayContiguous<T> arr, T val) {
        System.out.println("\nAppending(TAIL): " + val);
        arr.append(val);
        System.out.println(arr);
    }

    static void deleteAndPrint(CircularArrayContiguous<Integer> arr, boolean last) {
        String msg = last ? "Removing Last(TAIL)" : "Removing First(HEAD)" + ": ";
        System.out.println("\n" + msg);
        if (last) arr.removeLast();
        else arr.removeFirst();
        System.out.println(arr);
    }


    public static void unidimensional(String[] args) {
        int arr[] = new int[5];
        int arr2[] = {1, 2, 3, 4, 5};
        int[] array = new int[5];

        array[0] = 10;
        array[1] = 20;
        array[2] = 30;
        array[3] = 40;
        array[4] = 50;

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static void multidimensional(String[] args) {
        int[][] array = new int[2][3];
        array[0][0] = 10;
        array[0][1] = 20;
        array[0][2] = 30;
        array[1][0] = 40;
        array[1][1] = 50;
        array[1][2] = 60;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }

    public static void removeEvenIntegers() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, -9, 10};
        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, -9};
        Integer[] arr3 = {-1, 2, 3, 4, 5, 6, 7, 8};
        System.out.printf(
                "\n%s\n%s\n%s\n\n",
                Arrays.toString(AlgorithmsContiguousArray.removeEvenIntegers(arr)),
                Arrays.toString(AlgorithmsContiguousArray.removeEvenIntegers(arr2)),
                Arrays.toString(AlgorithmsContiguousArray.removeEvenIntegers(arr3))
        );
        /*
            [1, 3, 5, 7, -9]
            [1, 3, 5, 7, -9]
            [-1, 3, 5, 7]
         */
    }

    public static void findMinimum() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, -9, 10};
        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, -9};
        Integer[] arr3 = {-1, 2, 3, 4, 5, 6, 7, 8};
        System.out.printf(
                "\n%s\n%s\n%s\n\n",
                AlgorithmsContiguousArray.findMinimum(arr, 0),
                AlgorithmsContiguousArray.findMinimum(arr2, 0),
                AlgorithmsContiguousArray.findMinimum(arr3, 0)
        );
        /*
            -9
            -9
            -1
         */
    }

    public static void findSecondGreatest() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, -9, 10};
        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, -9};
        Integer[] arr3 = {-1, 2, 3, 4, 5, 6, 7, 8};
        System.out.printf(
                "\n%s\n%s\n%s\n\n",
                AlgorithmsContiguousArray.findSecondGreatest(arr),
                AlgorithmsContiguousArray.findSecondGreatest(arr2),
                AlgorithmsContiguousArray.findSecondGreatest(arr3)
        );
        /*
            8
            7
            7
         */
    }

    public static void moveAllZerosToTheEnd() {
        Integer[] arr = {0, 2, 3, 4, 5, 6, 7, 8, -9, 0};
        Integer[] arr2 = {1, 2, 3, 0, 5, 6, 7, 0, -9};
        Integer[] arr3 = {-1, 0, 3, 4, 5, 6, 7, 0};
        Integer[] arr4 = {0, 0, 0, 0, 0, 0, 0, 0};
        Integer[] arr5 = {0, 0, 0, 0, 0, 0, 0, Integer.MIN_VALUE};

        AlgorithmsContiguousArray.moveAllZerosToTheEnd(arr);
        AlgorithmsContiguousArray.moveAllZerosToTheEnd(arr2);
        AlgorithmsContiguousArray.moveAllZerosToTheEnd(arr3);
        AlgorithmsContiguousArray.moveAllZerosToTheEnd(arr4);
        AlgorithmsContiguousArray.moveAllZerosToTheEnd(arr5);
        System.out.printf(
                "\n%s\n%s\n%s\n%s\n%s\n\n",
                Arrays.toString(arr),
                Arrays.toString(arr2),
                Arrays.toString(arr3),
                Arrays.toString(arr4),
                Arrays.toString(arr5)
        );
        /*
            [-9, 2, 3, 4, 5, 6, 7, 8, 0, 0]
            [1, 2, 3, -9, 5, 6, 7, 0, 0]
            [-1, 7, 3, 4, 5, 6, 0, 0]
            [0, 0, 0, 0, 0, 0, 0, 0]
            [-2147483648, 0, 0, 0, 0, 0, 0, 0]
         */
    }

    public static void reverseAnArray() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, -9, 10};
        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, -9};
        Integer[] arr3 = {-1, 2, 3, 4, 5, 6, 7, 8};
        AlgorithmsContiguousArray.reverseAnArray(arr, 0, arr.length - 1);
        AlgorithmsContiguousArray.reverseAnArray(arr2, 0, arr2.length - 1);
        AlgorithmsContiguousArray.reverseAnArray(arr3, 0, arr3.length - 1);
        System.out.printf(
                "\n%s\n%s\n%s\n\n",
                Arrays.toString(arr),
                Arrays.toString(arr2),
                Arrays.toString(arr3)
        );
        /*
            [10, -9, 8, 7, 6, 5, 4, 3, 2, 1]
            [-9, 8, 7, 6, 5, 4, 3, 2, 1]
            [8, 7, 6, 5, 4, 3, 2, -1]
         */
    }

    public static void findMissingNumber() {
        /* Required Complexity: O(n)

        Given an array of n - 1 distinct numbers in
        the range of 1 to n, find the missing number
        in it
        */
        Integer[] arr = {2, 3, 4, 5, 6, 7, 8, 9};   // 1  is missing: [ 1 ; 9 ]
        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 8, 9};   // 7  is missing: [ 1 ; 9 ]
        Integer[] arr3 = {1, 2, 3, 4, 5, 6, 7, 9};   // 8  is missing: [ 1 ; 9 ]
        Integer[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8};   // 9 is missing:  [ 1 ; 9 ]
        System.out.printf(
                "\n%s\n%s\n%s\n%s\n\n",
                AlgorithmsContiguousArray.findMissingNumber(arr),
                AlgorithmsContiguousArray.findMissingNumber(arr2),
                AlgorithmsContiguousArray.findMissingNumber(arr3),
                AlgorithmsContiguousArray.findMissingNumber(arr4)
        );
        /*
            1
            7
            8
            9
         */
    }

    public static void isPalindrome() {
        System.out.printf(
                "\n%s\n%s\n%s\n\n",
                AlgorithmsContiguousArray.isPalindrome("madam"),
                AlgorithmsContiguousArray.isPalindrome("racecar"),
                AlgorithmsContiguousArray.isPalindrome("hello")
        );
        /*
            true
            true
            false
         */
    }
}
