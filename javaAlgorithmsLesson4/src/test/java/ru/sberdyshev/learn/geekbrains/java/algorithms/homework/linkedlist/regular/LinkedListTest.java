package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.iterator.Iterable;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void insertWithIndexCheckOnEmptyList() {
        String expectedResultBefore = null;
        String actualResultBefore = emptyList.get();
        assertThrows(IllegalArgumentException.class, () -> emptyList.insert("test", 4));
        String expectedResultAfter = null;
        String actualResultAfter = emptyList.get();
        assertEquals(expectedResultBefore, actualResultBefore);
        assertEquals(expectedResultAfter, actualResultAfter);
    }

    @Test
    void insertWithIndexCheckOnFilledList() {
        Integer expectedResultBefore = 4;
        Integer actualResultBefore = filledList.get();
        filledList.insert(5,1);
        Integer expectedResultAfterFirstDelete = 4;
        Integer actualResultAfterFirstDelete = filledList.delete();
        Integer expectedResultAfterSecondDelete = 5;
        Integer actualResultAfterSecondDelete = filledList.delete();
        Integer expectedResultAfterThirdDelete = 3;
        Integer actualResultAfterThirdDelete = filledList.delete();
        assertEquals(expectedResultBefore, actualResultBefore);
        assertEquals(expectedResultAfterFirstDelete, actualResultAfterFirstDelete);
        assertEquals(expectedResultAfterSecondDelete, actualResultAfterSecondDelete);
        assertEquals(expectedResultAfterThirdDelete, actualResultAfterThirdDelete);
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
    void deleteWithIndexCheckOnEmptyList() {
        String expectedResultBefore = null;
        String actualResultBefore = emptyList.get();
        String expectedDeletionResult = null;
        String actualDeletionResult = emptyList.delete(3);
        String expectedResultAfter = null;
        String actualResultAfter = emptyList.get();
        assertEquals(expectedResultBefore, actualResultBefore);
        assertEquals(expectedDeletionResult, actualDeletionResult);
        assertEquals(expectedResultAfter, actualResultAfter);
    }

    @Test
    void deleteWithIndexCheckOnFilledList() {
        Integer expectedResultBefore = 4;
        Integer actualResultBefore = filledList.get();
        Integer expectedDeletionWithIndexResult = 3;
        Integer expectedDeletionResult = 4;
        Integer actualDeletionWithIndexResult = filledList.delete(1);
        Integer actualDeletionResult = filledList.delete();
        Integer expectedResultAfter = 2;
        Integer actualResultAfter = filledList.get();
        assertEquals(expectedResultBefore, actualResultBefore);
        assertEquals(expectedDeletionResult, actualDeletionResult);
        assertEquals(expectedDeletionWithIndexResult, actualDeletionWithIndexResult);
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

    @Test
    void getWithIndexCheckOnEmptyList() {
        String expectedResult = null;
        String actualResult = emptyList.get(4);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getWithIndexCheckOnFilledList() {
        Integer expectedResult = 2;
        Integer actualResult = filledList.get(2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void forEachTestFilledList() {
        Iterable<String> filledListIterable = new LinkedList<>("1", "2", "3", "4");
        StringBuilder expectedResult = new StringBuilder("4321");
        StringBuilder actualResult = new StringBuilder();
        Consumer<String> actionAppend = actualResult::append;
        filledListIterable.forEach(actionAppend);
        assertEquals(expectedResult.toString(), actualResult.toString());
    }

    @Test
    void forEachTestEmptyList() {
        Iterable<String> filledListIterable = new LinkedList<>();
        StringBuilder expectedResult = new StringBuilder();
        StringBuilder actualResult = new StringBuilder();
        Consumer<String> actionAppend = actualResult::append;
        filledListIterable.forEach(actionAppend);
        assertEquals(expectedResult.toString(), actualResult.toString());
    }
}