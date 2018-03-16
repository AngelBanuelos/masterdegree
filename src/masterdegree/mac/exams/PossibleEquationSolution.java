package masterdegree.mac.exams;

/**
 *
 * @author Angel.Sahagun
 */
public class PossibleEquationSolution {

    private String equation;
    private int solutionCount;
    private String formula;

    public PossibleEquationSolution(String equation) {
        this.equation = equation;
    }

    public void run() {
        String result = equation.split("=")[1];
        String[] valiablesForSum = equation.split("=")[0].split("\\+");
        int n = valiablesForSum.length;
        int r = Integer.parseInt(result);
        formula = "C(n+r-1,r) = C(" + (n + r - 1) + "," + r + ")";
        Permutation permutation = new Permutation();
        long factorN = permutation.recursiveFactor(n + r - 1, 1);
        long factorR = permutation.recursiveFactor(r, 1);
        System.out.println("(n+r-1)!  = " + (n + r - 1) + "! = " + factorN);
        System.out.println("r! = " + r + "! = " + factorR);
        System.out.println("" + formula + " = " + (factorN / (factorR * permutation.recursiveFactor(n - 1, 1))));
        System.out.println("Para " + equation);
        for (int i = 0; i <= Integer.parseInt(result); i++) {
            for (int j = 0; j <= Integer.parseInt(result); j++) {
                for (int k = 0; k <= Integer.parseInt(result); k++) {
                    if (i + j + k == Integer.parseInt(result)) {
                        solutionCount++;
                        System.out.println(i + " + " + j + " + " + k + " = " + Integer.parseInt(result));
                    }
                }
            }
        }
    }

    public int getSolutionCount() {
        return solutionCount;
    }

    public String getFormula() {
        return formula;
    }

    @Override
    public String toString() {
        return "PossibleEquationSolution{" + "equation=" + equation + ", solutionCount=" + solutionCount + ", formula=" + formula + '}';
    }

}
