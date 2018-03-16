/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import masterdegree.ada.sort.Mergesort;
import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author angel_banuelos
 */
public class LowerCaseProblem {
    /*s letras están escritas en
     Tienes un amigo interesado en las palabras que tienen la propiedad de que sus letras están escritas en
     orden alfabético, tales como: adiós, ajo, himno. Asimismo, le interesa saber si al combinar dos o más
     de estas palabras se forma alguna palabra interesante que siga estando en orden alfabético; sin
     embargo, la combinación puede ser muy cansado. Por tanto, tu amigo te pide ayuda para que le hagas
     un programa que reciba una lista de palabras con esta propiedad, y que imprima el resultado de
     combinar todas las palabras sin perder la propiedad. Como sabe que este problema es muy fácil para
     ti, también te pide que imprimas el resultado de combinar cada par de palabras adyacentes de la lista
     original, y cada par de combinaciones adyacentes sucesivas, hasta llegar a la palabra final. La
     restricción que le pones a tu amigo es que el número de palabras de la lista sea potencia de 2.
    
     input: La primera línea contiene un número entero T > 0 que denota el número de casos de prueba. Cada
     caso de prueba comienza con un número entero N ≥ 2 que denota el número de palabras. Se cumple
     que N es una potencia de dos. Le sigue una lista de N palabras formadas por 1 o más letras minúsculas
     acomodadas en orden alfabético y que se pueden repetir.
    
     output: Por cada caso de prueba, 
     imprime en líneas separadas el resultado de combinar cada par de palabras
     adyacentes de la entrada. Luego, imprime el resultado de combinar cada par de palabras adyacentes
     que fueron combinadas en el paso anterior; y así, hasta llegar a una palabra que combina todo. Separa
     cada caso de prueba con una línea en blanco.
    
     */

    public static void main(String[] args) {
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String text = bufferRead.readLine().trim();
            int testCases = Integer.parseInt(text);
            if (testCases <= 0) {
                System.err.println("Number of test cases should be greater than 0");
            }
            int i = 0;
            while (i < testCases) {
                String helper = bufferRead.readLine().trim();
                long n = Long.parseLong(helper);
                if (!Utils.isPow(n, 2)) {
                    System.err.println("Number is not pow of 2");
                    continue;
                }
                Mergesort mergeSort = new Mergesort();
                LinkedList<String> sortedPartialArray = new LinkedList();
                for (int j = 0; j < n; j++) {
                    helper = bufferRead.readLine().trim();
                    sortedPartialArray.push(mergeSort.sort(helper));
                }
                while (sortedPartialArray.size() > 1) {
                    String mixed = sortedPartialArray.pollLast();
                    mixed += sortedPartialArray.pollLast();
                    sortedPartialArray.push(mergeSort.sort(mixed));
                    System.out.println(sortedPartialArray.peek());
                }
                System.out.println();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
