/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.optimizationalgorithms;

/**
 *
 * @author angel_banuelos
 */
public class Rosenbrock {

    private static double MIN_X1 = -5, MIN_X2 = -5;
    private static double MAX_X1 = 5, MAX_X2 = 5;
    private static double BEST_X1 = 1, BEST_X2 = 1;

    public static void main(String[] args) {
        System.out.println(R(1, 1));
        System.out.println(R(0, 0));
        System.out.println(rand(-5, -2));
        System.out.println(getFitness(R(-2, 2)));
        System.out.println(getFitness(R(1, 1)));

        System.out.println("");
        runHillClimbing(20_000, 0.000_001);
    }

    private static double R(double x1, double x2) {
        return 100 * Math.pow(x2 - x1 * x1, 2) + Math.pow(1 - x1, 2);
    }

    private static double rand(double a, double b) {
        return a + (b - a) * Math.random();
    }

    private static void runHillClimbing(int g, double minDX) {
        double x1 = rand(MIN_X1, MAX_X1), x2 = rand(MIN_X2, MAX_X2);
        double r = R(x1, x2);
        double f = getFitness(r);
        int i = 0;

        double dx1 = (MAX_X1 - MIN_X1) * (1 - f), dx2 = (MAX_X2 - MIN_X2) * (1 - f);

        while (i < g-1 && norm(dx1, dx2) > minDX) {
            double mdx1 = rand(-dx1 / 2, dx1 / 2), mdx2 = rand(-dx2, dx2);
            double r1 = R(x1 + mdx1, x2 + mdx2);
            if (r1 < r) {
                r = r1;
                f = getFitness(r);
                x1 += mdx1;
                x2 += mdx2;
                dx1 = (MAX_X1 - MIN_X1) * (1 - f);
                dx2 = (MAX_X2 - MIN_X2) * (1 - f);
            }
            i++;
        }
        System.out.printf("Mejor Solucion: R(%.4f,%.4f) = %.5f\n", x1, x2, r);
        System.out.printf("Generacione = %d , fitness = %.4f\n", g, f);
        System.out.printf("Distancia con la mejor : %.4f\n ", norm(x1 - BEST_X1, x2 - BEST_X2));
    }

    private static double norm(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    private static double getFitness(double r) {
        return 1.0 / (1 + r);
    }

}
