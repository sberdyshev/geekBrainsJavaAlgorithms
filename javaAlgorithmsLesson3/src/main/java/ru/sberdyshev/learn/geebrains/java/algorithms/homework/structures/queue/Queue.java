package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.queue;

public interface Queue<T> {
    public T read();
    public void write(T element);
    public void print();
    public boolean isEmpty();
}
