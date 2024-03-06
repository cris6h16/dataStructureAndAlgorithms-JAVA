package org.example.DataStructure.Hashing;

//Generic class may not extend 'java.lang.Throwable'
//public class CollisionException<K> extends RuntimeException {
public class CollisionException extends RuntimeException {
    //    public CollisionException(int idx, Object key) {
    public CollisionException(int idx) {
        super("Array Index: " + idx + " is in use");
    }
}
