/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.examns.partial2;

/**
 *
 * @author Angel.Sahagun
 */
public class SuperFormula {

    final static long MODULE = 57413;

    static long rF(int x, int y, int z) {
        if ((x * y * z) <= 0) {
            return 0;
        }
        return (1 + rF(x - 2, y - 1, z - 1) + rF(x - 1, y - 2, z - 1)
                + rF(x - 1, y - 1, z - 2)) % MODULE;
    }

    static long superFormulaPD(int x, int y, int z) {
        long[][][] matrix = new long[x+1][y+1][z+1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    if ((i * j * k) <= 0) {
                        matrix[i][j][k] = 0;
                        continue;
                    }
                    if (i < 2 || j < 2 || k < 2) {
                        matrix[i][j][k] = 1;
                    } else {
                        matrix[i][j][k] = (1
                                + matrix[i - 2][j - 1][k - 1]
                                + matrix[i - 1][j - 2][k - 1]
                                + matrix[i - 1][j - 1][k - 2]) % MODULE;
                    }
                }
            }
        }
        return matrix[x][y][z];
    }

    public static void main(String[] args) {
        System.out.println("1)	F(5, 6, 7) = " + superFormulaPD(5,6,7));
        System.out.println("2)	F(10,9,8) = " + superFormulaPD(10,9,8));
        System.out.println("3)	F(30,29,28) = " + superFormulaPD(30,29,28));
        System.out.println("4)	F(95,96,97) = " + superFormulaPD(95,96,97));
        System.out.println("5)	F(100,100,100) = " + superFormulaPD(100,100,100));
    }

}
