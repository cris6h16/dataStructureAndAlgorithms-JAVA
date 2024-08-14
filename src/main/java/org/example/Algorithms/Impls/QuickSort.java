package org.example.Algorithms.Impls;

public class QuickSort {
    public static void main(String[] args) {
        String[] alphabet = {"z", "a", "v", "m", "e", "c", "q", "p", "r", "g", "h", "n", "l", "i", "o", "d", "q", "f", "s", "t", "u", "j", "k", "w", "x", "y"};
        quickSort(alphabet, 0, alphabet.length - 1);
        for (String s : alphabet) {
            System.out.print(s + " ");
        }
        /*
            a c d e f g h i j k l m n o p q q r s t u v w x y z
         */
    }


    public static <T extends Comparable<T>> void quickSort(T[] arr, int fromIdx, int toIdx) {
        if (fromIdx > toIdx) return;
        int pivotIdx = partition(arr, fromIdx, toIdx); // [ less or equals - pivot - greater ] -> the result always regardless if arr.length is odd or even
        quickSort(arr, fromIdx, pivotIdx - 1); // pivot is already in the right place ( center )
        quickSort(arr, pivotIdx + 1, toIdx); // pivot is already in the right place ( center )
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int fromIdx, int toIdx) {
        setRandomPivotAtStart(arr, fromIdx, toIdx); // achieve average case ( O(n log n) )
        T pivot = arr[fromIdx];
        int greaterIdxInLeft = fromIdx + 1; // avoid check pivot
        int lessOrEqualsIdxInRight = toIdx;
        while (true) {
            while (greaterIdxInLeft <= toIdx && arr[greaterIdxInLeft].compareTo(pivot) <= 0) { // val in arr[] is less / equals
                greaterIdxInLeft++;
            }
            while (lessOrEqualsIdxInRight >= fromIdx && arr[lessOrEqualsIdxInRight].compareTo(pivot) > 0) { // val in arr[] is greater
                lessOrEqualsIdxInRight--;
            }
            if (greaterIdxInLeft >= lessOrEqualsIdxInRight) break;

            swap(arr, greaterIdxInLeft, lessOrEqualsIdxInRight);
        }
        // if arr has odd length the last of any side is any, if is even is the idx that comes from the right
        swap(arr, fromIdx, lessOrEqualsIdxInRight);
        return lessOrEqualsIdxInRight; // pivot idx
    }


    private static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static <T> void setRandomPivotAtStart(T[] arr, int minIdx, int maxIdx) {
        // both inclusive
        int idxRan = (minIdx) + (int) (Math.random() * (maxIdx - minIdx + 1));
        swap(arr, idxRan, minIdx);
    }


    // my first implementation
//    public static <T extends Comparable<T>> void quickSort(T[] arr,
//                                                           int idxStart,
//                                                           int idxEnd) {
//        if (idxStart < idxEnd) {
//            int lastIdxOfLessSide = partition(arr, idxStart, idxEnd);
//            //[ less ][ greater or equal ]
//            quickSort(arr, idxStart, lastIdxOfLessSide);
//            quickSort(arr, lastIdxOfLessSide + 1, idxEnd);
//        }
//
//    }
//
//    public static <T extends Comparable<T>> int partition(T[] arr,
//                                                          int idxStart,
//                                                          int idxEnd) {
//
//        setRandomPivotAtStart(arr, idxStart, idxEnd);
//        T pivot = arr[idxStart];
//        int left = idxStart - 1;
//        int right = idxEnd + 1;
//
//        while (true) {
//            do left++;
//            while (arr[left].compareTo(pivot) < 0); //arr[left] < pivot
//
//            do right--;
//            while (arr[right].compareTo(pivot) > 0);//arr[right] > pivot
//            // if left passed to greater or equal side
//            if (left >= right) return right;
//            swap(arr, left, right);
//        }
//
//    }
//

}
