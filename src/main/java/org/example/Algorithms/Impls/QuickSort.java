package org.example.Algorithms.Impls;

public class QuickSort {
    /**
     *
     * @param arr
     * @param idxStart inclusive
     * @param idxEnd inclusive
     * @param <T>
     */
    public static <T extends Comparable<T>> void quickSort(T[] arr,
                                                           int idxStart,
                                                           int idxEnd) {
        if (idxStart < idxEnd) {
            int lastIdxOfLessSide = partition(arr, idxStart, idxEnd);
            //[ less ][ greater or equal ]
            quickSort(arr, idxStart, lastIdxOfLessSide);
            quickSort(arr, lastIdxOfLessSide + 1, idxEnd);
        }

    }

    public static <T extends Comparable<T>> int partition(T[] arr,
                                                          int idxStart,
                                                          int idxEnd) {

        setRandomPivotAtStart(arr, idxStart, idxEnd);
        T pivot = arr[idxStart];
        int left = idxStart - 1;
        int right = idxEnd + 1;

        while (true) {
            do left++;
            while (arr[left].compareTo(pivot) < 0); //arr[left] < pivot

            do right--;
            while (arr[right].compareTo(pivot) > 0);//arr[right] > pivot
            // if left passed to greater or equal side
            if (left >= right) return right;
            swap(arr, left, right);
        }

    }

    private static <T> void setRandomPivotAtStart(T[] arr,
                                                  int min,
                                                  int max) {
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
