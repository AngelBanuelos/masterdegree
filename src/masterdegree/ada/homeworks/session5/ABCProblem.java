/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author angel_banuelos
 */
public class ABCProblem {

    /*
     You will be given three integers A, B and C. The numbers will not be given in that exact order, but
     we do know that A is less than B and B less than C. In order to make for a more pleasant viewing, we
     want to rearrange them in the given order.
    
     The input contains on the first line the number of test cases (N). Each test case consists of two input
     lines. The first line contains three positive integers A, B and C, not necessarily in that order. All three
     numbers will be less than or equal to 100. The second line contains three uppercase letters 'A', 'B' and
     'C' (with no spaces between them) representing the desired order.
    
     Output the A, B and C in the desired order on a single line, separated by single spaces.
     */
    public static void main(String[] args) {
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String text = bufferRead.readLine();
            int testCases = Integer.parseInt(text);
            int i = 0;
            while (i < testCases) {
                String[] numbers = bufferRead.readLine().split(" ");
                String letters = bufferRead.readLine();
                int[] array = new int[numbers.length];
                int j = 0, C = 0, B = 0, A = 0;
                for (String s : numbers) {
                    array[j++] = Integer.parseInt(s);
                    if (array[j - 1] > array[C]) {
                        C = (j - 1);
                    }
                    if ( array[j - 1] < array[A]) {
                        A = (j - 1);
                    }
                }
                if ((A + C) == 1) {
                    B = 2;
                } else if ((A + C) == 2) {
                    B = 1;
                } else{
                    B = 0;
                }
                for (int k = 0; k < 3; k++) {
                    if (letters.substring(k, k + 1).equalsIgnoreCase("A")) {
                        System.out.print(array[A] + " ");
                    } else if (letters.substring(k, k + 1).equalsIgnoreCase("B")) {
                        System.out.print(array[B] + " ");
                    } else if (letters.substring(k, k + 1).equalsIgnoreCase("C")) {
                        System.out.print(array[C] + " ");
                    }
                }
                System.out.println();
                i++;
            }

        } catch (Exception e) {
            System.err.println("" + e);
        }
    }

}
