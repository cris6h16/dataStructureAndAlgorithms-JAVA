package org.example.Exercises.Exercises_JavaPrimer;

public class Fifth {
    public static void main(String[] args) {
        System.out.println(sumAllPositiveIntLessThanOrEqualsTo(-10));
        System.out.println(sumAllPositiveIntLessThanOrEqualsTo(0));
        System.out.println(sumAllPositiveIntLessThanOrEqualsTo(4));

   /* OUTPUT:

    0
    0
    10

    */
    }

    private static int sumAllPositiveIntLessThanOrEqualsTo(int i) {
        int sum = 0;
        for (int j = 0; j < i + 1; j++) {
            sum += j;
        }
        return sum;
    }
}