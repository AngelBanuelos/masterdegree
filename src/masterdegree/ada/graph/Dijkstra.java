/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.graph;

import java.util.Stack;

/**
 *
 * @author Angel.Sahagun
 */
public class Dijkstra {

    public static double[] dijkstra(double[][] graph, int start) {
        Stack<Integer> nodeStack = new Stack();
        Stack<Double> distStack = new Stack();
        boolean[] visited = new boolean[graph.length];
        double[] minDistances = new double[graph.length];
        for (int i = 0; i < minDistances.length; i++) {
            minDistances[i] = GraphConstants.INF;
        }
        minDistances[start] = 0;
        nodeStack.push(start);
        distStack.push(0.0);
        while (!nodeStack.isEmpty()) {
            int currentNode = nodeStack.pop();
            double currentDist = distStack.pop();
            if (visited[currentNode] && minDistances[currentNode] <= currentDist) {
                continue;
            }
            visited[currentNode] = true;

            minDistances[currentNode] = currentDist;

            for (int i = 0; i < graph.length; i++) {
                if (graph[currentNode][i] != GraphConstants.INF) {
                    nodeStack.push(i);
                    distStack.push(currentDist + graph[currentNode][i]);
                }
            }
        }
        return minDistances;
    }

    public static void main(String[] args) {
        double[][] graph1 = //{
                //            {GraphConstants.INF, 2, 5.5, 4},
                //            {GraphConstants.INF, GraphConstants.INF, 3, 1},
                //            {GraphConstants.INF, GraphConstants.INF, GraphConstants.INF, GraphConstants.INF},
                //            {GraphConstants.INF, GraphConstants.INF, GraphConstants.INF, GraphConstants.INF
                //            }
                //        };
                {
                    {GraphConstants.INF, 20.0, 15.0, GraphConstants.INF},
                    {20.0, GraphConstants.INF, GraphConstants.INF, 10.0},
                    {15.0, GraphConstants.INF, GraphConstants.INF, 25.0},
                    {GraphConstants.INF, 10.0, 25.0, GraphConstants.INF}
                };
        double[] d = dijkstra(graph1, 0);
        for (double e : d) {
            System.out.print("" + e + ", ");
        }
    }
}
