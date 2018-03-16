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
public class Combination {

    public static long combination(int n, int r) throws Exception {
        long combination = 0;
        if (n < r) {
            throw new Exception("n should be greater than r");
        } else if (n == r) {
            return 1;
        }
        long factorN = 1;
        int top = (n - r - 1);
        System.out.println("top= " + top);
        for (int i = 0; i < (top==0?1:top); i++) {
            factorN *= n--;
        }
        System.out.println("factorN=" + factorN);
        System.out.println("FactorR=" + Utils.factorN(r));
        combination = factorN / Utils.factorN(r);
        return combination;
    }

    @Override
    public String toString() {
        return "Combination{ c(n,r) = (n!/(r!*(n-r)!))}";
    }

}
