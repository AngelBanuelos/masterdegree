/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session2;

import masterdegree.ada.sort.Shell;
import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class Session2Part2 {

    public static void main(String[] args) {

        System.out.println("Num,Algoritm,sortingTime,swapCount,comparationCount");
        for (int i = 1; i <= 20000; i = i + 100) {
            for (int j = 0; j < 100; j++) {
                int[] array = Utils.createArray(i, 1, 200);
                Shell shell = new Shell();
                shell.sort(array);
                System.out.println(i + ",Shell," + shell.getSortingTime() + "," + shell.getSwapCount() + "," + shell.getComparationCount());
            }
        }
    }

}
