# 5.2 TextIO: Output

Previously we have learned how to read from an external file, and in this chapter we will learn how to write to a file.

## 1. Output Syntax

### 1.1 Basic Syntax

Generally there are 3 steps to read from a file:

1. create a `File` object and link it with the file path

   ```java
   File file = new File(path);
   ```

2. create a `FileWriter` object and link it with the previous `File` object, and in this step, you should use `try with resource` structure and create the `FileWriter` object as the resource.  If you only pass one parameter to the constructor, Java will open the file in `over-writing` mode, and Java will always over-write the file ignoring the previous context. If you pass `true` as the second parameter, then Java will open the file in `appending` mode, and add the data in the end of the previous context instead of over-writing it.   

   ```java
   // try (FileWriter fw = new FileWriter(file)) {		    // over-write mode
   try (FileWriter fw = new FileWriter(file, true)) {		// appending mode
       // code
   }
   catch (IOException e) {
       System.out.println("Fail to write to the file");
   }
   // once the try-catch structure is over, the input resource will be released
   ```

3. write data to the file. You can use `write()` to write data to the file. `write()` method does not contain the line breaker (like `print()`), so if you want to break the line, you should add `"\n"` manualy/  

   ```java
   try (FileWriter fw = new FileWriter(file, true)) {
       fw.write("hi\n");
   }
   catch (IOException e) {
       System.out.println("Fail to write to the file");
   }
   ```

Here is an example of a method to write a file. However, the second parameter (the data) is different case by case.

```java
/**
 * Writes data to a file
 *
 * @param path the path of the output file
 * @param num the data to write
 */
public static void writeFile(String path, int num) {
    // Step 1: create File object
    File file = new File(path);

    // Step 2: create FileWriter object
    try (FileWriter fw = new FileWriter(file, true)) {
        fw.write(num + "\n");
        //            PrintWriter pw = new PrintWriter(fw);
        //            pw.println(pw);
    } catch (IOException e) {
        System.out.println("Writing file failed");
    }
}
```

 

### 1.2 Write Multi-column Data

Previously we have leaned how to write one data to an external file. In this section we will see a more complicated situation, if we want to write to a row. Assume the data (score of a student, separated by space) look like this:

```markdown
1 2 3 4 5	
```

If the data is an array, we can use an enhanced for loop to go through the data and write them, separated by `,`.  

```java
/**
 * Writes a row of data into a file
 *
 * @param path the path of the file
 * @param nums the data to write: 1 2 3 4 5
 */
public static void writeFileRow(String path, int[] nums) {
    File file = new File(path);

    try (FileWriter fw = new FileWriter(file, true)) {
        for (int num : nums)
            fw.write(num + ",");
    } catch (IOException e) {
        System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
    }
}
```



### 1.3. Write Multi-row Data

Let's say right now we want to write the same array to a file, but each element in a new row, the only thing we have to change is to add `"\n"` instead of `","` in the `write()`.

```java
/**
 * Writes a column of data into a file
 *
 * @param path the path of the file
 * @param nums the data to write
 */
public static void writeFileCol(String path, int[] nums) {
    File file = new File(path);

    try (FileWriter fw = new FileWriter(file, true)) {
        for (int num : nums)
            fw.write(num + "\n");

    } catch (IOException e) {
        System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
    }

}
```

 

### 1.4. Write Table-like Data

If we have data that contains more than one row and more than one column at the same time, we can combine the two previous methods as one:

```java
/**
 * Writes a matrix of data into a file
 *
 * @param path the path of the file
 * @param numss the data to write
 */
public static void writeFileTable(String path, int[][] numss) {
    File file = new File(path);

    try (FileWriter fw = new FileWriter(file, true)) {
        for (int[] nums : numss) {
            for (int num : nums)
                fw.write(num + ",");
            fw.write("\n");
        }

    } catch (IOException e) {
        System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
    }
}
```

