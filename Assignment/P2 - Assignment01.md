# P2 - Assignment01

## **Due Date:** 

Jan-30 23:57:00. **Late submission will directly be marked as 0**.

## **Submission:**

**Please submit one .java file for task 1 and 2, one .java file for Address class, one .java file for Student class (3 .java files in total, Omnivox accepts multi-submission). DO NOT zip your files**.

**Full Score**: 100

## **Knowledge Points**  of  This  Assignment

1. Using control structures 
2. Creating a basic class and objects of the class 

***

## Task 1

### Requirement

Write a method **int reverseNum(int num)** to reverse an integer number. 

### Hint

1. You should use loop, / and %. You MUST NOT use String class at all, using anything related to String will be considered as wrong and directly get a 0 for this task.

### Example

1. 12345 -> 54321
2. -12345 -> -54321 
3. 1230 -> 321                 // no zero in front
4. -1230 -> -321              // no zero in front
5. 1 -> 1 

***

Task 2

### Requirement

Write a method **double countStringScore(String str)** to count a score of a string. The rule to count the score:

1. Each space worth a score of 0 
2. Each digit worth a score of 1 
3. Each English character worth a score of 2 
4. Each other symbol worth a score of 3 
5. The final score of a string is the total score divide by the length of the string 
6. null strings and empty strings have a score of 0 

### Example：

1. "hello!" -> 2.17 
2. 1 + 2 = 3" -> 1.00 
3. "I am 35." -> 1.38 
4. \"" -> 0 
5. null -> 0 

***

## Task3

### Task 3.1

#### Requirement

Write a Class Address, that contains 

* **Data members**：

  * street 
  * streetNum 
  * city 
  * zipCode

* **Methods**:

  * Default constructor 

  * Constructor with all data members 

  * Copy constructor

  * toTitleCase(String str): converts a string to title-case, the first character of the word and the first character after each space is uppercase, while all other characters are lowercase, e.g.: "New York". the string does not necessary only contains two words.

  * equals(Address address) 

  * toString(): print address like: 

    ```java
    Street  : 123, Abc Streat       // street name must be in titlecase 
    City    : Xxxxx                 // camel case, use getter and setter: use toTitleCase()
    ZipCode : A0A0A0                // letters in uppercase
    ```

  * getter and setter: use toTitleCase() in setStreet() method to make sure the street stored as data member is in titlecase. 

    

### Task 3.2

#### Requirement

Write a Class Student, that contains 

* **Data members**：

  * fName
  * lName 
  * age
  * address: object of the Address class in Task 3.1
  * email

* **Methods**:

  * Default constructor 

  * Constructor with only fName and lName 

  * Constructor with only fName, lName, age, and address

  * Copy constructor

  * generateEmail(): generates an email for a student and set the value of data member email. The email should be: lName + first letter of fName + 4 random digits. For example: wangy1601@vaniercollege.qc.ca. This method should be called in some constructors when a student object is created (if the name of the student is given, however, the default constructor does not need this method, since the names are not given.).

  * toTitleCase(String str): converts a string to title-case, the first character of the word and the first character after each space is uppercase, while all other characters are lowercase, e.g.: "New York".

  * equals(Student student) 

  * toString(): print a string like: 

    ```java
    Name    : Yi Wang
    Age     : 35
    Address : 						// you can use the toString() in the Address class
    Street  : 123, Abc Streat       
    City    : Xxxxx                        
    ZipCode : A0A0A0 
    Email   : wangy1601@vaniercollege.qc.ca
    ```

  * getter and setter

    