# P2 - Assignment05

## **Due Date:** 

Apr-09 23:57:59. **Late submission will directly be marked as 0**.

## **Submission:**

**Please submit one .java file for this assignment**.

**Full Score**: 100

## **Knowledge Points**  of  This  Assignment

1. Recursion

***

## Task 1

### Requirement

1. Create a method `void printShape(int row, char symbol)` that prints a certain pattern displayed as below:

   (Note, for all `pringShape` methods, you allow to use for loop to print a row, but you should only use recursion to shift from one row to another)
```java
5, @

@ @ @ @ @
@ @ @ @
@ @ @
@ @
@

// There is a space between each @
```

2. Create a method `void printShape2(int row, char symbol)` that prints a certain pattern displayed as below:
```java
5, @

@
@ @
@ @ @
@ @ @ @
@ @ @ @ @

// There is a space between each @
```

3. Create a method `void printShape3(int totalRow, char symbol, int currentRowId)` that prints a certain pattern displayed as below:

   Hint: you need the total number of rows to calculate the number of space for each row. For example, if there is only one row, then you need zero spaces, if there are two rows, then you need two spaces in front, if there are three rows, then you need four spaces, etc. You should have two formulas,  one to calculate the number of spaces and the other one to calculate the number of symbols.
```java
4, !, 4
    
      !
    ! ! !
  ! ! ! ! !
! ! ! ! ! ! ! 

// There is a space between each !
```

4. **[Bonus Question]** Create a method `void printShape4(int row, char symbol, int currentRowId)` that prints a certain pattern displayed as below. *Note: here, 3 indicates that the longest row will be the 4th row, so that there are 3 rows above it, and 3 rows below it.*

   Hint: you can have one general pattern for the upper part, and another general pattern for the lower part.
```java
3, !, 3 
    
      !
    ! ! !
  ! ! ! ! !
! ! ! ! ! ! !
  ! ! ! ! !
    ! ! !
      !

// There is a space between each !
```

5. Create a method `int[][] generateMatrix(int row, int col, int boundary1, int boundary2, int iteration)` that generates a random matrix with random numbers between `[min(boundary1, boundary2), max(boundary1, boundary2))`.
    * The sum of the diagonal and the sub-diagonal should be the same. If not, regenerate it again, until a matrix that satisfies the condition is generated (return that matrix).
    
    * If you try `iteration` times and none of the matrixes satisfy the condition, return `null`.