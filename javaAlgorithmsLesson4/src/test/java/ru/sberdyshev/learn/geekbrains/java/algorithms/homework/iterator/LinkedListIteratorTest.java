package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.LinkedList;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author sberdyshev
 */
class LinkedListIteratorTest {
    private List<Integer> emptyList;
    private List<Integer> filledList;
    private Iterator<Integer> emptyListIterator;
    private Iterator<Integer> filledListIterator;

    @BeforeEach
    void setUp() {
        emptyList = new LinkedList<>();
        filledList = new LinkedList<>(1, 2, 3, 4);
        emptyListIterator = emptyList.getIterator();
        filledListIterator = filledList.getIterator();
    }

    @Test
    void resetFilledList() {
        Integer expectedCurrentFirstStep = 4;
        Integer actualCurrentFirstStep = filledListIterator.getCurrent();
        filledListIterator.next();
        Integer expectedCurrentSecondStep = 3;
        Integer actualCurrentSecondStep = filledListIterator.getCurrent();
        filledListIterator.reset();
        Integer expectedCurrentThirdStep = 4;
        Integer actualCurrentThirdStep = filledListIterator.getCurrent();
        assertEquals(expectedCurrentFirstStep, actualCurrentFirstStep);
        assertEquals(expectedCurrentSecondStep, actualCurrentSecondStep);
        assertEquals(expectedCurrentThirdStep, actualCurrentThirdStep);
    }

    @Test
    void resetEmptyList() {
        Integer expectedCurrentFirstStep = null;
        Integer actualCurrentFirstStep = emptyListIterator.getCurrent();
        assertThrows(IllegalStateException.class, () -> {
            emptyListIterator.next();
        });
        assertEquals(expectedCurrentFirstStep, actualCurrentFirstStep);
    }

    @Test
    void atEndFilledList() {
        boolean expectedResult = false;
        boolean actualResult = filledListIterator.atEnd();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void atEndEmptyList() {
        boolean expectedResult = true;
        boolean actualResult = emptyListIterator.atEnd();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getCurrentFilledList() {
        Integer expectedCurrentBefore = 4;
        Integer actualCurrentBefore = filledListIterator.getCurrent();
        assertEquals(expectedCurrentBefore, actualCurrentBefore);
    }

    @Test
    void getCurrentEmptyList() {
        Integer expectedCurrentBefore = null;
        Integer actualCurrentBefore = emptyListIterator.getCurrent();
        assertEquals(expectedCurrentBefore, actualCurrentBefore);
    }

    @Test
    void deleteCurrentFilledList() {
        Integer expectedCurrentBefore = 4;
        Integer actualCurrentBefore = filledListIterator.getCurrent();
        Integer expectedDeletedElement = 4;
        Integer actualDeletedElement = filledListIterator.deleteCurrent();
        Integer expectedCurrentAfter = 3;
        Integer actualCurrentAfter = filledListIterator.getCurrent();
        assertEquals(expectedCurrentBefore, actualCurrentBefore);
        assertEquals(expectedDeletedElement, actualDeletedElement);
        assertEquals(expectedCurrentAfter, actualCurrentAfter);
    }

    @Test
    void deleteCurrentEmptyList() {
        Integer expectedCurrentBefore = null;
        Integer actualCurrentBefore = emptyListIterator.getCurrent();
        Integer expectedDeletedElement = null;
        Integer actualDeletedElement = emptyListIterator.deleteCurrent();
        Integer expectedCurrentAfter = null;
        Integer actualCurrentAfter = emptyListIterator.getCurrent();
        assertEquals(expectedCurrentBefore, actualCurrentBefore);
        assertEquals(expectedDeletedElement, actualDeletedElement);
        assertEquals(expectedCurrentAfter, actualCurrentAfter);
    }
}