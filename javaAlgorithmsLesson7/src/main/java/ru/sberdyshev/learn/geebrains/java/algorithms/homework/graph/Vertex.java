package ru.sberdyshev.learn.geebrains.java.algorithms.homework.graph;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
    private String name;
    private List<Vertex> connectedVertexes;
    private boolean visited;

    private Vertex() {
    }

    private Vertex(String name) {
        this.name = name;
        this.connectedVertexes = new LinkedList<>();
    }

    public static Vertex createNewWithName(String name) {
        return new Vertex(name);
    }

    public void visit() {
        this.visited = true;
    }

    public boolean hasNotVisitedConnections() {
        for (Vertex vertex : connectedVertexes) {
            if (!vertex.isVisited()) {
                return true;
            }
        }
        return false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void connectTo(Vertex anotherVertex) {
        if (anotherVertex == null) {
            throw new IllegalArgumentException("Can't connect to non existing Vertex");
        }
        if (this.isAlreadyConnectedTo(anotherVertex)) {
            return;
        }
        connectedVertexes.add(anotherVertex);
        anotherVertex.connectTo(this);
    }

    public String toString() {
        return name;
    }

    private boolean isAlreadyConnectedTo(Vertex anotherVertex) {
        for (Vertex vertex : connectedVertexes) {
            if (vertex == anotherVertex) {
                return true;
            }
        }
        return false;
    }

    public String name() {
        return this.name;
    }

    public void clearVisit() {
        visited = false;
    }

    public List<Vertex> edges() {
        return new LinkedList<>(connectedVertexes);
    }
}
