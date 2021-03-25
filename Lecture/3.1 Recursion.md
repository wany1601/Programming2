# 3.1 Recursion

## 1. What is recursion

`Recursion` is another way to write a `repeated structure`. Technically a loop (for, while) could be replaced by a recursion. However, for some specific tasks, it is not easy to find a solution by using regular loops, and in this case, recursion gives you another option, and that option could be easier than using loops. 

`Recursion` is basically **a method that calls itself**.

This is a example of infinity loop:

```java
public static void printInfo() {
    sout("Hello");
    printInfo();		// calls itself
}

public static void printInfo() {
    while (true)
        sout("Hello");
}

public static void main() {
    printInfo();			// "Hello""Hello""Hello""Hello""Hello""Hello""Hello""Hello""Hello""Hello""Hello"...
}
```



This is another example of loop with certain iteration:

```java
public static void printInfo(int num) {
    for (int i = 0; i < num; i++) 
        sout("Hello");
}

public static void printInfo(int num) {    
    // base case: pre-knowledge, you know what to do without any calcualtion
    if (num == 0)			
        return;
    
    // general pattern: real action you want to do for general situation, and you should call the method itself with an update in this part, 
    sout("Hello");			
    printInfo(num - 1);
}

public static void main() {
    printInfo(1000000);			// "Hello""Hello""Hello"
}
```



## 2 How to Write A Recursion

A recursion method always contains two parts: (1) **base case** and (2) **general pattern**

### 2.1 Base case

The `base case` is a like a pre-knowledge, is a situation that you know the answer directly without any calculation. For example, for a method `sum(int x)` (assume `x` is not negative) to calculate the sum of numbers in range `[0, x)`, if I ask you the result of `sum(4)`, yo u cannot give me the answer without calculation, then 4 is not a base case, the same as `sum(2)`, `sum(10)` or  `sum(99)`. But if I ask you the result of `sum(0)`, then you can directly tell the answer as `0`, because it is the border. then `x = 0` is a base case, when `x = 0`, you directly know the answer of the method, so you should return that answer, the code would look like:

```java
if (x == 0)
    return 0;
```

### 2.2 General pattern

The `general pattern` is for other cases that is not the base case, like `x = 4` or `x = 10`, usually in the general pattern part there should be a calling of the method itself, with a parameter update towards to the base case. And you might need to write one or two cases to find the general pattern.

For example, for the `sum(x)` task, `x = 3` and `x = 4` are two general cases, you can analysis them as:

```
sum(3) = 1 + 2
sum(4) = 1 + 2 + 3

so 

sum(4) = sum(3) + 3
```

And you may realize there is a pattern here for general `sum(x)`, which would be `sum(x) = sum(x - 1) + x - 1`

So you can have the conclusion, for a general situation, you can also gives the solution, even though it is an equation instead of a number, and since you have the answer, you should also directly return it.

```java
return sum(x - 1) + x - 1;
```



### 2.3 Final solution 

If you mix the base case and the general pattern together, you have the final solution of the recursion.

```java
public static int sumRecursion(int num) {
    // base case
    if (num == 0)
        return 0;

    // general pattern
    return sumRecursion(num - 1) + num - 1;
}
```



## 3. Pros and Cons

### 3.1 Pros

Even though beginners may find recursion is very difficult to write, but the fact is, once you get used to it, you may find recursion is always easy to write, it always contains the base case and the general pattern, no matter how complicated the task is. And to figure out the base case and the general pattern is relatively easy comparing with regular loops for some tasks. Many programmers will have the recursion solution immediately when they are facing a new task, while the loop solution make takes them a while to get there, and the code would be much longer. So generally, **recursion solution is easier for programmers to reach and implement**.  

### 2.1 Cons

Recursion has two disadvantages:

1. **Memory**: **Recursion takes more memory than regular loops**, because every time when a method call itself, that method is not done yet, so the computer has to keep that piece of memory for it and at the same time allocate another piece of memory for the new method.

2. **Speed**: **Recursion could be a little bit slower than regular loops**, this is because recursion is a method that calls itself, so usually the computer has to call methods more than one time, and calling a methods means: passing parameters, allocate memory, and returning the results, which will take some time, and if you have to iterate many times, that will make the algorithm slow.

   

## 4. How Recursion Works

Recursion works different a loop that we familiar with, which will move to the next iteration after it finish the current one:

```java
public static int sum(int num) {
    int sum = 0;
    
    // the iterator i equals 0 at first, and it will execute the body part of the for loop, once it is finished (adding 0 to the sum), it will move on to the next iteration.
    for (int i = 0; i < 5; i++)
        sum += i;
    
    return sum;
}
```

 Recursion does not work like that, it follows **first call, last return** rule (like Stack data structure, last-in-first-out(LIFO)). The first call method will be hanging there wait without returning until the method that it calls finished. The last called method will activate the base case and activate the `return` , and then activates the `return` of the previous methods one by one. 

```java
public static int sumRecursion(int num) {
    if (num == 0)
        return 0;

    return sumRecursion(num - 1) + num - 1;
}

public static void main(String[] args) {
    System.out.println(sumRecursion(5));
}
```

Here is an example of the methods calling and returning flow of the previous example:

![](imgs\Chapter3\3.1-flow for calling sum(5).png)

