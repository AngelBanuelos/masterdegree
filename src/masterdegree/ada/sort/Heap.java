/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.sort;

import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author angel_banuelos
 */
public class Heap {

    private long sortingTime = 0l;
    private int swapCount = 0;
    private int comparationCount = 0;
    private boolean printExecutionTime = false;

    public int[] sort(int[] array) {
//		Step 1: heapify array
        for (int i = 1; i < array.length; i++) {  // por cada hijo
//			Llevarlo tan arriba como su valor lo permita
            int ch = i;
            int p = (ch + 1) / 2 - 1;
            while (p >= 0 && array[ch] > array[p]) {
                Utils.swap(array, ch, p);
                ch = p;
                p = (ch + 1) / 2 - 1;
            }
        }
        System.out.println("isheap?" + Utils.isHeap(array));
//		Step 2: sort heap
        for (int heapLast = array.length - 1; heapLast > 0; heapLast--) {
            Utils.swap(array, 0, heapLast);
            int p = 0;
            int ch = 1;
            if (array[2] > array[1] && heapLast > 2) {
                ch = 2;
            }

            while (ch < heapLast && array[p] < array[ch]) {
                Utils.swap(array, ch, p);
                p = ch;
                int chL = (p + 1) * 2 - 1;
                if (chL >= heapLast) {
                    break;
                }
                int chR = chL + 1;
                if (chR >= heapLast) {
                    ch = chL;
                } else {
                    ch = array[chL] > array[chR] ? chL : chR;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 400; i++) {
        int[] array = Utils.createArray(1024, 1, 1024);
        int a = Utils.maxSumRec(array);
//        int b = Utils.maxSum(array);
//            if (a != b) {
//                System.out.println("Error " + a +  "_" + b);
//            }
        }
        //Utils.printArray(array);

    }

}
