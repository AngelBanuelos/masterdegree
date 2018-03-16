/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.optimizationalgorithms;

import java.util.Arrays;

/**
 *
 * @author angel_banuelos
 */
public class AgenteViajero {

    public static void runHC(int G, int[][] graph, int start) {
        // Crear Ruta Aleatoria Valida
        int[] solution = new int[graph.length - 1];

        for (int g = 0, s = 0; g < graph.length; g++) {
            if (g == start) {
                continue;
            }
            solution[s] = g;
            s++;
        }
        for (int s = 0; s < solution.length - 1; s++) {
            int t = rand(s + 1, solution.length - 1);
            swap(solution, s, t);
        }
        int time = getTime(solution, graph, start);
        for (int g = 0; g < G; g++) {
            int i1 = rand(0, solution.length - 1), i2 = rand(0, solution.length - 1);
            while (i1 == i2) {
                i2 = rand(0, solution.length - 1);
            }
            swap(solution, i1, i2);
            int time1 = getTime(solution, graph, start);
            if (time1 < time) {
                time = time1;
            } else {
                swap(solution, i1, i2);
            }
        }
        System.out.println("Min time: " + time);
        System.out.println(Arrays.toString(solution));
    }

    private static int getTime(int[] solution, int[][] graph, int start) {
        int time = graph[start][solution[0]] + graph[solution[solution.length - 1]][start];
        for (int i = 0; i < solution.length - 1; i++) {
            time += graph[solution[i]][solution[i + 1]];
        }
        return time;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;

    }

    private static int rand(int a, int b) {
        return a + (int) ((b - a + 1) * Math.random());
    }

    public static void main(String[] args) {
        int graph[][] = {{0, 4, 1, 2},
        {3, 0, 5, 6},
        {2, 3, 0, 2},
        {3, 8, 2, 0}
        };
        runHC(200_000, graph, 0);
    }

}
