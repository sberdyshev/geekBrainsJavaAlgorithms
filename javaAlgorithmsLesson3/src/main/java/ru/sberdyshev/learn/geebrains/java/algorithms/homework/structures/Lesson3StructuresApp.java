package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures;

import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.CLIController;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.StructuresAppCliController;

/**
 * @author sberdyshev
 */
public class Lesson3StructuresApp {
    public static void main(String[] args) {
        CLIController controller = new StructuresAppCliController(3);
        controller.start();
    }
}
