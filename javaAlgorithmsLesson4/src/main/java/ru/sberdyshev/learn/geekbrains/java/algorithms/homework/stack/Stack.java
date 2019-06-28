package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.stack;

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
