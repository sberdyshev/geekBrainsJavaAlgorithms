package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway.link;

//todo add logger
//todo add javadoc
public class LinkImpl<T> implements Link<T> {

    private T object;
    private Link<T> next;
    private Link<T> previous;

    public LinkImpl(T object) {
        this.object = object;
    }

    public LinkImpl(T object, Link<T> previous, Link<T> next) {
        this.object = object;
        this.previous = previous;
        this.next = next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public boolean hasPrevious() {
        return previous != null;
    }

    @Override
    public Link<T> getNext() {
        return next;
    }

    @Override
    public void setNext(Link<T> next) {
        this.next = next;
    }

    @Override
    public Link<T> getPrevious() {
        return previous;
    }

    @Override
    public void setPrevious(Link<T> previous) {
        this.previous = previous;
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
