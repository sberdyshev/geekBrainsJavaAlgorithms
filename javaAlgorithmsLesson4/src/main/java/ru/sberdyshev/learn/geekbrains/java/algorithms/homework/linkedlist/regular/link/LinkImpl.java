package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.link;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of link object - cover for an object with references to the next and previous elements in a collection.
 *
 * @param <T> - type of an object
 * @author sberdyshev
 */
public class LinkImpl<T> implements Link<T> {
    private static final Logger logger = LoggerFactory.getLogger(LinkImpl.class);

    private T object;
    private Link<T> next;

    public LinkImpl(T object) {
        logger.debug("Created a link with a covered object \"{}\".", object);
        this.object = object;
    }

    public LinkImpl(T object, Link<T> next) {
        logger.debug("Created a link with a covered object \"{}\" and a link to the next element.", object);
        this.object = object;
        this.next = next;
    }

    @Override
    public boolean hasNext() {
        logger.debug("Checking if a link has next element - \"{}\".", next != null);
        return next != null;
    }

    @Override
    public Link getNext() {
        logger.debug("Getting next element of a link - \"{}\".", next);
        return next;
    }

    @Override
    public void setNext(Link next) {
        logger.debug("Setting next element of a link - \"{}\".", next);
        this.next = next;
    }

    @Override
    public T getObject() {
        logger.debug("Getting current element - \"{}\".", object);
        return object;
    }

    @Override
    public void setObject(T object) {
        logger.debug("Setting current element - \"{}\".", object);
        this.object = object;
    }
}
