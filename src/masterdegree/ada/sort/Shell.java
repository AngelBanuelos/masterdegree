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
public class Shell {

    private long sortingTime = 0l;
    private int swapCount = 0;
    private int comparationCount = 0;
    private boolean printExecutionTime = false;

    public int[] sort(int[] array) {

        int h = 1; //knuth's Interval sequence
        long startTime = System.currentTimeMillis();
        while (h <= array.length / 3) { // giving the maximum allow value for h.
            h = (h * 3) + 1;
        }

        while (h > 0) {
            comparationCount++;
            for (int i = h; i < array.length; i++) {
                int temp = array[i];
                int j = i;
                comparationCount++;
                while (j > h - 1 && array[j - h] >= temp) {
                    comparationCount++;
                    array[j] = array[j - h];
                    j -= h;
                }
                if (j != i) {
                    swapCount++;
                    array[j] = temp;
                }
            }
            h = (h - 1) / 3;
        }

        long endime = System.currentTimeMillis();
        sortingTime = endime - startTime;

        if (printExecutionTime) {
            System.out.println("Shell Sorting time: " + sortingTime + " miliseconds.");
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

    public boolean isPrintExecutionTime() {
        return printExecutionTime;
    }

    public void printExecutionTime(boolean printExecutionTime) {
        this.printExecutionTime = printExecutionTime;
    }

    public static void main(String[] args) {
        int[] array = Utils.createArray(1 << 27, 1, 19876);
        Shell shell = new Shell();
        shell.printExecutionTime(true);
        shell.sort(array);
        
        System.out.println("Is sorted? " + Utils.isSorted(array));
    }

}
