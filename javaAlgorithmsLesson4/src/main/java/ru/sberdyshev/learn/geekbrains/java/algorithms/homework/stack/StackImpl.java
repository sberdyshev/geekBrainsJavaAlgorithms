package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.stack;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Stack implementation
 *
 * @param <T> - type of values stack can contain
 * @author sberdyshev
 */
public class StackImpl<T> implements Stack<T> {
    private static final Logger logger = LoggerFactory.getLogger(StackImpl.class);
    @NonNull
    private LinkedList<T> list;
    @Getter
    @Setter
    private String name;

    /**
     * Creates a stack with specific type and name
     *
     * @param name - name of the stack
     */
    public StackImpl(@NonNull String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name of a StackImpl can't be null.");
        }
        this.list = new LinkedList<>();
        this.name = name;
    }

    /**
     * Creates a stack with specific type and name
     *
     * @param name        - name of the stack
     * @param startValues - values to fill the stack
     */
    public StackImpl(@NonNull String name, @NonNull T... startValues) {
        if (name == null) {
            throw new IllegalArgumentException("Name of a StackImpl can't be null.");
        }
        this.list = new LinkedList<>();
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
    public T pop() {
        logger.debug("Getting a top element from stack \"{}\".", name);
        if (!isEmpty()) {
            T topElement = list.removeLast();
            logger.debug("Got top element \"{}\" from a stack \"{}\".", topElement, name);
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
    public void push(T element) {
        logger.debug("Pushing an element \"{}\" into stack \"{}\".", element, name);
        list.addLast(element);
        logger.debug("Pushed an element \"{}\" into stack \"{}\".", element, name);
    }

    /**
     * Gets the top element of the stack. Element is not deleted.
     *
     * @return - top element of the stack
     */
    @Override
    public T peek() {
        logger.debug("Getting a peek element from stack \"{}\".", name);
        T peekElement = null;
        if (!list.isEmpty()) {
            peekElement = list.getLast();
        }
        logger.debug("Got peek element \"{}\" from a stack \"{}\".", peekElement, name);
        return peekElement;
    }

    /**
     * Checks if stack is empty
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        logger.debug("Checking if stack \"{}\" is empty.", name);
        boolean result = list.isEmpty();
        logger.debug("Stack \"{}\" is empty - \"{}\".", name, result);
        return result;
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
        return new LinkedList<>(list);
    }

    /**
     * Gets stack size
     *
     * @return stack size
     */
    @Override
    public int getSize() {
        logger.debug("Getting stack \"{}\" size.", name);
        logger.debug("Stack \"{}\" size - {}.", name, list.size());
        return list.size();
    }

    /**
     * Clears all stack values
     */
    @Override
    public void clear() {
        list = new LinkedList<>();
    }
}
