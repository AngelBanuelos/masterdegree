/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.sort;

/**
 *
 * @author Angel.Sahagun
 */
public class Insertion {

    private long sortingTime = 0l;
    private int swapCount = 0;
    private int comparationCount = 0;
    private boolean printExecutionTime = false;

    public int[] sort(int[] array) {
        
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int current = array[i]; // Se toma el segundo elemento en la primera corrida
            int j = i - 1;
            comparationCount++;
            while (j >= 0 && array[j] > current) { // se compara el segundo elemento con el primero si es menor se recorren a la izq 
                comparationCount++;
                array[j + 1] = array[j--];
            }
            if ((j + 1) != i) {
                array[j + 1] = current;
                swapCount++;
            }
        }
        
        long endime = System.currentTimeMillis();
        sortingTime = endime - startTime;
        if (printExecutionTime) {
            System.out.println("Insertion Sorting time: " + sortingTime + " miliseconds.");
        }
        return array;
    }
    
    public InsertionComparation[] sort(InsertionComparation[] array) {
        
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            InsertionComparation current = array[i]; // Se toma el segundo elemento en la primera corrida
            int j = i - 1;
            comparationCount++;
            while (j >= 0 && array[j].getIndex() > current.getIndex()) { // se compara el segundo elemento con el primero si es menor se recorren a la izq 
                comparationCount++;
                current.setSelected(true);
                array[j + 1] = array[j--];
            }
            if ((j + 1) != i) {
                array[j + 1] = current;
                swapCount++;
            }
        }
        
        long endime = System.currentTimeMillis();
        sortingTime = endime - startTime;
        if (printExecutionTime) {
            System.out.println("Insertion Sorting time: " + sortingTime + " miliseconds.");
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
