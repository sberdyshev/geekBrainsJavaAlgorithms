package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.regular.link;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkImplTest {
    private Link<String> linkNoNext;
    private Link<String> linkWithNext;

    @BeforeEach
    public void setUp() {
        linkNoNext = new LinkImpl<>("test");
        linkWithNext = new LinkImpl<>("test", linkNoNext);
    }

    @Test
    void hasNextCheckOnLinkNoNext() {
        boolean expectedresult = false;
        boolean actualResult = linkNoNext.hasNext();
        assertEquals(expectedresult, actualResult);
    }

    @Test
    void hasNextCheckOnLinkWithNext() {
        boolean expectedresult = true;
        boolean actualResult = linkWithNext.hasNext();
        assertEquals(expectedresult, actualResult);
    }
}