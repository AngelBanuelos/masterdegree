/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.mac.session5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author angel_banuelos
 */
public class GraphMain {

    public static void main(String[] args) throws Exception {

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Grafos\n Ingresa el numero total de vertices de el grafo");
        String n = bufferRead.readLine();
        int nodes = Integer.parseInt(n);
        Graph graph = new Graph(nodes);
        int i = 0;
        while (i < nodes) {
            System.out.println("Ingresa el nombre o etiqueta del vertice " + (i + 1));
            String label = bufferRead.readLine();
            graph.addNode(label);
            i++;
        }
        int next = 0;
        do {

            System.out.println("Ingresa la(s) arista(s) de cada node siguiendo la forma e.g. VerticeA,VerticeB,NumeroDeArista (A,B,1)");
            String edges = bufferRead.readLine();
            String[] helper = edges.split(",");
            try {
                graph.addEdgeByLabel(helper[0], helper[1], Integer.parseInt(helper[2]));
            } catch (Exception e) {
                System.err.println("Error, " + e.getMessage());
            }
            System.out.println("Deseas ingresar un vertice mas? Si=1, No=0");
            String other = bufferRead.readLine();
            next = Integer.parseInt(other);
        } while (next != 0);
        System.out.println("Imprimiendo Matriz de adyacencia");
        graph.printAdjacencyMatrix();

        System.out.println("Numero de Aristas: " + GraphUtils.countEdges(graph.getAdjacencyMatrix()));

        System.out.println("Vertices: " + graph);
        System.out.println("Is bipartite? ");
        System.out.println(GraphUtils.isBipartite(graph.getVerticesArray()));
        if (GraphUtils.isBipartite(graph.getVerticesArray())) {
            System.out.println("Subconjuntos bipartitas seran mostrados");
            GraphUtils.printBipartiteConjuntions(graph.getVerticesArray());
        }

    }

}
