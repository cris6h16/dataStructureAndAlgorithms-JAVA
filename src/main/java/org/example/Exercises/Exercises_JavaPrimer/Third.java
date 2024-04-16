package org.example.Exercises.Exercises_JavaPrimer;

public class Third {

    public static void main(String[] args) {
        System.out.println(isMultiple(10, 5)); // true
        System.out.println(isMultiple(10, 3)); // false
    }

    public static boolean isMultiple(long n, long m) {
        return (n % m == 0);
    }
}