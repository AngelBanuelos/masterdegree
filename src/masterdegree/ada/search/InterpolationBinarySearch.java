/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.search;

import java.util.Arrays;

/**
 * Busqueda por interpolacion, Usa una regla de tres para dar un valor mas
 * acertado de pivote en nuevas iteraciones
 *
 * @author angel_banuelos
 */
public class InterpolationBinarySearch {

    public int search(int[] array, int value) {
        int half = array.length / 2;
        return searchR(array, 0, half, array.length - 1, value);
    }

    public int search(Searching[] array, int value) {
        int half = array.length / 2;
        return searchR(array, 0, half, array.length - 1, value);
    }

    private int searchR(int[] array, int start, int half, int end, int value) {
        if (value > array[end] || value < array[start]) {
            return -1;
        }
        int a = end - start;
        int b = array[end] - array[start];
        int c = value - array[start];
        int d = (c * a) / b;
        int slide = d + start;
        if (slide > end || slide < start) {
            return -1;
        }
        if (array[slide] == value) {
            return slide;
        }
        if (value < array[slide]) {
            end = slide;
            return searchR(array, start, half, end, value);
        } else {
            start = slide;
            return searchR(array, start, half, end, value);
        }
    }

    /**
     * Metodo para metodos que implementan Serching interface.
     *
     * @param array Arreglo en donde buscara el elemento
     * @param start Variable para la particion del arrglo inicial
     * @param half La mitad el arreglo
     * @param end el final del arreglo.
     * @param value Valor a buscar
     * @return regresa el indice del elemento a buscar.
     */
    private int searchR(Searching[] array, int start, int half, int end, int value) {
        if (value > array[end].getValue() || value < array[start].getValue()) {
            return -1;
        }
        int a = end - start;
        int b = array[end].getValue() - array[start].getValue();
        int c = value - array[start].getValue();
        int d = (c * a) / b;
        int slide = d + start;
        if (slide > end || slide < start) {
            return -1;
        }
        if (array[slide].getValue() == value) {
            return slide;
        }
        if (value < array[slide].getValue()) {
            end = slide;
            return searchR(array, start, half, end, value);
        } else {
            start = slide;
            return searchR(array, start, half, end, value);
        }
    }
}
