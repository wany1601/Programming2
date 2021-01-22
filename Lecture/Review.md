# Review


## 1. Data type
Generally, data type can be separated into two groups:
* **Primitive data type**: pre-defined and basic data type, the size is fixed.

    |Category|Type|Size|Comments|
    | - | - | - | - |
    |integral|byte|1||
    ||short|2||
    ||char|2|cannot be negative|
    ||int|4||
    ||long|8||
    |floating|float|4||
    ||double|8||
    |boolean||||
* **Class**: the size is not fixed.


## 2. Method

### 2.1 Overload method
**Overload** methods means more than one methods in the same class have the same method name, but different parameter lists.

```java
    public static double max(double num1, double num2)

    public static int max(int num1, int num2)

    public static double max(double num1, double num2, double num3)
```
### 2.2 Pre-defined methods in classes
Some pre-defined classes:
* Math
* String:
    the index of a string starts at 0
    
    * length()
    * charAt(): idx -> char
    * indexOf(): char -> idx 
        * "hello".indexOf('l') -> 2, 
        * "hello".indexOf('z') -> -1
    * lastIndexOf(): char -> idx 
        * "hello".lastIndexOf('l') -> 3
    * contains: 
        * "hello".contains("he") -> true
        * "hello".contains("z") -> false
    * substring()
    * \+ 
    * equals()
    * Stirng.format(): the same as the printf(), but instead of printing the string in the console, it will return the string.
    * toUpperCase()
    * toLowerCase()
* Random
* Scanner
* Character: 
    * Character.isUpperCase('a') -> false
    * Character.isLowerCase('a') -> true
    * Character.isLetter('a') -> true
    * Character.isDigit('a') -> true
    * Character.toUpperCase('a') -> 'A'
    * Character.toLowerCase('a') -> 'a'

    ```java
    public static boolean isPasswordValid(String password) {
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c))
                upper = true;
            else if (Character.isLowerCase(c))
                lower = true;
            else if (Character.isDigit(c))
                digit = true;
        }
        
        return upper && lower && digit;
    }
    ```


## 3. OOP (Object-oriented Programming)

### 3.1 what is OOP
OOP is about 2 things:
* Class: abstract
    * data members: the information you care 
    * methods: to define the behaviors
        * constructor
            * **default constructor**: with no param
            ```Java
            public Clock()
            ```
            * **copy constructor**: param has the same data type as the class
            ```Java
            public Clock(Clock clock) {
                this.hr = clock.hr; 
                this.mi = clock.mi;
                this.se = clock.se;
            }
            ```
            
        * **toString()**: to generate a string to represent an object of that class
        
            ```java
            @Override
            public String toString() {
                return String.format("%02d:%02d:%02d", hr, mi, se);
                // %d: integer
                // %f: floating
                // %c: char
                // %s: string
                // %%: %
                // %5d: the width of the place holder   123 -> "  123"
                // %05d: zero-padding  123 -> "00123"
                // %.2f: the legnth of the decimal part: 3.3333333 -> 3.33 
                // %5.2f: 3.3333333 -> " 3.33"
                // %-5.2f: 3.3333333 -> "3.33 "
            }
            ```
        
            
        
        * **equals()**: to compare two objects (*overload* version), we will learn the (*override* version) of this method this semester
        
        * **getter and setter**: to read or modify the data members of the class
* Object: real

### 2.2 Access modifier
Access modifier is used to define where can this data member/method can be used. There are 4 access modifiers in total, and we have learned 2 of them:
* **private**: only can be used inside of the same class
* **public**: every one can use it, no matter inside or outside of the class, and no matter what is the relationship it has with the current class.
* protected
* default

### Shallow copy VS Deep copy
For each object, java will allocate two pieces of memory to it, one to store the real values based on the data member, while the other one to store the address of the first piece of memory.

* **shallow copy**: a copy of the address. Shallow copy does not create a new object, it only creates another name for an exist object. 

* **deep copy**: a copy of the real values of one object. Deep copy really create another object.

### TODO!static VS non-static
* **static**: belongs to the class, when you use it, you have to call it through the class. 
  
    ```java
    public static void main() {
        Clock.staticMethod();
    }
    ```
```
    
* **non-static**: belongs to the object, when you use it, you have to call it through the object.
    ```java
    public static void main() {
        Clock c1 = new Clock();
        c1.nonStaticMethod();
    }
```
    ```java
    public class Clock{
        private int hr;     // non-static
        private int mi;
        private int se;
        private static String brand; // static 
    
        /**
        * A non-static method can visit non-static and static values and methods
    
        non-static method should be called through an object
        e.g.: c1.increaseHr()
        */
        public void increaseHr() {  
            hr++;
            if (hr == 24)
                hr = 0;
            sout(brand);
        }
    
        /**
        * A static method can ONLY visit static values and methods
    
        static method should be called through the class
        e.g.: Clock.printBrand()
        Math.max(1, 2)
        */
        public void printBrand() {
            sout(brand);
        } 
    }
    ```

STOP AT HERE! ### Memory allocation

Debug tools