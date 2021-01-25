# Single-dimension Array



## 1. What is an Array

An array is a collection of data, **with the same data type**. The data type could be different from one array to another.

**An array is an object**, which contains two pieces of memories. So it also faces the shallow copy / deep copy, and equals issue.

## 2. How to create an array

There are two ways to create an array:

1. If you know the size of the array, but there is no specific initial values, use the keyword **new** to create. When you use this way to create an array, default values will be given to each elements.

```java
// datatype[] varname = new datatype[length];
double[] scores = new double[22];			// the length is obligated, and CANNOT be changed.
double scores[] = new double[22];			// do not suggest
Clock[] clocks = new Clock[5];				// an array of objects
```

​	Default values are given based on the data type:

| Data type                         | Default value-              |
| --------------------------------- | --------------------------- |
| double, int, char (or any number) | 0                           |
| boolean                           | false                       |
| String                            | null, not empty string ("") |
| Clock (any class)                 | null                        |

2. If you not only know the size of the array, but also want to give some specific values to initialize it, use the following syntax to initialize it:

   ```java
   // datatype[] varname = {element1, element2, ..... elementN};
   String[] validDifficultyLevels = {"Easy", "Medium", "Hard"};	// no need to give the length
   ```

3. Sometimes, you may need to declare an array and then initialize it in another place

   ```java
   double[] nums;										// declare an array
   double num1 = 5;
   double num2 = 3;
   double num3 = num1 + num2;
   double num4 = num1 - num2;
   nums = {num1, num2, num3, num4};				    // ERROR
   nums = new double[]{num1, num2, num3, num4};		//  Correct, initialize the array
   ```


## 3. How to visit an array

An array is very similar to a string.

| Purpose           | String          | Array        |
| ----------------- | --------------- | ------------ |
| Check the length  | str.length()    | array.length |
| Read an element   | str.charAt(idx) | array[idx]   |
| Modify an element | Does not exist  | array[idx]   |



## 4. How to fix the problems with two pieces of memory

 	Object takes two pieces of memory, which creates some problems when we use it, for example, when you want to

1. **print the entire object**

   Usually for a class, we have to override a toString() method, so it does not give us the address of the object when we print it.

   For Array, there is a specific method created for us already: `Arrays.toString(array)`, which will return you a string to represent the array. However, you cannot customize the output format.

   ```java
   int[] nums = {1, 2 ,3};
   
   System.out.print(Arrays.toString(nmums));		// prints the array at once:     [1, 2, 3]
   ```

   

   If you really want to customize the format, create a loop to go through element by yourself.

   ```java
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
   ```

   

2. TODO


