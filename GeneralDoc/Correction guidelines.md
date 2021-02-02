# Correction Guidelines

## Minor Mistakes (-1)
*Note: Minor mistakes of the same type can cummulate up to -5*

### Missing or Extra Spaces
Here are general guidelines on how to properly use spaces

- You should add a space after a comma
- You should never have two spaces between two characters
- You should use spaces before and after operators if they are not unary
  
    *Example 1*
    
    ```java
int num=3/2;
    return num >0 ?  1:0;

    // Should be
    
    int num = 3 / 2;
    return num > 0 ? 1 : 0;
    ```
    *Example 2*
    ```java
num++;
  // This is a unary operator, so no need for spaces
  ```
  
- When you create signatures for methods, you should not add a space between the name of the method and the parentheses for parameters
  
    *Example*
    ```java
    public int calcPoint ()
    
    // Should be:

    public int calcPoint()
    ```

- However, when you use if statements, for loops, or similar statements, you should add a space between the keyword and the parentheses 

    *Example*
    ```java
    if(x = 3)

    // Should be:

    if (x = 3)
    ```

- Lastly, you should also add a space before curly brackets
  
    *Example*
    ```java
    public int calcPoint{
        // Code
    }

    // Should be:

    public int calcPoint {
        // Code
    }
    ```

### Redundant Parentheses
- You should not add parentheses in places where they are not needed. Only use them when they actually make a difference in the code
  
    *Example 1*
    ```java
    double num = (x + y);

    // Should be

    double num = x + y;
    ```
    *Example 2*
    ```java
    double num = (x + y) * 3;
    // In this case, the parentheses actually matter for the end result
    
    // Or the formular is very difficult to understand
    return (x * 3.4 * y / 7) + (y * x * z)
    ```


### Naming Conventions
- Use **camelcase** when needed 
  
    * Ex: *absValue* for a **variable**
    * Ex: *PermanentEmployee* for a **class**
    
- Don't use all uppercase for an abbreviation 

    ```java
    Person VIP;
    
    // "VIP" is all uppercase, all uppercase is only used for final static varialbe, do something like this:
    
    Person vip;
    static final double KG_TO_LB_RATIO = 2.2; 
    ```

- Don't use meaningless names 

    *Example*
    ```java
    String x = "Welcome";
    
    // "s" is not descriptive. Instead, do something like this:

    String greeting = "Welcome";
    ```

### Javadoc
- Required for functional methods (user-defined methods)
- Remember to use the tags (@author, @param, @return) when necessary

### Redundant (WET) Code
- Boolean methods
    ```java
    if (Character.isUpperCase(char) == true)

    // The boolean method already implies that you are checking if the condition is true. Instead, it should be:

    if (Character.isUpperCase(char))
    ```
- if / else structure

    *Example 1*
    
    ```java
    if (condition)
        return true;
    else
    	return false;
    
    // Should be:
    
    return condition;
    ```

    *Example 2*

	```java
	if (num1 > num2)
	    return num1;
	else
	    return num2;
	
	// Should be:
	
	return num1 > num2 ? num1 : num2;
	```


  * Low-level operators
    ```java
	num = num + 5;
	num = num + 1;
	num += 1;

    // Should be:
    
    num += 5;
    num++; // or ++num
    ```

### For Loops
- If you should use enhanced for loops, but you use regular ones, -1

### Magic Numbers
- Magic numbers are numbers used in code with either: 
    * An unexplained meaning (adding a random number in the code that doesn't make sense)
    * A value that may be changed in the future, and should therefore be declared through a variable
        * Ex: For a special tax on an item, you should create a variable, because that tax may change
        * Ex2: If you're talking about time, you do not need to create variables for values such as "24" or "60", because those values will always remain the same and everyone understands
        * Ex3: 
            ```java
            if (num > 46)
            ```
            In this case, this is a magic number, because the boundary you are using (46) might be changed in the future. 

### Indentation
Indents are a very important to achieve a clean code. Here are some general guidelines on when you should add them.
*Note: To add indents, you can press the tab key on your keyboard.*

- Classes should be in the leftmost column (no indent)

- Anything inside a block (inside of a pair of curly brackets, even if the brackets could be invisible) should be indented once

    *Example*
    
    ```java
    public class Employee {
        // All the code here is indented by one
        public int countPoint {
            // Second pair of curly brackets means 1 additional indent
            // So on and so forth...
        }
    }
    ```
    
- When using if / else if / if structures, the keyword and its condition are not indented, but the code that comes afterwards should be. The same applies for for loops. 
  
    *Example*
    ```java
    if (num = 0)
        num++;
    else if (num > 0)
        num += 5;
    else {
        num -= 5;
        System.out.println(num);
    }
    // Rest of the code continues at same level as keywords
    ```

- When using switch / case, there is no indent for the switch and its condition, one indent for the case keyword, and another indent for the code that follows
  
    *Example*
    ```java
    switch (option) {
        case 1:
            // Code block
            break;
        case 2:
            // Code block
            break;
        default:
            // Code block
    }
    // Rest of code continues at same level as switch keyword
    ```
    
- It's very important to keep track of the indents for curly brackets, otherwise it can get very confusing. Here's a more complex example.

    ```java
    public class Employee {
        public int calcPoint {
            int length = 5;
    
            for (int i = 0; i < length; i++) {
                // Code here
            }
        }
    }
    ```

* If one statement is not finished in one line and is continued in another line, use two-level of indent 

    ```java
    return "Hi, my name is Yi, I am a teacher at Vanier Colelge" +
        	"Nice to meet you";				// two-level of indent since this is one statement
    ```
    
    If everything was left indented, it would be hard to keep track of where something starts or ends.

### Lines
- Your code should not contain lines that go past the vertical line that is in Netbeans files by too much (this vertical line marks 80 characters, I will tolerate up to 100 characters / line)
- It is okay to use empty lines to separate different steps of code, but do not go overboard with them (usually, one empty line will suffice to create that separation)

<br>

## Major Mistakes (-3)
*Note: Major mistakes do not have a cummulative limit, and depend more on your comprehension of the course and its tasks.*