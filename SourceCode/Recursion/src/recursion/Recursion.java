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
        // base case
        if (num == 0 || num == 1)
            return 1;

        // general pattern
        // f(5) = 1 * 2 * 3 * 4 * 5 = f(4) * 5
        // f(4) = 1 * 2 * 3 * 4
        // f(x) = f(x - 1) * x
        return factorial(num - 1) * num;
    }

    /**
     * calculates the fibonacci sequence of a number
     *
     * @param num the input number
     * @return the fibonacci sequence of the number
     *
     * F(0) = 0
     *
     * F(1) = 1
     *
     * F(2) = F(0) + F(1) = 1
     *
     * F(3) = F(1) + F(2) = 2
     *
     * F(4) = 3
     *
     * F(5) = 5
     *
     * F(6) = 8
     */
    public static int fibonacciRecursion(int num) {
        if (num == 0 || num == 1)
            return num;

        return fibonacci(num - 2) + fibonacci(num - 1);
    }

    public static int fibonacci(int num) {
        if (num == 0 || num == 1)
            return num;

        int f0 = 0;
        int f1 = 1;
        int result = 0;

        for (int i = 2; i <= num; i++) {
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }

        return result;
    }

    /**
     * reveres a string
     *
     * @param str the original string
     * @return the reversed string
     */
    public static String reverse(String str) {
        String str2 = "";

        for (int i = str.length() - 1; i >= 0; i--)
            str2 += str.charAt(i);

        return str2;
    }

    public static String reverseRecursion(String str) {
        // base
        if (str.isEmpty())
            return str;

        // general
        /*
            "hello" -> "olleh"
            "ello  + h"
            "llo + e"
            "lo + l"
            "o + l"
         */
        return reverseRecursion(str.substring(1)) + str.charAt(0);

    }

    /**
     * Checks if a String is palindrome (reading from left to right is the same
     * as reading from right to left) e.g.: lol, racecar, laval,
     *
     * @return if a String is palindrome
     */
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++)
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;

        return true;
    }

    public static boolean isPalindromeRecursion(String str) {
        // base
        if (str.length() <= 1)
            return true;

        // general
        // a|sdjfklasd|z
        return str.charAt(0) == str.charAt(str.length() - 1)
                && isPalindrome(str.substring(1, str.length() - 1));

        //
    }

    /**
     * Removes all vowels from a string
     *
     * @param str the original string
     * @return a string with no vowels inside
     */
    public static String removeVowelRecursion(String str) {
        // base
        if (str.isEmpty())
            return "";

        // general
        String vowels = "aeiou";
        String c = str.substring(0, 1).toLowerCase(); // take the first character

        // if the character is a vowel, then set it as empty
        if (vowels.contains(c))
            c = "";

        // the character plus the rest of the string
        return c + removeVowelRecursion(str.substring(1));
    }

    /**
     * Counts the number of vowels in a string
     *
     * @param str the input string
     * @return the number of vowels in the string
     */
    public static int countVowelRecursion(String str) {
        if (str.isEmpty())
            return 0;

        String vowels = "aeiou";
        return (vowels.contains(str.substring(0, 1)) ? 1 : 0)
                + countVowelRecursion(str.substring(1));
    }

    public static void towerOfHanoi(int disk, char start, char end, char assistant) {
        if (disk == 0)
            return;

        // move all disks on top from start to assistant
        towerOfHanoi(disk - 1, start, assistant, end);

        // move the biggest disk from start to end
        System.out.println(start + " -> " + end);

        // move all disks from assistant to end
        towerOfHanoi(disk - 1, assistant, end, start);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(countVowelRecursion("hello"));
    }

}
