package ru.sb.geekbrains.algorithms.tree;

import lombok.Getter;

@Getter
public enum NodeType {
    LEFT_CHILD("L"), RIGHT_CHILD("R"), ROOT("Root"), NONE("None");

    private String shortName;

    NodeType(String shortName) {
        this.shortName = shortName;
    }
}
