package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Stack implementation
 *
 * @param <T> - type of values stack can contain
 * @author sberdyshev
 */
public class StackImpl<T> implements Stack<T> {
    private static final int STACK_MIN_SIZE = 5;
    private static final Logger logger = LoggerFactory.getLogger(StackImpl.class);
    @NonNull
    private T[] array;
    @NonNull
    private Class<T> classType;
    private int topPointer;
    @Getter
    @Setter
    private String name;

    /**
     * Creates a stack with specific type and name
     *
     * @param classType - type of stacks contained values
     * @param name      - name of the stack
     */
    public StackImpl(@NonNull Class<T> classType, @NonNull String name) {
        if (classType == null) {
            throw new IllegalArgumentException("Class type of a StackImpl can't be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name of a StackImpl can't be null.");
        }
        this.classType = classType;
        this.array = (T[]) Array.newInstance(classType, STACK_MIN_SIZE);
        this.topPointer = 0;
        this.name = name;
    }

    /**
     * Creates a stack with specific type and name
     *
     * @param classType   - type of stacks contained values
     * @param name        - name of the stack
     * @param startValues - values to fill the stack
     */
    public StackImpl(@NonNull Class<T> classType, @NonNull String name, @NonNull T... startValues) {
        if (classType == null) {
            throw new IllegalArgumentException("Class type of a StackImpl can't be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name of a StackImpl can't be null.");
        }
        this.classType = classType;
        this.array = (T[]) Array.newInstance(classType, STACK_MIN_SIZE);
        this.topPointer = 0;
        this.name = name;
        for (T value : startValues) {
            this.push(value);
        }
    }

    /**
     * Gets the top element of the stack. Element is deleted.
     *
     * @return - top element of the stack
     */
    @Override
    @Nullable
    public T pop() {
        logger.debug("Getting a top element from stack \"{}\". Current top position \"{}\".", name, topPointer);
        if (!isEmpty()) {
            T topElement = array[topPointer - 1];
            topPointer--;
            logger.debug("Got top element \"{}\" from a stack \"{}\". Current top position \"{}\".", topElement, name, topPointer);
            return topElement;
        } else {
            logger.debug("Stack \"{}\" is empty.", name);
            return null;
        }
    }

    /**
     * Adds an element to the stack.
     *
     * @param element - element that has to be added
     */
    @Override
    public void push(@Nullable T element) {
        logger.debug("Pushing an element \"{}\" into stack \"{}\". Current top position \"{}\".", element, name, topPointer);
        if (array.length == topPointer) {
            logger.debug("The array of stack \"{}\" is full, giving it new length - {}", name, 2 * array.length);
            T[] tempArray = (T[]) Array.newInstance(classType, 2 * array.length);
            for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        array[topPointer] = element;
        topPointer++;
        logger.debug("Pushed an element \"{}\" into stack \"{}\". Current top position \"{}\".", element, name, topPointer);
    }

    /**
     * Gets the top element of the stack. Element is not deleted.
     *
     * @return - top element of the stack
     */
    @Override
    @Nullable
    public T peek() {
        logger.debug("Getting a peek element from stack \"{}\". Current top position \"{}\".", name, topPointer);
        if (!isEmpty()) {
            T peekElement = array[topPointer - 1];
            logger.debug("Got peek element \"{}\" from a stack \"{}\". Current top position \"{}\".", peekElement, name, topPointer);
            return array[topPointer - 1];
        } else {
            logger.debug("Stack \"{}\" is empty.", name);
            return null;
        }
    }

    /**
     * Checks if stack is empty
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        logger.debug("Checking if stack \"{}\" is empty.", name);
        if (topPointer == 0) {
            logger.debug("Stack \"{}\" is empty.", name);
            return true;
        } else {
            logger.debug("Stack \"{}\" is not empty.", name);
            return false;
        }
    }

    /**
     * Returns stack values as a list
     *
     * @return stack values
     */
    @Override
    @NonNull
    public List<T> getValues() {
        logger.debug("Getting stack \"{}\" values.", name);
        T[] arrayToReturn = (T[]) Array.newInstance(classType, topPointer);
        for (int i = 0; i < topPointer; i++) {
            arrayToReturn[i] = array[i];
        }
        List<T> stackValuesAsList = new LinkedList<>(Arrays.asList(arrayToReturn));
        return stackValuesAsList;
    }

    /**
     * Gets stack size
     *
     * @return stack size
     */
    @Override
    public int getSize() {
        logger.debug("Getting stack \"{}\" size.", name);
        logger.debug("Stack \"{}\" size - {}.", name, topPointer);
        return topPointer;
    }

    /**
     * Clears all stack values
     */
    @Override
    public void clear() {
        array = (T[]) Array.newInstance(classType, STACK_MIN_SIZE);
        topPointer = 0;
    }
}
