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
package p1review;

/**
 *
 * @author Yi Wang
 */
public class ControlStructureExercise {

    /**
     * Counts the number of digits in a String
     *
     * @param str the input string
     * @return the number of digits in the string
     */
    public static int countDigit(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++)
            if (Character.isDigit(str.charAt(i)))
                count++;

        return count;
    }

    /**
     * Reverses the case in a string, upper to lower, and lower to upper
     *
     * @param strIn the input string
     * @return the reversed-cased string
     */
    public static String reverseString(String strIn) {
        String strOut = "";

        for (int i = 0; i < strIn.length(); i++) {
            char c = strIn.charAt(0);
            strOut += (Character.isLowerCase(c)
                    ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }

        return strOut;
    }

    /**
     * Checks if a number is prime or not
     *
     * @param num the input number
     * @return if the number is prime or not
     */
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;

        return true;
    }
}
