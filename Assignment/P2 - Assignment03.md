# P2 - Assignment03

## **Due Date:** 

02-26 23:57:00. **Late submission will directly be marked as 0**.

## **Submission:**

**Please submit three `.java` files for this assignment**.

	1. one `.java` file for Task 1
	2. one `.java` file for Task 2.1
	3. one `.java` file for Task 2.2

**Full Score**: 100

## **Knowledge Points**  of  This  Assignment

1. 2-D array
2. ArrayList

***

## Task 1

### Requirement

Implement the following methods concerning 2-D arrays: 

**Notice: a 2-D array is not necessary a matrix, in the other word, the length of each row might not be the same.**

1. a method `double min(double[][] numss)` to calculate the min value of a 2-D double array
2. a method `double[] minOfRow(double[][] numss)` to calculate the min value of each row of a 2-D double array
3. a method `double[] minOfCol(double[][] numss)` to calculate the min value of each column of a 2-D double array
5. a method `double[][] add(double[][] numss1, double[][] numss2)` to add two 2-D double arrays together; returns a new array, 
   * E.g. `numss1`: `{{1, 2, 3}, {4, 5}}`, `numss2`:  `{{1, 2}, {3, 4, 5}, {6, 7}}`, returns `{{2, 4, 3}, {7, 9, 5}, {6, 7}}`
6. a method `double[][] deleteRow(double[][] numss, int idx)` to delete a row from a 2-D double array.
7. a method `double[][] appendArray(double[][] numss1, double[][] numss2)` to append a 2-D double array under another 2-D double array; returns a new array. 
   * E.g. `numss1`: `{{1, 2}, {3, 4, 5}, {6}}`, `numss2`: `{{7}, {8, 9}}`, returns `{{1, 2}, {3, 4, 5}, {6}, {7}, {8, 9}}` 
8. a method `double[][] expendArray(double[][] numss1, double[][] numss2)` to append a 2-D double array at the right of another 2-D double array.
   * E.g. `numss1`: `{{1, 2}, {3, 4, 5}, {6}}`, `numss2`: `{{7}, {8, 9}}`, returns `{{1, 2, 7}, {3, 4, 5, 8, 9}, {6}} `
8. a method `double[][] transposeMatrix(double[][] numss) to flip the row and the collom of a matrix`
   * E.g. `numss`: `{{1, 2, 3}, {4, 5, 6}}`, returns `{{1, 4}, {2, 5}, {3, 6}}`

------------

## Task 2

### Task 2.1

### Requirement

Write a Class `Animal`, that contains 

* **Data members**：

  * `name`
  * `gender`
  * `age`
  * `type`
  * a static `ArrayList` that holds all legal types
    * Originally only contains `"Cat"`, `"Dog"` and `"Monkey"`, but the list can be expended or shortened in the future.

* **Methods**:

  * Default constructor 

  * Constructor with all data members 
  * Copy constructor

  * `boolean isTypeValid(String type)`

  * `equals()`
  * `toString()`
    * Example

  ```markdown
  Name   : Copain
  Gender : Male
  Age    : 5
  Type   : Dog
  ```

  

  * getters and setters
    * You should use `isTypeValid()` in `setType()` and constructor(s)

### Task 2.2

#### Requirement

Write a Class `Zoo`, that contains 

* **Data members**:

  * `animals`
    * a collection of animals, the number is NOT FIXED, you can add a new animal or remove one from it.

* **Methods**:

  * Default constructor
  * Constructor with all data members
  * Copy constructor
  * `int countAnimals(String type)`
    * count in the zoo, how many animals belong to a certain type 
  * `void updateValidTypes()`
    * go through all animals in the zoo and check if there is a valid type in the ArrayList from which no animals in the zoo belong to that type. If so, remove the type from the valid type ArrayList.
  * `boolean isGenderBalanced(String type)`
    * check if, for a specific type, the difference between the number of female and number of male is less than `20%` of the total number of animals of that type. 
  * `void removeOldest(String type)`
    * first check if the type is valid or not, if it is valid, then remove the oldest animal(s) of a certain type from the `animals` (if two animals have the same age, remove both), it calls `updateValidTypes()` in the end.

  * `equals()`
  * `toString()`
    * Example:

  ```
  Total Number of Animals: 28
  Male: 12
  Female: 16
  
  Dog:    
      Number    : 6
      Female    : 3
      Male      : 3
      Balanced  : Yes						
      Oldest age: 12
  Cat:    
      Number    : 9
      Female    : 7
      Male      : 2
      Balanced  : No						
      Oldest age: 7
  Monkey:    
      Number    : 13
      Female    : 6
      Male      : 7
      Balanced  : No						
      Oldest age: 20
  ```

  * getters and setters