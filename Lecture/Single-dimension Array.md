# Chapter 01 -- Single-dimension Array



## 1. What is an Array

An array is a collection of data, **with the same data type**. The data type could be different from one array to another.

**An array is an object**, which contains two pieces of memories. So it also faces the shallow copy / deep copy, and equals issue.



## 2. How to declare and initialize an array

There are two ways to create an array:

1. If you know the size of the array, but there is **no specific initial values**, use the keyword **new** to create. When you use this way to create an array, default values will be given to each elements.

```java
// datatype[] varname = new datatype[length];

double[] scores = new double[22];			// the length is obligated, and CANNOT be changed.
double scores[] = new double[22];			// do not suggest
Clock[] clocks = new Clock[5];				// an array of objects
```

Default values are given based on the data type:

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


## 3. How to visit elements in an array

An array is very similar to a string.

| Purpose           | String            | Array          |
| ----------------- | ----------------- | -------------- |
| Check the length  | `str.length()`    | `array.length` |
| Read an element   | `str.charAt(idx)` | `array[idx]`   |
| Modify an element | Does not exist    | `array[idx]`   |



## 4. Arrays class

Java provides us an `Arrays` class which contains many useful methods related to array.

### 4.1. print the entire array

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


### 4.2. compare two arrays

Usually we create an `equals()` method in the class to compare two objects. For array, we can directly call `Arrays.equals()` to compare two arrays.

```java
// comparet two arrays
int[] nums1 = {1, 2, 3};
int[] nums2 = {1, 2, 3};

// 1. using ==
System.out.println(nums1 == nums2); 			// comparing the reference -> false

// 2. using 
System.out.println(Arrays.equals(nums1, nums2)); // comparing the elements -> true
```

### 4.3. deep copy

Usually we can use the copy constructor (or `clone()`) to implement deep copy. For array, there are two methods we can directly use:

1. `Arrays.copyOf()`: deep copy an array, **from the first element to a specific element**. 
2. `Arrays.copyOfRange()`: deep copy an array, **from a specific element to another specific element**.

```java
// deep copy
int[] nums1 = {1, 2, 3};

// copy the entire array
int[] nums2 = Arrays.copyOf(nums2, nums2.length);     // {1, 2, 3};

// copy part of an array
int[] nums3 = Arrays.copyOf(nums1, 2);      		 // {1, 2};

// copy the entire array and extend the length of the new array
int[] nums4 = Arrays.copyOf(nums1, 5);     // {1, 2, 3, 0, 0};

// copy part of an array 
int[] nums5 = Arrays.copyOfRange(nums1, 1, 2); // {2}
```

### 4.4. sort an array

```java
// Sort an array
int[] nums = {1, 6, 3, -2, 5, 0};
// Arrays.sort() is a void method, it direclty modifies the original array instead of create a new array. If you want to keep the original array, you should create a copy of the array manually before sorting it.
int[] numsCopy = Arrays.copyOf(nums12, nums12.length);

// sort the entire array, ascending
Arrays.sort(numsCopy);            
// sort part of the array, ascending
Arrays.sort(numsCopy, 1, 4);
```

### 4.5. fill all elements in an array with a new specific value

```java
int[] nums = {0, 0, 0};
// Arrays.fill() directly modifies the original array
Arrays.fill(nums, 1);   	// {1, 1, 1}
```

### 4.6 A method in String class

You cannot use enhanced-for loop to go through a string, so you have to use the index system. However, you can first convert the String into a char array, then since it is an array, you can use enhanced-for to go through it:

```java
String str = "hello!";
// convert the string into a char array and then print each element of it
for (char c : str.toCharArray())
    System.out.println(c);

// convert the string into a char array and then count the number of digits in it
int digitCount = 0;
for (char c : str.toCharArray())
    if (Character.isDigit(c))
        digitCount++;
```



## 5. Enhanced-for loop

### 5.1 What is enhanced-for loop

In a regular for loop we have to create and control an index to visit elements in a collection. But the fact is that, we only care about the values of the elements in the collection most of the time, not the value of the index.

```java
// Regualr for loop for a String. String only supports regular for loop
String str = "hello";

for (int i = 0; i < str.length(); i++)
    System.out.print(str.charAt(i));
```

There is another kind of loop we can use when we deal with collections (not including String), which is called the **enhanced-for** loop (or **for-each** loop). The idea of using an **enhanced-for** loop is to **go through a collection without using any index**.

