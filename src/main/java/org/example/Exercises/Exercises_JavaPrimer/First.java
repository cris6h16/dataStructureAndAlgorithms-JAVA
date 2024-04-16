package org.example.Exercises.Exercises_JavaPrimer;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        inputAllBaseTypes();
    }

    public static void inputAllBaseTypes() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter a byte: ");
        byte b = sc.nextByte();
        System.out.println("\tYou typed a Byte: " + b);

        System.out.println("\nEnter a short: ");
        short s = sc.nextShort();
        System.out.println("\tYou typed a Short: " + s);

        System.out.println("\nEnter an int: ");
        int i = sc.nextInt();
        System.out.println("\tYou typed an Integer: " + i);

        System.out.println("\nEnter a long: ");
        long l = sc.nextLong();
        System.out.println("\tYou typed a Long: " + l);

        System.out.println("\nEnter a float: ");
        float f = sc.nextFloat();
        System.out.println("\tYou typed a Float: " + f);

        System.out.println("\nEnter a double: ");
        double d = sc.nextDouble();
        System.out.println("\tYou typed a Double: " + d);

        System.out.println("\nEnter a boolean: ");
        boolean bool = sc.nextBoolean();
        System.out.println("\tYou typed a Boolean: " + bool);

        System.out.println("\nEnter a char: ");
        char c = sc.next().charAt(0);
        System.out.println("\tYou typed a Char: " + c);

/*
        Enter a byte:
        -128
            You typed a Byte: -128

        Enter a short:
        9956
            You typed a Short: 9956

        Enter an int:
        10025
            You typed an Integer: 10025

        Enter a long:
        99999
            You typed a Long: 99999

        Enter a float:
        2.35
            You typed a Float: 2.35

        Enter a double:
        1.99999999
            You typed a Double: 1.99999999

        Enter a boolean:
        true
            You typed a Boolean: true

        Enter a char:
        H
            You typed a Char: H
 */

    }
}
