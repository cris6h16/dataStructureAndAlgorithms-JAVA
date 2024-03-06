package org.example.DataStructure.Hashing;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
//        testSimpleHash();
//        testHashClass();
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("aa", 1);
        ht.put("bb", 2);
        ht.put("cc", 3);
        ht.put("dd", 4);
        ht.put("ee", 5);
        ht.put("AA", 6);
        ht.put("BB", 7);
        ht.put("CC", 8);
        ht.put("DD", 9);
        ht.put("EE", 10);

        ht.put("hello", 1);
        ht.put("word", 2);
        ht.put("bro", 3);
        ht.put("I", 4);
        ht.put("am", 5);
        ht.put("english", 6);
        ht.put("learner", 7);
    }

    public static void testMyHashClass() {
        HashClass<String, Integer> hc = new HashClass<>(5);
        hc.add("aa", 1);
        hc.add("bb", 2);
        hc.add("cc", 3);
        hc.add("dd", 4);
        hc.add("ee", 5);
        hc.add("AA", 6);
        hc.add("BB", 7);
        hc.add("CC", 8);
        hc.add("DD", 9);
        hc.add("EE", 10);

        hc.add("hello", 1);
        hc.add("word", 2);
        hc.add("bro", 3);
        hc.add("I", 4);
        hc.add("am", 5);
        hc.add("english", 6);
        hc.add("learner", 7);

    }

    public static void testMySimpleHash() {
        SimpleHashArray<String, Integer> array = new SimpleHashArray<>(11); // size like a prime number
        array.add("aa", 1);
        array.add("bb", 2);
        array.add("cc", 3);
        array.add("dd", 4);
        array.add("ee", 5);
        array.add("AA", 6);
        array.add("BB", 7);
        array.add("CC", 8);
        array.add("DD", 9);
        array.add("EE", 10);
    }
}
