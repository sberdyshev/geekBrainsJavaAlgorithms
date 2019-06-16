package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.arrays;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author sberdyshev
 */
public class ArrayHandlerGeneralTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;
    private ArrayHandler<Integer> integerTestArray;
    private ArrayHandler<String> stringTestArray;
    private ArrayHandler<Double> doubleTestArray;
    private ArrayHandler<Integer> integerTestArrayForSorting;
    private ArrayHandler<Double> doubleTestArrayForSorting;

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

    @BeforeEach
    public void setUpTest() {
        integerTestArray = new ArrayHandler<>(Integer.class, 1, 2, null, 8);
        stringTestArray = new ArrayHandler<>(String.class, "Test1", "Test2");
        doubleTestArray = new ArrayHandler<>(Double.class, 2.05, 3.09, 4.15);
        integerTestArrayForSorting = new ArrayHandler<>(Integer.class, 8, 7, 3, 9, 1);
        doubleTestArrayForSorting = new ArrayHandler<>(Double.class, 3.09, 2.05, 4.15);
    }

    @AfterEach
    public void resetOutputStream() {
        outContent.reset();
    }

    @Test
    public void addStringOk() {
        String expectedResult = "-- Test1 Test2 Test3 null null --\r\n";
        stringTestArray.add("Test3");
        stringTestArray.print();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void addIntegerOverflow() {
        String expectedResult = "-- 1 2 null 8 3 4 5 6 7 null --\r\n";
        integerTestArray.add(3);
        integerTestArray.add(4);
        integerTestArray.add(5);
        integerTestArray.add(6);
        integerTestArray.add(7);
        integerTestArray.print();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void deleteIntegerNulls() {
        String expectedResult = "-- 1 2 8 --\r\n";
        integerTestArray.delete(null);
        integerTestArray.print();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void deleteDoubleNumber() {
        String expectedResult = "-- 2.05 4.15 null null --\r\n";
        doubleTestArray.delete(3.09);
        doubleTestArray.print();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void findNumber() {
        int expectedResult = 3;
        int result = integerTestArray.find(8);
        assertEquals(expectedResult, result);
    }

    @Test
    public void findNull() {
        int expectedResult = 2;
        int result = integerTestArray.find(null);
        assertEquals(expectedResult, result);
    }

    @Test
    public void sortBubbleInteger() {
        String expectedResult = "-- 1 3 7 8 9 --\r\n";
        integerTestArrayForSorting.sortBubble();
        integerTestArrayForSorting.print();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void sortBubbleDouble() {
        String expectedResult = "-- 2.05 3.09 4.15 null null --\r\n";
        doubleTestArrayForSorting.sortBubble();
        doubleTestArrayForSorting.print();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void sortSelectInteger() {
        String expectedResult = "-- 1 3 7 8 9 --\r\n";
        integerTestArrayForSorting.sortSelect();
        integerTestArrayForSorting.print();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void sortSelectDouble() {
        String expectedResult = "-- 2.05 3.09 4.15 null null --\r\n";
        doubleTestArrayForSorting.sortSelect();
        doubleTestArrayForSorting.print();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void sortInsertInteger() {
        String expectedResult = "-- 1 3 7 8 9 --\r\n";
        integerTestArrayForSorting.sortInsert();
        integerTestArrayForSorting.print();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void sortInsertDouble() {
        String expectedResult = "-- 2.05 3.09 4.15 null null --\r\n";
        doubleTestArrayForSorting.sortInsert();
        doubleTestArrayForSorting.print();
        assertEquals(expectedResult, outContent.toString());
    }
}