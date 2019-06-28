package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.queue;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Queue Implementation
 *
 * @param <T> - type of values queue can contain
 * @author sberdyshev
 */
public class QueueImpl<T> implements Queue<T> {
    private static final Logger logger = LoggerFactory.getLogger(QueueImpl.class);
    @NonNull
    private LinkedList<T> list;
    @Getter
    @Setter
    private String name;

    /**
     * Creates a queue with specific type and name
     *
     * @param name - name of the queue
     */
    public QueueImpl(@NonNull String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name of a QueueImpl can't be null.");
        }
        this.list = new LinkedList<>();
        this.name = name;
    }

    /**
     * Creates a queue with specific type and name
     *
     * @param name        - name of the queue
     * @param startValues - values to fill the queue
     */
    public QueueImpl(@NonNull String name, T... startValues) {
        if (name == null) {
            throw new IllegalArgumentException("Name of a QueueImpl can't be null.");
        }
        this.list = new LinkedList<>();
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
    public T read() {
        logger.debug("Reading queue \"{}\".", name);
        if (!isEmpty()) {
            T lastElement = list.removeFirst();
            logger.debug("Read a value \"{}\" from queue \"{}\".", lastElement, name);
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
    public T browse() {
        logger.debug("Browsing queue \"{}\".", name);
        if (!isEmpty()) {
            T lastElement = list.getFirst();
            logger.debug("Browsed a value \"{}\" from queue \"{}\"", lastElement, name);
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
    public void write(T element) {
        logger.debug("Writing an element \"{}\" into queue \"{}\".", element, name);
        list.add(element);
        logger.debug("Added an element \"{}\" into queue \"{}\".", element, name);
    }

    /**
     * Checks if queue is empty
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        logger.debug("Checking if queue \"{}\" is empty.", name);
        boolean result = list.isEmpty();
        logger.debug("Queue \"{}\" is empty - \"{}\".", name, result);
        return result;
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
        return new LinkedList<>(list);
    }

    /**
     * Gets queue size
     *
     * @return queue size
     */
    @Override
    public int getSize() {
        logger.debug("Getting queue \"{}\" size.", name);
        logger.debug("Queue \"{}\" size - {}.", name, list.size());
        return list.size();
    }

    /**
     * Clears all queue values
     */
    @Override
    public void clear() {
        logger.debug("Clearing queue \"{}\".", name);
        list = new LinkedList<>();
        logger.debug("Queue \"{}\". is cleared", name);
    }
}
