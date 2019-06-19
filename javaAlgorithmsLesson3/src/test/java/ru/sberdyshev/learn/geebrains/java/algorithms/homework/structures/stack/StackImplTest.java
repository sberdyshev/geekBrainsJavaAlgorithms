package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author sberdyshev
 */
class StackImplTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;
    private static Stack<String> stackString;
    private static Stack<Integer> stackInteger;
    private static Stack<String> stackStringEmpty;
    private static Stack<Integer> stackIntegerEmpty;

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
        stackString = new StackImpl<>(String.class, "String stack", "Test1", "Test2", "Test456");
        stackStringEmpty = new StackImpl<>(String.class, "String empty stack");
        stackInteger = new StackImpl<>(Integer.class, "Integer stack", 10, 59, 1111, 123);
        stackIntegerEmpty = new StackImpl<>(Integer.class, "Integer empty stack");
    }

    @AfterEach
    public void resetOutputStream() {
        outContent.reset();
    }

    @Test
    void popFromStringStack() {
        String expectedValueFirstIteration = "Test456";
        Integer expectedStackSizeFirstIteration = 2;
        String expectedValueSecondIteration = "Test2";
        Integer expectedStackSizeSecondIteration = 1;
        String actualValueFirstIteration = stackString.pop();
        Integer actualStackSizeFirstIteration = stackString.getSize();
        String actualValueSecondIteration = stackString.pop();
        Integer actualStackSizeSecondIteration = stackString.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedStackSizeFirstIteration, actualStackSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedStackSizeSecondIteration, actualStackSizeSecondIteration);
    }

    @Test
    void popFromEmptyStringStack() {
        String expectedValueFirstIteration = null;
        Integer expectedStackSizeFirstIteration = 0;
        String expectedValueSecondIteration = null;
        Integer expectedStackSizeSecondIteration = 0;
        String actualValueFirstIteration = stackStringEmpty.pop();
        Integer actualStackSizeFirstIteration = stackStringEmpty.getSize();
        String actualValueSecondIteration = stackStringEmpty.pop();
        Integer actualStackSizeSecondIteration = stackStringEmpty.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedStackSizeFirstIteration, actualStackSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedStackSizeSecondIteration, actualStackSizeSecondIteration);
    }

    @Test
    void popFromIntegerStack() {
        Integer expectedValueFirstIteration = 123;
        Integer expectedStackSizeFirstIteration = 3;
        Integer expectedValueSecondIteration = 1111;
        Integer expectedStackSizeSecondIteration = 2;
        Integer actualValueFirstIteration = stackInteger.pop();
        Integer actualStackSizeFirstIteration = stackInteger.getSize();
        Integer actualValueSecondIteration = stackInteger.pop();
        Integer actualStackSizeSecondIteration = stackInteger.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedStackSizeFirstIteration, actualStackSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedStackSizeSecondIteration, actualStackSizeSecondIteration);
    }

    @Test
    void popFromEmptyIntegerStack() {
        Integer expectedValueFirstIteration = null;
        Integer expectedStackSizeFirstIteration = 0;
        Integer expectedValueSecondIteration = null;
        Integer expectedStackSizeSecondIteration = 0;
        Integer actualValueFirstIteration = stackIntegerEmpty.pop();
        Integer actualStackSizeFirstIteration = stackIntegerEmpty.getSize();
        Integer actualValueSecondIteration = stackIntegerEmpty.pop();
        Integer actualStackSizeSecondIteration = stackIntegerEmpty.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedStackSizeFirstIteration, actualStackSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedStackSizeSecondIteration, actualStackSizeSecondIteration);
    }

    @Test
    void pushToStringStack() {
        String valueToPush = "new value";
        String expectedValueBeforeIteration = "Test456";
        Integer expectedStackSizeBeforeIteration = 3;
        String expectedValueAfterIteration = "new value";
        Integer expectedStackSizeAfterIteration = 4;
        String actualValueBeforeIteration = stackString.peek();
        Integer actualStackSizeBeforeIteration = stackString.getSize();
        stackString.push(valueToPush);
        String actualValueAfterIteration = stackString.peek();
        Integer actualStackSizeAfterIteration = stackString.getSize();
        assertEquals(expectedValueBeforeIteration, actualValueBeforeIteration);
        assertEquals(expectedStackSizeBeforeIteration, actualStackSizeBeforeIteration);
        assertEquals(expectedValueAfterIteration, actualValueAfterIteration);
        assertEquals(expectedStackSizeAfterIteration, actualStackSizeAfterIteration);
    }

    @Test
    void pushToEmptyStringStack() {
        String valueToPush = "new value";
        String expectedValueBeforeIteration = null;
        Integer expectedStackSizeBeforeIteration = 0;
        String expectedValueAfterIteration = "new value";
        Integer expectedStackSizeAfterIteration = 1;
        String actualValueBeforeIteration = stackStringEmpty.peek();
        Integer actualStackSizeBeforeIteration = stackStringEmpty.getSize();
        stackStringEmpty.push(valueToPush);
        String actualValueAfterIteration = stackStringEmpty.peek();
        Integer actualStackSizeAfterIteration = stackStringEmpty.getSize();
        assertEquals(expectedValueBeforeIteration, actualValueBeforeIteration);
        assertEquals(expectedStackSizeBeforeIteration, actualStackSizeBeforeIteration);
        assertEquals(expectedValueAfterIteration, actualValueAfterIteration);
        assertEquals(expectedStackSizeAfterIteration, actualStackSizeAfterIteration);
    }

    @Test
    void pushToIntegerStack() {
        Integer valueToPush = 999;
        Integer expectedValueBeforeIteration = 123;
        Integer expectedStackSizeBeforeIteration = 4;
        Integer expectedValueAfterIteration = 999;
        Integer expectedStackSizeAfterIteration = 5;
        Integer actualValueBeforeIteration = stackInteger.peek();
        Integer actualStackSizeBeforeIteration = stackInteger.getSize();
        stackInteger.push(valueToPush);
        Integer actualValueAfterIteration = stackInteger.peek();
        Integer actualStackSizeAfterIteration = stackInteger.getSize();
        assertEquals(expectedValueBeforeIteration, actualValueBeforeIteration);
        assertEquals(expectedStackSizeBeforeIteration, actualStackSizeBeforeIteration);
        assertEquals(expectedValueAfterIteration, actualValueAfterIteration);
        assertEquals(expectedStackSizeAfterIteration, actualStackSizeAfterIteration);
    }

    @Test
    void pushToEmptyIntegerStack() {
        Integer valueToPush = 999;
        Integer expectedValueBeforeIteration = null;
        Integer expectedStackSizeBeforeIteration = 0;
        Integer expectedValueAfterIteration = 999;
        Integer expectedStackSizeAfterIteration = 1;
        Integer actualValueBeforeIteration = stackIntegerEmpty.peek();
        Integer actualStackSizeBeforeIteration = stackIntegerEmpty.getSize();
        stackIntegerEmpty.push(valueToPush);
        Integer actualValueAfterIteration = stackIntegerEmpty.peek();
        Integer actualStackSizeAfterIteration = stackIntegerEmpty.getSize();
        assertEquals(expectedValueBeforeIteration, actualValueBeforeIteration);
        assertEquals(expectedStackSizeBeforeIteration, actualStackSizeBeforeIteration);
        assertEquals(expectedValueAfterIteration, actualValueAfterIteration);
        assertEquals(expectedStackSizeAfterIteration, actualStackSizeAfterIteration);
    }


    @Test
    void peekFromStringStack() {
        String expectedValueFirstIteration = "Test456";
        Integer expectedStackSizeFirstIteration = 3;
        String expectedValueSecondIteration = "Test456";
        Integer expectedStackSizeSecondIteration = 3;
        String actualValueFirstIteration = stackString.peek();
        Integer actualStackSizeFirstIteration = stackString.getSize();
        String actualValueSecondIteration = stackString.peek();
        Integer actualStackSizeSecondIteration = stackString.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedStackSizeFirstIteration, actualStackSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedStackSizeSecondIteration, actualStackSizeSecondIteration);
    }

    @Test
    void peekFromEmptyStringStack() {
        String expectedValueFirstIteration = null;
        Integer expectedStackSizeFirstIteration = 0;
        String expectedValueSecondIteration = null;
        Integer expectedStackSizeSecondIteration = 0;
        String actualValueFirstIteration = stackStringEmpty.peek();
        Integer actualStackSizeFirstIteration = stackStringEmpty.getSize();
        String actualValueSecondIteration = stackStringEmpty.peek();
        Integer actualStackSizeSecondIteration = stackStringEmpty.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedStackSizeFirstIteration, actualStackSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedStackSizeSecondIteration, actualStackSizeSecondIteration);
    }

    @Test
    void peekFromIntegerStack() {
        Integer expectedValueFirstIteration = 123;
        Integer expectedStackSizeFirstIteration = 4;
        Integer expectedValueSecondIteration = 123;
        Integer expectedStackSizeSecondIteration = 4;
        Integer actualValueFirstIteration = stackInteger.peek();
        Integer actualStackSizeFirstIteration = stackInteger.getSize();
        Integer actualValueSecondIteration = stackInteger.peek();
        Integer actualStackSizeSecondIteration = stackInteger.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedStackSizeFirstIteration, actualStackSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedStackSizeSecondIteration, actualStackSizeSecondIteration);
    }

    @Test
    void peekFromEmptyIntegerStack() {
        Integer expectedValueFirstIteration = null;
        Integer expectedStackSizeFirstIteration = 0;
        Integer expectedValueSecondIteration = null;
        Integer expectedStackSizeSecondIteration = 0;
        Integer actualValueFirstIteration = stackIntegerEmpty.peek();
        Integer actualStackSizeFirstIteration = stackIntegerEmpty.getSize();
        Integer actualValueSecondIteration = stackIntegerEmpty.peek();
        Integer actualStackSizeSecondIteration = stackIntegerEmpty.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedStackSizeFirstIteration, actualStackSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedStackSizeSecondIteration, actualStackSizeSecondIteration);
    }

    @Test
    void isEmptyStringStack() {
        boolean expectedValue = false;
        boolean actualValue = stackString.isEmpty();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isEmptyStringEmptyStack() {
        boolean expectedValue = true;
        boolean actualValue = stackStringEmpty.isEmpty();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isEmptyIntegerStack() {
        boolean expectedValue = false;
        boolean actualValue = stackInteger.isEmpty();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isEmptyIntegerEmptyStack() {
        boolean expectedValue = true;
        boolean actualValue = stackIntegerEmpty.isEmpty();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getValuesStringStack() {
        String[] expectedResults = {"Test1", "Test2", "Test456"};
        List<String> actualResults = stackString.getValues();
        assertEquals(expectedResults.length, actualResults.size());
        for (int i = 0; i < expectedResults.length; i++) {
            assertEquals(expectedResults[i], actualResults.get(i));
        }
    }

    @Test
    void getValuesStringEmptyStack() {
        String[] expectedResults = {};
        List<String> actualResults = stackStringEmpty.getValues();
        assertEquals(expectedResults.length, actualResults.size());
    }

    @Test
    void getValuesIntegerStack() {
        Integer[] expectedResults = {10, 59, 1111, 123};
        List<Integer> actualResults = stackInteger.getValues();
        assertEquals(expectedResults.length, actualResults.size());
        for (int i = 0; i < expectedResults.length; i++) {
            assertEquals(expectedResults[i], actualResults.get(i));
        }
    }

    @Test
    void getValuesIntegerEmptyStack() {
        Integer[] expectedResults = {};
        List<Integer> actualResults = stackIntegerEmpty.getValues();
        assertEquals(expectedResults.length, actualResults.size());
    }

    @Test
    void getSizeStringStack() {
        Integer expectedValue = 3;
        Integer actualValue = stackString.getSize();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getSizeStringEmptyStack() {
        Integer expectedValue = 0;
        Integer actualValue = stackStringEmpty.getSize();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getSizeIntegerStack() {
        Integer expectedValue = 4;
        Integer actualValue = stackInteger.getSize();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getSizeIntegerEmptyStack() {
        Integer expectedValue = 0;
        Integer actualValue = stackIntegerEmpty.getSize();
        assertEquals(expectedValue, actualValue);
    }
}