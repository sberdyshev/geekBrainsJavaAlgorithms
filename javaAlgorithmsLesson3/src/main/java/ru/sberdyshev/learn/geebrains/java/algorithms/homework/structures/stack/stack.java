package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack;

public interface stack<T> {
    public T pop();
    public void push(T element);
    public T peek();
    public boolean isEmpty();
    public void print();
}
