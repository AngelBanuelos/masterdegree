/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session2;

import masterdegree.ada.sort.Bubble;
import masterdegree.ada.sort.Insertion;
import masterdegree.ada.sort.Selection;
import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class Session2 {

    public static void main(String[] args) {
        System.out.println("Num,Algoritm,sortingTime,swapCount,comparationCount");
        for (int i = 1; i < 201; i++) {
            for (int j = 0; j < 500; j++) {
                int[] array = Utils.createArray(i, 1, 200);
                Selection selection = new Selection();
                selection.sort(array);
                System.out.println(i + ",Selection," + selection.getSortingTime() + "," + selection.getSwapCount() + "," + selection.getComparationCount());
            }
        }
        for (int i = 1; i < 201; i++) {
            for (int j = 500; j < 1000; j++) {
                int[] array = Utils.createArray(i, 1, 200);
                Bubble bubble = new Bubble();
                bubble.sort(array);
                System.out.println(i + ",Bubble," + bubble.getSortingTime() + "," + bubble.getSwapCount() + "," + bubble.getComparationCount());
            }
        }
        for (int i = 1; i < 201; i++) {
            for (int j = 0; j < 500; j++) {
                int[] array = Utils.createArray(i, 1, 200);
                Insertion insertion = new Insertion();
                insertion.sort(array);
                System.out.println(i + ",Insertion," + insertion.getSortingTime() + "," + insertion.getSwapCount() + "," + insertion.getComparationCount());
            }
        }

    }

}
