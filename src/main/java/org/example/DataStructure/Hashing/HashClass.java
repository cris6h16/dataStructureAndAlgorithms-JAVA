package org.example.DataStructure.Hashing;

import java.util.LinkedList;

public class HashClass<K extends Comparable<K>, V> {
    private LinkedList<HashElement<K, V>>[] arr;
    private final float maxLoadFactor = 0.6f;
    private int entries;

    public HashClass(int initialSize) {
        this.entries = 0;
        this.arr = (LinkedList<HashElement<K, V>>[]) new LinkedList[initialSize];
        initializeArray(arr);
    }

    public void add(K key, V value) {
        checkSize();
        int idx = getIdxFromKey(key);
        arr[idx].addLast(new HashElement<>(key, value));
        entries++;
    }

    public boolean remove(K key) {
        int idx = getIdxFromKey(key);
        for (HashElement<K, V> e : arr[idx])
            if (e.key.compareTo(key) == 0) {
                arr[idx].remove(e);
                entries--;
                return true;
            }
        return false;
    }

    public float loadFactor() {
        float lf = (float) entries / arr.length;
        lf = lf * 100;
        lf = (float) Math.round(lf) / 100;
        return lf;
    }


    private int getIdxFromKey(K key) {
        System.out.println("HasCode: " + key.hashCode() + " KEY: " + key);
        return ((key.hashCode() & 0x7FFFFFFF) % arr.length);
    }

    private void checkSize() {
        if (loadFactor() >= maxLoadFactor) resize();
    }

    private void resize() {
        LinkedList<HashElement<K, V>>[] narr = (LinkedList<HashElement<K, V>>[]) new LinkedList[arr.length * 2];
        initializeArray(narr);

        for (LinkedList<HashElement<K, V>> list : arr)
            for (HashElement<K, V> h : list) {
                int newIdx = h.key.hashCode() % narr.length;
                narr[newIdx].addLast(h);
            }
        arr = narr;
        System.out.println("Array was resized");
    }

    private void initializeArray(LinkedList<HashElement<K, V>>[] arr) {
//        We cannot initialize in ForEach because is a New Iterator<> Object
//        for (LinkedList<HashElement<K, V>> list : arr)
//            list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++)
            arr[i] = new LinkedList<>();


    }

    private class HashElement<K, V> {
        K key;
        V value;

        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
