package ru.sberdyshev.learn.geekbrains.java.algorithms.homework;

import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.arrays.ArrayHandler;

/**
 * @author sberdyshev
 */
public class Lesson2App {
    public static void main(String[] args) {
        ArrayHandler<Integer> integerArrayHandler = new ArrayHandler<>(Integer.class, 1,2,2, null, 3);
        integerArrayHandler.print();
    }
}
