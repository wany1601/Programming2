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
package recursion;

/**
 *
 * @author Yi Wang
 */
public class Recursion {

    /**
     * For loop version Calculates the sum of numbers between [0, num)
     *
     * @param num the boundary, e.g.: 5
     * @return the sum of numbers between [0, num), e.g.{0, 1, ... 4} = 10
     */
    public static int sum(int num) {
        int sum = 0;

        for (int i = 1; i < num; i++)
            sum += i;

        return sum;
    }

    /**
     * Recursion version Calculates the sum of numbers between [0, num)
     *
     * @param num the boundary, e.g.: 5
     * @return the sum of numbers between [0, num), e.g.{0, 1, ... 4} = 10
     */
    public static int sumRecursion(int num) {
        // base base
        if (num == 0)
            return 0;

        // general patten           3 2 99
        // f(5): 0 + 1 + 2 + 3 + 4 -> f(4) + 4
        // f(4): 0 + 1 + 2 + 3     -> f(3) + 3
        // f(3): 0 + 1 + 2         -> f(2) + 2
        // f(2): 0 + 1             -> f(1) + 1
        // f(1): 0
        // general pattern:   f(5) = f(4) + 4
        //                    f(x) = f(x -1) + x - 1
        return sumRecursion(num - 1) + num - 1;
    }

    /**
     * calculates the factorial of a number
     *
     * @param num the input number, e.g.: 5
     * @return the factorial of the number, e.g.: 1 * 2 * 3 * 4 * 5 = 120
     */
    public static int factorial(int num) {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sumRecursion(1));
    }

}