### 5.2 Comparison between **regular for** loop and **enhanced for** loop

| -                                             | Regular for                                                  | Enhanced for                                                 |
| --------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| index                                         | uses index system                                            | no index system                                              |
| writing difficulty                            | more difficult to write                                      | easier to write                                              |
| features                                      | can customize the index, so can go through the collection with a specific rule | cannot customize the index, can only go through the collection from the 1st element to the last element |
| local variable                                | most of time, you create `int i`                             | the data type of the variable is the same as the data type of the array , and that's the reason you should name any array plural. |
| read as                                       |                                                              | `for (double num : nums)` can be read as "*for each `num` in `nums`*" |
| reading                                       | √                                                            | √                                                            |
| writing                                       | √                                                            | ×                                                            |
| visit more than one collections synchronously | √                                                            | ×                                                            |

### 5.3 Using enhanced-for loop to read elements (YOU SHOULD)

Enhanced-for **can be used to go through a collection and read each of its element** without an index.


```java
// Array can support both regular for loop and enhanced-for loop
double[] num = {1.1, 2.2, 3.3, 4.4};

// Regular for loop for an array
for (int i = 1; i < nums.length - 1; i += 2)
    System.out.print(nums[i]);

// Enhance for loop for any array
for (double num : nums)
    System.out.print(num);
```

### 5.4 Using enhanced-for loop to modify elements (YOU SHOULD NOT)

Enhanced-for **CANNOT be used to go through a collection and modify each element of a collection**, since the modification will only be applied on the local variable instead of the real collection.

```java
int[] nums = {1, 2, 3};

// increase values of elements in an array by using enhanced-for loop
// won't work, nums will still be {1, 2, 3}
for (int num : nums)
   num++;      				// num is a local variable, it will not affect the array

// increase values of elements in an array by using regular for loop
// will work, nums will be {2, 3, 4}
for (int i = 0; i < nums.length; i++)
    nums[i]++;				// changes applied on nums
```

### 5.5 YOU SHOULD NOT use enhanced-for loop if you have to use the index in the loop

If you want to go through an array, read all the values, it sounds like you can use enhanced for loop in this situation. However, if the task requires to use the index system, then you still cannot use the enhance-for loop.

```java
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
        if (i % 2 == 1)		// have to check if the index is odd or not, cannot use an enhanced-for loop
            sum += nums[i];

    // solution 2;
    for (int i = 1; i < nums.length; i += 2) 
        sum += nums[i];

    return sum;
}
```

### 5.6 Using enhanced-for loop to go through more than one arrays (YOU SHOULD NOT)

If you have more than one arrays that you have to go through at once, you also need an index to synchronize the two arrays. And since in the case we have to use the index, you SHOULD NOT use the enhanced-for loop.

```java
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
        if (flags[i])       // do not write "flags[i] == true"
            sum += nums[i];

    return sum;
}
```



## 6 Array of object

Array not only supports primitive data types, but also objects. The general rules are the same as the array of primitive data types.

```java
Clock[] clocks = new Clocks[3];			// {null, null, null}
Arrays.fill(clocks, new Clock());		// fill all null by a real object

Clock[] clocks2 = {new Clock(), new Clock(1, 2, 3), new Clock(2, 3 ,4)};

Clock[] clocks3;
Clock c1 = new Clock();
Clock c2 = new Clock(8, 8, 8);
Clock c3 = new Clock(9, 9, 9);
clocks3 = new Clock[]{c1, c2, c3};
```

You can also use the index to visit each element inside of an object array.

```java
Clock[] clocks = {new Clock(), new Clock(1, 2, 3), new Clock(2, 3 ,4)};

System.out.print(clocks[0]);				// clocks[0] is a Clock object
clocks[0].increaseHr();						// you can use . to visit methods of the object
```

**You CAN use enhanced-for even for modifying the data member of an object in an object array**

```java
Clock[] clocks = {new Clock(), new Clock(1, 2, 3), new Clock(2, 3 ,4)};		// only the address is stored in the array

// increase each clock's hour by 1
// you CAN use enhanced-for even for modifying the data member of an object in an object array
for (Clock clock : clocks)
    clock.increaseHr();

// the regular for loop version is much longer
for (int i = 0; i < clocks.length; i++)
    clocks[i].increaseJHr();
```

