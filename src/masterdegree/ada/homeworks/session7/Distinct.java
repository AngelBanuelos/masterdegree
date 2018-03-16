
package masterdegree.ada.homeworks.session7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @authors 
 * BANUELOS SAHAGUN ANGEL DE JESUS 
 * FLORES DIAZ JOSE ARMANDO
 * GARCIA FERMIN GENARO
 */

public class Distinct {
    
    public static class Case{
        public String[] sequence;
        public String[] subsequence;
        
        public Case(String[] sequence, String[] subsequence){
            this.sequence = sequence;
            this.subsequence = subsequence;
        }

        public long distinct(String[] a, String[] b, int i, int j) {
                if (j == b.length) {
                        if (i == a.length && !a[i-1].equals(b[j-1])) return 0;
                        else return 1;
                } 
                if (i == a.length) return 0;

                if (a[i].equals(b[j]) ) 
                        return distinct(a, b, i+1, j+1) + distinct(a, b, i+1, j);
                else 
                        return distinct(a, b, i+1, j);
        }


        public long analize(){
            return distinct(this.sequence, this.subsequence, 0, 0);
        }
        


     }

    public static String[] splitInArray(String string){
        String[] a = new String[string.length()];
        for(int i=0; i<a.length; i++){
            a[i] = string.substring(i, i+1);
        }
        return a;
    }    

    public static void getDistinct(){
        System.out.println("\n Distinct Subsequences"); 
        // scanning from the input user  
        try (Scanner sc = new Scanner(System.in)){
            int N = sc.nextInt();
            sc.nextLine(); 
            // a tree for a case
            ArrayList<Case> cases = new ArrayList<>();
            // reading all cases
            for(int n = 0; n < N; n++){
                String sequence = sc.nextLine(); 
                String subsequence = sc.nextLine(); 
                String[] a = splitInArray(sequence);
                String[] b = splitInArray(subsequence);
                cases.add(new Case(a,b)); 
            }
            // Print each case
            System.out.println("\n Output");
            for(int n = 0; n < N; n++){
                Case cas = cases.get(n);
                long d = cas.analize();
                System.out.println("" + d);
            }
            System.out.println("");
        }
}    
    
    public static void main(String[] args){
        getDistinct();
    }
    
    
}
