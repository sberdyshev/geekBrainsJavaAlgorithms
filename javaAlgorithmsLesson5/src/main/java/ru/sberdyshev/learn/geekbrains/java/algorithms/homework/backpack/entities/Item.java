package ru.sberdyshev.learn.geekbrains.java.algorithms.homework.backpack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {
    private String name;
    private int weight;
    private int cost;
}
