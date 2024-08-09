package org.example.DataStructure.Stack;

public interface Stack<T> {

    void push(T val);

    T pop();

    T peek();

    int size();

    boolean isEmpty();
}
