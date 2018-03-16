/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session4;

import masterdegree.ada.sort.Mergesort;
import masterdegree.ada.sort.Quicksort;
import masterdegree.ada.sort.Radix;
import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class Session4 {

    public static void main(String[] args) {
        System.out.println("Arreglos aleatorios");
        System.out.println("Num,Algoritm,sortingTime,swapCount,comparationCount");
        for (int i = 1000; i < 10000; i = i + 100) {
            for (int j = 0; j < 50; j++) {
                int[] array = Utils.createArray(i, 1, 200);
                Quicksort bubble = new Quicksort();
                bubble.sort(array);
                System.out.println(i + ",Quicksort," + bubble.getSortingTime() + "," + bubble.getSwapCount() + "," + bubble.getComparationCount());
            }
        }
        for (int i = 1000; i < 10000; i = i + 100) {
            for (int j = 0; j < 50; j++) {
                int[] array = Utils.createArray(i, 1, 200);
                Mergesort insertion = new Mergesort();
                insertion.sort(array);
                System.out.println(i + ",Mergesort," + insertion.getSortingTime() + "," + insertion.getSwapCount() + "," + insertion.getComparationCount());
            }
        }
        System.out.println("Arreglos SemiOrdenados");
        System.out.println("Num,Algoritm,sortingTime,swapCount,comparationCount");
        for (int i = 1000; i < 10000; i = i + 100) {
            for (int j = 0; j < 50; j++) {
                int[] array = Utils.partialSortArray(i);
                Quicksort bubble = new Quicksort();
                bubble.sort(array);
                System.out.println(i + ",Quicksort," + bubble.getSortingTime() + "," + bubble.getSwapCount() + "," + bubble.getComparationCount());
            }
        }
        for (int i = 1000; i < 10000; i = i + 100) {
            for (int j = 0; j < 50; j++) {
                int[] array = Utils.partialSortArray(i);
                Mergesort insertion = new Mergesort();
                insertion.sort(array);
                System.out.println(i + ",Mergesort," + insertion.getSortingTime() + "," + insertion.getSwapCount() + "," + insertion.getComparationCount());
            }
        }
        System.out.println("Arreglos Invertidos");
        System.out.println("Num,Algoritm,sortingTime,swapCount,comparationCount");
        for (int i = 1000; i < 10000; i = i + 100) {
            for (int j = 0; j < 50; j++) {
                int[] array = Utils.invertedArray(i);
                Quicksort bubble = new Quicksort();
                bubble.sort(array);
                System.out.println(i + ",Quicksort," + bubble.getSortingTime() + "," + bubble.getSwapCount() + "," + bubble.getComparationCount());
            }
        }
        for (int i = 1000; i < 10000; i = i + 100) {
            for (int j = 0; j < 50; j++) {
                int[] array = Utils.invertedArray(i);
                Mergesort insertion = new Mergesort();
                insertion.sort(array);
                System.out.println(i + ",Mergesort," + insertion.getSortingTime() + "," + insertion.getSwapCount() + "," + insertion.getComparationCount());
            }
        }
    }
}
