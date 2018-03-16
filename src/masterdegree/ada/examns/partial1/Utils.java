/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.examns.partial1;

/**
 *
 * @author angel_banuelos
 */
public class Utils {

    /**
     * Cada nodo tiene un valor comparable tal que ningún nodo tiene un valor
     * más grande que el de su padre.
     *
     * Está balanceado: cada nodo tiene 2 hijos, excepto los de los últimos dos
     * niveles.
     *
     * Está alineado a la izquierda: si un nodo sólo tiene un hijo, debe ser el
     * izquierdo.
     *
     * @param array to validate if it is heap
     * @return
     */
    public static boolean isHeap(int[] array) {
        int parent = 0;
        int childL = 1, childR = 2;
        for (int i = 1; i < array.length; i++) {
            // Ningun nodo tiene un valor mas grande que el de su padre
            if (array[parent] < array[childL] || ((childR < array.length) && array[parent] < array[childR])) {
                return false;
            }
            parent = i;
            childL = ((parent + 1) * 2) - 1;
            childR = childL + 1;
            if (childL > (array.length - 1)) {
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {-10, 5, 7, 2, 1, -1};

//        System.out.println("" + maxSumReq(array, 0, array.length - 1, 0, 0));
        System.out.println("" + maxSumRec(array));
//        System.out.println("" + maxSum(array));
    }

    private static int maxSumRec(int[] a, int min, int max) {
        int maxSumLeft = 0;
        int maxSumRight = 0;
        int sum = 0;
        int maxSum = 0;
        int middle = (min + max) / 2;
        if (min == max) {
            return a[min] > 0 ? a[min] : 0;
        }
        //c.	Calcula la suma obtenida en la primera mitad
        int sumLeft = maxSumRec(a, min, middle);
        //d.	Calcula la suma obtenida en la segunda mitad.
        int sumRight = maxSumRec(a, middle + 1, max);

        //i.	Encuentra la suma máxima del sub-arreglo que termina en la primera mitad.
        for (int i = middle; i >= min; i--) {
            sum += a[i];
            if (sum > maxSumLeft) {
                maxSumLeft = sum;
            }
        }
        //ii.	Encuentra la suma máxima del sub-arreglo que comienza en la segunda mitad.
        for (int j = middle + 1; j <= max; j++) {
            maxSum += a[j];
            if (maxSum > maxSumRight) {
                maxSumRight = maxSum;
            }
        }
        //f.	Devuelve la mayor de las tres sumas
        return maxOfTree(sumLeft, sumRight, maxSumLeft + maxSumRight);

    }

    public static int maxSumRec(int a[]) {
        return maxSumRec(a, 0, a.length - 1);

    }

    private static int maxOfTree(int left, int right, int maxSum) {
        if (left < right && left < maxSum) {
            if (right < maxSum) {
                return maxSum;
            } else {
                return right;
            }
        } else if (right < left && right < maxSum) {
            if (left < maxSum) {
                return maxSum;
            } else {
                return left;
            }
        } else {
            if (left < right) {
                return right;
            } else {
                return left;
            }
        }
    }

}
