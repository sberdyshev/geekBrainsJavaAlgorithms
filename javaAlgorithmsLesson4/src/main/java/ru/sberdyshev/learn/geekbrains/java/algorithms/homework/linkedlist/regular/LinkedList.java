package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular;

import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.iterator.Iterable;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.iterator.Iterator;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.iterator.LinkedListIterator;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.link.Link;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.link.LinkImpl;

import java.util.function.Consumer;

/**
 * LinkedList implementation
 * @param <T> - type of object
 */
public class LinkedList<T> implements List<T>, Iterable<T> {

    private Link<T> first;
    private int size;

    public LinkedList() {
        this.first = null;
        size = 0;
    }

    public LinkedList(T... elements) {
        size = 0;
        for (T element : elements) {
            insert(element);
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void insert(T element) {
        Link<T> newElement = new LinkImpl<>(element);
        newElement.setNext(first);
        first = newElement;
        size++;
    }

    @Override
    public void insert(T element, int index) {
        Link<T> current = first;
        Link<T> previous = null;
        Link<T> newElement = new LinkImpl<>(element);
        if (index >= getSize()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        for (int i = 0; i < getSize(); i++) {
            if (i == index) {
                newElement.setNext(current);
                if (previous != null) {
                    previous.setNext(newElement);
                } else {
                    first = current;
                }
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        size++;
    }

    @Override
    public T delete() {
        if (!isEmpty()) {
            size--;
            Link<T> deletedElement = first;
            first = first.getNext();
            return deletedElement.getObject();
        } else {
            return null;
        }
    }

    @Override
    public T delete(int index) {
        if (!isEmpty()) {
            size--;
            Link<T> current = first;
            Link<T> previous = null;
            for (int i = 0; i < getSize(); i++) {
                if (i == index) {
                    if (previous != null) {
                        previous.setNext(current.getNext());
                    } else {
                        first = current.getNext();
                    }
                    return current.getObject();
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public T get() {
        if (!isEmpty()) {
            return first.getObject();
        } else {
            return null;
        }
    }

    @Override
    public T get(int index) {
        Link<T> current = first;
        for (int i = 0; i < getSize(); i++) {
            if (i == index) {
                return current.getObject();
            }
            if (current.hasNext()) {
                current = current.getNext();
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> getIterator() {
        return new LinkedListIterator<>(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Link<T> current = first;
        while (current != null) {
            action.accept(current.getObject());
            current = current.getNext();
        }
    }
}
