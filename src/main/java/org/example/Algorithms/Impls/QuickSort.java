package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

import java.util.Arrays;

public class QuickSort {
    private static int c = 0;

    public static void main(String[] args) {
        // %s -> types
        String beforeMsg = "\nQuick Sort using %s \nBefore: array ";
        // %s, %s -> partitions :length
        String successful = "was sorted, partition times: %s arr length: %d";
        String alreadySorted = "Array already sorted";
        String notSorted = "not sorted";
        String fail = "wasn't sorted";

        //------------ Nums: aprox 1_000_000 -------------\\
        c = 0;
        Integer[] nums = MyUtilClass.getNumsArray();

        System.out.println(
                String.format(beforeMsg, "Integer") +
                        (MyUtilClass.isSorted(nums) ? alreadySorted : notSorted));

        quickSort(nums, 0, nums.length - 1);

        System.out.println("After: " +
                (MyUtilClass.isSorted(nums) ?
                        String.format(successful, c, nums.length) : fail));


        //-----------------------------------------------\\

        //----------- Strings: aprox 25_000 -------------\\
        c = 0;
        String[] arr = MyUtilClass.getNamesArray();

        System.out.println(
                String.format(beforeMsg, "String") +
                        (MyUtilClass.isSorted(arr) ? alreadySorted : notSorted));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After: " +
                (MyUtilClass.isSorted(arr) ?
                        String.format(successful, c, arr.length) : fail));
        //-----------------------------------------------\\

        /*
        output

        Quick Sort using Integer
        Before: array not sorted
        After: was sorted, partition times: 99999 arr length: 100000

        Quick Sort using String
        Before: array not sorted
        After: was sorted, partition times: 25441 arr length: 25442

        Process finished with exit code 0

         */
    }

    // idxStart, idxEnd; both inclusive
    public static <T extends Comparable<T>> void quickSort(T[] arr, int idxStart, int idxEnd) {

        if (idxStart < idxEnd) {
            int lastIdxOfLessSide = partition(arr, idxStart, idxEnd);//[ less ][ greater or equal ]

            quickSort(arr, idxStart, lastIdxOfLessSide);
            quickSort(arr, lastIdxOfLessSide + 1, idxEnd);
        }

    }

    public static <T extends Comparable<T>> int partition(T[] arr, int idxStart, int idxEnd) {

        c++;
        setRandomStartPivot(arr, idxStart, idxEnd);// random "pivot"
        T pivot = arr[idxStart];
        int left = idxStart - 1;
        int right = idxEnd + 1;

        while (true) {
            do left++;
            while (arr[left].compareTo(pivot) < 0); //arr[left] < pivot

            do right--;
            while (arr[right].compareTo(pivot) > 0);//arr[right] > pivot

            if (left >= right) return right;// if left passed to greater or equal side
            swap(arr, left, right);
        }

    }

    private static <T> void setRandomStartPivot(T[] arr, int min, int max) {
        // both inclusive
        int idxRan = (min) + (int) (Math.random() * (max - min + 1));
        swap(arr, idxRan, min);
    }

    private static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
