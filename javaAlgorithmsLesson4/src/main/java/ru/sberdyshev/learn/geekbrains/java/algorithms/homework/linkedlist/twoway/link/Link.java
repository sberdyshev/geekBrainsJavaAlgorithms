package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway.link;

/**
 * Represents and object with a link to another object
 *
 * @param <T> - object
 */
public interface Link<T> {
    boolean hasNext();

    boolean hasPrevious();

    Link<T> getNext();

    void setNext(Link<T> object);

    Link<T> getPrevious();

    void setPrevious(Link<T> object);

    T getObject();

    void setObject(T object);
}
