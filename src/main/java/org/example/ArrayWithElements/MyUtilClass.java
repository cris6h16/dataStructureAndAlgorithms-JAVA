package org.example.ArrayWithElements;

public class MyUtilClass {


    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0) {//arr[i - 1] > arr[i]
                System.out.println("Previous: " + arr[i - 1] + " Current: " + arr[i]+" index: "+i);
                return false;
            }

        return true;
    }

    public static String[] getAlphabetArray() {
        String[] alphabet = new String[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf((char) (((int) 'a') + i));
        }
        return alphabet;
    }

    public static Integer[] generateSortedNUms(int includedFrom, int includedTo) {
        int size = includedTo - includedFrom + 1;
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = includedFrom + i;
        }
        return arr;
    }
}
