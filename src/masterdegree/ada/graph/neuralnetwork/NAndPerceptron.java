/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.graph.neuralnetwork;

import java.util.Arrays;

/**
 *
 * @author angel_banuelos
 */
public class NAndPerceptron {

    static double getOutput(byte[] currentInput, double[] weights) {
        // feed forward
        double output = 0;
        for (int i = 0; i < currentInput.length; i++) {
            output += currentInput[i] * weights[i]; // producto punto. 
        }
        return output;
    }

    static double activationFunction(double output) {
        return output > 0.5 ? 1.0 : 0.0;
    }

    static void backpropagation(double error, byte[] input, double[] weight) {
        final double LEARNING_RATE = 0.1;
        double delta = error * LEARNING_RATE; // delta puede ser: -0.1, 0.0, 0.1
        for (int i = 0; i < weight.length; i++) {
            weight[i] += input[i] * delta;
        }
    }

    static double[] trainPerceptron(byte[][] trainingMatrix, byte[] classes) {

        double[] weights = new double[trainingMatrix[0].length];
        int hits = 0;
        int currentRow = 0;
        int iteration = 0;
        while (trainingMatrix.length > hits) {
            byte[] currentInput = trainingMatrix[currentRow];
            double output = getOutput(currentInput, weights);
            double af = activationFunction(output); // activation function
            double error = classes[currentRow] - af; // error purede ser: -1, 0, 1
            System.out.println(iteration + " " + Arrays.toString(currentInput) + " " + error);
            if (error == 0) {
                hits++;
            } else {
                hits = 0;
                backpropagation(error, currentInput, weights);
                // Backpropagation
            }
            currentRow++;
            iteration++;
            currentRow %= trainingMatrix.length; // to restart current row
        }
        return weights;
    }

    public static void main(String[] args) {
        byte[][] trainingMatrix = {{1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}};
        byte[] classes = {1, 1, 1, 0};

        double[] perceptron = trainPerceptron(trainingMatrix, classes);
        
        System.err.println(Arrays.toString(perceptron));
        
        double o = activationFunction(getOutput(new byte[]{1,1,1}, perceptron));
        System.out.println( "{1,1,1} " + o );
        
    }

}
