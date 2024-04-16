package org.example.Exercises.Exercises_JavaPrimer;

public class Sixth {
    public static void main(String[] args) {
        System.out.println(sumAllOddPositiveIntLessThanOrEquals(-15));
        System.out.println(sumAllOddPositiveIntLessThanOrEquals(0));
        System.out.println(sumAllOddPositiveIntLessThanOrEquals(1));
        System.out.println(sumAllOddPositiveIntLessThanOrEquals(2));
        System.out.println(sumAllOddPositiveIntLessThanOrEquals(3));
        System.out.println(sumAllOddPositiveIntLessThanOrEquals(15));

        /* OUTPUT:
            0
            0
            1
            1
            4
            64
         */
    }

    private static int sumAllOddPositiveIntLessThanOrEquals(int i) {
        int sum = 0;
        for (int j = 0; j < i + 1; j++) {
            if (j % 2 != 0) sum += j;
        }
        return sum;
    }

}