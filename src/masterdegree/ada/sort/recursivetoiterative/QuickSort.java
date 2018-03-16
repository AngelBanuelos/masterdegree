/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.sort.recursivetoiterative;

import java.util.Stack;
import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author angel_banuelos
 */
public class QuickSort {

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        int j = right;
        while (true) {
            while (array[++i] < pivot) {
            }
            while (j > 0 && array[--j] > pivot) {
            }
            if (i >= j) {
                break;
            } else {
                Utils.swap(array, i, j);
            }
        }
        Utils.swap(array, i, right);
        return i;
    }

    static class Parameters {

        int left, right;

        public Parameters(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public int[] sort(int[] array) {
        int left = 0, right = array.length - 1;

        Stack<Parameters> stack = new Stack();
        stack.push(new Parameters(left, right));

        while (!stack.isEmpty()) {
            Parameters p = stack.pop();
            if (p.left >= p.right) {
                continue;
            }
            int partition = partition(array, p.left, p.right);
            stack.push(new Parameters(partition + 1, p.right));
            stack.push(new Parameters(p.left, partition - 1));

        }
        return array;
    }

    public static void main(String[] args) {
        int array[] = {6, 54, 7, 23};
        QuickSort qs = new QuickSort();
        array = qs.sort(array);
        Utils.printArray(array);

    }

}
