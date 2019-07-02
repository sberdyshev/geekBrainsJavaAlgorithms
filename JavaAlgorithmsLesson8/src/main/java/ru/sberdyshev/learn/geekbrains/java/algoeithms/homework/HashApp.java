package ru.sberdyshev.learn.geekbrains.java.algoeithms.homework;

public class HashApp {
    public static void main(String[] args) {
        HashTable table = new HashTable(5);
        Word moscow = new Word("Moscow");
        Word moscow2 = new Word("Moscow");
        Word voronejWithLowerCaseV = new Word("voronej");
        Word voronejWithUpperCaseV = new Word("Voronej");
        Word apple = new Word("Apple");
        Word apple2 = new Word("Apple");
        Word apricot = new Word("Apricot");
        Word melioration = new Word("melioration");
        Word demystify = new Word("demystify");
        Word notAWord = new Word("Not a word");
        System.out.println("Adding \"Moscow\". Hash: " + table.add(moscow));
        System.out.println("Adding another variable with value \"Moscow\". Hash: " + table.add(moscow2));
        System.out.println("Adding \"voronej\". Hash: " + table.add(voronejWithLowerCaseV));
        System.out.println("Adding \"Apple\". Hash: " + table.add(apple));
        System.out.println("Adding \"Apricot\". Hash: " + table.add(apricot));
        System.out.println("Adding \"melioration\". Hash: " + table.add(melioration));
        System.out.println("Adding \"demystify\". Hash: " + table.add(demystify));
        table.display();
        System.out.println("HashTable contains \"Apricot\": " + table.contains(apricot));
        System.out.println("HashTable contains \"voronej\": " + table.contains(voronejWithLowerCaseV));
        System.out.println("HashTable contains \"Voronej\": " + table.contains(voronejWithUpperCaseV));
        System.out.println("HashTable contains \"Apple\" (checking via new variable) :" + table.contains(apple2));
        System.out.println("Deleting \"Not a word\" (wasn't added to the table). Deleted object: " + table.delete(notAWord));
        System.out.println("Deleting \"Apple\" (deleting via new variable). Deleted object: " + table.delete(apple2));
        table.display();
    }
}
