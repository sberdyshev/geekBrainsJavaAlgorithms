package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular;

import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.List;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.link.Link;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.link.LinkImpl;

public class LinkedListRegular<T> implements List<T> {
    private Link<T> first;

    public LinkedListRegular() {
        this.first = null;
    }

    public LinkedListRegular(T... elements) {
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
