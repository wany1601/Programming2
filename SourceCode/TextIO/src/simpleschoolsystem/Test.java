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
package simpleschoolsystem;

/**
 *
 * @author Yi Wang
 */
public class Test {

    public static void main(String[] args) {
        SimpleSchoolSystem.initData();
        Student s1 = new Student(SimpleSchoolSystem.generateID('s'), "Yi", "Wang", "male");
        SimpleSchoolSystem.addStudent(s1);
        Teacher t1 = new Teacher(SimpleSchoolSystem.generateID('t'), "Jon", "Snow", "male");
        Teacher t2 = new Teacher(SimpleSchoolSystem.generateID('t'), "Mike", "Conna", "male");
        SimpleSchoolSystem.addTeacher(t1);
        SimpleSchoolSystem.addTeacher(t2);
        Course c1 = new Course("C0001", "Programing 1");
        SimpleSchoolSystem.addCourse(c1);

//        System.out.println(students);
//        System.out.println(teachers);
//        System.out.println(courses);
        s1.registerCourse(c1);      // 0
        s1.registerCourse(c1);      // 1
        t1.registerCourse(c1);      // 0
        t1.registerCourse(c1);      // 1
        t2.registerCourse(c1);      // 2
//        System.out.println(students);
//        System.out.println(teachers);
//        System.out.println(courses);
//        System.out.println(c1);
//        System.out.println(s1);
//        System.out.println(t1);
    }
}
