# 4.1 Exception Handling

## 1. What is Exception Handling

Usually when write some bad code, orally we would say there is an `error` in your code. However most of them are not really error, in fact, the name for them is `Exception`.

`Error` and `Exception` are at the same level, both of them means there is something with your code. However, `error` is more serious than `exception`

`Error` relates to something very serious, such as memory leaking 

`Exception` it is something less serious, which could be fixed on the programmer side.

In Java, both `error` and `exception` are defined as classes, and both of them belong to the same hierarchy 

![](imgs\Chapter4\ExceptionHierarchy.png)

[1] image from www.javamadesoeasy.com/2015/05/exception-handling-exception-hierarchy.html

## 2. Checked VS Unchecked

A `checked exception` is an exception Java will pre-detect it and you have to prepare a solution for it, if not, Java will not allow you to execute the code. 

while `unchecked exception` is an exception Java will pre-detect it, so you don't have to prepare a solution for it, and you can directly execute the code. 

`Error` and `Runtime exception` are both `unchecked`, while all other exceptions are `checked` .



## 3. Default Handler

When an exception / error is thrown, Java needs to handle the exception / error by using a `handler`, handler is a piece of code to respond to the problem.

Java has a default exception handler, which is a pre-defined piece of code that will handle whatever exception, if a programmer does not provide specific exception handlers.

Java default exception handler will do few things: 

1. prints `Error` or `Exception`, with the name, message (additional information) in the console
2. prints the `stacktrace` of the error or exception in the console
3. stops the execution



## 4. User-defined Handler

There are two ways to handler an exception

* `try-catch`: in which the programmer will provide sericeous solution to handle exceptions
* `throws`: will tell Java to find the solution in another method

### 4.1 try-catch

#### 4.1.1 Basic Syntax of try-catch

The `try-catch` structure at least contains two parts: `try` and `catch`. You cannot have a `try` without `catch`, and you cannot have a `catch` without `try`. There is a third part `finally` which is optional.

`try` is a sandbox, `try` does not really change the behavior of the statements inside, however, if the code inside `try`  crashed (throws an exception), the `catch` can provide an user-defined solution for it. 

```java
try {
    // sandbox, you can put whatever code that you think may throw an exception in this part 
}
catch (Type1 e) { // a handler that can handle Type kind of exception
    // if this kind of exception is thrown from the try part, this catch will be activated and the code in the body will be excuted
}
catch (Type2 e) { // you can have as many catches as you want
    // different catches can be used to handle different kinds of exceptions
}
```

If the code in the try part does not throw any exception, then the try-catch pair will not provide any addition operation to your code, it is the same as the code without the try-catch.

It is not a good idea to put all your code into the `try` part, not every statement in your code may result an exception. Usually we only put the code that we think may crush into the try part. And usually we only have to use try-catch to handle checked exception. For unchecked-exception, such as `RunTimeException`, technically, if you write your code carefully enough, there is no need to use try-catch to handle it.

`try` cannot exist without `catch`, you can have as many `catch`es as you want, but not zero. A `catch` is like a worker that can solve a specific problem (handle a specific kind of exception). Some workers are multi-handed, thus can handle more than one kind of exception, while some can only handle a really specific exception. And when a worker handles an exception, what behaviors will the worker take is customized in the body of the `catch`.

#### 4.1.2 try-catch With Specific Handler

Here is an example of a `try` with two `catch`es, the first `catch` is an expert to handle the `ArrayIndexOutOfBoundsException`, while the other is an expert to handle `ArithmeticException`.  the `try` part contains a `for` loop which iterates `10` times,  each time it will generate a random number in `[0, 9]` and use the number as an index to extract a number from `nums`. `nums` is an array that contains only 4 numbers, and one of them is `0`. So if the index is too big, an `ArrayIndexOutOfBoundsException` will be thrown, and if the index equals `2`, number `0` will be extracted, and be used for the division, which will throw an `ArithmeticException` (divide by 0). 

