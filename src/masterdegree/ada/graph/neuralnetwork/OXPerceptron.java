/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.graph.neuralnetwork;

/**
 *
 * @author angel_banuelos
 */
public class OXPerceptron {

    static double[][] inputHiddenWeights;
    static double[] hiddenOutputWeights;
    static double[] hiddenLayerValues;
    final static int HIDDEN_LAYER_SIZE = 13;

    static void initWeight(int inputLayerSize) {
        inputHiddenWeights = new double[inputLayerSize][HIDDEN_LAYER_SIZE];
        hiddenOutputWeights = new double[HIDDEN_LAYER_SIZE];
        hiddenLayerValues = new double[HIDDEN_LAYER_SIZE];
        for (int i = 0; i < inputLayerSize; i++) {
            for (int j = 0; j < HIDDEN_LAYER_SIZE; j++) {
                inputHiddenWeights[i][j] = -0.1 + 0.2 * Math.random();
            }
        }
        for (int i = 0; i < HIDDEN_LAYER_SIZE; i++) {
            hiddenOutputWeights[i] = -0.1 + 0.2 * Math.random();
        }
    }

    static double activationFunction(double output) {
        return output > 0.5 ? 1.0 : 0.0;
    }

    static void trainPerceptron(byte[][] trainingMatrix, byte[] classes) {
        initWeight(trainingMatrix[0].length);
        int hits = 0;
        int currentRow = 0;
        int epochs = 0;
        while (trainingMatrix.length > hits && epochs <= 10000) {
            byte[] currentInput = trainingMatrix[currentRow];
            double output = getOuput(currentInput);

            double expectedOutput = classes[currentRow] == 0 ? 0.25 : 0.75;
            double error = expectedOutput - output;
            if (Math.abs(error) <= 0.25) {
                hits++;
            } else {
                hits = 0;
                backpropagation(currentInput, error, output);
            }

            currentRow++;
            if (currentRow == trainingMatrix.length) {
                epochs++;
                currentRow = 0;
            }
        }

    }

    public static void main(String[] args) {

    }

    static double getOuput(byte[] currentInput) {
        for (int i = 0; i < HIDDEN_LAYER_SIZE; i++) {
            double dot = 0;
            for (int j = 0; j < currentInput.length; j++) {
                dot += currentInput[j] * inputHiddenWeights[j][i];
            }
            hiddenLayerValues[i] = sigmoid(dot);
        }
        int output = 0;
        for (int i = 0; i < HIDDEN_LAYER_SIZE; i++) {
            output += hiddenLayerValues[i] * hiddenOutputWeights[i];
        }

        return sigmoid(output);
    }

    static double sigmoid(double dot) {
        return 1.0 / (1 + Math.exp(-dot));
    }

    static void backpropagation(byte[] currentInput, double error, double output) {
        final double LEARNING_RATE = 0.1;
        double outputDelta = error * dsigmoid(output);
        for (int i = 0; i < HIDDEN_LAYER_SIZE; i++) {
            hiddenOutputWeights[i] += hiddenLayerValues[i] * LEARNING_RATE * outputDelta;
        }
        double hiddenDeltas[] =  new double[HIDDEN_LAYER_SIZE];
        for (int i = 0; i < HIDDEN_LAYER_SIZE; i++) {
            hiddenDeltas[i] = dsigmoid(hiddenLayerValues[i]) * outputDelta * hiddenOutputWeights[i];
        }
        for (int i = 0; i < currentInput.length; i++) {
            for (int j = 0; j < HIDDEN_LAYER_SIZE; j++) {
                inputHiddenWeights[i][j] += currentInput[i] * LEARNING_RATE * hiddenDeltas[j];
            }
        }

    }

    private static double dsigmoid(double x) {
        return x * (1 - x);
    }

}
