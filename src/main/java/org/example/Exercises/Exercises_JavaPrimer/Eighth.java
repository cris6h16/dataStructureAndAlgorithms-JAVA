package org.example.Exercises.Exercises_JavaPrimer;

import java.util.Arrays;

public class Eighth {
    public static void main(String[] args) {
        System.out.println(countVowels("Hello I'm Cristian & I like Java"));
        System.out.println(countVowels("I study around 8 hours per day"));
        System.out.println(countVowels("I'm also studying a formal career of Software"));
        System.out.println(countVowels("I like English"));

        /* OUTPUT:
                        11
                        9
                        15
                        5
         */
    }

    private static long countVowels(String str) {
        return str.toLowerCase().chars() // .chars() --> IntStream
                .filter(val ->
                        val == 'a' ||
                        val == 'e' ||
                        val == 'i' ||
                        val == 'o' ||
                        val == 'u')
                .count();
    }


}