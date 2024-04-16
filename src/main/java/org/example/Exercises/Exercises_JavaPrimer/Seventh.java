package org.example.Exercises.Exercises_JavaPrimer;

public class Seventh {
    public static void main(String[] args) {
        System.out.println(sumOfSquaresOfAllPositiveIntLessThanOrEquals(-5));
        System.out.println(sumOfSquaresOfAllPositiveIntLessThanOrEquals(-1));
        System.out.println(sumOfSquaresOfAllPositiveIntLessThanOrEquals(0));
        System.out.println(sumOfSquaresOfAllPositiveIntLessThanOrEquals(1));
        System.out.println(sumOfSquaresOfAllPositiveIntLessThanOrEquals(2));
        System.out.println(sumOfSquaresOfAllPositiveIntLessThanOrEquals(3));
        System.out.println(sumOfSquaresOfAllPositiveIntLessThanOrEquals(4));

        /* OUTPUT:
                    0
                    0
                    0
                    1
                    5
                    14
                    30
         */
    }

    private static int sumOfSquaresOfAllPositiveIntLessThanOrEquals(int i) {
        int sum = 0;
        for (int j = 0; j < i + 1; j++) {
            sum += (j * j);
        }
        return sum;
    }
}