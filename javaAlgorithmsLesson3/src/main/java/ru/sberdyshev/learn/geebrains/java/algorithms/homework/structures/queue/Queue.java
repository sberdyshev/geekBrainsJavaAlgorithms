package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.queue;

import java.util.List;

/**
 * Queue API
 *
 * @param <T> - type of values queue can contain
 * @author sberdyshev
 */
public interface Queue<T> {
    T read();

    T browse();

    void write(T element);

    boolean isEmpty();

    List<T> getValues();

    int getSize();

    void clear();
}
