package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.iterator;

import java.util.function.Consumer;

/**
 * @param <T> - type of object
 * @author sberdyshev
 */
public interface Iterable<T> {
    Iterator<T> getIterator();

    void forEach(Consumer<? super T> action);
}
