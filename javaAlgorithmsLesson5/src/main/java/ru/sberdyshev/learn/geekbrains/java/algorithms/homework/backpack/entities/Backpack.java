package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.backpack.entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backpack {
    @Getter
    private int maxWeight;
    @Getter
    private int itemsWeight;
    @Getter
    private int itemsCost;
    private List<Item> itemInBag;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
        this.itemsWeight = 0;
        this.itemsCost = 0;
        this.itemInBag = new ArrayList<>();
    }

    public List<Item> getItemsInBag() {
        return new ArrayList<>(itemInBag);
    }

    public void addItem(Item item) {
        itemInBag.add(item);
        itemsWeight += item.getWeight();
        itemsCost += item.getCost();
    }


    public void addItems(List<Item> items) {
        for (Item item : items) {
            itemInBag.add(item);
            itemsWeight += item.getWeight();
            itemsCost += item.getCost();
        }
    }

    public boolean areItemFit() {
        return itemsWeight <= maxWeight;
    }

    private int gatherOptions(int readElement, List<Item> allItems, List<Item> usedItems, List<Backpack> options) {
        int amountOfCalls = 1;
        for (int i = readElement; i < allItems.size(); i++) {
            Item item = allItems.get(i);
            readElement += 1;
            List<Item> newUsedItems = new ArrayList<>(usedItems);
            newUsedItems.add(item);
            Backpack option = new Backpack(maxWeight);
            option.addItems(newUsedItems);
            options.add(option);
            amountOfCalls += gatherOptions(readElement, allItems, newUsedItems, options);
        }
        return amountOfCalls;
    }

    public List<Backpack> getOptimalBackpackOptions(List<Item> possibleItems) {
        List<Backpack> options = new LinkedList<>();
        List<Item> usedItems = new ArrayList<>();
        Integer amountOfCalls = gatherOptions(0, possibleItems, usedItems, options);
        System.out.println("-------------------------------------------------------");
        System.out.println("For a backpack with weight \"" + maxWeight + "\" made " + amountOfCalls + " function calls.");
        System.out.println("For a backpack with weight \"" + maxWeight + "\" there are " + options.size() + " options.");
        List<Backpack> theMostExpensiveOptions = new LinkedList<>();
        Backpack theMostExpensiveOption = new Backpack(0);
        for (Backpack currentOption : options) {
            if (currentOption.areItemFit()) {
                if (currentOption.getItemsCost() > theMostExpensiveOption.getItemsCost()) {
                    theMostExpensiveOption = currentOption;
                    theMostExpensiveOptions = new LinkedList<>();
                    theMostExpensiveOptions.add(currentOption);
                } else if (currentOption.getItemsCost() == theMostExpensiveOption.getItemsCost()) {
                    theMostExpensiveOptions.add(currentOption);
                }
            }
        }
        return theMostExpensiveOptions;
    }
}
