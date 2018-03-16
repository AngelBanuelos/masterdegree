package masterdegree.ada.sort;

import masterdegree.ada.sort.utils.Utils;

public class Selection {

    private long sortingTime = 0l;
    private int swapCount = 0;
    private int comparationCount = 0;
    private boolean printExecutionTime = false;

    public int[] sort(int[] array) { // Temporal: N^2 + 3N + 11 , Espacial: 4 + N 

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) { // 2 + 2N  
            int aux = i; // 1
            for (int j = i + 1; j < array.length; j++) {
                comparationCount++;
                if (array[aux] > array[j]) { // N^2 + 3 
                    aux = j; // 1
                }
            }
            if (aux != i) { // N 
                swapCount++;
                Utils.swap(array, aux, i); // 6
            }
        }
        long endime = System.currentTimeMillis();
        sortingTime = endime - startTime;
        if(printExecutionTime){
            System.out.println("Selection Sorting time: " + sortingTime + " miliseconds.");
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
