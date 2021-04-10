# P2 - Assignment06

## **Due Date:** 

MMM-DD HR:MI:SE. **Late submission will directly be marked as 0**.

## **Submission:**

**Please submit one .java file for this assignment**.

**Full Score**: 100

## **Knowledge Points**  of  This  Assignment

1. Exception Handling

***

## Task 1

### Requirement

Define a new exception class: `InvalidNumberException`, which contains two constructors:
1. Default constructor
2. Constructor with `String` as a parameter

***

## Task 2

### Requirement

1. Create a method `Integer[][] generateRandomMatrix(int row, int col, double upperBound)` to generate some random numbers in range `[1, upperBound]`. 
   
    * If  the `upperBound` is lower than `1`, replace it by a default value of `10`. 
    * For each number in the matrix, there needs to be a `1/5` chance it will be a `null`, a `2/5` chance it will be a normal random number, and a `2/5` chance it will be a negative random number (generate a random number and then multiply it by `-1`)


2. Create a method `String[][] calcResult(Integer[][] numss)` that takes a matrix and then reads the values from the left to the right, and from the top to the bottom. This value will be stored as `num1`. Then, it should read from the right to the left, and from the bottom to the top. This value will be stored as `num2`.
   * Calculate `num1/num2` as a result, with two decimals.
   * If any value of `num1` or `num2` is negative, throw the `InvalidNumberException`.
   * The method should be able to handle `ArithmeticException`, `NullPointerException`, and `InvalidNumberException`.
   * If it is an `ArithmeticException`, put an `A` in the result. If it is a `NullPointerException`, put a `N` in the result. If it is an `InvalidNumberException`, put a `I` in the result.

*Example*

```java
// input matrix
1       2       3
null    5       0
7      -8       0

/**
Cell 1: num1 = 1, num2 = 0, result = 1 / 0 -> A 
Cell 2: num1 = 2, num2 = -8, result = 2 / -8 -> I
Cell 3: num1 = 3, num2 = 7, result = 3 / 7 -> 0.43
Cell 4: num1 = null, num2 = 0, result = null / 0 -> N
Cell 5: num1 = 5, num2 = 5, result = 5 / 5 -> 1.00
Cell 6: num1 = 0, num2 = null, result = 0 / null -> N
Cell 7: num1 = 7, num2 = 3, result = 7 / 3 -> 2.33
Cell 8: num1 = -8, num2 = 2, result = -8 / 2 -> I
Cell 9: num1 = 9, num2 = 1, result = 0 / 1 -> 0.00
*/
    
// result
A       I       0.43
N       1.00    N              
2.33    I       0.00
```