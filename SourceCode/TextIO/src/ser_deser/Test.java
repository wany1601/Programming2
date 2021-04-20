/*
 * The MIT License
 *
 * Copyright 2021 Yi Wang.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ser_deser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import textio.Student;

/**
 *
 * @author Yi Wang
 */
public class Test {

    public static void main(String[] args) {
        Integer num1 = -8;
        Integer num2 = 0;
        System.out.println(num1 / num2);
//        String str = "hello";         // pre-defined class
//        String[] strs = {"hello", "world", "yi", "wang"};       // array object
//        String path = "stu.ser"; // serialized file
//        Student stu = new Student("0001", "yi", "wang", true, new double[]{98, 92});
        // serialization
//        serializeData(path, stu);

        // deserialization
        // deserialization always only return an Object object, which usually is
        // not the data type we are looking for. We usually have to cast the result
        // of deserialization into the proper data type manually.
//        System.out.println(Arrays.toString((String[]) deserializeData(path)));
//        System.out.println((Student) deserializeData(path));
    }

    /**
     * Serializes data into a file
     *
     * @param path the path of the file
     * @param obj the data to be serialized
     */
    public static void serializeData(String path, Object obj) {
        // step 1 create a FileOutputStream object
        try ( FileOutputStream fos = new FileOutputStream(path)) {
            // step 2 create an ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // step 3 call writeObject() to write the object to a file
            oos.writeObject(obj);
        } catch (Exception e) {
        }
    }

    /**
     * Deserializes a file to data
     *
     * @param path the path of the file
     * @return the deserialized object
     */
    public static Object deserializeData(String path) {
        Object obj = null;
        // step 1 create a FileInputStream object
        try ( FileInputStream fis = new FileInputStream(path)) {
            // step 2 create an ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(fis);
            // step 3 call readObject() to read the object from a file
            obj = ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        return obj;
    }

}
