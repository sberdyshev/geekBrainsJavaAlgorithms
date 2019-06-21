package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author sberdyshev
 */
public class ArrayHandlerSortPerformaceTest {
    private static final int ARRAY_SIZE = 10000;
    private static final int MAX_ARRAY_VALUE = 100;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;
    private static ArrayHandler<Integer> bubbleTestArray;
    private static ArrayHandler<Integer> selectTestArray;
    private static ArrayHandler<Integer> insertTestArray;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeAll
    public static void setUpTest() {
        ArrayHandler<Integer> genArray = new ArrayHandler<>(Integer.class, generateArray());
        bubbleTestArray = new ArrayHandler<>(Integer.class, genArray.getArray());
        selectTestArray = new ArrayHandler<>(Integer.class, genArray.getArray());
        insertTestArray = new ArrayHandler<>(Integer.class, genArray.getArray());
    }

    private static Integer[] generateArray() {
        Integer[] array = new Integer[ARRAY_SIZE];
        Random random = new Random(MAX_ARRAY_VALUE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    @AfterEach
    public void resetOutputStream() {
        outContent.reset();
    }

    @Test
    public void sortBubbleInteger() {
        bubbleTestArray.print();
        String expectedResult = outContent.toString();
        bubbleTestArray.sortInsert();
        bubbleTestArray.print();
        String actualResult = outContent.toString();
        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    public void sortSelectInteger() {
        selectTestArray.print();
        String expectedResult = outContent.toString();
        selectTestArray.sortInsert();
        selectTestArray.print();
        String actualResult = outContent.toString();
        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    public void sortInsertInteger() {
        insertTestArray.print();
        String expectedResult = outContent.toString();
        insertTestArray.sortInsert();
        insertTestArray.print();
        String actualResult = outContent.toString();
        assertNotEquals(expectedResult, actualResult);
    }
}