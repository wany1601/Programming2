# Single-dimension Array



## 1. What is an Array

An array is a collection of data, **with the same data type**. The data type could be different from one array to another.

**An array is an object**, which contains two pieces of memories. So it also faces the shallow copy / deep copy, and equals issue.

## 2. How to create an array

There are two ways to create an array:

1. If you know the size of the array, but there is **no specific initial values**, use the keyword **new** to create. When you use this way to create an array, default values will be given to each elements.

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

2. If you not only know the size of the array, but also want to **initialize it with specific values**, use **{}** to initialize it:

```java
// datatype[] varname = {element1, element2, ..... elementN};

String[] validDifficultyLevels = {"Easy", "Medium", "Hard"};	// no need to give the length
```

3. Sometimes, you may need to declare an array and then initialize it in another place

```java
double[] nums;									   // declare an array
double num1 = 5;
double num2 = 3;
double num3 = num1 + num2;
double num4 = num1 - num2;
nums = {num1, num2, num3, num4};				    // ERROR
nums = new double[5];							   // Correct, initlize the array with default values
nums = new double[]{num1, num2, num3, num4};		 //  Correct, initialize the array with specific values
```

## 3. How to visit an array

An array is very similar to a string.

| Purpose           | String            | Array          |
| ----------------- | ----------------- | -------------- |
| Check the length  | `str.length()`    | `array.length` |
| Read an element   | `str.charAt(idx)` | `array[idx]`   |
| Modify an element | Does not exist    | `array[idx]`   |



## 4. How to fix the problems with two pieces of memory

Object takes two pieces of memory, which creates some problems when we use it, for example, when you want to

1. **print the entire object**

   For a class, we should override the `toString()` method, so it does not give us the address of the object.

   For an Array, we can directly call `Arrays.toString(array)`, which returns a string to represent the array. However, the output format is fixed and you cannot customize it.

   ```java
   int[] nums = {1, 2 ,3};
   
   System.out.print(Arrays.toString(nums));		// prints the array at once:     [1, 2, 3]
   ```

   

   If you want to customize the output format, create a loop to go through the array by yourself.

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

   

2. **compare two arrays**

   Usually we create an `equals()` method in the class to compare two objects. For array, we can directly call `Arrays.equals()` to compare two arrays.

   ```java
   // comparet two arrays
   int[] nums4 = {1, 2, 3};
   int[] nums5 = {1, 2, 3};
   
   // 1. using ==
   System.out.println(nums4 == nums5); 			// comparing the reference -> false
   
   // 2. using 
   System.out.println(Arrays.equals(nums4, nums5)); // comparing the elements -> true
   ```

   

3. **deep copy**

   Usually we can use the copy constructor (or `clone()`) to implement deep copy. For array, there are two methods we can directly use:

   	1. `Arrays.copyOf()`: deep copy an array, **from the first element to a specific element**. 
    	2. `Arrays.copyOfRange()`: deep copy an array, **from a specific element to another specific element**.

   ```java
   // deep copy
   int[] nums1 = {1, 2, 3};
   
   // copy the entire array
   int[] nums2 = Arrays.copyOf(nums2, nums2.length);     // {1, 2, 3};
   
   // copy part of an array
   int[] nums9 = Arrays.copyOf(nums6, 2);      		 // {1, 2};
   
   // copy the entire array and extend the length of the new array
   int[] nums10 = Arrays.copyOf(nums6, 5);     // {1, 2, 3, 0, 0};
   
   // copy part of an array 
   int[] nums11 = Arrays.copyOfRange(nums6, 1, 2); // {2}
   ```

4. **sort an array** (not caused by two pieces of memory, it is just another method in the Arrays class)

   ```java
   // Sort an array
   int[] nums12 = {1, 6, 3, -2, 5, 0};
   // Arrays.sort() is a void method, it will direclty modify the original array instead of create a new array. If you want to keep the original array without be changed, you should create a copy of the array manually before the sorting by yourself.
   int[] nums12Copy = Arrays.copyOf(nums12, nums12.length);
   
   // sort the entire array, ascending
   Arrays.sort(nums12Copy);            
   // sort part of the array, ascending
   Arrays.sort(nums12Copy, 1, 4);
   ```

   

## 5. Enhanced-for loop

There is another kind of loop we can use when we deal with collections (not including String), which is called the **enhanced-for** loop (or **for-each** loop).

In a regular for loop we have to create and control an index to visit elements in a collection. But the fact is that, we only care about the values of the elements in the collection most of the time, not the value of the index.

The idea of using an enhanced-for loop is to go through a collection without using any index.

```java
// Regualr for loop for a String. String only supports regular for loop
String str = "hello";

for (int i = 0; i < str.length(); i++)
    System.out.print(str.charAt(i));

// Array can support both regular for loop and enhanced-for loop
double[] nums = {1.1, 2.2, 3.3, 4.4};

// Regular for loop for an array
for (int i = 0; i < nums.length; i++)
    System.out.print(nums[i]);

// Enhance for loop for any array
for (double num : nums)
    System.out.print(num);
```









