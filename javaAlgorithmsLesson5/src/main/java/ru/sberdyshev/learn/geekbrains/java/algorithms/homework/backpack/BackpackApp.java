package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.backpack;

import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.backpack.entities.Backpack;
import ru.sberdyshev.learn.geekbrains.java.algorithms.homework.backpack.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class BackpackApp {
    public static void main(String[] args) {
        Item book = new Item("книга", 1, 600);
        Item binoculars = new Item("бинокль", 2, 5000);
        Item medkit = new Item("аптечка", 4, 1500);
        Item laptop = new Item("ноутбук", 2, 40000);
        Item pot = new Item("котелок", 1, 500);
        List<Item> allItems = new ArrayList<>();
        allItems.add(book);
        allItems.add(binoculars);
        allItems.add(medkit);
        allItems.add(laptop);
        allItems.add(pot);
        processBackpackOptions(1,allItems);
        processBackpackOptions(2,allItems);
        processBackpackOptions(3,allItems);
        processBackpackOptions(4,allItems);
        processBackpackOptions(5,allItems);
        processBackpackOptions(6,allItems);
        processBackpackOptions(7,allItems);
        processBackpackOptions(8,allItems);
        processBackpackOptions(9,allItems);
        processBackpackOptions(10,allItems);
        processBackpackOptions(11,allItems);

    }

    private static void processBackpackOptions(int maxWeight, List<Item> allItems) {
        Backpack backpack = new Backpack(maxWeight);
        List<Backpack> optimalBackpackOptions = backpack.getOptimalBackpackOptions(allItems);
        System.out.println("-------------------------------------------------------");
        System.out.println("For a backpack with weight \"" + maxWeight + "\" optimal options are:");
        System.out.println("-------------------------------------------------------");
        int i = 1;
        for (Backpack optimalBackpack : optimalBackpackOptions) {
            System.out.println("Option #" + i);
            System.out.println("*****");
            for (Item item : optimalBackpack.getItemsInBag()) {
                System.out.println(item.getName());
            }
            System.out.println("*****");
        }
    }
}
