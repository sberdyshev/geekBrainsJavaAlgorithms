package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.List;

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

    @Override
    public T pop() {
        return null;
    }

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

    @Override
    public boolean isEmpty() {
        if (topPointer == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<T> getValues() {
        return null;
    }

    @Override
    public int getSize() {
        return topPointer;
    }
}
