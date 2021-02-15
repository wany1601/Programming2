# P2 - Assignment02

## **Due Date:** 

02-12 23:57:59. **Late submission will directly be marked as 0**.

## **Submission:**

**Please submit four .java files in total. Do not zip your files**.

* one .java files for task 1, 2 and 3
* one .java files for task 4.1
* one .java files for task 4.2
* one .java files for task 4.3

**Full Score**: 100

## **Knowledge Points**  of  This  Assignment

1. 1-D array
2. Enhanced for (for-each) loop
3. Arrays class
4. Array of objects

***

## Task 1

### Requirement

Implement the following methods:
1. `public static double sum(double[] nums)`
2. `public static double avg(double[] nums)`
3. `public static double min(double[] nums)`
5. `public static double[] delete(double[] nums, int idx)`
    - deletes a specific element from an array

***

## Task 2

### Requirement

Write a method to generate a sequence of uniformly distributed numbers.

`double[] generateUniformDistributionNum(double startNum, double endNum, int amount)` 

### Hint

1. The distance between each two numbers in a uniformly distributed number sequence are always the same. For example: in `{1, 2, 3, 4, 5}`, the distance is 1 between each two numbers. In `{1.5, 1.8, 2.1, 2.4, 2.7, 3.0, 3.3}`, the distance is 0.3 between each two numbers.

2. You have to calculate the distance by yourself (Hint, in example 1, if you start at 1 and you increase the numbers 4 times, you reach 5. The whole distance between 1 and 5 is 4, so the distance is 4 / 4 = 1).

3. If `startNum` is bigger than `endNum`, you should switch them.

4. If the `amount` is less than 2, then only return an array with 2 numbers `{startNum, endNum}`.

### Example

1. `1, 5, 5` -> `{1, 2, 3, 4, 5}`

2. `1.5, 3.3, 7` -> `{1.5, 1.8, 2.1, 2.4, 2.7, 3.0, 3.3} `

3. `2, -2, 6` -> `{-2, -1.2, -0.4, 0.4, 1.2, 2}`
    - switch `startNum` and `endNum` first

4. `4, -1, 2` -> `{-1, 4}`

5. `4, -1, 1` -> `{-1, 4} `
    - `amount` is less than 2, returns an array with two numbers

***

## Task 3

### Requirement

Write a method to calculate the final score of an athlete.

`double calcFinalScore(double[] scores)`

### Hint
1. In some sport games (e.g.: Diving), there are more than one (e.g.: 5) judges that give scores to an athlete. To calculate the final score for that athlete, they will calculate the sum of all scores, then remove both the highest and lowest score, and average the rest. 

2. If, in the array, the max or min score is repeated by more than one judge, only discard one of the scores. For example, if the min score is 7.4, and two judges gave that score, only remove one of them.


### Example
1. `{10, 9.8, 9.6, 9.2, 9.7}` -> `9.7`

2.	`{7.4, 7.4, 8.0, 8.2, 7.6}` -> `7.7`

***

## Task 4

### Task 4.1

#### Requirement

Write a Class `Author`, that contains 

* **Data members**：

  * `name`
  * `nationality`
  * `email`

* **Methods**:

  * Default constructor 
* Constructor with all data members 
  
  * Copy constructor
* `isNationalityValid(String nationality)`
  
      * a nationality can only be one of `{"Canadian", "American", "French", "British", "German"}`
* `equals()`
  * `toString()`
      * Example

  ```markdown
Name        : Yi Wang
  Nationality : Canadian
Email       : wangy@vaniercollege.qc.ca
  ```
  
  
  
  * getters and setters
      * You should use `isNationalityValid()` in `setNationality()` and constructor(s)

### Task 4.2

#### Requirement

Write a Class `Book`, that contains 

* **Data members**：

  * `title`
  * `authors`
      * a book may have more than one author
  * `price`

* **Methods**:

  * Default constructor 
* Constructor with all data members 
  * Copy constructor
* `equals()`
  * `toString()`                 
* Example:
  
```markdown
  Title:    Java Programming
Author:   Yi Wang, Jon Snow						// only show the author's name
  Price:    $9.99
```

  * getters and setters

### Task 4.3

#### Requirement

Write a Class `MyLibrary`, that contains

* **Data members**:

  * `books`
    * a collection of books, the number is fixed

* **Methods**:
  
  * Default constructor
  * Constructor with all data members
  * Copy constructor
  * `selectBook()`
    * selects a random book
  * `selectBook(int idx)`
      * selects a book with a specific index. If `idx` is not valid, select a random book
  * `int calcTotalPrice()`
    * calculate the total price of all the books in the library
  * `int countAuthorNum(String nationality)`
    * count how many authors of books in the library have that nationality, an author can be counted for more than one times
  * `equals()`
  * `toString()`
    * Example:
  
  ```markdown
  Title:    Introduction to Magic
  Author:   Bran Strark, Night King						
  Price:    $9.99
    
  Title:    How to kill a dragon
  Author:   Night King, Euron Greyjoy
  Price:    $12.98
  ```
  
  * getters and setters