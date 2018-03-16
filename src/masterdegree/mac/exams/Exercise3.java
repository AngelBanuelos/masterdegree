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
public class Exercise3 {
    
    public static void main(String[] args) {
        
        System.out.println("Programa que imprime todos los bits posibles en un byte");
        System.out.println("En orden creciente de menor a mayor.");
        
        ByteToBinaryConverter converter ;
        try{
        System.out.println("Ingresa el numero de Byte \"Usa maximo el 2\"");  
	    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    String n = bufferRead.readLine();
            converter = new ByteToBinaryConverter(Integer.parseInt(n));
            converter.convert();
	    converter.print();
            System.out.println(converter);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
        
        
    }
    
}
