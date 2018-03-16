/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import masterdegree.ada.sort.Bubble;

/**
 *
 * @author angel_banuelos
 */
public class TrainSwappingProblem {

    /*
     Definition: At an old railway station, you may still encounter one of the last remaining “train swappers”. 
     A train swapper is an employee of the railroad, whose sole job is to rearrange the carriages of trains. 
     Once the carriages are arranged in the optimal order, all the train driver has to do, is drop the carriages off,
     one by one, at the stations for which the load is meant.
     The title “train swapper'” stems from the first person who performed this task, at a station close to a
     railway bridge. Instead of opening up vertically, the bridge rotated around a pillar in the center of the
     river. After rotating the bridge 90 degrees, boats could pass left or right. The first train swapper had
     discovered that the bridge could be operated with at most two carriages on it. By rotating the bridge
     180 degrees, the carriages switched place, allowing him to rearrange the carriages (as a side effect,
     the carriages then faced the opposite direction, but train carriages can move either way, so who cares).
     Now that almost all train swappers have died out, the railway company would like to automate their
     operation. Part of the program to be developed, is a routine which decides for a given train the least
     number of swaps of two adjacent carriages necessary to order the train. Your assignment is to create
     that routine
    
     Input: The input contains on the first line the number of test cases (N). Each test case consists of two input
     lines. 
     The first line of a test case contains an integer L, determining the length of the train such that:
     0 ≤ L ≤ 60. 
     The second line of a test case contains a permutation of the numbers 1 through L,
     indicating the current order of the carriages. 
     The carriages should be ordered such that carriage 1
     comes first, then 2, etc. with carriage L coming last.
    
     Output: For each test case output the sentence: ‘Optimal train swapping takes S swaps.' where S is an integer.
    
     */
    public static void main(String[] args) {
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String text = bufferRead.readLine().trim();
            int testCases = Integer.parseInt(text);
            int i = 0;
            while (i < testCases) {
                String helper = bufferRead.readLine().trim();
                int length = Integer.parseInt(helper);
                if (!(length >= 0 && length <= 60)) {
                    System.err.println("train length should be between 0 and 60");
                    continue;
                }
                helper = bufferRead.readLine().trim();

                String numbers[] = helper.split(" ");
                int[] array = new int[numbers.length];
                for (int j = 0; j < numbers.length; j++) {
                    array[j] = Integer.parseInt(numbers[j]);
                }
                Bubble bubbleSort = new Bubble();
                bubbleSort.sort(array);
                System.out.println("Optimal train swapping takes " + bubbleSort.getSwapCount() + " Swaps.");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
