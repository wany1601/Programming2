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
        double max = Double.NEGATIVE_INFINITY;  // or Double.MIN_VALUE

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
     * -> sum: {6, 4, 4, 3, -2}
     *
     * -> count: {3, 3, 3, 2, 1}
     *
     * -> avgs: {2, 1.33, 1.33, 1.5, -2}
     *
     * @param numss the input 2d array
     * @return the average of each column of the 2d array
     */
    public static double[] avgInCol(double[][] numss) {
        // find the longest row in the 2d array
        int maxCol = 0;
        for (double[] nums : numss)
            maxCol = Math.max(maxCol, nums.length);

        double[] avgs = new double[maxCol];         // {0, 0, 0, 0, 0}
        double[] counts = new double[maxCol];       // {0, 0, 0, 0, 0}

        for (double[] nums : numss)
            for (int j = 0; j < nums.length; j++) {
                avgs[j] += nums[j];              // calc the sum
                counts[j]++;                    // count the number of elements
            }

        // calc the real avgs
        for (int i = 0; i < avgs.length; i++)
            avgs[i] /= counts[i];

        return avgs;
    }

    /**
     * Appends a new number in the end of a specific row in a 2d array
     *
     * Example: {{1,2,0,0,0},{3,4}}, 5, 1 -> {{1,2,0,0,0},{3,4,5}}
     *
     * @param numss the input 2d array
     * @param num the new number to append
     * @param rowIdx the index of the row you want to append the number to
     */
    public static void appendNum(double[][] numss, double num, int rowIdx) {
        double[] row = Arrays.copyOf(numss[rowIdx], numss[rowIdx].length + 1);
        row[row.length - 1] = num;
        numss[rowIdx] = row;
    }

    /**
     * Inserts a new row in a 2d array
     *
     * Example: {{1,2,0,0,0},{3,4}}, {9,9,9}, 1 -> {{1,2,0,0,0},{9,9,9},{3,4}}
     *
     * @param numss the input 2d array
     * @param nums the new row to append
     * @param idx where the new row is append to
     * @return the new array with the additional row inserted
     */
    public static double[][] insertRow(double[][] numss, double[] nums, int idx) {
        double[][] numss2 = Arrays.copyOf(numss, numss.length + 1);

        numss2[idx] = nums;

        for (int i = idx; i < numss.length; i++)
            numss2[i + 1] = numss[i];

        return numss2;
    }

    /**
     * Generates a matrix with random numbers in range [min(bound1, bound2),
     * max(bound1, bound2))
     *
     * Example: 3, 4, 2, 5 -> {{3,3,4,2},{4,2,3,4},{2,3,2,2}}
     *
     * @param row the number of row of the matrix
     * @param col the number of column of the matrix
     * @param bound1 the bound of the range
     * @param bound2 another bound of the range
     * @return a matrix with random numbers inside
     */
    public static double[][] generateRandomMatrix(int row, int col,
            double bound1, double bound2) {
        double[][] numss = new double[row][col];            // matrix
        double min = Math.min(bound1, bound2);
        double max = Math.max(bound1, bound2);          // [3.1,   5.5)

        if (bound1 > bound2) {
            double temp = bound1;
            bound1 = bound2;
            bound2 = temp;
        }

        for (double[] nums : numss)
            for (int j = 0; j < col; j++)
                // [0, 1) -> [0, 2.4) -> [3.1, 5.5)
                nums[j] = min + Math.random() * (max - min);

        return numss;
    }

    /**
     * Adds two 2-D double arrays together; returns a new array,
     *
     *
     * Example:
     *
     * numss1:
     *
     * 1 2 3
     *
     * 4 5
     *
     * 2 2 2
     *
     * 3 3 3
     *
     * numss2:
     *
     * 1 2 3 | 4 5
     *
     * 1 1 1
     *
     * results:
     *
     * 2 3 6 4 5
     *
     * 5 6 1
     *
     * 2 2 2
     *
     * 3 3 3
     *
     * @param numss1 a 2d array
     * @param numss2 another 2d array
     * @return a new array that contains the sum of the two 2d array
     */
    public static double[][] add(double[][] numss1, double[][] numss2) {
        int maxRow = Math.max(numss1.length, numss2.length);
        int minRow = Math.min(numss1.length, numss2.length);

        double[][] numss3 = new double[maxRow][];

        // row overlapping
        for (int i = 0; i < minRow; i++) {
            int maxCol = Math.max(numss1[i].length, numss2[i].length);
            int minCol = Math.min(numss1[i].length, numss2[i].length);

            numss3[i] = new double[maxCol];

            // column overlapping
            for (int j = 0; j < minCol; j++)
                numss3[i][j] = numss1[i][j] + numss2[i][j];

            // column additional
            double[] longRow = (numss1[i].length > numss2[i].length) ? numss1[i] : numss2[i];
            for (int j = minCol; j < maxCol; j++)
                numss3[i][j] = longRow[j];

        }

        // row additional
        double[][] largeArray = (numss1.length > numss2.length) ? numss1 : numss2;
        for (int i = minRow; i < maxRow; i++)
            numss3[i] = largeArray[i];

        return numss3;
    }

    /**
     * append a 2-D double array at the right of another 2-D double array.
     *
     * Example:
     *
     * numss1:
     *
     * 1 2 3
     *
     * 4 5
     *
     * numss2:
     *
     * 1 2 3 4 5
     *
     * 1 1 1
     *
     * 2 2 2
     *
     * 3 3 3
     *
     * result:
     *
     * 1 2 3 | 1 2 3 4 5
     *
     * 4 5 | 1 1 1
     *
     * 2 2 2
     *
     * 3 3 3
     *
     * @param numss1 a 2d array
     * @param numss2 another 2d array
     * @return a new 2d array withe numss2 expended after numss1
     */
    public static double[][] expendArray(double[][] numss1, double[][] numss2) {
        int maxRow = Math.max(numss1.length, numss2.length);
        int minRow = Math.min(numss1.length, numss2.length);

        double[][] numss3 = new double[maxRow][];

        // row overlapping
        for (int i = 0; i < minRow; i++) {
            numss3[i] = new double[numss1[i].length + numss2[i].length];

            // copy a row in numss1
            for (int j = 0; j < numss1[i].length; j++)
                numss3[i][j] = numss1[i][j];

            // copy a row in numss2 with a shift
            for (int j = 0; j < numss2[i].length; j++)
                numss3[i][j + numss1[i].length] = numss2[i][j];
        }

        // row additional
        double[][] largeArray = (numss1.length > numss2.length) ? numss1 : numss2;
        for (int i = minRow; i < maxRow; i++)
            numss3[i] = largeArray[i];

        return numss3;
    }

    public static void main(String[] args) {
        double[][] numss = {{1, 2, 0, 0, 0}, {3, 4}};
        double[][] numss2 = {{1, 2, 0, 0, 0}, {3, 4}};

        System.out.println(Arrays.deepToString(generateRandomMatrix(3, 4, 5.5, 3.1)));
//        System.out.println(numss.equals(numss2));   // comparing the address of numss and numss2
//        System.out.println(Arrays.equals(numss, numss2));   // comparing the address of 1d array inside of numss and numss2
        System.out.println(Arrays.deepEquals(numss, numss2));   // comparing each double value inside of numss and numss2
        double[] nums = {9, 9, 9};
//        appendNum(numss, 5, 1);
        System.out.println(Arrays.deepToString(insertRow(numss, nums, 1)));
    }
}
