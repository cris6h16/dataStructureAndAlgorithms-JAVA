package org.example.Algorithms.Impls;

public class LinearSearch {

    public static <T extends Comparable<T>> int linearSearch(T[] nums,
                                                             T val) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i].compareTo(val) == 0) return i; //nums[i] == val
        return -1;
    }
}
