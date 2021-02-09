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

import java.util.Arrays;

/**
 *
 * @author Yi Wang
 */
public class MultiDimensionArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] numss = {{1, 2, 3}, {4, 5}};

        increaseValue(numss, 100);

        System.out.println(Arrays.deepToString(numss));
    }

    /**
     * Increases each element in the array by a specific value
     *
     * @param numss the input array
     * @param value the amount to increase
     */
    public static void increaseValue(double[][] numss, double value) {
        for (double[] nums : numss)
            for (int j = 0; j < nums.length; j++)
                nums[j] += value;
    }

    /**
     * Calculates the sum of a 2d array
     *
     * @param numss the input 2d array
     * @return the sum of the 2d array
     */
    public static double sum(double[][] numss) {
        int sum = 0;

        for (double[] nums : numss)
            for (double num : nums)
                sum += num;

        return sum;
    }

    /**
     * Finds the max value in a 2d array
     *
     * @param numss the input 2d array
     * @return the max value in the 2d array
     */
    public static double max(double[][] numss) {
        double max = Double.NEGATIVE_INFINITY;
//        double max = Double.MIN_VALUE;

        for (double[] nums : numss)
            for (double num : nums)
                max = Math.max(max, num);

        return max;
    }

    /**
     * Finds the max in each row of a 2d array.
     *
     * Example:
     *
     * 1 2 3
     *
     * 4 1 2 3
     *
     * 1 1 -1 0 -2
     *
     * -> {3, 4, 1}
     *
     * @param numss the input 2d array
     * @return the max in each row of that 2d array 17
     */
    public static double[] maxInRow(double[][] numss) {
        double[] maxs = new double[numss.length];      // {0, 0, 0}
        Arrays.fill(maxs, Double.NEGATIVE_INFINITY);   // {-INF, -INF, -INF}

        for (int i = 0; i < numss.length; i++)
            for (double num : numss[i])
                maxs[i] = Math.max(num, maxs[i]);

        return maxs;
    }

    /**
     * Calculates the average of each row of a 2d array
     *
     * Example:
     *
     * 1 2 3
     *
     * 4 1 2 3
     *
     * 1 1 -1 0 -2
     *
     * -> {2, 2.5, -0.2}
     *
     * @param numss the input 2d array
     * @return the average of each row of the 2d array
     */
    public static double[] avgInRow(double[][] numss) {
        double[] avgs = new double[numss.length];           // {0, 0, 0}

        for (int i = 0; i < numss.length; i++) {
            // sum a row
            for (double num : numss[i])
                avgs[i] += num;

            // avg a row
            avgs[i] /= numss[i].length;
        }

        return avgs;
    }

    /**
     * Finds the max in each column of a 2d array.
     *
     * Example:
     *
     * 1 2 3
     *
     * 4 1 2 3
     *
     * 1 1 -1 0 -2
     *
     * -> {4, 2, 3, 3, -2}
     *
     * @param numss the input 2d array
     * @return the max in each column of that 2d array
     */
    public static double[] maxInCol(double[][] numss) {
        // find the longest row in the 2d array
        int maxCol = 0;
        for (double[] nums : numss)
            maxCol = Math.max(maxCol, nums.length);

        double[] maxs = new double[maxCol];      // {0, 0, 0, 0, 0}
        Arrays.fill(maxs, Double.NEGATIVE_INFINITY);   // {-INF, -INF, -INF, -INF, -INF}

        for (double[] nums : numss)
            for (int j = 0; j < nums.length; j++)
                maxs[j] = Math.max(nums[j], maxs[j]);

        return maxs;
    }

    /**
     * Calculates the average of each column of a 2d array
     *
     * Example:
     *
     * 1 2 3
     *
     * 4 1 2 3
     *
     * 1 1 -1 0 -2
     *
     * -> {2, 1.33, 1.33, 1.5, -2}
     *
     * @param numss the input 2d array
     * @return the average of each column of the 2d array
     */
    public static double[] avgInCol(double[][] numss) {
        // find the longest row in the 2d array
        int maxCol = 0;
        for (double[] nums : numss)
            maxCol = Math.max(maxCol, nums.length);

        double[] avgs = new double[maxCol];      // {0, 0, 0, 0, 0}

        for (double[] nums : numss)
            for (int j = 0; j < nums.length; j++)
                avgs[j] += nums[j];

        // TODO: figure out the number for the division
        return avgs;
    }

}
