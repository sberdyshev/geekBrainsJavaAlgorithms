package ru.sberdyshev.learn.geebrains.java.algorithms.homework.flipper;

import java.util.Scanner;

public class Lesson3FlipperApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        do {
            String line = scanner.nextLine();
            if (line.equals("/exit")) {
                isExit = true;
                continue;
            }
            char[] inputLineAsArray = line.toCharArray();
            char[] reversedLineAsArray = new char[inputLineAsArray.length];
            for (int i = 0; i < inputLineAsArray.length; i++) {
                reversedLineAsArray[i] = inputLineAsArray[inputLineAsArray.length - 1 - i];
            }
            String reversedLine = new String(reversedLineAsArray);
            System.out.println("Reversed line: " + reversedLine);
        } while (!isExit);
    }
}
