package ru.sberdyshev.learn.geekbrains.java.algoeithms.homework;

public class Word {
    private final String word;
    private final double hash;

    public Word(String word) {
        this.word = word;
        this.hash = calculateHash();
    }

    public double getHash() {
        return hash;
    }

    private double calculateHash() {
        double hash = 11;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            hash += array[i] * Math.pow(26, (array.length - i - 1));
        }
        return hash;
    }

    public String toString() {
        return word;
    }
}
