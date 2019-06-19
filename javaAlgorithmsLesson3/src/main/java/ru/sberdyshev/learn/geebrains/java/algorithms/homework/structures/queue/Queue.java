package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.queue;

public interface Queue<T> {
    T read();

    void write(T element);

    void print();

    boolean isEmpty();
}
