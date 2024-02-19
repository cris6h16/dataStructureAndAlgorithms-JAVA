package org.example.Algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickMerge {
    public static void main(String[] args) {
        Integer[] arr = {999, -9, 2, -8, -4, 7, 6, 3, 5, 4, 0, -1, 8, -3, 9, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

    //subroutines: divide in two parts: swap index left and right
    public static void quickSort(Integer[] arr) {
        divideByPivot(arr, 0, arr.length - 1);
    }

    /**
     * Pivot is the element in 'from' index in the array
     *
     * @param arr
     * @param from start index - inclusive
     * @param to   end index - inclusive
     */
    public static void divideByPivot(Integer[] arr, int from, int to) {
        if (from >= to) return;

        int pivot = arr[from];
        int left = from + 1; // range= (from, to]
        int right = to;

        while (left < right) {
            while (left <= to && arr[left] <= pivot) left++;
            while (right >= from && arr[right] > pivot) right--;

            if (left > right) break;
            swap(arr, left++, right--);
        }
        arr[from] = arr[--left];
        arr[left] = pivot;

        divideByPivot(arr, from, left);//
        divideByPivot(arr, ++right, arr.length - 1);//
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
