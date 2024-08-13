package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        String[] names = {"a", "y", "c", "v", "m", "l"};
        Integer[] numbers = {-10, -20, 50, 10, 0, 1};
        bubbleSort(names);
        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(names));
        /*
            iterations: 21
            iterations: 21
            [-20, -10, 0, 1, 10, 50]
            [  a,   c, l, m,  v, y ]
         */
    }


    //: iterate array from left to right, inner loop from left to right - i - 1

    /* Time Complexity:
     BEST:  O(n):       when array is already sorted
     WORST: O(n^2):     when array is sorted in reverse order
     AVERAGE: O(n^2):   when array is randomly sorted
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean isAlreadySorted = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    isAlreadySorted = false;
                }
            }
            if (isAlreadySorted) break;
        }
    }

    private static <T extends Comparable<T>> void swap(T[] arr,
                                                       int a,
                                                       int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
