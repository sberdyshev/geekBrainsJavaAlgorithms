package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway;

/**
 * Represents a list, that can be read and can delete elements from it's head and tail
 *
 * @param <T> - element type, that list keeps
 */
public interface ListTwoWays<T> {
    boolean isEmpty();

    void insertToHead(T element);

    void insertToTail(T element);

    T deleteFromHead();

    T deleteFromTail();

    T getFromHead();

    T getFromTail();
}
