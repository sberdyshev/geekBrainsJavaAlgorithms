package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.List;

/**
 * An iterator for LinkedList implementation
 *
 * @param <T> - type of object to iterate
 */
public class LinkedListIterator<T> implements Iterator<T> {
    private static final Logger logger = LoggerFactory.getLogger(LinkedListIterator.class);
    private List<T> list;
    private int currentElementNumber;

    /**
     * Creates an iterator with a link to the list
     *
     * @param list - list to iterate
     */
    public LinkedListIterator(List<T> list) {
        logger.debug("Created an iterator for the \"{}\" list.", list);
        this.list = list;
        currentElementNumber = 0;
    }

    /**
     * Resets an iterator
     */
    @Override
    public void reset() {
        logger.debug("Reseted an iterator");
        currentElementNumber = 0;
    }

    /**
     * Checks if an iterator is at the end of a list
     *
     * @return true if it is at the end, false otherwise
     */
    @Override
    public boolean atEnd() {
        logger.debug("Checked if iterator is at the end - \"{}\".", currentElementNumber == list.getSize());
        return currentElementNumber == list.getSize();
    }

    /**
     * Moves an iterator to the next element
     */
    @Override
    public void next() {
        logger.debug("Moving iterator to the next element.");
        if (atEnd()) {
            throw new IllegalStateException("Out of list bounds");
        }
        currentElementNumber++;
    }

    /**
     * Returns an element that is referenced by an iterator
     *
     * @return current element
     */
    @Override
    public T getCurrent() {
        logger.debug("Getting current element.");
        return list.get(currentElementNumber);
    }

    /**
     * Deletes an element that is referenced by an iterator. Moves the iterator backwards.
     *
     * @return deleted element
     */
    @Override
    public T deleteCurrent() {
        if (currentElementNumber != 0) {
            currentElementNumber--;
        }
        logger.debug("Deleted current element - \"{}\".", currentElementNumber);
        return list.delete(currentElementNumber);
    }
}
