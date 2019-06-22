package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {
    private List<String> emptyList;
    private List<Integer> filledList;

    @BeforeEach
    void setUp() {
        emptyList = new LinkedList<>();
        filledList = new LinkedList<>(1, 2, 3, 4);
    }

    @Test
    void isEmptyCheckOnEmptyList() {
        boolean expectedResult = true;
        boolean actualResut = emptyList.isEmpty();
        assertEquals(expectedResult, actualResut);
    }

    @Test
    void isEmptyCheckOnFilledList() {
        boolean expectedResult = false;
        boolean actualResut = filledList.isEmpty();
        assertEquals(expectedResult, actualResut);
    }

    @Test
    void insertCheckOnEmptyList() {
        String expectedResultBefore = null;
        String actualResultBefore = emptyList.get();
        emptyList.insert("test");
        String expectedResultAfter = "test";
        String actualResultAfter = emptyList.get();
        assertEquals(expectedResultBefore, actualResultBefore);
        assertEquals(expectedResultAfter, actualResultAfter);
    }

    @Test
    void insertCheckOnFilledList() {
        Integer expectedResultBefore = 4;
        Integer actualResultBefore = filledList.get();
        filledList.insert(5);
        Integer expectedResultAfter = 5;
        Integer actualResultAfter = filledList.get();
        assertEquals(expectedResultBefore, actualResultBefore);
        assertEquals(expectedResultAfter, actualResultAfter);
    }

    @Test
    void deleteCheckOnEmptyList() {
        String expectedResultBefore = null;
        String actualResultBefore = emptyList.get();
        String expectedDeletionResult = null;
        String actualDeletionResult = emptyList.delete();
        String expectedResultAfter = null;
        String actualResultAfter = emptyList.get();
        assertEquals(expectedResultBefore, actualResultBefore);
        assertEquals(expectedDeletionResult, actualDeletionResult);
        assertEquals(expectedResultAfter, actualResultAfter);
    }

    @Test
    void deleteCheckOnFilledList() {
        Integer expectedResultBefore = 4;
        Integer actualResultBefore = filledList.get();
        Integer expectedDeletionResult = 4;
        Integer actualDeletionResult = filledList.delete();
        Integer expectedResultAfter = 3;
        Integer actualResultAfter = filledList.get();
        assertEquals(expectedResultBefore, actualResultBefore);
        assertEquals(expectedDeletionResult, actualDeletionResult);
        assertEquals(expectedResultAfter, actualResultAfter);
    }

    @Test
    void getCheckOnEmptyList() {
        String expectedResult = null;
        String actualResult = emptyList.get();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getCheckOnFilledList() {
        Integer expectedResult = 4;
        Integer actualResult = filledList.get();
        assertEquals(expectedResult, actualResult);
    }
}