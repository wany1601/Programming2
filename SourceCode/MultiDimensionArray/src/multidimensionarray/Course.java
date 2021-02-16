/*
 * The MIT License
 *
 * Copyright 2021 Yi Wang.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package multidimensionarray;

/**
 * A class of Course
 *
 * @author Yi Wang
 */
public class Course {

    private double[][] scores;          // each row is for a student, each column is for an assignment/exam
    private double[] weights;           // the weight for each assignment/exam

    public Course() {
        scores = MultiDimensionArray.generateRandomMatrix(20, 10, 0, 100);
        weights = new double[]{0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.3, 0.3};
    }

    /**
     * Calculates the final scores (weighted sum) for all students
     *
     * @return the final scores of all students
     */
    public double[] calcStudentFinalScore() {
        double[] finalScores = new double[scores.length];

        for (int i = 0; i < finalScores.length; i++)    // need an idx for scores and finalScores
            for (int j = 0; j < weights.length; j++)    // need an idx for scores and weights
                finalScores[i] += scores[i][j] * weights[j];

        return finalScores;
    }

    // TODO: continue with this class
}
