package ru.sberdyshev.learn.geekbrains.java.algorithms.homework;

import lombok.Getter;

public class ArrayHandlerImpl<T> implements ArrayHandler{
    @Getter
    private T[] array;


    @Override
    public boolean add(Object element) {
        return false;
    }

    @Override
    public boolean delete(Object element) {
        return false;
    }

    @Override
    public boolean find(Object element) {
        return false;
    }

    @Override
    public void print() {
    }
}
