package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.link;

/**
 * Represents and object with a link to another object
 *
 * @param <T> - object
 */
public interface Link<T> {
    boolean hasNext();

    Link<T> getNext();

    void setNext(Link<T> object);

    T getObject();

    void setObject(T object);
}
