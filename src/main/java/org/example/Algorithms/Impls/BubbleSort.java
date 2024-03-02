package org.example.Algorithms.Impls;

import org.example.ArrayWithElements.MyUtilClass;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
//        String[] names = MyUtilClass.getNamesArray();
//        bubbleSort(names);
//        System.out.println(MyUtilClass.isSorted(names));
        Integer[] numbers = {-1, -2, -0, 12};
        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }


    //: iterate array( get the greater compare by each ) , iterations will be reduced in 1
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

        int i, j;
        int toIdx = arr.length - 1;

        for (i = 0; i < toIdx; i++)
            for (j = 0; j < toIdx - i; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0)// arr[j] > arr[j+1]
                    swap(arr, j, j + 1);
    }

    private static <T extends Comparable<T>> void swap(T[] arr,
                                                       int a,
                                                       int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
