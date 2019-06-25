package ru.sberdyshev.learn.geebrains.java.algorithms.homework.deque.deque;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DequeImpl<T> implements Deque<T> {
    private static final int DEQUE_MIN_SIZE = 5;
    private static final Logger logger = LoggerFactory.getLogger(DequeImpl.class);
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
     * Creates a deque with specific type and name
     *
     * @param classType - type of values deque contains
     * @param name      - name of the deque
     */
    public DequeImpl(@NonNull Class<T> classType, @NonNull String name) {
        if (classType == null) {
            throw new IllegalArgumentException("Class type of a QueueImpl can't be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name of a QueueImpl can't be null.");
        }
        this.classType = classType;
        this.array = (T[]) Array.newInstance(classType, DEQUE_MIN_SIZE);
        this.headPointer = 0;
        this.tailPointer = 0;
        this.name = name;
    }

    /**
     * Creates a deque with specific type and name
     *
     * @param classType   - type of values deque contains
     * @param name        - name of the deque
     * @param startValues - values to fill the deque
     */
    public DequeImpl(@NonNull Class<T> classType, @NonNull String name, T... startValues) {
        if (classType == null) {
            throw new IllegalArgumentException("Class type of a QueueImpl can't be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name of a QueueImpl can't be null.");
        }
        this.classType = classType;
        this.array = (T[]) Array.newInstance(classType, DEQUE_MIN_SIZE);
        this.headPointer = 0;
        this.tailPointer = 0;
        this.name = name;
        for (T value : startValues) {
            this.writeToHead(value);
        }
    }

    /**
     * Reads an element from the head of a deque. The element is deleted after the operation.
     *
     * @return queued element. if queue is empty, returns null.
     */
    @Override
    public T readAtHead() {
        logger.debug("Reading at head deque \"{}\". Current head position \"{}\", current tail position \"{}\".", name, headPointer, tailPointer);
        if (!isEmpty()) {
            T lastElement = array[headPointer];
            headPointer--;
            logger.debug("Read a value \"{}\" from the head of the deque \"{}\". Current head position \"{}\", current tail position \"{}\".", lastElement, name, headPointer, tailPointer);
            return lastElement;
        } else {
            logger.debug("Deque \"{}\" is empty.", name);
            return null;
        }
    }

    /**
     * Reads an element from the tail of a deque. The element is deleted after the operation.
     *
     * @return queued element. if queue is empty, returns null.
     */
    @Override
    public T readAtTail() {
        logger.debug("Reading at the tail of deque \"{}\". Current head position \"{}\", current tail position \"{}\".", name, headPointer, tailPointer);
        if (!isEmpty()) {
            T lastElement = array[tailPointer];
            tailPointer--;
            logger.debug("Read a value \"{}\" from the tail of the deque \"{}\". Current head position \"{}\", current tail position \"{}\".", lastElement, name, headPointer, tailPointer);
            return lastElement;
        } else {
            logger.debug("Dequeue \"{}\" is empty.", name);
            return null;
        }
    }

    /**
     * Reads an element from the head of a deque. The element is not deleted after the operation.
     *
     * @return queued element. if queue is empty, returns null.
     */
    @Override
    public T browseAtHead() {
        logger.debug("Reading at head deque \"{}\". Current head position \"{}\", current tail position \"{}\".", name, headPointer, tailPointer);
        if (!isEmpty()) {
            T lastElement = array[headPointer];
            logger.debug("Read a value \"{}\" from the head of the deque \"{}\". Current head position \"{}\", current tail position \"{}\".", lastElement, name, headPointer, tailPointer);
            return lastElement;
        } else {
            logger.debug("Deque \"{}\" is empty.", name);
            return null;
        }
    }

    /**
     * Reads an element from the tail of a deque. The element is not deleted after the operation.
     *
     * @return queued element. if queue is empty, returns null.
     */
    @Override
    public T browseAtTail() {
        logger.debug("Reading at the tail of deque \"{}\". Current head position \"{}\", current tail position \"{}\".", name, headPointer, tailPointer);
        if (!isEmpty()) {
            T lastElement = array[tailPointer];
            logger.debug("Read a value \"{}\" from the tail of the deque \"{}\". Current head position \"{}\", current tail position \"{}\".", lastElement, name, headPointer, tailPointer);
            return lastElement;
        } else {
            logger.debug("Dequeue \"{}\" is empty.", name);
            return null;
        }
    }

    /**
     * Writes an element to the head of the deque.
     *
     * @param element - Element that has to be added
     */
    @Override
    public void writeToHead(T element) {
        logger.debug("Writing an element \"{}\" to the head of th deque \"{}\". Current top position \"{}\", current tail position \"{}\".", element, name, headPointer, tailPointer);
        if (array.length == headPointer) {
            int dequeDepth = headPointer - tailPointer;
            logger.debug("The array of the deque \"{}\" is full, giving it new length - {}", name, 2 * dequeDepth);
            T[] tempArray = (T[]) Array.newInstance(classType, 2 * dequeDepth);
            for (int i = tailPointer; i < headPointer; i++) {
                tempArray[i - tailPointer] = array[i];
            }
            array = tempArray;
            headPointer -= tailPointer;
            tailPointer = 0;
        }
        array[headPointer] = element;
        headPointer++;
        logger.debug("Added an element \"{}\" to the head of the deque \"{}\". Current top position \"{}\", current tail position \"{}\".", element, name, headPointer, tailPointer);
    }

    /**
     * Writes an element to the tail of the deque.
     * P.S. Можно было бы, конечно, предусмотреть увеличение и смещение массива, если хвост уперся в ноль, но я не успею это все сделать.
     *
     * @param element - Element that has to be added
     */
    @Override
    public void writeToTail(T element) {
        logger.debug("Writing an element \"{}\" to the tail of th deque \"{}\". Current top position \"{}\", current tail position \"{}\".", element, name, headPointer, tailPointer);
        if (tailPointer == 0) {
            logger.debug("The tail of the deque \"{}\" is full.");
        } else {
            array[tailPointer] = element;
            tailPointer--;
        }
        logger.debug("Added an element \"{}\" to the tail of the deque \"{}\". Current top position \"{}\", current tail position \"{}\".", element, name, headPointer, tailPointer);
    }

    /**
     * Checks if deque is empty
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        logger.debug("Checking if deque \"{}\" is empty.", name);
        if (headPointer == tailPointer) {
            logger.debug("Deque \"{}\" is empty.", name);
            return true;
        } else {
            logger.debug("Deque \"{}\" is not empty.", name);
            return false;
        }
    }

    /**
     * Returns deque values as a list
     *
     * @return deque values
     */
    @Override
    @NonNull
    public List<T> getValues() {
        logger.debug("Getting stack \"{}\" values.", name);
        T[] arrayToReturn = (T[]) Array.newInstance(classType, headPointer);
        for (int i = 0; i < headPointer; i++) {
            arrayToReturn[i] = array[i];
        }
        return new LinkedList<>(Arrays.asList(arrayToReturn));
    }

    /**
     * Gets deque size
     *
     * @return deque size
     */
    @Override
    public int getSize() {
        logger.debug("Getting stack \"{}\" size.", name);
        int size = headPointer - tailPointer;
        logger.debug("Stack \"{}\" size - {}.", name, size);
        return size;
    }

    /**
     * Clears all stack values
     */
    @Override
    public void clear() {
        array = (T[]) Array.newInstance(classType, DEQUE_MIN_SIZE);
        headPointer = 0;
        tailPointer = 0;
    }
}
