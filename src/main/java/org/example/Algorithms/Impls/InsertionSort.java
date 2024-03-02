package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        String[] numbers = MyUtilClass.getNamesArray();
        insertionSort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(MyUtilClass.isSorted(numbers));

    }

    //
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int previousIdx;
        T current;

        for (int i = 1; i < arr.length; i++) {

            current = arr[i];

            previousIdx = i - 1;       // arr[j] > current
            while (previousIdx >= 0 && arr[previousIdx].compareTo(current) > 0) {
                arr[previousIdx + 1] = arr[previousIdx];
                previousIdx--;
            }

            arr[previousIdx + 1] = current;

        }
    }
}
