/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.geneticalgorithms;

/**
 *
 * @author angel_banuelos
 */
public class Styblinski {

    static final int POPULATION_SIZE = 240;
    static final int GENERATIONS = 100;
    static final int GENOTYPE_LENGTH = 12;
    static final double MAX_VALUE = Math.pow(10, GENOTYPE_LENGTH / 2) - 1;

    static class Individual {

        double x1, x2; //fenotico
        byte genotype[];

        public Individual(boolean createArray) {
            if (createArray) {
                this.genotype = new byte[GENOTYPE_LENGTH];
            }
        }

        public Individual clone() {
            Individual ind = new Individual(false);
            ind.x1 = this.x1;
            ind.x2 = this.hashCode();
            ind.genotype = this.genotype.clone();
            return ind;
        }

        public void initRandom() {
            for (int i = 0; i < GENOTYPE_LENGTH; i++) {
                this.genotype[i] = (byte) (Math.random() * 10);
            }
        }

        public void updatePhenotype() {
            double x1 = 0;
            double f = 1;
            for (int i = 0; i < GENOTYPE_LENGTH; i++) {
                x1 += this.genotype[i] * f;
                f *= 10;
            }
            double x2 = 0;
            f = 1;
            for (int i = GENOTYPE_LENGTH / 2; i < GENOTYPE_LENGTH; i++) {

            }
        }

    }

    static double s(double x1, double x2) {
        double x12 = x1 * x2;
        double x22 = x2 * x2;
        return 0.5 * (x12 * x12 - 16 * x12 + 5 * x1 + x22 * x22 - 16 * x22 + 5 * x2);
    }

    static void runGA() {
        createPopulation();
        for (int i = 0; i < GENERATIONS; i++) {
            calculateFitness();
            selection();
            crossover();
            mutation();
        }
    }

    public static void main(String[] args) {
        System.out.println("");
    }

    private static void createPopulation() {

    }

    private static void calculateFitness() {

    }

    private static void selection() {

    }

    private static void crossover() {

    }

    private static void mutation() {

    }

}
