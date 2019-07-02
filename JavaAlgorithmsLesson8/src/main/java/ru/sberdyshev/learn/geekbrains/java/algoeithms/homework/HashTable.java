package ru.sberdyshev.learn.geekbrains.java.algoeithms.homework;

import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private static final int LEGTH_OF_FIRST_PART_DURING_OUTPUT = 30;
    private int base;
    private List<Word>[] table;

    public HashTable(int base) {
        this.table = new LinkedList[base];
        this.base = base;
    }

    public int add(Word newWord) {
        int reducedHash = (int) (newWord.getHash() % base);
        List<Word> collisions = table[reducedHash];
        if (collisions == null) {
            collisions = new LinkedList<>();
            table[reducedHash] = collisions;
        }
        for (Word savedWord : collisions) {
            if (savedWord.getHash() == newWord.getHash()) {
                collisions.remove(savedWord);
            }
        }
        collisions.add(newWord);
        return reducedHash;
    }

    public Word find(double hash) {
        int reducedHash = (int) (hash % base);
        List<Word> collisions = table[reducedHash];
        if (collisions == null) {
            return null;
        }
        for (Word word : collisions) {
            if (word.getHash() == hash) {
                return word;
            }
        }
        return null;
    }

    public Word delete(Word word) {
        return delete(word.getHash());
    }

    public Word delete(double hash) {
        int reducedHash = (int) (hash % base);
        List<Word> collisions = table[reducedHash];
        if (collisions == null) {
            return null;
        }
        for (Word word : collisions) {
            if (word.getHash() == hash) {
                collisions.remove(word);
                return word;
            }
        }
        return null;
    }

    public boolean contains(Word searchWord) {
        double searchedWordHash = searchWord.getHash();
        int reducedHash = (int) (searchedWordHash % base);
        List<Word> collisions = table[reducedHash];
        if (collisions == null) {
            return false;
        }
        for (Word savedWord : collisions) {
            if (savedWord.getHash() == searchedWordHash) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        int groupNumber = 1;
        for (int i = 0; i < table.length; i++) {
            List<Word> collisions = table[i];
            if (collisions != null) {
                System.out.println("--------------------------");
                System.out.println("GROUP #" + groupNumber);
                System.out.println("INDEX INSIDE THE ARRAY #" + i);
                for (Word word : collisions) {
                    String firstPart = "WORD: \"" + word + "\"";
                    int firstPartLength = firstPart.length();
                    if (firstPartLength < LEGTH_OF_FIRST_PART_DURING_OUTPUT) {
                        char[] additionalSpaces = new char[LEGTH_OF_FIRST_PART_DURING_OUTPUT - firstPartLength];
                        for (int j = 0; j < additionalSpaces.length; j++) {
                            additionalSpaces[j] = ' ';
                        }
                        firstPart = firstPart + new String(additionalSpaces);
                    }
                    System.out.println(firstPart + "REDUCED HASH: " + (int) (word.getHash() % base) + ", FULL HASH: " + word.getHash());
                }
                System.out.println("--------------------------");
                groupNumber++;
            }
        }
    }
}
