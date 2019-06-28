package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTwoWayTest {
    private ListTwoWays<Integer> emptyList;
    private ListTwoWays<Integer> filledList;

    @BeforeEach
    void setUp() {
        emptyList = new LinkedListTwoWay<>();
        filledList = new LinkedListTwoWay<>(1, 2, 3, 4);
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
    void insertToHeadCheckOnEmptyList() {
        Integer expectedResultFromHeadBefore = null;
        Integer expectedResultFromTailBefore = null;
        Integer actualResultFromHeadBefore = emptyList.getFromHead();
        Integer actualResultFromTailBefore = emptyList.getFromTail();
        emptyList.insertToHead(1);
        Integer expectedResultFromHeadAfter = 1;
        Integer expectedResultFromTailAfter = 1;
        Integer actualResultFromHeadAfter = emptyList.getFromHead();
        Integer actualResultFromTailAfter = emptyList.getFromTail();
        assertEquals(expectedResultFromHeadBefore, actualResultFromHeadBefore);
        assertEquals(expectedResultFromTailBefore, actualResultFromTailBefore);
        assertEquals(expectedResultFromHeadAfter, actualResultFromHeadAfter);
        assertEquals(expectedResultFromTailAfter, actualResultFromTailAfter);
    }

    @Test
    void insertToTailCheckOnEmptyList() {
        Integer expectedResultFromHeadBefore = null;
        Integer expectedResultFromTailBefore = null;
        Integer actualResultFromHeadBefore = emptyList.getFromHead();
        Integer actualResultFromTailBefore = emptyList.getFromTail();
        emptyList.insertToTail(1);
        Integer expectedResultFromHeadAfter = 1;
        Integer expectedResultFromTailAfter = 1;
        Integer actualResultFromHeadAfter = emptyList.getFromHead();
        Integer actualResultFromTailAfter = emptyList.getFromTail();
        assertEquals(expectedResultFromHeadBefore, actualResultFromHeadBefore);
        assertEquals(expectedResultFromTailBefore, actualResultFromTailBefore);
        assertEquals(expectedResultFromHeadAfter, actualResultFromHeadAfter);
        assertEquals(expectedResultFromTailAfter, actualResultFromTailAfter);
    }

    @Test
    void insertToHeadCheckOnFilledList() {
        Integer expectedResultFromHeadBefore = 4;
        Integer expectedResultFromTailBefore = 1;
        Integer actualResultFromHeadBefore = filledList.getFromHead();
        Integer actualResultFromTailBefore = filledList.getFromTail();
        filledList.insertToHead(5);
        Integer expectedResultFromHeadAfter = 5;
        Integer expectedResultFromTailAfter = 1;
        Integer actualResultFromHeadAfter = filledList.getFromHead();
        Integer actualResultFromTailAfter = filledList.getFromTail();
        assertEquals(expectedResultFromHeadBefore, actualResultFromHeadBefore);
        assertEquals(expectedResultFromTailBefore, actualResultFromTailBefore);
        assertEquals(expectedResultFromHeadAfter, actualResultFromHeadAfter);
        assertEquals(expectedResultFromTailAfter, actualResultFromTailAfter);
    }

    @Test
    void insertToTailCheckOnFilledList() {
        Integer expectedResultFromHeadBefore = 4;
        Integer expectedResultFromTailBefore = 1;
        Integer actualResultFromHeadBefore = filledList.getFromHead();
        Integer actualResultFromTailBefore = filledList.getFromTail();
        filledList.insertToTail(0);
        Integer expectedResultFromHeadAfter = 4;
        Integer expectedResultFromTailAfter = 0;
        Integer actualResultFromHeadAfter = filledList.getFromHead();
        Integer actualResultFromTailAfter = filledList.getFromTail();
        assertEquals(expectedResultFromHeadBefore, actualResultFromHeadBefore);
        assertEquals(expectedResultFromTailBefore, actualResultFromTailBefore);
        assertEquals(expectedResultFromHeadAfter, actualResultFromHeadAfter);
        assertEquals(expectedResultFromTailAfter, actualResultFromTailAfter);
    }

    @Test
    void deleteFromHeadCheckOnEmptyList() {
        Integer expectedResultFromHeadBefore = null;
        Integer expectedResultFromTailBefore = null;
        Integer actualResultFromHeadBefore = emptyList.getFromHead();
        Integer actualResultFromTailBefore = emptyList.getFromTail();
        Integer expectedDeletionResult = null;
        Integer actualDeletionResult = emptyList.deleteFromHead();
        Integer expectedResultFromHeadAfter = null;
        Integer expectedResultFromTailAfter = null;
        Integer actualResultFromHeadAfter = emptyList.getFromHead();
        Integer actualResultFromTailAfter = emptyList.getFromTail();
        assertEquals(expectedDeletionResult, actualDeletionResult);
        assertEquals(expectedResultFromHeadBefore, actualResultFromHeadBefore);
        assertEquals(expectedResultFromTailBefore, actualResultFromTailBefore);
        assertEquals(expectedResultFromHeadAfter, actualResultFromHeadAfter);
        assertEquals(expectedResultFromTailAfter, actualResultFromTailAfter);
    }

    @Test
    void deleteFromTailCheckOnEmptyList() {
        Integer expectedResultFromHeadBefore = null;
        Integer expectedResultFromTailBefore = null;
        Integer actualResultFromHeadBefore = emptyList.getFromHead();
        Integer actualResultFromTailBefore = emptyList.getFromTail();
        Integer expectedDeletionResult = null;
        Integer actualDeletionResult = emptyList.deleteFromTail();
        Integer expectedResultFromHeadAfter = null;
        Integer expectedResultFromTailAfter = null;
        Integer actualResultFromHeadAfter = emptyList.getFromHead();
        Integer actualResultFromTailAfter = emptyList.getFromTail();
        assertEquals(expectedDeletionResult, actualDeletionResult);
        assertEquals(expectedResultFromHeadBefore, actualResultFromHeadBefore);
        assertEquals(expectedResultFromTailBefore, actualResultFromTailBefore);
        assertEquals(expectedResultFromHeadAfter, actualResultFromHeadAfter);
        assertEquals(expectedResultFromTailAfter, actualResultFromTailAfter);
    }

    @Test
    void deleteFromHeadCheckOnFilledList() {
        Integer expectedResultFromHeadBefore = 4;
        Integer expectedResultFromTailBefore = 1;
        Integer actualResultFromHeadBefore = filledList.getFromHead();
        Integer actualResultFromTailBefore = filledList.getFromTail();
        Integer expectedDeletionResult = 4;
        Integer actualDeletionResult = filledList.deleteFromHead();
        Integer expectedResultFromHeadAfter = 3;
        Integer expectedResultFromTailAfter = 1;
        Integer actualResultFromHeadAfter = filledList.getFromHead();
        Integer actualResultFromTailAfter = filledList.getFromTail();
        assertEquals(expectedDeletionResult, actualDeletionResult);
        assertEquals(expectedResultFromHeadBefore, actualResultFromHeadBefore);
        assertEquals(expectedResultFromTailBefore, actualResultFromTailBefore);
        assertEquals(expectedResultFromHeadAfter, actualResultFromHeadAfter);
        assertEquals(expectedResultFromTailAfter, actualResultFromTailAfter);
    }

    @Test
    void deleteFromTailCheckOnFilledList() {
        Integer expectedResultFromHeadBefore = 4;
        Integer expectedResultFromTailBefore = 1;
        Integer actualResultFromHeadBefore = filledList.getFromHead();
        Integer actualResultFromTailBefore = filledList.getFromTail();
        Integer expectedDeletionResult = 1;
        Integer actualDeletionResult = filledList.deleteFromTail();
        Integer expectedResultFromHeadAfter = 4;
        Integer expectedResultFromTailAfter = 2;
        Integer actualResultFromHeadAfter = filledList.getFromHead();
        Integer actualResultFromTailAfter = filledList.getFromTail();
        assertEquals(expectedDeletionResult, actualDeletionResult);
        assertEquals(expectedResultFromHeadBefore, actualResultFromHeadBefore);
        assertEquals(expectedResultFromTailBefore, actualResultFromTailBefore);
        assertEquals(expectedResultFromHeadAfter, actualResultFromHeadAfter);
        assertEquals(expectedResultFromTailAfter, actualResultFromTailAfter);
    }

    @Test
    void getFromHeadCheckOnEmptyList() {
        Integer expectedResult = null;
        Integer actualResult = emptyList.getFromHead();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getFromTailCheckOnEmptyList() {
        Integer expectedResult = null;
        Integer actualResult = emptyList.getFromTail();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getFromHeadCheckOnFilledList() {
        Integer expectedResult = 4;
        Integer actualResult = filledList.getFromHead();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getFromTailCheckOnFilledList() {
        Integer expectedResult = 1;
        Integer actualResult = filledList.getFromTail();
        assertEquals(expectedResult, actualResult);
    }
}