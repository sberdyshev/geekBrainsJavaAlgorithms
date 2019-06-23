package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.iterator;

/**
 * @author sberdyshev
 * @param <T> - type of object
 */
public interface Iterator<T> {
    void reset();

    boolean atEnd();

    void next();

    T getCurrent();

    T deleteCurrent();
}
