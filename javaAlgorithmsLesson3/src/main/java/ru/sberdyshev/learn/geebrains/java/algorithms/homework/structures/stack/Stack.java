package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack;

import java.util.List;

public interface Stack<T> {
    T pop();

    void push(T element);

    T peek();

    boolean isEmpty();

    List<T> getValues();

    int getSize();
}
