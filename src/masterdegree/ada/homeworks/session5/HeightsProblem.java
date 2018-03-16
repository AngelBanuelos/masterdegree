/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import masterdegree.ada.sort.Insertion;

/**
 *
 * @author angel_banuelos
 */
public class HeightsProblem {

    /*
     Descripcion: Estás a cargo de un grupo de alumnos de primaria quienes se tienen que formar por estatura cuando
     el director toca la campana para salir del salón. Los alumnos salen del salón formados en una fila
     siguiendo un orden arbitrario, tal vez los que estaban más cerca de la puerta están hasta adelante.
     Como conoces las estaturas de tus alumnos, sabes cuál debe ser el orden definitivo. Sin embargo, no
     quieres crear un caos afuera de tu salón. Para ordenar, quitas de su lugar actual a un alumno a la vez
     y lo llevas hasta delante hasta encontrar a uno más chaparrito. Todos los alumnos más altos que
     estaban adelante se mueven un paso atrás. Deseas realizar esta acción la mínima cantidad de veces.
    
     Entrada: La primera línea contiene un número entero T > 0 que denota el número de casos de prueba. Cada
     caso de prueba comienza con un número entero N ≥ 2 que denota el número de alumnos. Le sigue
     una lista de N nombres diferentes de alumnos separados por espacios; cada nombre se compone de
     una palabra. Esta lista representa el acomodo de los alumnos al salir del salón; a esta lista le sigue
     otra lista con el mismo formato, que denota el acomodo esperado de los alumnos (por estaturas).
    
     Salida: Por cada caso de prueba, imprime una lista de nombres de alumnos que tuvieron que salirse de su
     lugar para llegar al acomodo esperado. Si nadie se tuvo que salir de su lugar, imprime “Ordenado”
    
     */
    public static void main(String[] args) {

        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String text = bufferRead.readLine();
            int testCases = Integer.parseInt(text);
            if (testCases <= 0) {
                System.err.println("Number of test cases should be greater than 0");
            }
            int i = 0;
            while (i < testCases) {
                bufferRead.readLine().trim();
                String helper = bufferRead.readLine().trim();
                String names[] = helper.split(" ");
                Student[] array = new Student[names.length];
                for (int j = 0; j < names.length; j++) {
                    array[j] = new Student(names[j]);
                }
                helper = bufferRead.readLine().trim();
                String[] order = helper.split(" ");
                for (int j = 0; j < order.length; j++) {
                    int k = 0;
                    while (array[j].getOrder() == -1 && k < order.length) {
                        if (array[j].getName().equalsIgnoreCase(order[k])) {
                            array[j].setOrder(k);
                        }
                        k++;
                    }
                }
                Insertion insertion = new Insertion();
                insertion.sort(array);
                boolean sorted = true;
                for (Student student : array) {
                    if (student.isSelected()) {
                        System.out.print("" + student.getName() + " ");
                        sorted = false;
                    }
                }
                if (sorted) {
                    System.out.print("Ordenado");
                }
                System.out.println("");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
