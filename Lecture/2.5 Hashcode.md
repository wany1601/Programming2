# 2.5 HashCode

## 1. Set 

Let's first take a look at one example: there is a big library with thousands of books, and the library wants to know how many authors are Canadian. What we can do is to go through each book, and find out the nationality of the author, if she/he is Canadian, then increase the counter by one. However, an author may write more than one book, so this solution may count an author more than one time. 

A better solution is to create a collection that contains all Canadian authors that you have see so far. So every time you see a Canadian author, first check if it exists in that collection already, if so, you should not count it again, only if the collection does not contain that author, you can increase the counter by one and add the author to the collection. For this solution, you need to write a if statement to manually check if you should count a Canadian author or not.

There is a perfect data structure can do this for you. `Set`, which is also a collection, allows you to add different elements to it. However, Set do not have repeated elements, that is to say, if you have an empty set, and you want to add 1 to it, then 1 will be successfully added to it. After that, if you want to add 1 to the same set again, then the 1 will not be added since there is already a 1 inside. You can understand it as every time if you want to add a new element to a set, there is a hidden for loop that go through the set, and takes each element out and uses `equals()` compare it to the element you want to add, if the two are the same, then the set will not re-add the element again.    

## 2. HashCode

If we have a big set, like right now we have a set of Canadian authors, and since we have thousands of books in the library, the Canadian authors can also be a lot. Assume we have 1000 of them added to the set, and right now we find a new book that is written by a Canadian author, Java will go through the set, and try to compare the new author with each element, and there are two situations: 1. if any element in the set is the same as the new author, Java will not add the new author to the set; 2. if no element in the set is the same as the new author, then Java will add the new author to the set.

And to compare two authors Java can use the `equals()` method. The problem is that there are 1000 of authors in the set already, that is to say, in the worst case, we have to call `equals()` 1000 times to know if we can add that new author to the set. Calling a method takes resources, you have to pass parameters, do calculations (usually there are many if statements, and a casting statement in `equals()`), and then return the result. do it for 1000 times just for a simple adding operation does not sound very efficient. 

So there comes the `hashcode`.  The idea of hashcode is very simple. Comparing two objects by using `equals()` is very time consuming, but computer can always compare two integers fast, like 3 and 5 are not equal. So if we can use an integer number to represent an object, we can compare integers instead of comparing two objects, which will save us a lot of time.

`hashcode()` is a method that calculates the hashcode for an object based on its data member. There are many different algorithms to calculate the hashcode, but all of them can be understood as a mathematic function `f(x)`, passing `x`(the object) to it, it will return you `y` (an integer). If two objects (`x`) are the same, then the calculated hashcode(`y`) should always  be the same. But to be noticed, even though the chance is very low, if two objects (`x`) are not the same, the hashcde(`y`) may still be the same, in the other word, the hashcode is not unique.

So now what Java will do when we want to add a new element to the set, Java will first call the `hashCode()` method to calculate the hashcode for the new object, and then compare with the hashcode with each element in the set, if the two hashcode are not the same, Java knows that the two objects are not the same, and if the two hashcode are the same, Java will call the `equals()` to double check if the two objects are the same or not (this will happen very rarely).  

## 3. How to Write HashCode()

### 3.1 Superclass

For a superclass, you can generate the `hashCode()` directly, and choose the data member that you want to have.

```java
@Override
public int hashCode() {
    int hash = 5;          
    hash = 53 * hash + Objects.hashCode(this.id);           
    hash = 53 * hash + Objects.hashCode(this.title);        
    hash = 53 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
    return hash;
}
```

### 3.2 Subclass

For a subclass, you need to call the superclass `hashCode()` to generate a hashcode based on the superclass data members and then add it with the hashcode based on the subclass data members.

```java
@Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + super.hashCode();		// calling the super class hashcode()
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.publicationFrequency)
                ^ (Double.doubleToLongBits(this.publicationFrequency) >>> 32));
        return hash;
    }
```

 