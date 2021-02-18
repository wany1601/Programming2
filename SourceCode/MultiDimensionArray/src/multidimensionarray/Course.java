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

    private double[][] scoress;          // each row is for a student, each column is for an assignment/exam
    private double[] weights;           // the weight for each assignment/exam

    public Course() {
        scoress = MultiDimensionArray.generateRandomMatrix(20, 10, 50, 100);
        weights = new double[]{0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.3, 0.3};
    }

    /**
     * Calculates the final scores (weighted sum) for all students
     *
     * @return the final scores of all students
     */
    public double[] calcStudentsFinalScores() {
        double[] finalScores = new double[scoress.length];

        for (int i = 0; i < finalScores.length; i++)    // need an idx for scores and finalScores
            for (int j = 0; j < weights.length; j++)    // need an idx for scores and weights
                finalScores[i] += scoress[i][j] * weights[j];

        return finalScores;
    }

    /**
     * Calculates the average of each assignment
     *
     * @return the average of each assignment
     */
    public double[] calcAssignmentsAvgs() {
        return MultiDimensionArray.avgInCol(scoress);
    }

    /**
     * Calculates the standard deviation of each assignment, with classic nested
     * for loops: first row, then column
     *
     * @return the standard deviation of each assignment
     */
    public double[] calcAssignmentsStds() {
        double[] avgs = calcAssignmentsAvgs();
        double[] stds = new double[avgs.length];

        for (double[] scores : scoress)                 // row
            for (int j = 0; j < stds.length; j++)       // col
                stds[j] += Math.pow(scores[j] - avgs[j], 2);

        for (int i = 0; i < stds.length; i++) {
            stds[i] /= scoress.length;
            stds[i] = Math.sqrt(stds[i]);
        }

        return stds;

    }

    /**
     * Calculates the standard deviation of each assignment, with special nested
     * for loops: first column, then row
     *
     * @return the standard deviation of each assignment
     */
    public double[] calcAssignmentsStds2() {
        double[] avgs = calcAssignmentsAvgs();
        double[] stds = new double[avgs.length];

        for (int j = 0; j < stds.length; j++) {             // col
            for (double[] scores : scoress)                 // row
                stds[j] += Math.pow(scores[j] - avgs[j], 2);

            stds[j] /= scoress.length;
            stds[j] = Math.sqrt(stds[j]);
        }

        return stds;
    }

    /**
     * A1 A2 A3 A4 A5 A6 A7 A8 A9 A10 Final
     *
     * S1 56.2 59.0 90.0 73.6 72.5 58.7 96.5 68.2 86.7 91.6 82.2
     *
     * S2 57.2 53.9 97.3 99.2 96.6 60.2 56.1 96.8 56.5 96.1 76.6
     *
     * S3 89.4 59.6 87.5 53.0 79.8 87.3 98.7 64.9 80.7 98.2 84.7
     *
     * S4 87.4 74.9 84.8 58.6 70.1 88.2 63.8 64.1 86.7 89.3 82.4
     *
     * S5 74.9 53.3 69.5 90.2 52.1 92.2 55.4 77.2 58.7 88.1 72.3
     *
     * S6 64.0 61.0 75.9 51.9 78.6 96.0 90.5 51.2 90.2 70.2 76.6
     *
     * S7 70.6 60.5 57.6 80.3 84.6 88.9 89.0 50.2 73.0 87.7 77.3
     *
     * S8 67.6 63.7 76.3 61.9 77.7 79.4 55.9 88.1 83.4 62.3 72.2
     *
     * S9 65.9 66.3 71.0 66.3 94.5 62.1 92.0 72.7 95.6 76.0 81.0
     *
     * S10 80.8 90.8 67.6 58.6 75.0 51.1 67.5 73.3 80.8 77.7 75.8
     *
     * S11 62.4 93.0 57.5 51.2 80.0 52.6 90.7 84.4 62.7 70.6 68.6
     *
     * S12 79.9 61.5 65.8 87.3 91.6 52.0 62.1 63.1 64.3 97.0 76.6
     *
     * S13 81.1 69.8 51.7 77.3 57.3 53.0 58.7 58.5 58.3 91.1 70.2
     *
     * S14 99.5 80.1 89.8 69.3 52.9 89.7 93.7 92.6 97.4 98.2 92.1
     *
     * S15 64.9 53.8 76.0 72.9 57.8 84.0 80.8 58.7 90.3 57.1 71.7
     *
     * S16 94.5 65.4 76.9 83.4 86.6 83.8 89.9 77.4 95.7 93.5 89.6
     *
     * S17 95.7 98.3 63.7 55.1 60.3 67.1 99.6 82.1 96.7 80.0 84.1
     *
     * S18 64.8 69.0 98.2 95.6 59.6 60.7 60.4 94.3 85.5 81.1 80.1
     *
     * S19 93.6 67.1 71.2 98.9 66.1 65.4 75.8 99.3 91.5 57.6 76.6
     *
     * S20 71.5 87.7 94.8 61.9 64.5 98.3 90.8 95.5 76.6 94.2 84.5
     *
     * Avg 76.1 69.4 76.2 72.3 72.9 73.5 78.4 75.6 80.6 82.9
     *
     * Std 13.2 13.3 13.4 15.7 13.5 16.2 16.1 15.2 13.5 13.1
     *
     * @return a string that represents all students' assignments scores and
     * final scores, also with the average and the standard deviation of each
     * assignment
     */
    @Override
    public String toString() {
        double[] avgs = calcAssignmentsAvgs();
        double[] stds = calcAssignmentsStds();
        double[] finalScores = calcStudentsFinalScores();

        int row = scoress.length;
        int col = scoress[0].length;

        String str = "";

        // row header
        str += String.format("%-7s", "");
        for (int j = 0; j < col; j++)
            str += String.format("A%-6d", j + 1);
        str += String.format("%11s", "Final\n");

        // scores
        for (int i = 0; i < row; i++) {
            str += String.format("S%-6d", i + 1);
            for (double score : scoress[i])
                str += String.format("%-7.1f", score);
            str += String.format("%10.1f\n", finalScores[i]);
        }

        // avgs
        str += String.format("\n%-7s", "Avg");
        for (int j = 0; j < col; j++)
            str += String.format("%-7.1f", avgs[j]);
        str += '\n';

        // stds
        str += String.format("%-7s", "Std");
        for (int j = 0; j < col; j++)
            str += String.format("%-7.1f", stds[j]);
        str += '\n';

        return str;
    }

    public static void main(String[] args) {
        Course c = new Course();
        System.out.println(c);
    }

}
