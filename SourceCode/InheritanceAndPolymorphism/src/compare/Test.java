package compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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
/**
 * A testing class
 *
 * @author Yi Wang
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[]{1, 3, 4, 2}));
        System.out.println(nums);

        Collections.sort(nums);         // sorting the arraylist (accending)  {1,2,3,4}
        Collections.reverse(nums);      // reverse the order {4,3,2,1}
        System.out.println(nums);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("1", "yi", "wang", 36, 'm'));
        students.add(new Student("2", "mike", "conna", 18, 'm'));
        students.add(new Student("3", "jon", "a", 22, 'm'));
        students.add(new Student("4", "jon", "c", 22, 'f'));
        students.add(new Student("5", "jon", "b", 22, 'f'));
        students.add(new Student("6", "jon", "d", 22, 'm'));
        students.add(new Student("-1", "jon", "d", 22, 'm'));
//        Collections.sort(students);     // How to sort an arrayList of user-defined objects ???
//        Collections.sort(students, new NameComparator());
//        System.out.println(students);
        sortStudents(students);
        printStudents(students);
    }

    /**
     * Asks the user to choose a specific way to sort the students
     *
     * @param students the original students list
     */
    public static void sortStudents(ArrayList<Student> students) {
        System.out.println("How do you want to sort the students");
        System.out.println("1. based on the age");
        System.out.println("2. based on the name");
        System.out.println("3. based on the gender");

        Scanner console = new Scanner(System.in);
        int choice = console.nextInt();

        switch (choice) {
            case 1:
                Collections.sort(students, new Student.AgeComparator());
                return;
            case 2:
                Collections.sort(students, new Student.NameComparator());
                return;
            case 3:
                Collections.sort(students, new Student.GenderComparator());
        }
    }

    /**
     * Prints the students line by line
     *
     * @param students the original students list;
     */
    public static void printStudents(ArrayList<Student> students) {
        for (Student student : students)
            System.out.println(student);
    }

}
