package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack;

import java.util.List;

/**
 * Stack API
 *
 * @param <T> - type of values stack can contain
 * @author sberdyshev
 */
public interface Stack<T> {
    T pop();

    void push(T element);

    T peek();

    boolean isEmpty();

    List<T> getValues();

    int getSize();

    void clear();
}
