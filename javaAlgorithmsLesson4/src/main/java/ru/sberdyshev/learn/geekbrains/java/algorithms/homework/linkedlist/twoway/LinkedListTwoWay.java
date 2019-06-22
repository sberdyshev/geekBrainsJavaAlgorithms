package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway;

import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway.link.Link;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway.link.LinkImpl;

public class LinkedListTwoWay<T> implements ListTwoWays<T> {
    private Link<T> head;
    private Link<T> tail;

    public LinkedListTwoWay() {
        this.head = null;
        this.tail = null;
    }

    public LinkedListTwoWay(T... elements) {
        for (T element : elements) {
            insertToHead(element);
        }
    }

    @Override
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

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
    }

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
    }

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
        return deletedObject;
    }

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
        return deletedObject;
    }

    @Override
    public T getFromHead() {
        T returnedObject = null;
        if (head != null) {
            returnedObject = head.getObject();
        }
        return returnedObject;
    }

    @Override
    public T getFromTail() {
        T returnedObject = null;
        if (tail != null) {
            returnedObject = tail.getObject();
        }
        return returnedObject;
    }
}
