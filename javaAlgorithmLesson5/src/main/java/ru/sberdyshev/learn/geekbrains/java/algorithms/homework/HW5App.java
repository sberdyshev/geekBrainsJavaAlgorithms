package ru.sberdyshev.learn.geekbrains.java.algorithms.homework;

import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.power.RaiseToAPower;

public class HW5App {
    public static void main(String[] args) {
        System.out.println(RaiseToAPower.process(2, 2));
        System.out.println(RaiseToAPower.process(3, 2));
        System.out.println(RaiseToAPower.process(10, 4));
        System.out.println(RaiseToAPower.process(5, 0));
        System.out.println(RaiseToAPower.process(6, 1));
        System.out.println(RaiseToAPower.process(2, -1));
        System.out.println(RaiseToAPower.process(2, -2));
    }
}
