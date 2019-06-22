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
        if (first == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insert(T element) {
        Link<T> newElement = new LinkImpl<T>(element);
        newElement.setNext(first);
        first = newElement;
    }

    @Override
    public T delete() {
        if (first != null) {
            Link<T> deletedElement = first;
            first = first.getNext();
            return deletedElement.getObject();
        } else {
            return null;
        }
    }

    @Override
    public T get() {
        if (first != null) {
            return first.getObject();
        } else {
            return null;
        }
    }
}
