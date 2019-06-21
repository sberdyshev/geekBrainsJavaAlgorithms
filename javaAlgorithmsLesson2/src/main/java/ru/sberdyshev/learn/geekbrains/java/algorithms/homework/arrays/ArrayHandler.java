package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

/**
 * Allows to work with arrays: add elements, delete elements, search for elements;
 *
 * @author sberdyshev
 */
public class ArrayHandler<T extends Comparable<T>> {
    private static final Logger logger = LoggerFactory.getLogger(ArrayHandler.class);
    private static final int ARRAY_MIN_LENGTH = 5;
    private final Class<T> classType;
    private T[] array;
    private int currentPosition;

    /**
     * Creates an instance and initialises it
     *
     * @param classType - type of the elements to work with
     * @param elements  - values to initialise the array
     */
    @SuppressWarnings("unchecked")
    public ArrayHandler(Class<T> classType, T... elements) {
        this.classType = classType;
        this.array = (T[]) Array.newInstance(classType, ARRAY_MIN_LENGTH);
        this.currentPosition = 0;
        for (T currentElement : elements) {
            this.add(currentElement);
        }
        logger.info("An object has been created with predefined elements: {}", elements);
    }

    /**
     * Creates an instance
     *
     * @param classType - type of the elements to work with
     */
    @SuppressWarnings("unchecked")
    public ArrayHandler(Class<T> classType) {
        this.classType = classType;
        this.array = (T[]) Array.newInstance(classType, ARRAY_MIN_LENGTH);
        this.currentPosition = 0;
        logger.info("An object has been created");
    }

    /**
     * Returns an underlying array
     *
     * @return T[]
     */
    public T[] getArray() {
        return array;
    }

    /**
     * Adds an element to the array
     *
     * @param addedElement - element (weather a value or mull) that has to be added
     * @return true if there was an addition, false in other case
     */
    @SuppressWarnings("unchecked")
    public boolean add(T addedElement) {
        logger.info("Adding element {}", addedElement);
        if (array.length == currentPosition) {
            logger.info("The array is full, giving it new length - {}", 2 * array.length);
            T[] tempArray = (T[]) Array.newInstance(classType, 2 * array.length);
            for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        array[currentPosition] = addedElement;
        currentPosition++;
        return true;
    }

    /**
     * Deletes an element from an array
     *
     * @param deletedElement - element (weather a value or mull) that has to be deleted
     * @return true if there was a deletion, false in other case
     */
    @SuppressWarnings("unchecked")
    public boolean delete(T deletedElement) {
        logger.info("Deleting element {}", deletedElement);
        boolean result = false;
        T[] tempArray = array;
        List<Integer> undeletedIndexes = collectUndeletedIndexes(deletedElement);
        int remainedElementAmount = undeletedIndexes.size();
        if (remainedElementAmount != tempArray.length) {
            result = true;
        }
        logger.info("Creating new array without deleted {} elements", array.length - remainedElementAmount);
        if (remainedElementAmount != 0) {
            array = (T[]) Array.newInstance(classType, remainedElementAmount);
            int i = 0;
            for (Integer index : undeletedIndexes) {
                array[i] = tempArray[index];
                i++;
            }
        } else {
            logger.info("There is no elements left. Creating an empty array with the default size");
            array = (T[]) Array.newInstance(classType, ARRAY_MIN_LENGTH);
        }
        return result;
    }

    /**
     * Gather all indexes of elements, that won't be deleted (that are not equal to deletedElement).
     * Method is used in delete method.
     *
     * @param deletedElement - element, that will be deleted
     * @return list of element's indexes, that will be kept
     */
    private List<Integer> collectUndeletedIndexes(T deletedElement) {
        List<Integer> undeletedIndexes = new LinkedList<>();
        if (deletedElement == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    undeletedIndexes.add(i);
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (!deletedElement.equals(array[i])) {
                    undeletedIndexes.add(i);
                }
            }
        }
        return undeletedIndexes;
    }

    /**
     * Searches for an element in the array
     *
     * @param searchedElement - element (weather a value or mull) that has to be checked if it is in the array
     * @return position of the found element, -1 otherwise
     */
    public int find(T searchedElement) {
        logger.info("Searching for an element {}", searchedElement);
        int defPosition = -1;
        if (searchedElement == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (searchedElement.equals(array[i]))
                    return i;
            }
        }
        return defPosition;
    }

    /**
     * Prints all elements one in a line with separation lines
     */
    public void print() {
        logger.info("Printing the array [{}]", array);
        System.out.print("-- ");
        for (T checkedElement : array) {
            System.out.print(checkedElement + " ");
        }
        System.out.println("--");
    }

    /**
     * Sorts elements from the lowest to the biggest.
     * NULLs are considered the biggest.
     */
    public void sortBubble() {
        logger.info("Start sorting by bubble algorithm array [{}]", array);
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                boolean isNullElementStandsBeforeNotNullElement = array[j] == null && array[j + 1] != null;
                boolean isFirstNotNullBiggerThenSecondNotNull = array[j] != null && array[j + 1] != null && array[j].compareTo(array[j + 1]) > 0;
                if (isNullElementStandsBeforeNotNullElement || isFirstNotNullBiggerThenSecondNotNull) {
                    change(j, j + 1);
                }
            }
        }
        logger.info("Finish sorting by bubble algorithm array [{}]", array);
    }

    /**
     * Changes two elements in the array
     *
     * @param a - index of the first element
     * @param b - index of the second element
     */
    private void change(int a, int b) {
        T tmp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = tmp;
    }

    /**
     * Sorts elements from the lowest to the biggest.
     * NULLs are considered the biggest.
     */
    public void sortSelect() {
        logger.info("Start sorting by select algorithm array [{}]", array);
        int out;
        int in;
        int mark;
        for (out = 0; out < array.length; out++) {
            mark = out;
            for (in = out + 1; in < array.length; in++) {
                boolean isCheckedElementNotNullAndMarkerNull = array[in] != null && array[mark] == null;
                boolean isNotNullCheckedLessThenNotNullMarker = array[in] != null && array[mark] != null && array[in].compareTo(array[mark]) < 0;
                if (isCheckedElementNotNullAndMarkerNull || isNotNullCheckedLessThenNotNullMarker) {
                    mark = in;
                }
            }
            change(out, mark);
        }
        logger.info("Finish sorting by bubble algorithm array [{}]", array);
    }

    /**
     * Sorts elements from the lowest to the biggest.
     * NULLs are considered the biggest.
     */
    public void sortInsert() {
        logger.info("Start sorting by insert algorithm array [{}]", array);
        int in;
        int out;
        for (out = 1; out < array.length; out++) {
            T temp = array[out];
            in = out;
            while (in > 0 && ((array[in - 1] == null) || (temp != null && array[in - 1].compareTo(temp) >= 0))) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
        logger.info("Finish sorting by insert algorithm array [{}]", array);
    }
}
