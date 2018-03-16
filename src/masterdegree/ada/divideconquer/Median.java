/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.divideconquer;

import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author angel_banuelos
 */
public class Median {

    public int getMedian(int[] array, int k) {
        int p = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[k]) {
                p++;
            }
        }
        if (p == k) {
            return array[k];
        } 
        
        if (p > k) {
            int[] arrayMin = new int[p];
            for (int i = 0, j = 0; i < array.length; i++) {
                if (array[i] < array[array.length / 2]) {
                    arrayMin[j++] = array[i];
                }
            }
            return getMedian(arrayMin, k);
        } else {
            int[] arrayMax = new int[array.length - p - 1];
            for (int i = 0, j = 0; i < array.length; i++) {
                if (array[i] > array[array.length / 2]) {
                    arrayMax[j++] = array[i];
                }
            }
            return getMedian(arrayMax, k - p - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};//Utils.createArray(1 << 10, -1100, 20833);
        Median median = new Median();
        System.out.println("" + median.getMedian(array, array.length / 2));

    }

}
