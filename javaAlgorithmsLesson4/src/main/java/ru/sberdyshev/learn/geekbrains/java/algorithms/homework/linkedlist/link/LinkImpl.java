package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.link;

public class LinkImpl<T> implements Link<T> {

    private T object;
    private Link<T> next;

    public LinkImpl(T object) {
        this.object = object;
    }

    public LinkImpl(T object, Link<T> next) {
        this.object = object;
        this.next = next;
    }

    @Override
    public boolean hasNext() {
        if (next != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Link getNext() {
        return next;
    }

    @Override
    public void setNext(Link next) {
        this.next = next;
    }

    @Override
    public T getObject() {
        return object;
    }

    @Override
    public void setObject(T object) {
        this.object = object;
    }
}
