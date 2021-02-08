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

}
