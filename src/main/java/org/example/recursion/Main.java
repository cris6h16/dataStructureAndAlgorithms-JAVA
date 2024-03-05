package org.example.recursion;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int num = 3000;
        System.out.println("Sum from 1 to " + num + " is: " + sum(num));

        Integer[] nums = {-10, 0, 10, 20, 30, 40, 50, 60, 70, 80, -11};
        System.out.println("Minimum element in the array is: " + arrMin(nums, nums.length));

        System.out.println("Sum of all elements in the array is: " + arrSum(nums, nums.length));

        Integer[] nums2 = {1, 2, 3, 4, 3, 2, 1};
//        Integer[] nums2 = {1, 3, 2, 1};
        System.out.println("Is the array a palindrome? " + arrPalindrome(nums2, nums2.length));

        Integer[] nums3 = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        System.out.println("Index of the target in the array is: " + bSearch(nums3, nums3.length, 3));
    }


    /*
    Write a recursive function that computes the sum of all numbers from 1 to n, where n is given as parameter.
     */
    // return (n == 1) ? 1 : n + sum(n - 1);
    public static int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n - 1);
    }

    /*
    Write a recursive function that finds and returns the minimum element in an array
     */
    public static <T extends Comparable<T>> T arrMin(T[] arr, int size) {
        if (size == 1) return arr[0];

        T curr = arr[size - 1];
        T min = arrMin(arr, size - 1);

        return (curr.compareTo(min) < 0) ? curr : min;
    }

    /*
    Write a recursive function that computes and returns the sum of all elements in an array,
    where the array and its size are given as parameters.
     */
    public static Integer arrSum(Integer[] arr, int size) {
        if (size == 1) return arr[0];
        return arr[size - 1] + arrSum(arr, size - 1);
    }

    /*
    Write a recursive function that determines whether an array is a palindrome,
    where the array and its size are given as parameters.
     */
    public static <T extends Comparable<T>> boolean arrPalindrome(T[] arr, int size) {

        int left = arr.length - size;
        int right = size - 1;

        if (left == right) return true;
        if (left + 1 == right) return arr[left].compareTo(arr[right]) == 0;

        return (arr[left].compareTo(arr[right]) == 0) && arrPalindrome(arr, size - 1);

    }

    /*
    Write a recursive function that searches for a target in a
    sorted array using binay search, where the array, its size and the target are given as parameters.
     */
    public static <T extends Comparable<T>> int bSearch(T[] arr, int size, T target) {
        return bSearchRecursive(arr, 0, size - 1, target);
    }

    private static <T extends Comparable<T>> int bSearchRecursive(T[] arr, int fromIdx, int toIdx, T target) {
        if (fromIdx == toIdx) return arr[fromIdx].compareTo(target) == 0 ? fromIdx : -1;

        int mid = (fromIdx + toIdx) / 2;
        if (arr[mid].compareTo(target) == 0) return mid;
        else if (arr[mid].compareTo(target) < 0) return bSearchRecursive(arr, mid + 1, toIdx, target);
        else return bSearchRecursive(arr, 0, mid - 1, target);

    }
}