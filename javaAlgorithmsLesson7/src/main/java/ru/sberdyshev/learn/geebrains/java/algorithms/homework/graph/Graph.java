package ru.sberdyshev.learn.geebrains.java.algorithms.homework.graph;

import java.util.*;

public class Graph {
    private List<Vertex> vertexes;

    public static void main(String[] args) {
        Vertex moscow = Vertex.createNewWithName("Москва");
        Vertex tula = Vertex.createNewWithName("Тула");
        Vertex ryazan = Vertex.createNewWithName("Рязань");
        Vertex kaluga = Vertex.createNewWithName("Калуга");
        Vertex tambov = Vertex.createNewWithName("Тамбов");
        Vertex lipetsk = Vertex.createNewWithName("Липецк");
        Vertex orel = Vertex.createNewWithName("Орел");
        Vertex saratov = Vertex.createNewWithName("Саратов");
        Vertex kursk = Vertex.createNewWithName("Курск");
        Vertex voronej = Vertex.createNewWithName("Воронеж");
        Vertex vologda = Vertex.createNewWithName("Вологда");
        moscow.connectTo(tula);
        moscow.connectTo(ryazan);
        moscow.connectTo(kaluga);
        tula.connectTo(lipetsk);
        lipetsk.connectTo(voronej);
        ryazan.connectTo(tambov);
        tambov.connectTo(saratov);
        saratov.connectTo(voronej);
        kaluga.connectTo(orel);
        orel.connectTo(kursk);
        kursk.connectTo(voronej);
        Graph graph = new Graph();
        graph.addVertex(moscow);
        graph.addVertex(tula);
        graph.addVertex(lipetsk);
        graph.addVertex(ryazan);
        graph.addVertex(tambov);
        graph.addVertex(saratov);
        graph.addVertex(kaluga);
        graph.addVertex(orel);
        graph.addVertex(kursk);
        graph.addVertex(voronej);
        graph.printShortestPassageBetweenVertexes(moscow, tambov);
        graph.printShortestPassageBetweenVertexes(moscow, voronej);
        graph.printShortestPassageBetweenVertexes(ryazan, lipetsk);
        graph.printShortestPassageBetweenVertexes(orel, lipetsk);
        graph.printShortestPassageBetweenVertexes(orel, vologda);
    }

    public void printPossibleWays(Vertex startingPoint) {
        clearVisits();
        startingPoint.visit();
        String visitedVertexes = startingPoint.name();
        if (startingPoint.hasNotVisitedConnections()) {
            for (Vertex currentVertex : startingPoint.edges()) {
                if (!currentVertex.isVisited()) {
                    String renewedVisitedVertexes = visitedVertexes + " -> " + currentVertex.name();
                    printPossibleWays(currentVertex, renewedVisitedVertexes);
                }
            }
        } else {
            System.out.println(startingPoint.name());
        }
        clearVisits();
    }

    private void printPossibleWays(Vertex nextPoint, String visitedVertexes) {
        nextPoint.visit();
        if (nextPoint.hasNotVisitedConnections()) {
            for (Vertex currentVertex : nextPoint.edges()) {
                if (!currentVertex.isVisited()) {
                    String renewedVisitedVertexes = visitedVertexes + " -> " + currentVertex.name();
                    printPossibleWays(currentVertex, renewedVisitedVertexes);
                }
            }
        } else {
            System.out.println(visitedVertexes + " -> " + nextPoint.name());
        }
    }

    private void clearVisits() {
        for (Vertex vertex : vertexes) {
            vertex.clearVisit();
        }
    }

    public void printShortestPassageBetweenVertexes(Vertex startingVertex, Vertex destinationVertex) {
        clearVisits();
        Map<Vertex, Queue<Vertex>> startingVertexes = new HashMap<>();
        startingVertexes.put(startingVertex, new LinkedList<>());
        Queue<Vertex> shortestPassage = findShortestPassage(startingVertexes, destinationVertex);
        if (shortestPassage != null && !shortestPassage.isEmpty()) {
            System.out.print("Кратчайший путь между городами \"" + startingVertex + "\" и \"" + destinationVertex + "\": ");
            System.out.print(shortestPassage.remove());
            while (!shortestPassage.isEmpty()) {
                System.out.print(" -> " + shortestPassage.remove());
            }
        } else {
            System.out.println("Не существует пути между городами \"" + startingVertex + "\" и \"" + destinationVertex + "\".");
        }
        System.out.println();
        clearVisits();
    }

    /**
     * Самый короткий путь
     *
     * @param startingVertexes  - мапа. Содержит проверяемые вершины и соответствующие им реализованные на очередях списки узлов, по которым программа дошла до проверяемой вершины.
     * @param destinationVertex - целевая вершина
     * @return
     */
    private Queue<Vertex> findShortestPassage(Map<Vertex, Queue<Vertex>> startingVertexes, Vertex destinationVertex) {
        Map<Vertex, Queue<Vertex>> newStartingVertexes = new HashMap<>();
        for (Map.Entry<Vertex, Queue<Vertex>> entry : startingVertexes.entrySet()) {
            if (!entry.getKey().isVisited() && entry.getKey().equals(destinationVertex)) {
                entry.getValue().add(entry.getKey());
                return entry.getValue();
            }
            for (Vertex vertex : entry.getKey().edges()) {
                if (!vertex.isVisited()) {
                    Queue<Vertex> newQueue = new LinkedList<>(entry.getValue());
                    newQueue.add(entry.getKey());
                    newStartingVertexes.put(vertex, newQueue);
                }
            }
            entry.getKey().visit();
        }
        Queue<Vertex> result = null;
        if (!newStartingVertexes.isEmpty()) {
            result = findShortestPassage(newStartingVertexes, destinationVertex);
        }
        return result;
    }

    private void addVertex(Vertex newVertex) {
        if (vertexes == null) {
            vertexes = new ArrayList<>();
        }
        if (newVertex == null) {
            throw new IllegalArgumentException("Can't add non existing vertex");
        }
        if (this.doesHaveSuchVertex(newVertex)) {
            return;
        }
        vertexes.add(newVertex);
    }

    public boolean doesHaveSuchVertex(Vertex checkedVertex) {
        for (Vertex addedVertex : vertexes) {
            if (addedVertex == checkedVertex) {
                return true;
            }
        }
        return false;
    }
}