If we are very lucky, and have `10` valid numbers generated (none of them are too big or equal to `2`), then the `for` loop will not throw any exception at all. In this case, the `catch`es will not be activated, the `try-catch` structure will not do anything.

If a random number `7` is generated, then `nums[rand.nextInt(10)]` will throw an `ArrayIndexOutOfBoundsException`, and when an exception is thrown, Java will stop the current operation (reading an element from the array) and look for an handler to handle the exception. Java will check the `catch`es provided by the programmer one by one. Our first `catch` can perfectly handle the exception (the `ArrayIndexOutOfBoundsException` between the `()` matches with the exception java just throwed), so the code in the `catch` part will be activated, and set the `result` to `-1`. And once all code inside the `catch` part are executed, it will turn-off the alarm (the exception is handled, so there is no exception anymore) , and Java will get out of the entire `try-catch` structure and print the result (`-1`).

If a random number `2` is generated, then `nums[rand.nextInt(10)]` will equal to `0`, and `num / 0` will throw an `ArithmeticException`, and again, Java will check the catches provided by the programmer one by one. Our first `catch` cannot handle the exception (the `ArrayIndexOutOfBoundsException` between the `()` does not matches with the exception java just throwed), and Java will continue to check the second `catch`, and fortunately, this one can handle the exception, so the code in the second `catch` part will be activated, and set the `result` to `0`. And once all code inside the `catch` part are executed, it will turn-off the alarm (the exception is handled, so there is no exception anymore) , and it will get out of the entire `try-catch` structure and print the result (`0`).

```java
public static void main(String[] args) {
    int num = 5;
    Random rand = new Random();
    int num2 = rand.nextInt(num);           // [0, 1, 2, 3, 4]
    int result = 0;
    int[] nums = {1, 2, 0, 3};

    try {
        for (int i = 0; i < 10; i++)	// may throw ArithmeticException and ArrayIndexOutOfBoundException
            result = num / nums[rand.nextInt(10)];  
    } 
    catch (ArrayIndexOutOfBoundsException e) {
        result = -1;
    }
    catch (ArithmeticException e) {
        result = 0;
    }
    System.out.print(result);
}
```

#### 4.1.2 try-catch With General Handler

Now let's consider a special situation: what if the code in the `try` part throws an exception that is neither a `ArrayIndexOutOfBoundsException` nor a `ArithmeticException`? Let's assume for some reason the try part throws a `StringIndexOutOfBoundsExcerption` , in this case, Java will still check the two `catch`es one by one to see if any of them can handle the exception, and the answer is no. In this case, Java will have no choice, but go back to the default-handler, which will print the exception information, the stacktrace and then exit the program.

What if we really do not want Java to use the default handler to handle an exception but at the same time it is very difficult for us to list all kinds of exceptions? Can we have a general solution to handle more than one kind of exception? The answer is yes, you can have a `catch` that can handle a range of exceptions. For example you can have `catch (RuntimeExcetion e)` that can handle all kinds of `RuntimeExcetion` s, or even more general `catch (Exception e)` that can handle all kinds of `Exception`s. The only thing you have to pay attention is that Java will check the `catch`es one by one, so **you are not allowed to put general catches before specific catches**, cause if you do so, the specific `catch`es will never be used, the general ones can handle the exceptions before the specific ones.

Here is one example of 3 catchers, the last one is a general catch `catch (Exception e)` that can handle all kinds of exceptions. It is so general we can only put it in the end of the list. So if an `ArrayIndexOutOfBoundsException` is thrown, the first `catch` can handle it, and if an `ArrayIndexOutOfBoundsException ` is thrown, the second `catch` can handle it, and if whatever other kinds of exception is thrown, the last `catch` can handle them all. 

