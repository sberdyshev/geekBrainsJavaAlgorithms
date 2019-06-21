package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.queue;

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
 * Queue Implementation
 *
 * @param <T> - type of values queue can contain
 * @author sberdyshev
 */
public class QueueImpl<T> implements Queue<T> {
    private static final int QUEUE_MIN_SIZE = 5;
    private static final Logger logger = LoggerFactory.getLogger(QueueImpl.class);
    @NonNull
    private T[] array;
    @NonNull
    private Class<T> classType;
    private int headPointer;
    private int tailPointer;
    @Getter
    @Setter
    private String name;

    /**
     * Creates a queue with specific type and name
     *
     * @param classType - type of values stack contains
     * @param name      - name of the stack
     */
    public QueueImpl(@NonNull Class<T> classType, @NonNull String name) {
        if (classType == null) {
            throw new IllegalArgumentException("Class type of a QueueImpl can't be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name of a QueueImpl can't be null.");
        }
        this.classType = classType;
        this.array = (T[]) Array.newInstance(classType, QUEUE_MIN_SIZE);
        this.headPointer = 0;
        this.tailPointer = 0;
        this.name = name;
    }

    /**
     * Creates a queue with specific type and name
     *
     * @param classType   - type of values stack contains
     * @param name        - name of the stack
     * @param startValues - values to fill the queue
     */
    public QueueImpl(@NonNull Class<T> classType, @NonNull String name, T... startValues) {
        if (classType == null) {
            throw new IllegalArgumentException("Class type of a QueueImpl can't be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name of a QueueImpl can't be null.");
        }
        this.classType = classType;
        this.array = (T[]) Array.newInstance(classType, QUEUE_MIN_SIZE);
        this.headPointer = 0;
        this.tailPointer = 0;
        this.name = name;
        for (T value : startValues) {
            this.write(value);
        }
    }

    /**
     * Reads an element from a queue. The element is deleted after the operation.
     *
     * @return queued element. if queue is empty, returns null.
     */
    @Override
    @Nullable
    public T read() {
        logger.debug("Reading queue \"{}\". Current head position \"{}\", current tail position \"{}\".", name, headPointer, tailPointer);
        if (!isEmpty()) {
            T lastElement = array[tailPointer];
            tailPointer++;
            logger.debug("Read a value \"{}\" from queue \"{}\". Current head position \"{}\", current tail position \"{}\".", lastElement, name, headPointer, tailPointer);
            return lastElement;
        } else {
            logger.debug("Queue \"{}\" is empty.", name);
            return null;
        }
    }

    /**
     * Browses an element from a queue. The element is not deleted after the operation.
     *
     * @return queued element. if queue is empty, returns null.
     */
    @Override
    @Nullable
    public T browse() {
        logger.debug("Browsing queue \"{}\". Current head position \"{}\", current tail position \"{}\".", name, headPointer, tailPointer);
        if (!isEmpty()) {
            T lastElement = array[tailPointer];
            logger.debug("Browsed a value \"{}\" from queue \"{}\". Current head position \"{}\", current tail position \"{}\".", lastElement, name, headPointer, tailPointer);
            return lastElement;
        } else {
            logger.debug("Queue \"{}\" is empty.", name);
            return null;
        }
    }

    /**
     * Adds an element to the queue.
     *
     * @param element - element that has to be added
     */
    @Override
    public void write(@Nullable T element) {
        logger.debug("Writing an element \"{}\" into queue \"{}\". Current top position \"{}\", current tail position \"{}\".", element, name, headPointer, tailPointer);
        if (array.length == headPointer) {
            int queueDepth = headPointer - tailPointer;
            logger.debug("The array of queue \"{}\" is full, giving it new length - {}", name, 2 * queueDepth);
            T[] tempArray = (T[]) Array.newInstance(classType, 2 * queueDepth);
            for (int i = tailPointer; i < headPointer; i++) {
                tempArray[i - tailPointer] = array[i];
            }
            array = tempArray;
            headPointer -= tailPointer;
            tailPointer = 0;
        }
        array[headPointer] = element;
        headPointer++;
        logger.debug("Added an element \"{}\" into queue \"{}\". Current top position \"{}\", current tail position \"{}\".", element, name, headPointer, tailPointer);
    }

    /**
     * Checks if queue is empty
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        logger.debug("Checking if queue \"{}\" is empty.", name);
        if (headPointer == 0 || headPointer == tailPointer) {
            logger.debug("Queue \"{}\" is empty.", name);
            return true;
        } else {
            logger.debug("Queue \"{}\" is not empty.", name);
            return false;
        }
    }

    /**
     * Returns queue values as a list
     *
     * @return queue values
     */
    @Override
    @NonNull
    public List<T> getValues() {
        logger.debug("Getting queue \"{}\" values.", name);
        T[] arrayToReturn = (T[]) Array.newInstance(classType, getSize());
        for (int i = tailPointer; i < headPointer; i++) {
            arrayToReturn[i - tailPointer] = array[i];
        }
        List<T> stackValuesAsList = new LinkedList<>(Arrays.asList(arrayToReturn));
        return stackValuesAsList;
    }

    /**
     * Gets queue size
     *
     * @return queue size
     */
    @Override
    public int getSize() {
        logger.debug("Getting queue \"{}\" size.", name);
        logger.debug("Queue \"{}\" size - {}.", name, headPointer - tailPointer);
        return headPointer - tailPointer;
    }

    /**
     * Clears all queue values
     */
    @Override
    public void clear() {
        logger.debug("Clearing queue \"{}\".", name);
        array = (T[]) Array.newInstance(classType, QUEUE_MIN_SIZE);
        headPointer = 0;
        tailPointer = 0;
        logger.debug("Queue \"{}\". is cleared", name);
    }
}
