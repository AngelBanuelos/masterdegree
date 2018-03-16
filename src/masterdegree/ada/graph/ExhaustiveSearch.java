/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.graph;

import java.util.Arrays;
import java.util.Collections;
import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author angel_banuelos
 */
public class ExhaustiveSearch {

    private static int minTime;
    private static int bestRoute[];
    private static double minTimeD;
    private static double bestRouteD[];

    private static void processSolution(int[][] graph, int[] solution, boolean[] visited, int k, int start) {
        int n = graph.length;
        if (k == n - 1) {
            int time = graph[start][solution[0]] + graph[solution[n - 2]][start];
            for (int i = 0; i < n - 2; i++) {
                time += graph[solution[i]][solution[i + 1]];
            }
            if (minTime > time) {
                minTime = time;
                bestRoute = solution;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i]) { // start was visited.
                    continue;
                }
                int[] solutionClone = Arrays.copyOf(solution, solution.length);
                solutionClone[k] = i;
                boolean[] visitedClone = Arrays.copyOf(visited, visited.length);
                visitedClone[i] = true;
                processSolution(graph, solutionClone, visitedClone, k + 1, start);

            }
        }
    }

    public static void calculateMinTime(int[][] graph, int start) {
        minTime = Integer.MAX_VALUE;
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
            processSolution(graph, solution, visited, 1, start);
        }

        System.out.println("Min time  " + minTime);
        System.out.println("best route:  ");
        Utils.printArray(bestRoute);

    }

    public static void main(String[] args) {
        int graph[][] = {{0, 4, 1, 2},
        {3, 0, 5, 6},
        {2, 3, 0, 2},
        {3, 8, 2, 0}
        };

        calculateMinTimeFaster(graph, 0);
    }

    private static void processSolutionFaster(int[][] graph, int[] solution, boolean[] visited, int k, int start, int currentTime) {
        int n = graph.length;
        if (k == n - 1) {
            int time = currentTime + graph[solution[k - 1]][start];
            if (minTime > time) {
                minTime = time;
                bestRoute = solution;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i]) { // start was visited.
                    continue;
                }
                if (minTime < currentTime + graph[solution[k - 1]][i]) {
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

    public static void calculateMinTimeFaster(int[][] graph, int start) {
        minTime = Integer.MAX_VALUE;
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

    public void calculateMinTimeFaster(double[][] graph, int start) {
        minTimeD = Double.MAX_VALUE;
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

        System.out.println("Min time  " + minTimeD);
        System.out.println("best route:  ");
        Utils.printArray(bestRoute);
    }

    private void processSolutionFaster(double[][] graph, int[] solution, boolean[] visited, int k, int start, double currentTime) {
        int n = graph.length;
        if (k == n - 1) {
            double time = currentTime;
            if (minTimeD > time) {
                minTimeD = time;
                bestRoute = solution;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i]) { // start was visited.
                    continue;
                }
                if (minTimeD < currentTime + graph[solution[k - 1]][i]) {
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

}
