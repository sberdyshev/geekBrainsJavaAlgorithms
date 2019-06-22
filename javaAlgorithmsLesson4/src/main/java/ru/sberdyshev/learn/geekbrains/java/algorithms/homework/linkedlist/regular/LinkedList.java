package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular;

import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.link.Link;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.link.LinkImpl;
//todo add logger
//todo add javadoc
public class LinkedList<T> implements List<T> {
    private Link<T> first;

    public LinkedList() {
        this.first = null;
    }

    public LinkedList(T... elements) {
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
    }

    @Override
    public T delete() {
        if (!isEmpty()) {
            Link<T> deletedElement = first;
            first = first.getNext();
            return deletedElement.getObject();
        } else {
            return null;
        }
    }

    @Override
    public T get() {
        if (!isEmpty()) {
            return first.getObject();
        } else {
            return null;
        }
    }
}
