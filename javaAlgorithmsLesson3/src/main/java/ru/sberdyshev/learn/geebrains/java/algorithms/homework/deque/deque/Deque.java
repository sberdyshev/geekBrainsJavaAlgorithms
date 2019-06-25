package ru.sberdyshev.learn.geebrains.java.algorithms.homework.deque.deque;

import java.util.List;

/**
 * @author sberdyshev
 */
public interface Deque<T> {
    T readAtHead();

    T readAtTail();

    T browseAtHead();

    T browseAtTail();

    void writeToHead(T element);

    void writeToTail(T element);

    boolean isEmpty();

    List<T> getValues();

    int getSize();

    void clear();
}
