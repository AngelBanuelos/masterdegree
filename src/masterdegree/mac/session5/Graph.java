/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.mac.session5;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author angel_banuelos
 * @decription Programa que: a. capture un grafo de m vértices y de n aristas.
 * b. validar si el grafo dado es un grafo bipartito. c. en caso de ser grafo
 * bipartito, enumerar los conjuntos de vértices de cada conjunto.
 */
public class Graph {

    private int nodes;
    private Vertex[] verticesArray;
    private LinkedList<Vertex> verticesLinkedList; //Future Release
    private int[][] adjacencyMatrix;
    private int index = 0;

    public Graph(int nodes) {
        this.nodes = nodes;
        // Creating arries dimentions
        verticesArray = new Vertex[nodes];
        // adjacency matrix is always N*N
        adjacencyMatrix = new int[nodes][nodes];
        fillEmptyMatrix(adjacencyMatrix);
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public Vertex[] getVerticesArray() {
        return verticesArray;
    }

    /**
     * Population of the adjacency Matrix of 0 values..
     *
     * @param adjacencyMatrix
     */
    private void fillEmptyMatrix(int[][] adjacencyMatrix) {
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                adjacencyMatrix[i][j] = 0; //filling all values to zero 
            }
        }
    }

    /**
     * This method will add a new vertex into the matrix. Will throw an
     * Exception if all Vertex has been already entered or if the vertex has
     * been entered before.
     *
     * @param label
     * @throws Exception
     */
    public void addNode(String label) throws Exception {
        if (index >= nodes) { // throw an Exception if user try to enter more elements than given.
            throw new Exception("You have enter all vertex");
        }
        Vertex newVertex = new Vertex(label);
        if (GraphUtils.existsVertex(newVertex, verticesArray)) {
            throw new Exception("This Vertex already exists");
        }
        verticesArray[index] = newVertex;
        index++;
    }

    @Override
    public String toString() {
        return "Graph{" + "verticesArray=" + Arrays.toString(verticesArray) + '}';
    }

    /**
     * Method will look into the array a given label and return the selected
     * Vertex.
     *
     * @param label
     * @return The vertex label, if not found return null
     */
    public Vertex getVertexByLabel(String label) {
        Vertex vertex = null;
        for (int i = 0; i < nodes; i++) {
            if (label.equals(verticesArray[i].getLabel())) {
                vertex = verticesArray[i];
                break;
            }
        }
        return vertex;
    }

    private void addEdge(int start, int end, int edges) {
        adjacencyMatrix[start][end] = edges;
        adjacencyMatrix[end][start] = edges;
    }

    /**
     * This method with add the corresponding edges between to points
     *
     * @param labelStart reference from
     * @param labelEnd reference to
     * @param edges number of exiting edges between labelend and labelstart
     * point
     * @throws Exception
     */
    public void addEdgeByLabel(String labelStart, String labelEnd, int edges) throws Exception {
        Vertex startVertex = new Vertex(labelStart);
        Vertex endVertex = new Vertex(labelEnd);
        int start = -1, end = -1;

        for (int i = 0; i < nodes; i++) {
            if (verticesArray[i].equals(startVertex)) {
                start = i;
            } 
            if (verticesArray[i].equals(endVertex)) {
                end = i;
            }
            if(start != -1 && end != -1){
                break;
            }
        }

        if (start >= 0 && end >= 0) {
            addEdge(start, end, edges);
            if (!verticesArray[start].getBipartiteHelper().isEmpty()) {
                if (verticesArray[start].getBipartiteHelper().equals("A")) {
                    verticesArray[end].setBipartiteHelper("B");
                } else {
                    verticesArray[end].setBipartiteHelper("A");
                }
            } else {
                verticesArray[start].setBipartiteHelper("A");
            }
            if (!verticesArray[end].getBipartiteHelper().isEmpty()) {

            } else {
                verticesArray[end].setBipartiteHelper("B");

            }
            verticesArray[start].setEdges(edges);
            verticesArray[end].setEdges(edges);
        } else {
            throw new Exception("One of the given label do not exists");
        }
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(adjacencyMatrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
