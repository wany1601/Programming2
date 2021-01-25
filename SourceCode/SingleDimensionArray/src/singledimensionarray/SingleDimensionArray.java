/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singledimensionarray;

import java.util.Arrays;

/**
 *
 * @author andre
 */
public class SingleDimensionArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // decalre and initialize a double array with 5 elements
        double[] nums = new double[5];      // {0, 0, 0, 0, 0}
        
        // decalre and initialize a double arary with specific values
        double[] nums2 = {3, 5, -1, 10, 99}; 
        
        // declare an array and initialize it later
        double[] nums3;
        nums3 = new double[]{nums[0], nums2[4]};    
        
        // read an element from an array
        System.out.println(nums2[4]);       
        
        // modify an element of an array
        nums[0] = -1;                       
        System.out.println(nums[0]);
        
        // use Arrays.toString() to print the entire array
        System.out.println(Arrays.toString(nums));
        
        // use customized method to print the entire array
        System.out.println(toString(nums));
    }
    
    /**
     * Creates a string to represent an array with customized formate 
     * @param nums the input array
     * @return a string to represent an array with customized formate 
     */
    public static String toString(double[] nums) {
        String str = "";
        for (int i = 0; i < nums.length; i++)
            str += String.format("%-5.0f", nums[i]);
        
        return str;
    }
    
}
