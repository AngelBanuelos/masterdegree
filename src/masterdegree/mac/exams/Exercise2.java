/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package masterdegree.mac.exams;

/**
 *
 * @author angel_banuelos
 */
public class Exercise2 {
    
    public static void main(String[] args) {
        System.out.println("Programa que imprime todas las \nposibles soluciones a la formula " );
        PossibleEquationSolution possible = new PossibleEquationSolution("x1+x2+x3=5");
        System.out.println("x1+x2+x3=5");
        possible.run();
        System.out.println(possible);
    }
    
}