```java
public static void main(String[] args) {
    int num = 5;
    Random rand = new Random();
    int num2 = rand.nextInt(num);           // [0, 1, 2, 3, 4]
    int result = 0;
    int[] nums = {1, 2, 0, 3};

    try {
        for (int i = 0; i < 10; i++)        					// new ArrayIndexOutOfBoundException();
            result = num / nums[rand.nextInt(nums.length)];       // may throw ArithmeticException
    } 
    catch (ArrayIndexOutOfBoundsException e) {
        result = -1
    }
    catch (ArithmeticException e) {
        result = 0;
    } 
    catch (Exception e) {
        result = -2;
    }
    System.out.print(result);
}
```

#### 4.1.3 Meaningful Handlers

Previously we have created 3 different handlers, which set `result` to different values. Technically you can write whatever code in `catch`, however, just set the `result` to a random number does not sound like a reasonable solution. 

Many times if we want to provide a much meaningful handler, we have to use the variable `e` of the `catch`.

 When an exception is thrown, an object of that exception is create, and Java will use it to compare with each `catch` parameter. If the exception type matches, Java will pass that object as a parameter to the `catch` as `e`. So when a `catch` is activated, the local variable `e` is an object that contains all information about that exception. If you want to know more details about the exception, you can get them from `e`.

`e` is an object of a specific exception, thus, you can use some pre-defined methods in the class. Most frequently used methods are:

* `e.getClass()`: returns the exact type of the exception just thrown. 
* `e.getMessage()`: returns the details of the exception, such as: "divide by zero" or when index out of bound, what is the index value
* `e.getStackTrace()`: returns the stractTrace of the exception, basically, which line throws the exception, in which method, and which method has called that method. Notice: Since there might be more than one methods in the stack trace, so the return type of this method is `StackTrace[]`, you have to use a for loop to extract each method from it.

```java
public static void main(String[] args) {
    int num = 5;
    Random rand = new Random();
    int num2 = rand.nextInt(num);           // [0, 1, 2, 3, 4]
    int result = 0;
    int[] nums = {1, 2, 0, 3};

    try {
        for (int i = 0; i < 10; i++)        					// new ArrayIndexOutOfBoundException();
            result = num / nums[rand.nextInt(nums.length)];       // may throw ArithmeticException
    } 
    catch (ArrayIndexOutOfBoundsException e) {
        result = -1
    }
    catch (ArithmeticException e) {
        result = 0;
    } 
    catch (Exception e) {						// a handler that mimic the default handler
        // exception information
        System.out.print(e.getClass() + ": ");
        System.out.println(e.getMessage());

        // exception stact trace
        StackTraceElement[] stes = e.getStackTrace();

        for (StackTraceElement ste : stes)		
            System.out.println("\t\t at " + ste);

        // stop the execusion with a special status 
        // 0 ususally represents normal, all other numbers indicate that there is a problem in the code
        // this line is optional, if you remove this line, then the handler will only print without stop the execusion
        System.exit(1);       
    }
    System.out.print(result);
```



### 4.2 throws

Another way to handle an exception is to use `throws`. Well, technically `throws` does not really provide a handler to really handle an exception. It is more like an announcement of a method, say if there is a specific exception happens in the method, it is none of my business, find the one who calls me to fix it. You can understand it as in a company, a manager give a task to an employee, and the employee says, well, if I have a specific problem that I cannot fix, I will give it back to the manager, don't expect I will provide a solution.

I know it does not sound very reasonable, why an employee can do that, if the problem happens on the employee side, then it should be the employee's duty to fix it. Well, let's say, the manager has 5 employees work for her/him, and the manager send each one a task. While working on these tasks, all employees may face the same problem. The manager can create a document, to describe the solution, and the deliver it to each of the employee, so the employees can fix the problem by themselves. But this requires 5 copies of the document, and beside, if the manager changed the idea, and has another solution for the problem, all 5 copies of the original document should be updated. It does not sound that bad in a company. But in programming, if we say the manager is a method, and it calls 5 different methods, which all may throw a specific exception. Here, we can write a `try-catch` in each of the 5 methods, but our code will be WET and it is difficult for us to maintain the code. A better solution is to write one single solution in the first method, and when the 5 methods throws exceptions, tell Java to find the solution in the first method.

