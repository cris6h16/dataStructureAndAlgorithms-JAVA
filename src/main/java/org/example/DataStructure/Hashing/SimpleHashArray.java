package org.example.DataStructure.Hashing;

public class SimpleHashArray<K, V> {
    V[] arr;
    int entries = 0;

    public SimpleHashArray(int size) {
        this.arr = (V[]) new Object[size];
    }

    public void add(K key, V obj) {
        int idx = key.hashCode() % arr.length;

        System.out.println("KEY: " + key + " IDX: " + idx + " LoadFactor: " + loadFactor());
        if (arr[idx] != null) throw new CollisionException(idx);


        arr[idx] = obj;
        entries++;
    }

    public float loadFactor() {
        float lf = (float) entries / arr.length;
        lf = lf * 100;
        lf = (float) Math.round(lf) / 100;
        return lf;
    }
}
