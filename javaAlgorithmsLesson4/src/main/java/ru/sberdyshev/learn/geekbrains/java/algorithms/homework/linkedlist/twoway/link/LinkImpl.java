package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway.link;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements a link class. Class contains references to to next and previous objects.
 *
 * @param <T> - type of stored element.
 * @author sberdyshev
 */
public class LinkImpl<T> implements Link<T> {
    private static final Logger logger = LoggerFactory.getLogger(LinkImpl.class);
    private T object;
    private Link<T> next;
    private Link<T> previous;

    /**
     * Create a linkobject above an element object
     *
     * @param object - object, that has to be covered by the link object
     */
    public LinkImpl(T object) {
        this.object = object;
        logger.debug("A link with an object \"{}\" has been created.", object);
    }

    /**
     * Create a linkobject above an element object
     *
     * @param object   - object, that has to be covered by the link object
     * @param previous - a link to the previous object
     * @param next     - a link to the next object
     */
    public LinkImpl(T object, Link<T> previous, Link<T> next) {
        this.object = object;
        this.previous = previous;
        this.next = next;
        logger.debug("A link with an object \"{}\" and links to the previous \"{}\" and next \"{}\" has been created.", object, previous, next);
    }

    /**
     * Checks if the link has a reference to the next object
     *
     * @return true if there is a reference, false otherwise
     */
    @Override
    public boolean hasNext() {
        logger.debug("Checking if the link has next - \"{}\".", next != null);
        return next != null;
    }

    /**
     * Checks if the link has a reference to the previous object
     *
     * @return true if there is a reference, false otherwise
     */
    @Override
    public boolean hasPrevious() {
        logger.debug("Checking if the link has previous - \"{}\".", previous != null);
        return previous != null;
    }

    /**
     * Returns a link object, that is referenced by current as next
     *
     * @return next link object
     */
    @Override
    public Link<T> getNext() {
        logger.debug("Getting the next");
        return next;
    }

    /**
     * Sets a next link object
     *
     * @param next - link object, that will be set as next to the current
     */
    @Override
    public void setNext(Link<T> next) {
        logger.debug("Setting the next");
        this.next = next;
    }

    /**
     * Returns a link object, that is referenced by current as previous
     *
     * @return previous link object
     */
    @Override
    public Link<T> getPrevious() {
        logger.debug("Getting the previous");
        return previous;
    }

    /**
     * Sets a previous link object
     *
     * @param previous - link object, that will be set as previous to the current
     */
    @Override
    public void setPrevious(Link<T> previous) {
        logger.debug("Setting the previous");
        this.previous = previous;
    }

    /**
     * Get an object, that is covered by current link instance
     *
     * @return object
     */
    @Override
    public T getObject() {
        logger.debug("Getting object - \"{}\".", object);
        return object;
    }

    /**
     * Set an object to be covered by current link instance
     *
     * @param object - that will be covered by current link class
     */
    @Override
    public void setObject(T object) {
        logger.debug("Setting object - \"{}\".", object);
        this.object = object;
    }
}