We can use keyword `throws` to achieve this goal. `throws` can be added in the end of the head of a method, it is like an announcement, says, if the exception that I have indicate here is thrown in the body, please go to the method who calls me to find the solution. 

```java
// throws ArithmeticException: if ArithmeticException is thrown in m1(), Java will go to the previous method who calls m1() to find the hander
public static void m1() throws ArithmeticException {    
    Random rand = new Random();
    int num1 = rand.nextInt(5);
    int num2 = rand.nextInt(5);
    int result = num1 / 0;
}
```

You can announce more than one exception after the `throws`, separated by `,`

```java
// throws ArithmeticException, IndexOutOfBoundException
public static void m1() throws ArithmeticException, IndexOutOfBoundException {    
    Random rand = new Random();
    int num1 = rand.nextInt(5);
    int num2 = rand.nextInt(5);
    int result = num1 / 0;
}
```

and  then in the method who calls `m1()` provide the handler.

```java
public static void main(String[] args) {
    try {
        m1();
        m2();	// a method also may throw ArithmeticException
        m3();
    } catch (ArithmeticException e) {
        System.out.println("Cannot divid by zero");
    } catch (IndexOutOfBoundException e) {
        System.out.println("Index ouf of bound");
    }
}
```

The previous methods do not have to provide a `try-catch` solution, it can use the same trick says if somebody ask for me to provide a solution, I will also make the same announce, says check the the previous method of me for the solution. Like `main()` calls `m1()`, then `m1()` calls `m2()`, and both `m1()` and `m2()` can use `throws` to make announcement, so Java will ask `main()` to provide a solution. In fact, even `main()` can use `throws`, the syntax is completely correct, but since there is no method before `main()`, Java will directly use the default handler to handle the exception.



## 5. User-Defined Exception

Previously we have seen all kinds of exceptions Java has pre-defined for us, and all these exceptions can be thrown automatically when a condition is satisfied. For example, when Java realizes the programmer want to calculate `1 / 0`, an `ArithmaticException` will be thrown automatically. But sometimes we want to have our own exception, and we want to define under what kind of condition that exception should be thrown. 

For example, let's say there is a specific task, you want to calculate the sum of two numbers. But these two numbers cannot be the same. You can define a `TwoNumberTheSameException`, and throw that exception when you find the two numbers are the same.

To define a user-defined exception, you only need to create a new class, and add it to the `Exception` hierarchy. If you add `extends Exception`, then the new exception will be considered as a `checked exception`, If you add `extend RunTimeException`, then the new exception will be considered as a `unchecked exception`.

And there is not much you need to create in the class, most of the methods are inherited from the superclass. All you need to do is to add two constructors: a default constructor and a constructor with `String message`

```java
// extends RuntimeException: unchecked exception
// extends Exception: checked exception
public class TwoNumberTheSameException extends RuntimeException {           
    // default constructor
    public TwoNumberTheSameException() {
    }
    
    // with String message
    public TwoNumberTheSameException(String message) {
        super(message);
    }
}
```

Once the class is declared, you can create an object of it to represent an exception and then throw it manually. You can use the keyword `throw` to throw an exception manually.

```java
// "throws" is an anounance, it does not do any real action
// "throw" is a verb, that notice java to handle exception 
public static void m1() throws ArithmeticException, TwoNumberTheSameException {    
        Random rand = new Random();
        int num1 = 2;//rand.nextInt(5);
        int num2 = 2;//rand.nextInt(5);
        if (num1 == num2)
            // throw new TwoNumberTheSameException();  // default constructor with no message
            throw new TwoNumberTheSameException(num1 + "");  // or adding a String as message    
        int result = num1 / 0;
        System.out.println();      // Runtime exception: Arithmatic
    }
```

And you can use `try-catch` or `throws` to handle the exception.

