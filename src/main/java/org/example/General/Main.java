package org.example.General;

public class Main {

    public static void main(String[] args) {

        // enum
        Impls.Day day = Impls.Day.MONDAY;
        System.out.println(day);

        // record
        Impls.Person person = new Impls.Person("John", 25);
        System.out.println(person.name() + " " + person.age()); // only getters are available

        // Special Chars with escape sequences
        System.out.println("Next\nLine");
        System.out.println("Tab\t\tSpace");
        System.out.println("Backspace\b");
        System.out.println("Carriage\rReturn");
        System.out.println("Form\fFeed");
        System.out.println("Single\'Quote");
        System.out.println("Double\"Quote");
        System.out.println("Back\\Slash");
        System.out.println("Unicode\u2122");

        //
        int[] primes = new int[5]; // { 0, 0, 0, 0, 0 }
        double[] doubles = new double[5]; // { 0.0, 0.0, 0.0, 0.0, 0.0 }
        boolean[] booleans = new boolean[5]; // { false, false, false, false, false }
        char[] chars = new char[5]; // { '\u0000', '\u0000', '\u0000', '\u0000', '\u0000' }
        String[] strings = new String[5]; // { null, null, null, null, null }

        //
        int a = 1;
        int b = a++; // b = 1 then a = 2
        int c = ++a; // a = 3 then c = 3
        int d = a--; // d = 3 then a = 2
        int e = 9 + --a; // a = 1 then e = 10

        //bitwise ; int 32 bits == 4 bytes -> Signed
        int x = 5;  // 0000 0000 0000 0000 0000 0000 0000 0101 ->  5
        int ba = ~x;// 1111 1111 1111 1111 1111 1111 1111 1010 -> -6
        int bb = -5 & 0x7fffffff; // 0111 1111 1111 1111 1111 1111 1111 1011 -> 2147483643
        int bc = 1 | -2 ; // 1111 1111 1111 1111 1111 1111 1111 1111 -> -1
        int bd = 5 ^ -1 ; // 1111 1111 1111 1111 1111 1111 1111 1010 -> -6
        int be = 1 << 2; // 0000 0000 0000 0000 0000 0000 0000 0100 -> 4
        int bf = -1 >> 1; // 0000 0000 0000 0000 0000 0000 0000 0001 -> 1 // dont touch the sign bit
        int bg = Integer.MIN_VALUE >>> 1; // 0111 1111 1111 1111 1111 1111 1111 1111 -> 2147483647 // shift right with zero fill | treat as unsigned


    }

    /*
    MONDAY
    Next
    Line
    Tab		Space
    Backspac
    Return
    FormFeed
    Single'Quote
    Double"Quote
    Back\Slash
    Unicode™
     */

}
