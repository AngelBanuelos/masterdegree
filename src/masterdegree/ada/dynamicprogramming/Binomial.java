/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.dynamicprogramming;

/**
 *
 * @author angel_banuelos
 */
public class Binomial {

    public static void main(String[] args) {
        long c = binomialDynamicProgramming(60, 30);
        System.out.println(" a " + c);
        //c = binomial(34, 17);
        System.out.println(c);

        int[] m = {1, 4, 6};
        System.out.println(cambio(9, m));
    }

    /**
     * Combination
     *
     * @param n
     * @param k
     * @return
     */
    private static long binomial(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        if (k > n) {
            return 0;
        }
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }

    private static long binomialDynamicProgramming(int n, int k) {
        long[][] matrix = new long[k + 1][n];
        for (int i = 0; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0 || i == j) {
                    matrix[i][j - 1] = 1;
                } else if (i > j) {
                    matrix[i][j - 1] = 0;
                } else {
                    matrix[i][j - 1] = matrix[i][j - 2] + matrix[i - 1][j - 2];
                }
            }
        }
        return matrix[k][n - 1];
    }

    private static int cambio(int c, int[] M) {
        int[][] matrix = new int[M.length][c];
        for (int i = 0; i < M.length; i++) {// cantidad de monedas
            for (int j = 1; j <= c; j++) { //Cantidad de cambio a dar.
                if (M[i] == 1) {
                    matrix[i][j - 1] = j;
                } else if (j == M[i]) {
                    matrix[i][j - 1] = 1;
                } else if (j < M[i]) {
                    matrix[i][j - 1] = matrix[i - 1][j - 1];
                } else {
                    int nuevo = matrix[i][j - 1 - M[i]] + 1;
                    if (nuevo < matrix[i - 1][j - 1]) {
                        matrix[i][j - 1] = nuevo;
                    } else {
                        matrix[i][j - 1] = matrix[i - 1][j - 1];
                    }
                }
            }
        }
        System.out.println("Monedas Utilizads");
        int m = M.length - 1;
        int j = c;
        while (m > 0) {
            int count = 0;
            System.out.print("$" + M[m] + " : ");
            while (j > 0 && matrix[m][j - 1] < matrix[m - 1][j - 1]) {
                count++;
                j -= M[m];
            }
            System.out.println(count);
            m--;
        }
        if (j > 0) {
            System.out.println("$" + M[m] + " : " + matrix[m][j - 1]);
        } else {
            System.out.println("$" + M[m] + " : " + 0);

        }
        return matrix[M.length - 1][ c - 1];
    }

}
