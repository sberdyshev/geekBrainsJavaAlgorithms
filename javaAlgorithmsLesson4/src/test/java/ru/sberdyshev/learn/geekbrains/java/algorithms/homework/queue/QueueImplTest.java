package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueImplTest {
    private static Queue<String> queueString;
    private static Queue<Integer> queueInteger;
    private static Queue<String> queueStringEmpty;
    private static Queue<Integer> queueIntegerEmpty;

    @BeforeEach
    public void setUpTest() {
        queueString = new QueueImpl<>("String queue", "Test1", "Test2", "Test456");
        queueStringEmpty = new QueueImpl<>("String empty queue");
        queueInteger = new QueueImpl<>("Integer queue", 10, 59, 1111, 123);
        queueIntegerEmpty = new QueueImpl<>("Integer empty queue");
    }

    @Test
    void readFromStringQueue() {
        String expectedValueFirstIteration = "Test1";
        Integer expectedQueueSizeFirstIteration = 2;
        String expectedValueSecondIteration = "Test2";
        Integer expectedQueueSizeSecondIteration = 1;
        String actualValueFirstIteration = queueString.read();
        Integer actualQueueSizeFirstIteration = queueString.getSize();
        String actualValueSecondIteration = queueString.read();
        Integer actualQueueSizeSecondIteration = queueString.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }

    @Test
    void readFromStringQueueTillItIsEmpty() {
        String expectedValueFirstIteration = "Test1";
        Integer expectedQueueSizeFirstIteration = 2;
        String expectedValueSecondIteration = "Test2";
        Integer expectedQueueSizeSecondIteration = 1;
        String expectedValueThirdIteration = "Test456";
        Integer expectedQueueSizeThirdIteration = 0;
        String expectedValueFourthIteration = null;
        Integer expectedQueueSizeFourthIteration = 0;
        String actualValueFirstIteration = queueString.read();
        Integer actualQueueSizeFirstIteration = queueString.getSize();
        String actualValueSecondIteration = queueString.read();
        Integer actualQueueSizeSecondIteration = queueString.getSize();
        String actualValueThirdIteration = queueString.read();
        Integer actualQueueSizeThirdIteration = queueString.getSize();
        String actualValueFourthIteration = queueString.read();
        Integer actualQueueSizeFourthIteration = queueString.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
        assertEquals(expectedValueThirdIteration, actualValueThirdIteration);
        assertEquals(expectedQueueSizeThirdIteration, actualQueueSizeThirdIteration);
        assertEquals(expectedValueFourthIteration, actualValueFourthIteration);
        assertEquals(expectedQueueSizeFourthIteration, actualQueueSizeFourthIteration);
    }

    @Test
    void readFromEmptyStringQueue() {
        String expectedValueFirstIteration = null;
        Integer expectedQueueSizeFirstIteration = 0;
        String expectedValueSecondIteration = null;
        Integer expectedQueueSizeSecondIteration = 0;
        String actualValueFirstIteration = queueStringEmpty.read();
        Integer actualQueueSizeFirstIteration = queueStringEmpty.getSize();
        String actualValueSecondIteration = queueStringEmpty.read();
        Integer actualQueueSizeSecondIteration = queueStringEmpty.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }

    @Test
    void readFromIntegerQueue() {
        Integer expectedValueFirstIteration = 10;
        Integer expectedQueueSizeFirstIteration = 3;
        Integer expectedValueSecondIteration = 59;
        Integer expectedQueueSizeSecondIteration = 2;
        Integer actualValueFirstIteration = queueInteger.read();
        Integer actualQueueSizeFirstIteration = queueInteger.getSize();
        Integer actualValueSecondIteration = queueInteger.read();
        Integer actualQueueSizeSecondIteration = queueInteger.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }

    @Test
    void readFromEmptyIntegerQueue() {
        Integer expectedValueFirstIteration = null;
        Integer expectedQueueSizeFirstIteration = 0;
        Integer expectedValueSecondIteration = null;
        Integer expectedQueueSizeSecondIteration = 0;
        Integer actualValueFirstIteration = queueIntegerEmpty.read();
        Integer actualQueueSizeFirstIteration = queueIntegerEmpty.getSize();
        Integer actualValueSecondIteration = queueIntegerEmpty.read();
        Integer actualQueueSizeSecondIteration = queueIntegerEmpty.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }

    @Test
    void writeToStringQueue() {
        String valueToWrite = "new value";
        String expectedValueBeforeIteration = "Test1";
        Integer expectedQueueSizeBeforeIteration = 3;
        String expectedValueAfterIteration = "Test1";
        Integer expectedQueueSizeAfterIteration = 4;
        String actualValueBeforeIteration = queueString.browse();
        Integer actualQueueSizeBeforeIteration = queueString.getSize();
        queueString.write(valueToWrite);
        String actualValueAfterIteration = queueString.browse();
        Integer actualQueueSizeAfterIteration = queueString.getSize();
        assertEquals(expectedValueBeforeIteration, actualValueBeforeIteration);
        assertEquals(expectedQueueSizeBeforeIteration, actualQueueSizeBeforeIteration);
        assertEquals(expectedValueAfterIteration, actualValueAfterIteration);
        assertEquals(expectedQueueSizeAfterIteration, actualQueueSizeAfterIteration);
    }

    @Test
    void writeToEmptyStringQueue() {
        String valueToWrite = "new value";
        String expectedValueBeforeIteration = null;
        Integer expectedQueueSizeBeforeIteration = 0;
        String expectedValueAfterIteration = "new value";
        Integer expectedQueueSizeAfterIteration = 1;
        String actualValueBeforeIteration = queueStringEmpty.browse();
        Integer actualQueueSizeBeforeIteration = queueStringEmpty.getSize();
        queueStringEmpty.write(valueToWrite);
        String actualValueAfterIteration = queueStringEmpty.browse();
        Integer actualQueueSizeAfterIteration = queueStringEmpty.getSize();
        assertEquals(expectedValueBeforeIteration, actualValueBeforeIteration);
        assertEquals(expectedQueueSizeBeforeIteration, actualQueueSizeBeforeIteration);
        assertEquals(expectedValueAfterIteration, actualValueAfterIteration);
        assertEquals(expectedQueueSizeAfterIteration, actualQueueSizeAfterIteration);
    }

    @Test
    void writeToIntegerQueue() {
        Integer valueToWrite = 999;
        Integer expectedValueBeforeIteration = 10;
        Integer expectedQueueSizeBeforeIteration = 4;
        Integer expectedValueAfterIteration = 10;
        Integer expectedQueueSizeAfterIteration = 5;
        Integer actualValueBeforeIteration = queueInteger.browse();
        Integer actualQueueSizeBeforeIteration = queueInteger.getSize();
        queueInteger.write(valueToWrite);
        Integer actualValueAfterIteration = queueInteger.browse();
        Integer actualQueueSizeAfterIteration = queueInteger.getSize();
        assertEquals(expectedValueBeforeIteration, actualValueBeforeIteration);
        assertEquals(expectedQueueSizeBeforeIteration, actualQueueSizeBeforeIteration);
        assertEquals(expectedValueAfterIteration, actualValueAfterIteration);
        assertEquals(expectedQueueSizeAfterIteration, actualQueueSizeAfterIteration);
    }

    @Test
    void writeToEmptyIntegerQueue() {
        Integer valueToWrite = 999;
        Integer expectedValueBeforeIteration = null;
        Integer expectedQueueSizeBeforeIteration = 0;
        Integer expectedValueAfterIteration = 999;
        Integer expectedQueueSizeAfterIteration = 1;
        Integer actualValueBeforeIteration = queueIntegerEmpty.browse();
        Integer actualQueueSizeBeforeIteration = queueIntegerEmpty.getSize();
        queueIntegerEmpty.write(valueToWrite);
        Integer actualValueAfterIteration = queueIntegerEmpty.browse();
        Integer actualQueueSizeAfterIteration = queueIntegerEmpty.getSize();
        assertEquals(expectedValueBeforeIteration, actualValueBeforeIteration);
        assertEquals(expectedQueueSizeBeforeIteration, actualQueueSizeBeforeIteration);
        assertEquals(expectedValueAfterIteration, actualValueAfterIteration);
        assertEquals(expectedQueueSizeAfterIteration, actualQueueSizeAfterIteration);
    }


    @Test
    void checkArrayRecreationIntegerQueue() {
        Integer valueToWriteFirst = 888;
        Integer valueToWriteSecond = 222;
        Integer valueToWriteThird = 333;
        Integer valueToWriteFourth = 444;
        Integer valueToWriteFifth = 555;
        Integer valueToWriteSixth = 666;
        Integer valueToWriteSeventh = 777;
        Integer expectedValueBeforeTest = 10;
        Integer expectedQueueSizeBeforeTest = 4;
        Integer expectedValueAfterFirstAdds = 10;
        Integer expectedQueueSizeAfterFirstAdds = 6;
        Integer expectedValueAfterAllReads = 123;
        Integer expectedQueueSizeAfterAllReads = 3;
        Integer expectedValueAfterLastAdds = 123;
        Integer expectedQueueSizeAfterLastAdds = 8;
        Integer actualValueBeforeTest = queueInteger.browse();
        Integer actualQueueSizeBeforeTest = queueInteger.getSize();
        queueInteger.write(valueToWriteFirst);
        queueInteger.write(valueToWriteSecond);
        Integer actualValueAfterFirstAdds = queueInteger.browse();
        Integer actualQueueSizeAfterFirstAdds = queueInteger.getSize();
        queueInteger.read();
        queueInteger.read();
        queueInteger.read();
        Integer actualValueAfterAllReads = queueInteger.browse();
        Integer actualQueueSizeAfterAllReads = queueInteger.getSize();
        queueInteger.write(valueToWriteThird);
        queueInteger.write(valueToWriteFourth);
        queueInteger.write(valueToWriteFifth);
        queueInteger.write(valueToWriteSixth);
        queueInteger.write(valueToWriteSeventh);
        Integer actualValueAfterLastAdds = queueInteger.browse();
        Integer actualQueueSizeAfterLastAdds = queueInteger.getSize();
        assertEquals(expectedValueBeforeTest, actualValueBeforeTest);
        assertEquals(expectedQueueSizeBeforeTest, actualQueueSizeBeforeTest);
        assertEquals(expectedValueAfterFirstAdds, actualValueAfterFirstAdds);
        assertEquals(expectedQueueSizeAfterFirstAdds, actualQueueSizeAfterFirstAdds);
        assertEquals(expectedValueAfterAllReads, actualValueAfterAllReads);
        assertEquals(expectedQueueSizeAfterAllReads, actualQueueSizeAfterAllReads);
        assertEquals(expectedValueAfterLastAdds, actualValueAfterLastAdds);
        assertEquals(expectedQueueSizeAfterLastAdds, actualQueueSizeAfterLastAdds);
    }


    @Test
    void browseFromStringQueue() {
        String expectedValueFirstIteration = "Test1";
        Integer expectedQueueSizeFirstIteration = 3;
        String expectedValueSecondIteration = "Test1";
        Integer expectedQueueSizeSecondIteration = 3;
        String actualValueFirstIteration = queueString.browse();
        Integer actualQueueSizeFirstIteration = queueString.getSize();
        String actualValueSecondIteration = queueString.browse();
        Integer actualQueueSizeSecondIteration = queueString.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }

    @Test
    void browseFromEmptyStringQueue() {
        String expectedValueFirstIteration = null;
        Integer expectedQueueSizeFirstIteration = 0;
        String expectedValueSecondIteration = null;
        Integer expectedQueueSizeSecondIteration = 0;
        String actualValueFirstIteration = queueStringEmpty.browse();
        Integer actualQueueSizeFirstIteration = queueStringEmpty.getSize();
        String actualValueSecondIteration = queueStringEmpty.browse();
        Integer actualQueueSizeSecondIteration = queueStringEmpty.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }

    @Test
    void browseFromIntegerQueue() {
        Integer expectedValueFirstIteration = 10;
        Integer expectedQueueSizeFirstIteration = 4;
        Integer expectedValueSecondIteration = 10;
        Integer expectedQueueSizeSecondIteration = 4;
        Integer actualValueFirstIteration = queueInteger.browse();
        Integer actualQueueSizeFirstIteration = queueInteger.getSize();
        Integer actualValueSecondIteration = queueInteger.browse();
        Integer actualQueueSizeSecondIteration = queueInteger.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }

    @Test
    void browseFromEmptyIntegerQueue() {
        Integer expectedValueFirstIteration = null;
        Integer expectedQueueSizeFirstIteration = 0;
        Integer expectedValueSecondIteration = null;
        Integer expectedQueueSizeSecondIteration = 0;
        Integer actualValueFirstIteration = queueIntegerEmpty.browse();
        Integer actualQueueSizeFirstIteration = queueIntegerEmpty.getSize();
        Integer actualValueSecondIteration = queueIntegerEmpty.browse();
        Integer actualQueueSizeSecondIteration = queueIntegerEmpty.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }

    @Test
    void isEmptyStringQueue() {
        boolean expectedValue = false;
        boolean actualValue = queueString.isEmpty();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isEmptyStringEmptyQueue() {
        boolean expectedValue = true;
        boolean actualValue = queueStringEmpty.isEmpty();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isEmptyIntegerQueue() {
        boolean expectedValue = false;
        boolean actualValue = queueInteger.isEmpty();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isEmptyIntegerEmptyQueue() {
        boolean expectedValue = true;
        boolean actualValue = queueIntegerEmpty.isEmpty();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getValuesStringQueue() {
        String[] expectedResults = {"Test1", "Test2", "Test456"};
        List<String> actualResults = queueString.getValues();
        assertEquals(expectedResults.length, actualResults.size());
        for (int i = 0; i < expectedResults.length; i++) {
            assertEquals(expectedResults[i], actualResults.get(i));
        }
    }

    @Test
    void getValuesStringEmptyQueue() {
        String[] expectedResults = {};
        List<String> actualResults = queueStringEmpty.getValues();
        assertEquals(expectedResults.length, actualResults.size());
    }

    @Test
    void getValuesIntegerQueue() {
        Integer[] expectedResults = {10, 59, 1111, 123};
        List<Integer> actualResults = queueInteger.getValues();
        assertEquals(expectedResults.length, actualResults.size());
        for (int i = 0; i < expectedResults.length; i++) {
            assertEquals(expectedResults[i], actualResults.get(i));
        }
    }

    @Test
    void getValuesIntegerEmptyQueue() {
        Integer[] expectedResults = {};
        List<Integer> actualResults = queueIntegerEmpty.getValues();
        assertEquals(expectedResults.length, actualResults.size());
    }

    @Test
    void getSizeStringQueue() {
        Integer expectedValue = 3;
        Integer actualValue = queueString.getSize();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getSizeStringEmptyQueue() {
        Integer expectedValue = 0;
        Integer actualValue = queueStringEmpty.getSize();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getSizeIntegerQueue() {
        Integer expectedValue = 4;
        Integer actualValue = queueInteger.getSize();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getSizeIntegerEmptyQueue() {
        Integer expectedValue = 0;
        Integer actualValue = queueIntegerEmpty.getSize();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void clearIntegerQueue() {
        Integer expectedValueFirstIteration = 10;
        Integer expectedQueueSizeFirstIteration = 4;
        Integer expectedValueSecondIteration = null;
        Integer expectedQueueSizeSecondIteration = 0;
        Integer actualValueFirstIteration = queueInteger.browse();
        Integer actualQueueSizeFirstIteration = queueInteger.getSize();
        queueInteger.clear();
        Integer actualValueSecondIteration = queueInteger.browse();
        Integer actualQueueSizeSecondIteration = queueInteger.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }

    @Test
    void clearStringQueue() {
        String expectedValueFirstIteration = "Test1";
        Integer expectedQueueSizeFirstIteration = 3;
        String expectedValueSecondIteration = null;
        Integer expectedQueueSizeSecondIteration = 0;
        String actualValueFirstIteration = queueString.browse();
        Integer actualQueueSizeFirstIteration = queueString.getSize();
        queueString.clear();
        String actualValueSecondIteration = queueString.browse();
        Integer actualQueueSizeSecondIteration = queueString.getSize();
        assertEquals(expectedValueFirstIteration, actualValueFirstIteration);
        assertEquals(expectedQueueSizeFirstIteration, actualQueueSizeFirstIteration);
        assertEquals(expectedValueSecondIteration, actualValueSecondIteration);
        assertEquals(expectedQueueSizeSecondIteration, actualQueueSizeSecondIteration);
    }
}