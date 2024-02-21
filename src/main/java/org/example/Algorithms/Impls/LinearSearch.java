package org.example.Algorithms.Impls;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int toSearch;

        // Complexity: O(n^2)
        System.out.println("Nums in array");
        // n times
        for (int i = 0; i < nums.length; i++) {
            toSearch = nums[i];
            // n times
            System.out.println(linearSearch(nums, toSearch));
        }

        // Complexity: O(kn)
        System.out.println("Nums nonexistent in array");
        // k times
        for (int i = 20; i < 27; i++) {
            toSearch = i;
            // n times
            System.out.println(linearSearch(nums, toSearch));
        }

    }

    // O(n)
    TODO: IMPLEMENT FIXINETFACE ETC
    public static <T extends Comparable<T>> int linearSearch(T[] nums, T val) {
        // n times
        for (int i = 0; i < nums.length; i++) if (nums[i] == val) return i;
        return -1;
    }
}
