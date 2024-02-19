package org.example.Algorithms;

import org.example.ArrayWithElements.GenerateNumbersInTxt;

import java.io.*;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        Integer[] arr = GenerateNumbersInTxt.getNumsArray();
        quickSort(arr);
        if (GenerateNumbersInTxt.isSorted(arr)) {
            System.out.println("arr is sorted, size: " + arr.length);
        }

    }

    //subroutines: divide in two parts: swap index left and right
    public static void quickSort(Integer[] arr) {
        divideByPivot(arr, 0, arr.length - 1);
    }

    /**
     * Pivot is randomly chosen
     *
     * @param arr
     * @param from start index - inclusive
     * @param to   end index - inclusive
     */
    public static void divideByPivot(Integer[] arr, int from, int to) {
        if (from >= to) return;

        // Random index swapped with 'from' index, 'from' is the pivot
        int randomIdx = (int) Math.floor(Math.random() * (to - from + 1) + from);
        swap(arr, randomIdx, from);

        int pivot = arr[from];
        int left = from + 1; // range= (from, to]
        int right = to;

        while (left <= right) {
            while (left <= to && arr[left] <= pivot) left++; // left++ until arr[left] > pivot
            while (right >= from && arr[right] > pivot) right--;// right-- until arr[right] <= pivot
            if (left < right) swap(arr, left++, right--); //if right still doesn't pass to the less than values
        }
        left--; // setting back to the last less than or equal to pivot
        right++; // setting back to the first greater than pivot

        swap(arr, from, left); // swap pivot with the last less than or equal to pivot
        left--; // structure: [less than or equals] [pivot] [greater than]

        divideByPivot(arr, from, left);// -{ pivot }, [less than or equal to pivot]
        divideByPivot(arr, right, to);// -{ pivot }, [greater than pivot]
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
