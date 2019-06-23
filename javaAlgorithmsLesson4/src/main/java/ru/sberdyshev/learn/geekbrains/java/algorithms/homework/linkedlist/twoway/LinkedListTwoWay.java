package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway.link.Link;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway.link.LinkImpl;

/**
 * List implementation, that allows to process elements from tail and head.
 *
 * @param <T> - type of object
 * @author sberdyshev
 */
public class LinkedListTwoWay<T> implements ListTwoWays<T> {
    private static final Logger logger = LoggerFactory.getLogger(LinkedListTwoWay.class);
    private Link<T> head;
    private Link<T> tail;

    /**
     * Creates an ampty list     *
     */
    public LinkedListTwoWay() {
        logger.debug("Created an empty instance of a list");
        this.head = null;
        this.tail = null;
    }

    /**
     * Creates a list and fills it with elements
     *
     * @param elements - an array of elements to fill the list
     */
    public LinkedListTwoWay(T... elements) {
        for (T element : elements) {
            insertToHead(element);
        }
        logger.debug("Created a filled instance of a list");
    }

    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        logger.debug("Checking if the list is empty - \"{}\".", (head == null && tail == null));
        return (head == null && tail == null);
    }

    /**
     * Inserts an element to the head of the list
     *
     * @param element - element that has to be inserted
     */
    @Override
    public void insertToHead(T element) {
        Link<T> newElement = new LinkImpl<>(element);
        if (head != null) {
            head.setNext(newElement);
            newElement.setPrevious(head);
            head = newElement;
        } else {
            head = newElement;
            tail = head;
        }
        logger.debug("Inserted \"{}\" to the head of the list", element);
    }

    /**
     * Inserts an element to the head of the list
     *
     * @param element - element that has to be inserted
     */
    @Override
    public void insertToTail(T element) {
        Link<T> newElement = new LinkImpl<>(element);
        if (tail != null) {
            newElement.setNext(tail);
            tail.setPrevious(newElement);
            tail = newElement;
        } else {
            tail = newElement;
            head = tail;
        }
        logger.debug("Inserted \"{}\" to the tail of the list", element);
    }

    /**
     * Deletes an element from the head of the list
     *
     * @return - deleted element
     */
    @Override
    public T deleteFromHead() {
        T deletedObject = null;
        if (head != null) {
            deletedObject = head.getObject();
            if (head.hasPrevious()) {
                Link<T> previousElement = head.getPrevious();
                previousElement.setNext(null);
                head = previousElement;
                return deletedObject;
            } else {
                head = null;
                tail = null;
            }
        }
        logger.debug("Deleted \"{}\" from the head of the list", deletedObject);
        return deletedObject;
    }

    /**
     * Deletes an element from the tail of the list
     *
     * @return - deleted element
     */
    @Override
    public T deleteFromTail() {
        T deletedObject = null;
        if (tail != null) {
            deletedObject = tail.getObject();
            if (tail.hasNext()) {
                Link<T> nextElement = tail.getNext();
                nextElement.setPrevious(null);
                tail = nextElement;
                return deletedObject;
            } else {
                head = null;
                tail = null;
            }
        }
        logger.debug("Deleted \"{}\" from the tail of the list", deletedObject);
        return deletedObject;
    }

    /**
     * Gets an element from the head of the list. Element is not deleted.
     *
     * @return - element
     */
    @Override
    public T getFromHead() {
        T returnedObject = null;
        if (head != null) {
            returnedObject = head.getObject();
        }
        logger.debug("Retrieved \"{}\" from the head of the list", returnedObject);
        return returnedObject;
    }

    /**
     * Gets an element from the tail of the list. Element is not deleted.
     *
     * @return - element
     */
    @Override
    public T getFromTail() {
        T returnedObject = null;
        if (tail != null) {
            returnedObject = tail.getObject();
        }
        logger.debug("Retrieved \"{}\" from the tail of the list", returnedObject);
        return returnedObject;
    }
}
