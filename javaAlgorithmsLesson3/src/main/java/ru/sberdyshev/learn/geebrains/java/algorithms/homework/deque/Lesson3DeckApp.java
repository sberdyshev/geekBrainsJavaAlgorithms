package ru.sberdyshev.learn.geebrains.java.algorithms.homework.deque;

import ru.sberdyshev.learn.geebrains.java.algorithms.homework.deque.deque.Deque;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.deque.deque.DequeImpl;

/**
 * @author sberdyshev
 */
public class Lesson3DeckApp {
    public static void main(String[] args) {
        Deque<Integer> dqS = new DequeImpl<>(Integer.class, "A Deque");
        dqS.isEmpty();
        dqS.writeToHead(1);
        dqS.writeToTail(2);
        dqS.writeToHead(3);
        dqS.readAtTail();
        dqS.writeToTail(4);
        dqS.writeToHead(5);
        dqS.browseAtHead();
        dqS.browseAtTail();
        dqS.isEmpty();
    }
}
