package masterdegree.mac.exams;

/**
 *
 * @author Angel.Sahagun
 */
public class Permutation {

    public long recursiveFactor(int n, int factorN) {
        factorN *= n;
        if (n <= 1) {
            return factorN;
        } else {
            return recursiveFactor(n - 1, factorN);
        }
    }

    public long getPermutation(int n, int r) throws Exception {
        if (r > n || n > 10 || (n * r) <= 0) {
            throw new Exception("Invalid number: \n'n' should be minor or equal to 10 and 'r' should be minor than 'n' \n (0 < r <= n <= 10 )");
        }
        return recursiveFactor(n, 1) / recursiveFactor((n - r) == 0 ? 1 : (n - r), 1);
    }

    @Override
    public String toString() {
        return "P(n,r) =  n! / (n-r)!";
    }

    private int factorN(int n) {
        int factorN = 1;
        for (int i = n; i > 0; i--) {
            factorN *= i;
        }
        return factorN;
    }
}
