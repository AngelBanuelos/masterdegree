/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package masterdegree.mac.exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author angel_banuelos
 */
public class Exercise1 {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Programa para calcular las r-permutaciones ");
        Permutation permutation = new Permutation();
        System.out.println("Siguiendo la formula: " + permutation.toString() + " n y r deben ser positivos no mayores a 10");
   
	try{
            System.out.println("Ingresa el valor para n: ");
	    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    String n = bufferRead.readLine();
            System.out.println("Ingresa el valor para r: ");
	    String r = bufferRead.readLine();  
	    System.out.println(permutation.getPermutation(Integer.parseInt(n), Integer.parseInt(r)));
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
        
    }
    
}
