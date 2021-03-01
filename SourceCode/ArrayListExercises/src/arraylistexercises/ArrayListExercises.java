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
package arraylistexercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Yi Wang
 */
public class ArrayListExercises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Double> al = new ArrayList<>(Arrays.asList(
                new Double[]{1.0, 1.0, 2.0, 3.0, 1.0}));

        // to go through an arraylist and remove everything that equals to 1
        // solution 1: when remove an element, use -- to cancle the ++
        for (int i = 0; i < al.size(); i++)
            if (al.get(i) == 1)
                al.remove(al.get(i--));

        // to go through an arraylist and remove everything that equals to 1
        // solution 2: only execute ++ when no element is removed
        for (int i = 0; i < al.size();)
            if (al.get(i) == 1)
                al.remove(al.get(i));
            else
                i++;

        System.out.println(al);

        // not suggested, has no data type restriction
        ArrayList al1 = new ArrayList();            // array list of Objects
        al1.add(1);                                 // elements can be anything
        al1.add(1.1);
        al1.add("hello");

        // suggested, with data type restriction in <>, you can only put a class in the <>
        // you can add Integer to both <> before and after the '=',
        // or you can just add it before the '=' if you have two <>
        // when you want to create an empty arrayList, use new constructor
        ArrayList<Integer> al2 = new ArrayList<>();          // capacity = 10, but no elements inside
        ArrayList<Integer> al3 = new ArrayList<>(100);       // capacity = 100, but no elements inside
        al3.remove(0);                  // 0 is int, so remove the idx
        al3.remove((Integer) 0);        // 0 is Integer, so remove the element   int 0  Integer 0

        ArrayList<Double> aa = new ArrayList<>();
        aa.remove(3);       // 3 is int, so idx
        aa.remove(3.14);    // 3.14 is double, so value

        ArrayList<String> ss = new ArrayList<>();
        ss.remove(0);       // 0 is int, so idx
        ss.remove("Hello"); // "Hello" is String, so value

        // advanced, will talk about it later in chapeter 2
        // the reference can also be List instead of ArrayList
        List<Integer> l4 = new ArrayList();                  // ArrayList is a special kind of array

        // advanced, will talk about it later in chapeter 2
        // when you have specific values you want to put in the arraylist,
        // first create an array with {} to list all elements,
        // then use Arrays.asList() to cast the array into a List
        Integer[] nums = {1, 2, 3, 1, 1, 1};     // array
        List<Integer> l5 = new ArrayList(Arrays.asList(nums));
        System.out.println(l5);

        al2.add(1);
        al2.add(2);
        al2.add(1, 9);

        // .size() the same as the .length() for string, .length for array
        System.out.println(al2.size());

        // ArrayList is a class, that contains the toString() method you can directly use
        System.out.println(al2);

        // get()  to read an element
        System.out.println(al2.get(0));      // nums[0] -> first element

        // set() to modify an element
        al2.set(0, -1);
        System.out.println(al2);

        // remove() to remove an element
        al2.remove(0);
        System.out.println(al2);

        // remove() takes also the value to remove
        al2.remove((Integer) 999);
        System.out.println(al2);
    }
}
