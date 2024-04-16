package org.example.Exercises.Exercises_JavaPrimer;

public class Fourth {
    public static void main(String[] args) {
        System.out.println(isEven(0));
        System.out.println(isEven(1));
        System.out.println(isEven(2));
        System.out.println(isEven(3));
        System.out.println(isEven(4));
        System.out.println(isEven(5));
    }

    public static boolean isEven(int i) {
        // cannot use multiple, modulus, or division
        String str = String.valueOf(i);
        boolean isEven = false;
        isEven = str.endsWith("0") ||
                 str.endsWith("2") ||
                 str.endsWith("4") ||
                 str.endsWith("6") ||
                 str.endsWith("8");

        return isEven;
    }
}
