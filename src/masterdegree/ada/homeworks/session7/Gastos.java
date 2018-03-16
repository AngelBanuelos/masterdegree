package masterdegree.ada.homeworks.session7;

import java.util.Scanner;

/**
 * @authors BANUELOS SAHAGUN ANGEL DE JESUS 
 * FLORES DIAZ JOSE ARMANDO 
 * GARCIA FERMIN GENARO
 */
public class Gastos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int D = sc.nextInt(); //dinero a ejercer
            if (D == 0) {
                break;
            }
            int C = sc.nextInt(); //cantidad de productos
            int[] valores = new int[C];
            for (int i = 0; i < C; i++) //costos de servicios y productos 
            {
                valores[i] = sc.nextInt();
            }
            int[] pesos = valores.clone();  //los pesos seran iguales a los valores

            //llenamos la mochila
            int[][] mochila = Mochila(pesos, valores, D);
            int cont = 0;
            for (int i = 0; i < mochila.length; i++) {
                if (mochila[i][D] == D) {
                    cont++;
                }
            }
            if (cont > 0) {
                System.out.println("Secretario de Finanzas");
            } else {
                System.out.println("Ni Modo");
            }
        }
        sc.close();
    }

    public static int[][] Mochila(int[] pesos, int[] valores, int capacidad) {
        int[][] matriz_mochila = new int[pesos.length + 1][capacidad + 1];
        //inicializamos los valores para la mochila
        for (int i = 0; i <= capacidad; i++) {
            matriz_mochila[0][i] = 0;
        }
        for (int i = 0; i <= pesos.length; i++) {
            matriz_mochila[i][0] = 0;
        }
        //llenamos la mochila
        for (int j = 1; j <= pesos.length; j++) {
            for (int c = 1; c <= capacidad; c++) {
                if (c < pesos[j - 1]) {
                    matriz_mochila[j][c] = matriz_mochila[j - 1][c];
                } else {
                    if (matriz_mochila[j - 1][c] > matriz_mochila[j - 1][c - pesos[j - 1]] + valores[j - 1]) {
                        matriz_mochila[j][c] = matriz_mochila[j - 1][c];
                    } else {
                        matriz_mochila[j][c] = matriz_mochila[j - 1][c - pesos[j - 1]] + valores[j - 1];
                    }
                }
            }
        }
        return matriz_mochila;
    }
}
