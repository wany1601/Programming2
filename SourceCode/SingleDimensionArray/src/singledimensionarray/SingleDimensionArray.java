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
        
        // compare two arrays
        int[] nums4 = {1, 2, 3};
        int[] nums5 = {1, 2, 3};
        // 1. using ==
        System.out.println(nums4 == nums5); // comparing the reference -> false
        // 2. using Arrays.equals()
        System.out.println(Arrays.equals(nums4, nums5)); // comparing the elements -> true
        
        // shallow copy VS deep copy
        int[] nums6 = {1, 2, 3};
        // shallow copy
        int[] nums7 = nums6;            // shallow copy
        nums6[0] = 999;
        System.out.println(nums7[0]);   // value get changed too
        // deep copy
        int[] nums8 = Arrays.copyOf(nums6, nums6.length);      // {1, 2, 3};
        nums6[1] = -1;
        System.out.println(nums8[1]);   // value does not get changed
        int[] nums9 = Arrays.copyOf(nums6, 2);      // {1, 2};
        System.out.println(Arrays.toString(nums9));
        int[] nums10 = Arrays.copyOf(nums6, 5);     // {1, 2, 3, 0, 0};
        System.out.println(Arrays.toString(nums10));
        int[] nums11 = Arrays.copyOfRange(nums6, 1, 2); // {}
        System.out.println(Arrays.toString(nums11));
        
        // sort an array
        int[] nums12 = {1, 6, 3, -2, 5, 0};
        int[] nums12Copy = Arrays.copyOf(nums12, nums12.length);
        // void method, direclty modify the entire original array, ascendingly
        Arrays.sort(nums12Copy);            
        System.out.println(Arrays.toString(nums12Copy));
        // void method, direclty modify part of the original array, ascendingly
        Arrays.sort(nums12Copy, 1, 4);
        System.out.println(Arrays.toString(nums12Copy));
        
        // fill an array with a specific value
        int[] nums13 = {1, 1, 1};
        Arrays.fill(nums13, 2);
        System.out.println(Arrays.toString(nums13));
        
        // modify an array
        int[] nums14 = {1, 2, 3};
        // using enhanced-for (WILL NOT work)
        for (int num : nums14)
            num++;      // num = num + 1
        // using regular-for (WILL work)
        for (int i = 0; i < nums14.length; i++)
            nums14[i]++;
        System.out.println(Arrays.toString(nums14));
        
        // call the addValue()
        double[] nums15 = {1, 2, 3};
        addValue(nums15, 3);
        System.out.println(Arrays.toString(nums15));
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
    
    /**
     * Removes an element at a specific location from an array
     * Example: {1,2,3,4,5,6,7} 2 -> {1,2,4,5,6,7}
     * @param nums the original array
     * @param idx the index of the element about to remove
     * @return a new array with one specific element deleted
     */
    public static double[] remove(double[] nums, int idx) {
        // solution 1: create an empty array and use a for loop to init the 
        // elements before the index
//        double[] nums2 = new double[nums.length - 1];
//        
//        // copy everything before idx
//        for (int i = 0; i < idx; i++) 
//            nums2[i] = nums[i];

        // solution 2: copy an array with one less element
        double[] nums2 = Arrays.copyOf(nums, nums.length - 1);

        // copy everything after idx
        for (int i = idx + 1; i < nums.length; i++) 
            nums2[i - 1] = nums[i];
        
        return nums2;
    }
    
    /**
     * Removes a character at a specific location from a String
     * @param str the original string
     * @param idx the index of the element about to remove
     * @return a new String with one specific character deleted
     */
    public static String remove(String str, int idx) {
        String str2 = "";
        
        // copy everything before idx
        for (int i = 0; i < idx; i++) 
            str2 += str.charAt(i);

        // copy everything after idx
        for (int i = idx + 1; i < str.length(); i++) 
            str2 += str.charAt(i);

        return str2;
    }
    
    /**
     * Creates an array in which each element is the reciprocal of the element 
     * in the original array (You have to use Arrays.fill())
     * Example: {1, 2, 3} -> {1, 0.5, 0.3}
     * @param nums the original array           
     * @return new reciprocal array             
     */
    public static double[] reciprocal(double[] nums) {
        double[] nums2 = new double[nums.length];            //{0,0,0}
        Arrays.fill(nums2, 1);                               // {1,1,1}
       
        for (int i = 0; i < nums2.length; i++)
            nums2[i] /= nums[i];         // nums2[i] = nums2[i] / nums[i];
       
        return nums2;
    }
    
    /**
     * Calculates the sum of an array
     * @param nums the input array
     * @return the sum of the array
     */
    public static double sum(double[] nums) {
        double sum = 0;
        
        for (double num : nums)
            sum += num;
        
        return sum;
    }
    
    /**
     * Adds a specific value to each element of an array, directly modify 
     * the original array
     * @param nums the input array
     * @param value the specific value
     */
    public static void addValue(double[] nums, double value) {
        for (int i = 0 ; i < nums.length; i++)
            nums[i] += value;
    }
    
    /**
     * Counts the number of odd numbers in an array
     * Example: {1, 2, 3} -> 2
     * @param nums the input array
     * @return the number of odd numbers in an array
     */
    public static int countOddNum(int[] nums) {
        int count = 0;
        
        for (int num : nums)
            if (num % 2 == 1)
                count++;
        
        return count;
    }
    
    /**
     * Adds elements in an array with odd index 
     * Example: {4, 6, 1, 9} -> 6 + 9 -> 15
     * @param nums the input array
     * @return the sum of elements in an array with odd index 
     */
    public static double sumElementsWithOddIdx(double[] nums) {
        double sum = 0;
        
        // solution 1;
        for (int i = 0; i < nums.length; i++) 
            if (i % 2 == 1)
                sum += nums[i];
        
        // solution 2;
        for (int i = 1; i < nums.length; i += 2) 
            sum += nums[i];
        
        return sum;
    }
    
    /**
     * Add elements of an double array if at the same position, the boolean 
     * array has a value of true, if the two array have different size, 
     * calculate the sum based on the short one.
     * Example: {1, 2, 3, 4, 5} {true, false, true} -> 4
     *           {1, 2, 3} {true, false, true, true, true} -> 4
     * @param nums the number array
     * @param flags the boolean array
     * @return the sum
     */
    public static double sum(double[] nums, boolean[] flags) {
        double sum = 0;
        int len = Math.min(nums.length, flags.length);
        
        // should use the regular for loop since we need the index system to 
        // synchronize the two array
        for (int i = 0; i < len; i++) 
            if (flags[i])       // // do not write "flags[i] == true"
                sum += nums[i];
        
        return sum;
    }

}
