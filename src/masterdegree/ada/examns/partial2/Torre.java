/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.examns.partial2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import masterdegree.ada.graph.Dijkstra;
import masterdegree.ada.graph.ExhaustiveSearch;
import masterdegree.ada.graph.Kruskal;
import masterdegree.ada.optimizationalgorithms.AgenteViajero;
import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class Torre {

    static Integer[] ObtenerTorre(int[] weights, int[] capacities) {
        PriorityQueue<Container> queue = new PriorityQueue();
        ArrayList<Integer> maxWeight = new ArrayList();
        int maxCapacity = -1; // no sabemos cual sea la maxima capacidad, Hay que buscarla.
        int maxCapacityIndex = -1; // Cual es el bloque con la maxima capacidad para ser insertado al principio.
        for (int i = 0; i < weights.length; i++) {// Aqui calculo el bloque con mas capacidad.
            int currentCapacity = capacities[i] - weights[i];
            queue.add(new Container(currentCapacity, i, weights[i]));
            if (currentCapacity > maxCapacity) {
                maxCapacity = currentCapacity;
                maxCapacityIndex = i;
            }
        }

        maxWeight.add(maxCapacityIndex);// agrego el bloque con mayor capacidad.
        while (!queue.isEmpty() && maxCapacity != 0) {
            Container current = queue.poll();
            System.out.println(current.currentCapacity);
            if (maxCapacityIndex == current.index) { // ya no agrego el bloque con mayor capacidad lo omito.
                continue;
            }
            if (maxCapacity >= current.weight) { // si aun hay espacion agrego el bloque y le resto el paso, para tener la nueva capacidad.
                maxCapacity -= current.weight;
                if (current.currentCapacity < maxCapacity) { // Ya no puedo agregar bloques con mayor peso a la capacidad maxima. 
                    maxCapacity = current.currentCapacity; // la capacidad maxima sera la del ultimo bloque
                }
                maxWeight.add(current.getIndex());
            }
        }
        Integer[] maxWeightI = new Integer[maxWeight.size()];
        maxWeight.toArray(maxWeightI);
        return maxWeightI;// returno el arreglo con los bloques.
    }

    static class Container implements Comparable<Container> {

        int currentCapacity;
        int index;
        int weight;

        public Container(int currentCapacity, int index, int weight) {
            this.currentCapacity = currentCapacity;
            this.index = index;
            this.weight = weight;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Container o) {
            if (this.currentCapacity < o.currentCapacity) {
                return 1; // If it is lower than return -1
            }
            if (this.currentCapacity > o.currentCapacity) {
                return -1; // If it is greter than return 1
            }
            return 0; // if are equals return 0
        }

    }

    static Integer[] MaximaAltura(int[] weights, int[] capacities) {
        final int INF = Integer.MAX_VALUE + 1;
        int[][] matrix = new int[weights.length][weights.length];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights.length; j++) {
                if (i == j) {
                    matrix[i][j] = INF;
                    System.out.println("i " + i + " j " + j + " : " + matrix[i][j]);
                    continue;
                }
                int currentCapacity = capacities[i] - weights[i];
                if (currentCapacity >= weights[j]) {
                    matrix[i][j] = currentCapacity - weights[j];
                } else {
                    matrix[i][j] = INF;
                }
                System.out.println("i " + i + " j " + j + " : " + matrix[i][j]);
            }
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        for (int i = 0; i < matrix.length; i++) {
            int currentCapacity = -1;
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    continue;
                }
                if (currentCapacity == -1) {
                    System.out.println("i " + i + " j " + j + " : " + matrix[i][j]);
                    currentCapacity = matrix[i][j];
                    System.out.println(currentCapacity);

                    continue;
                }
                if (currentCapacity >= matrix[i][j]) {
                    System.out.println("i " + i + " j " + j + " : " + matrix[i][j]);
                    currentCapacity -= matrix[i][j];
                    System.out.println(currentCapacity);
                }
            }
        }
        calculateMinTimeFaster(matrix, 0);
        return null;
    }

    static int minTime;
    static int bestRoute[];

    public static void calculateMinTimeFaster(int[][] graph, int start) {
        minTime = Integer.MAX_VALUE + 1;
        int n = graph.length;
        bestRoute = new int[n - 1];

        for (int i = 0; i < n; i++) {
            if (i == start) {
                continue;
            }
            int[] solution = new int[n - 1];
            boolean[] visited = new boolean[n];
            solution[0] = i;
            visited[start] = true;
            visited[i] = true;
            processSolutionFaster(graph, solution, visited, 1, start, graph[start][i]);
        }

        System.out.println("Min time  " + minTime);
        System.out.println("best route:  ");
        Utils.printArray(bestRoute);

    }

    private static void processSolutionFaster(int[][] graph, int[] solution, boolean[] visited, int k, int start, int currentTime) {
        int n = graph.length;
        if (k == n - 1) {
            int time = currentTime - graph[solution[k - 1]][start];//-
            if (minTime < time) {//>
                minTime = time;
                bestRoute = solution;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i]) { // start was visited.
                    continue;
                }
                if (minTime > currentTime - graph[solution[k - 1]][i]) {//<  -
                    continue;
                }
                int[] solutionClone = Arrays.copyOf(solution, solution.length);
                solutionClone[k] = i;
                boolean[] visitedClone = Arrays.copyOf(visited, visited.length);
                visitedClone[i] = true;
                processSolutionFaster(graph, solutionClone, visitedClone, k + 1, start, currentTime + graph[solution[k - 1]][i]);
            }
        }
    }

    public static Integer[] Solution(int[] weights, int[] capacities) {
        int[] maxCapacities = new int[weights.length];
        for (int i = 0; i < maxCapacities.length; i++) {
            maxCapacities[i] = capacities[i] - weights[i];
        }
        ArrayList<Integer> solutionTemp = new ArrayList();
        ArrayList<Integer> solution = new ArrayList();
        int best = 0;
        for (int i = 0, counter = 1; i < weights.length; i++) {
            solutionTemp.add(i);
            int tempCapacity = maxCapacities[i];
            for (int j = 0; j < weights.length; j++) {
                if (i == j) {
                    continue;
                }
                if (tempCapacity < 0) {
                    break;
                }
                if (tempCapacity >= weights[j]) {
                    tempCapacity -= weights[j];
                    solutionTemp.add(j);
                    counter++;
                }
            }
            if (counter > best) { // tengo una solucion buena solucion
                best = counter;
                solution = new ArrayList(solutionTemp);
            }
            solutionTemp.clear();
            counter = 1;
        }
        Integer[] solutionI = new Integer[solution.size()];
        solution.toArray(solutionI);
        return solutionI;
    }

    public static void main(String[] args) {

        int[] capacity = {10, 2, 10, 7, 12, 14, 6};//{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};//{7, 10, 4};//{10, 2, 10, 7, 12, 14, 6}; // 
        int[] weight = {8, 1, 10, 4, 2, 2, 2};//{1, 2, 3, 4, 5, 6, 7, 8, 9};//{1, 5, 3};//{8, 1, 10, 4, 2, 2, 2};//
        Integer[] torre = Solution(weight, capacity);
        System.out.println("Mejor Torre obtenida: " + Arrays.toString(torre));
        //Solution(weight, capacity);
    }

}
