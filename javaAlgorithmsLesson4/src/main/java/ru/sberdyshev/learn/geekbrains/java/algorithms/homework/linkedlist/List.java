package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist;

/**
 * Represents a list
 * @author sberdyshev
 */
public interface List<T> {
    boolean isEmpty();
    void insert(T element);
    T delete();
    T get();
}
