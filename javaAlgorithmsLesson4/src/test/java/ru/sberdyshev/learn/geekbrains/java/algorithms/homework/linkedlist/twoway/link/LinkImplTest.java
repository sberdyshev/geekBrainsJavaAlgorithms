package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.linkedlist.twoway.link;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkImplTest {

    private Link<String> linkNoNext;
    private Link<String> linkWithNext;
    private Link<String> linkNoPrevious;
    private Link<String> linkWithPrevious;

    @BeforeEach
    public void setUp() {
        linkNoNext = new LinkImpl<>("test");
        linkWithNext = new LinkImpl<>("test", null, linkNoNext);
        linkNoPrevious = new LinkImpl<>("test");
        linkWithPrevious = new LinkImpl<>("test", linkNoPrevious, null);
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

    @Test
    void hasPreviousCheckOnLinkNoNext() {
        boolean expectedresult = false;
        boolean actualResult = linkNoPrevious.hasPrevious();
        assertEquals(expectedresult, actualResult);
    }

    @Test
    void hasPreviousCheckOnLinkWithNext() {
        boolean expectedresult = true;
        boolean actualResult = linkWithPrevious.hasPrevious();
        assertEquals(expectedresult, actualResult);
    }
}