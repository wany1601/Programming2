/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1review;

/**
 *
 * @author Yi Wang
 */
public class ControlStructureExercise {
    
    /**
     * Counts the number of digits in a String
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
     * @param strIn the input string
     * @return the reversed-cased string
     */
    public static String reverseString(String strIn) {
        String strOut = "";
        
        for (int i = 0; i < strIn.length(); i++) {
            char c = strIn.charAt(0);
            strOut += (Character.isLowerCase(c) ? 
                    Character.toUpperCase(c) : Character.toLowerCase(c));
        }
        
        return strOut;
    }
    
    /**
     * Checks if a number is prime or not
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
