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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * A class of simple school system
 *
 * @author Yi Wang
 */
public class SimpleSchoolSystem {

    private static ArrayList<Student> students;
    private static ArrayList<Teacher> teachers;
    private static ArrayList<Course> courses;

    /**
     * initializes students, teachers and courses
     */
    public static void initData() {
        File studentFile = new File("students.ser");
        File teacherFile = new File("teachers.ser");
        File courseFile = new File("courses.ser");

        if (studentFile.isFile())
            students = (ArrayList<Student>) deserializeData("students.ser");
        else
            students = new ArrayList<>();

        if (teacherFile.isFile())
            teachers = (ArrayList<Teacher>) deserializeData("teachers.ser");
        else
            teachers = new ArrayList<>();

        if (courseFile.isFile())
            courses = (ArrayList<Course>) deserializeData("courses.ser");
        else
            courses = new ArrayList<>();
    }

    /**
     * Generates an ID for the new element
     *
     * @param type if the new element is a Student, or a Teacher or a Course
     * @return the ID for the new element
     */
    public static String generateID(char type) {
        type = Character.toLowerCase(type);
        switch (type) {
            case 's':
                return String.format("S%04d", students.size() + 1);
            case 't':
                return String.format("T%04d", teachers.size() + 1);
            default:
                return String.format("C%04d", courses.size() + 1);
        }
    }

    /**
     * Serialize data into a file
     *
     * @param path the path of the file
     * @param object the object to be serialized
     */
    public static void serializeData(String path, Object object) {
        try ( FileOutputStream fos = new FileOutputStream(path)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        } catch (Exception e) {
        }
    }

    /**
     * Deserialize data from a file
     *
     * @param path the path of the file
     * @return the data deserialized from the file
     */
    public static Object deserializeData(String path) {
        Object object = null;
        try ( FileInputStream fis = new FileInputStream(path)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
        } catch (Exception e) {
            System.out.println("!!!!!");
        }

        return object;
    }

    /**
     * Serialize students, teachers, and courses
     */
    public static void serializeALlData() {
        serializeData("students.ser", students);
        serializeData("teachers.ser", teachers);
        serializeData("courses.ser", courses);
    }

    /**
     * adds a new student to students
     *
     * @param student a new student
     */
    public static void addStudent(Student student) {
        students.add(student);
        serializeALlData();
    }

    /**
     * adds a new teacher to teachers
     *
     * @param teacher a new teacher
     */
    public static void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        serializeALlData();
    }

    /**
     * adds a new course to courses
     *
     * @param course a new course
     */
    public static void addCourse(Course course) {
        courses.add(course);
        serializeALlData();
    }

}
