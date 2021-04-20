# P2 - Assignment06

## **Due Date:** 

Apr-26 23:57:00. **Late submission will directly be marked as 0**.

## **Submission:**

**Please submit only .java files for this assignment**.

**Full Score**: 100

## **Knowledge Points**  of  This  Assignment

2. Text I/O
2. Serialization and Deserialization

***

## Task 1

### Requirement

Create a class of `Animal` with

1. Data members:
   1. `String id`
   2. `String name`
   3. `String type`
   4. `String gender`
   5. `int age`
   6. `int healthStatus`: a value of {-1, 0, 1, 2,}: 0 means healthy, 1 means a little sick, 2 means very sick, -1 means un-identical
2. Methods:
   1. Default constructor
   2. Constructor with `name`, `gender` and `age`
   3. `hashCode` and `equals`
   4. `toString`
   5. getters and setters 

Create a class of `Cat` that extends from `Animal`, with 

1. Additional Data Member 
   1. `boolean longFur`
2. Additional Methods
   1. constructor with `name`, `gender`, `age` and `longFur`
   2. `hashCode` and `equals`
   3. `toString`
   4. getters and setters 

Create a class of `Dog` that extends from `Animal`, with 

1. Additional Data Member 
   1. `String suitFor`				// "apartment" or "house"
2. Additional Methods
   1. constructor with `name`, `gender`, `age` and `longFur`
   2. `hashCode` and `equals`
   3. `toString`
   4. getters and setters 

***

## Task 2

### Requirement

Create a class of `Shelter`, which contains

1. Static variables:
    1. `List<Animal> animals`
2. Methods: 
    1. `addAnimal(Animal animal)`: to add an animal to the `animals`, it will call `serializeAnimals()` automatically to save the data
    2. `removeAnimal(Animal animal)`: to remove an animal from the `animals`, it will call `serializeAnimals()` automatically to save the data.
    3. `searchUnhealthyAnimals()`: to find all animals whose `healthStatus` is not `0`.
    4. `serializeAnimals(String path)`: to serialize the `animals` into a `.ser` file
    5. `deserializeAnimals(String path)`: to deserialize the .`ser` file into `animals`  
    6. `readAnimalFile(Strin path)`: to read a `.csv` file and returns all animals in a collection
    7. `writeAnimalFile(String path)`: to write a `.csv` file that contains all animals.
    8. `writeAnimalFile(String path, String suitFor)`: to write a `.csv` file that contains all animals, but only with the specific suit type. 
       1. If the input is `house`, then list all cats, and dogs with `house`
       2. If the input is `apartment`, then list all cats, and dogs with `apartment`

Note: Please create an initial `data.csv` file in the project folder by yourself:

```
id,name,type,gender,age,healthStatus,house/apartment,fur
1,kiki,cat,female,3,0,,long
2,tiger,dog,male,6,0,house
3,snow,cat,male,4,1,,short
4,lucky,cat,female,6,0,,short
5,angle,cat,female,2,0,,long
6,chase,dog,female,5,1,house
7,jojo,dog,male,10,2,apartment
8,lith,cat,female,0,-1,,short
9,copain,dog,male,5,0,apartment
10,charlie,dog,male,3,2,apartment
```

 