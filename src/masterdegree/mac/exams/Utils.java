/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.mac.exams;

/**
 *
 * @author Angel.Sahagun
 */
public class Utils {
    
    public static long factorN(int n){
        long factorN = 1;
        for (int i = n; i >= 1; i--) {
            factorN *= i;
        }
        return factorN;
    }
    
    
    
}
