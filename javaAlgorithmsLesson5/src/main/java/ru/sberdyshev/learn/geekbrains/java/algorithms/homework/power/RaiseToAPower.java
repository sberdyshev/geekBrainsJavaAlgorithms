package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.power;

public class RaiseToAPower {
    public static double process(int number, int power) {
        double result = 1;
        if (power >= 1) {
            result = process(number, power - 1);
            return number * result;
        } else if (power <= -1) {
            result = process(number, power + 1);
            return result / number;
        }
        return result;
    }
}
