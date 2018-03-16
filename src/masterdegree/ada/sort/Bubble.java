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
public class Bubble {

    private long sortingTime = 0l;
    private int swapCount = 0;
    private int comparationCount = 0;
    private boolean printExecutionTime = false;

    public int[] sort(int array[]) {
        boolean swapped = true;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                comparationCount++;
                if (array[j] > array[j + 1]) {
                    Utils.swap(array, j, j + 1);
                    swapCount++;
                    swapped = true;
                }
            }
        }
        long endime = System.currentTimeMillis();
        sortingTime = endime - startTime;
        if (printExecutionTime) {
            System.out.println("Bubble Sorting time: " + (sortingTime) + " miliseconds.");
        }
        return array;
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
    
}
