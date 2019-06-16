package ru.sberdyshev.learn.geekbrains.java.algorithms.homework;

public interface ArrayHandler<T> {
    boolean add(T element);
    boolean delete(T element);
    boolean find(T element);
    void print();
}
