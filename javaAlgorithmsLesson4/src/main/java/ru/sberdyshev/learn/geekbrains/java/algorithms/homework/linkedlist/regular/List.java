package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular;

import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.iterator.Iterator;

/**
 * Represents a list
 *
 * @author sberdyshev
 */
public interface List<T> {
    boolean isEmpty();

    void insert(T element);

    void insert(T element, int index);

    T delete();

    T delete(int index);

    T get();

    T get(int index);

    int getSize();

    Iterator<T> getIterator();
}
