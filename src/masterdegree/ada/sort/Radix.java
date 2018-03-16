/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author angel_banuelos
 */
public class Radix {

    private long sortingTime = 0l;
    private int swapCount = 0;
    private int comparationCount = 0;
    private boolean printExecutionTime = false;

    List<LinkedList<Integer>> sortedArrayHelper = new ArrayList<LinkedList<Integer>>();
    List<LinkedList<Integer>> sortedArrayHelperTemp = new ArrayList<LinkedList<Integer>>();

    public Radix() {
        initialize(sortedArrayHelper);
        initialize(sortedArrayHelperTemp);
    }

    public int[] sort(int[] array) {
        long startTime = System.currentTimeMillis();
        int mod = 10, div = 1, max = 0;
        for (int i = 0; i < array.length; i++) {
            int helper = array[i] % mod / div;
            sortedArrayHelper.get(helper).add(array[i]);
            if (max < array[i]) {
                max = array[i];
            }
        }
        int length = Integer.toString(max).length();
        for (int j = 0; j < length; j++) {
            comparationCount++;
            mod *= 10;
            div *= 10;
            for (LinkedList<Integer> shortedArrayHelper1 : sortedArrayHelper) {
                while (!shortedArrayHelper1.isEmpty()) {
                    int currentNumber = shortedArrayHelper1.pollFirst();
                    int helper = (currentNumber % mod) / div;
                    sortedArrayHelperTemp.get(helper).add(currentNumber);
                    swapCount++;

                }
            }
            Collections.copy(sortedArrayHelper, sortedArrayHelperTemp);
            sortedArrayHelperTemp.clear();
            initialize(sortedArrayHelperTemp);
        }
        long endime = System.currentTimeMillis();
        int i = 0;
        for (int value : sortedArrayHelper.get(0)) {
            array[i] = value;
            i++;
        }
        sortingTime = endime - startTime;
        if (printExecutionTime) {
            System.out.println("Radix Sorting time: " + sortingTime + " miliseconds.");
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

    public void setPrintExecutionTime(boolean printExecutionTime) {
        this.printExecutionTime = printExecutionTime;
    }

    private void initialize(List<LinkedList<Integer>> linkedList) {
        for (int i = 0; i < 10; i++) {
            LinkedList<Integer> newList = new LinkedList<Integer>();
            linkedList.add(newList);
        }
    }

}
