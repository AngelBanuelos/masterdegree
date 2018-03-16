/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.sort;

import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class Quicksort {

    private long sortingTime = 0l;
    private int swapCount = 0;
    private int comparationCount = 0;
    private boolean printExecutionTime = false;

    public int[] sort(int[] array) {
        long startTime = System.currentTimeMillis();
        reqSort(0, array.length - 1, array);
        long endime = System.currentTimeMillis();
        sortingTime = endime - startTime;
        if (printExecutionTime) {
            System.out.println("Quick Sorting time: " + sortingTime + " miliseconds.");
        }
        return array;
    }

    private int[] reqSort(int left, int right, int[] array) {
        if (right - left <= 0) {
            return array;
        } else {
            int pivot = array[right];
            int partition = partitionIt(left, right, pivot, array);
            reqSort(left, partition - 1, array);
            reqSort(partition + 1, right, array);
            return array;
        }
    }

    private int partitionIt(int left, int right, int pivot, int[] array) {
        int i = left - 1;
        int j = right;
        while (true) {
            comparationCount++;
            while (array[++i] < pivot) {
                comparationCount++;
            }
            while (j > 0 && array[--j] > pivot) {
                comparationCount++;
            }
            if (i >= j) {
                comparationCount++;
                break;
            } else {
                swapCount++;
                Utils.swap(array, i, j);
            }
        }
        swapCount++;
        Utils.swap(array, i, right);
        return i;
    }

    public long getSortingTime() {
        return sortingTime;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public int getComparationCount() {
        return comparationCount;
    }

    public void setPrintExecutionTime(boolean printExecutionTime) {
        this.printExecutionTime = printExecutionTime;
    }

}
