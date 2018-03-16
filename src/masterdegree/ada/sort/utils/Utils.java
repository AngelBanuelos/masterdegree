package masterdegree.ada.sort.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import masterdegree.ada.sort.Selection;
import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static int[] createArray(int n, int min, int max) {

        Random rmd = new Random();
        int[] array = new int[n];
        int bound = max - min + 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = rmd.nextInt(bound) + min;
        }

        return array;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] array, int i1, int i2) { // Tempotal = 6 , Espacial = 1 

        int temp = array[i1]; // 2
        array[i1] = array[i2]; // 2
        array[i2] = temp; // 2 

    }

    public static boolean isSorted(int[] array) { // 5N + 2

        for (int i = 0; i < array.length - 1; i++) { // 1 + (N + 1 ) + N
            if (array[i] > array[i + 1]) { // N(3)
                return false;
            }
        }
        return true;
    }

    public static int[] partialSortArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < (int) (n - (n / 10)); i++) {
            array[i] = i;
        }
        for (int i = 0; i < (n / 10); i++) {
            array[(n - (n / 10)) + i] = (n - (n / 10)) - (i * 2);
        }
        return array;
    }

    public static int[] invertedArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (n - i);
        }
        return array;
    }

    public static boolean isPow(long n, int pow) {
        boolean powB = false;
        while (n >= pow && n % pow == 0) {
            if (n == pow) {
                powB = true;
            }
            n = (n / pow);
        }
        return powB;
    }

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

    public static int maxSumReq(int[] array, int min, int max, int sum, int maxSum) {
        if (min == max) {
            return maxSum;
        }
        int middle = (min + max) / 2;
        int s1 = maxSumReq(array, min, middle, sum, maxSum);
        int s2 = maxSumReq(array, middle + 1, max, sum, maxSum);
        maxSum += (s1 + s2);
        return sumR(sum, min, middle, max, array, maxSum);
    }

    private static int sumR(int sum, int min, int middle, int max, int[] array, int maxSum) {
        int mid = middle - 1;
        while (min <= mid && middle <= max) {
            if (array[min] < array[middle]) {
                sum += array[min++];
            } else {
                sum += array[middle++];
            }
        }
        while (min <= mid) {
            sum += array[min++];
        }

        while (middle <= max) {
            sum += array[middle++];
        }
        if (maxSum < sum) {
            maxSum = sum;
        }
        return maxSum;
    }

    private static int sum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int maxSum(int[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int s = sum(array, i, j);
                if (s > maxSum) {
                    maxSum = s;
                }
            }
        }
        return maxSum;
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

    public static long pow(long num, int powOf) {
        long pow = 1;
        for (int i = 0; i < powOf; i++) {
            pow *= num;
        }
        return pow;
    }
}
