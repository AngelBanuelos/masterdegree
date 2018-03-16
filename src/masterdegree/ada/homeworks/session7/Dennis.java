/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session7;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @authors BANUELOS SAHAGUN ANGEL DE JESUS 
 * FLORES DIAZ JOSE ARMANDO 
 * GARCIA FERMIN GENARO
 */
public class Dennis {

    private final static double INF = Double.MAX_VALUE;

    private static List<Edge> d;

    private static double getMinDistance(ArrayList<Point> list) {
        double minDistance = 0;
        double[][] matrix = new double[list.size()][list.size()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0.0) {
                    continue;
                }
                if (i == j) {
                    matrix[i][j] = INF;
                } else {
                    matrix[i][j] = getDistance(list.get(i), list.get(j));
                    matrix[j][i] = matrix[i][j];
                }
            }
        }
        d = kruskal(matrix, list.size() - 1);
        for (Edge edge : d) {
            minDistance += edge.weight;
        }
        return minDistance;
    }

    private static double getDistance(Point aPoint, Point bPoint) {
        double a = (bPoint.x - aPoint.x);
        double b = (bPoint.y - aPoint.y);
        return Math.sqrt(a * a + b * b);
    }

    private static class Point {

        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); //Test Cases.
        while (testCases != 0) {
            ArrayList<Point> list = new ArrayList<Point>();
            int freckles = sc.nextInt();
            while (freckles != 0) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                list.add(new Point(x, y));
                freckles--;
            }
            double mindistance = getMinDistance(list);
            System.out.printf("%.2f\n", mindistance);
            testCases--;
        }
    }

    public static class Edge implements Comparable<Edge> {

        public int vertex1, vertex2;
        public double weight;

        public Edge(int vertex1, int vertex2, double weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight < o.weight) {
                return -1; // If it is lower than return -1
            }
            if (this.weight > o.weight) {
                return 1; // If it is greter than return 1
            }
            return 0; // if are equals return 0
        }
    }

    public static int findLeader(int[] parents, int x) {
        while (parents[x] != x) {
            x = parents[x];
        }
        return x;
    }

    public static boolean join(int[] parents, int[] rank, int i, int j) {
        int leaderI = findLeader(parents, i);
        int leaderJ = findLeader(parents, j);
        if (leaderI == leaderJ) {
            return false;
        }

        int rankLeaderI = rank[leaderI];
        int rankLeaderJ = rank[leaderJ];

        if (rankLeaderI > rankLeaderJ || (rankLeaderI == rankLeaderJ && leaderI > leaderJ)) {
            parents[leaderJ] = leaderI;
            rank[leaderI] += rank[leaderJ];
        } else {
            parents[leaderI] = leaderJ;
            rank[leaderJ] += rank[leaderI];
        }
        return true;
    }

    public static List<Edge> kruskal(double[][] graph, int start) {
        PriorityQueue<Edge> queue = new PriorityQueue();
        List<Edge> arm = new ArrayList<Edge>(graph.length - 1);
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[i].length; j++) {
                if (graph[i][j] != INF) {
                    Edge e = new Edge(i, j, graph[i][j]);
                    queue.offer(e);
                }
            }
        }
        int[] parents = new int[graph.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int[] rank = new int[graph.length];
        for (int i = 0; i < rank.length; i++) {
            rank[i] = 1;
        }

        while (arm.size() < graph.length - 1) {
            Edge minEdge = queue.poll();
            if (join(parents, rank, minEdge.vertex1, minEdge.vertex2)) {
                arm.add(minEdge);
            }
        }
        return arm;
    }
}
