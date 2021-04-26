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
package compare;

import java.util.Comparator;
import java.util.Objects;

/**
 * A simple Student class
 *
 * @author Yi Wang
 */
public class Student implements Comparable<Student> {       // implement the interface

    private String id;
    private String fname;
    private String lname;
    private int age;
    private char gender;

    public Student(String id, String fname, String lname, int age, char gender) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.gender = gender;
    }

    // return 0: equals
    // return positive:
    // return negative:
    @Override
    public int compareTo(Student student) {
//        return student.age - this.age;              // descending
//        return this.age - student.age;              // ascending
        return this.fname.compareTo(student.fname);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.fname);
        hash = 89 * hash + Objects.hashCode(this.lname);
        hash = 89 * hash + this.age;
        hash = 89 * hash + this.gender;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Student other = (Student) obj;
        if (this.age != other.age)
            return false;
        if (this.gender != other.gender)
            return false;
        if (!Objects.equals(this.id, other.id))
            return false;
        if (!Objects.equals(this.fname, other.fname))
            return false;
        if (!Objects.equals(this.lname, other.lname))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fname=" + fname + ", lname=" + lname
                + ", age=" + age + ", gender=" + gender + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * A Comparator to compare two students based on their ages, then fname,
     * then lname
     */
    public static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return (s1.age - s2.age) * 10000
                    + s1.fname.compareTo(s2.fname)
                    + s1.lname.compareTo(s2.lname);
        }

    }

    /**
     * A Comparator to compare two students based on their fname, then lname,
     * then id
     */
    public static class NameComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            // return heavy_weight * A + B
            return s1.fname.compareTo(s2.fname) * 10000
                    + s1.lname.compareTo(s2.lname) * 100
                    + s1.id.compareTo(s2.id);
        }

    }

    /**
     * A Comparator to compare two students based on their gender, then fname,
     * then lname, then id
     */
    public static class GenderComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return (s1.gender - s2.gender) * 1000000
                    + s1.fname.compareTo(s2.fname) * 10000
                    + s1.lname.compareTo(s2.lname) * 100
                    + s1.id.compareTo(s2.id);
        }

    }

}
