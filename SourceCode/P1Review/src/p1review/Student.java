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
package p1review;

/**
 * A simple class of Student
 *
 * @author Yi Wang
 */
public class Student {

    private String lname;           // ctrl + shift + up or down
    private String fname;

    private int age;
    private String gender;
    private Address address;

    public Student() {
        this.lname = null;
        this.fname = null;
        this.age = -1;
        this.gender = null;
        // null address, you cannot call anything through address, including the toString()
        // this.address = null;
        this.address = new Address();
    }

    public Student(String lname, String fname, int age, String gender, Address address) {
        this.lname = lname;
        this.fname = fname;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Student(Student student) {
        this.lname = student.lname;
        this.fname = student.fname;
        this.age = student.age;
        this.gender = student.gender;
        // this.address = student.address;             // shallow copy -- bad
        this.address = new Address(student.address);// deep copy -- good
    }

    public boolean equals(Student student) {
        return this.lname.equals(student.lname)
                && this.fname.equals(student.fname)
                && this.age == student.age
                && this.gender.equals(student.gender);
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s: %s %s\n", "Name", fname, lname);
        str += String.format("%-10s: %d\n", "Age", age);
        str += String.format("%-10s: %s\n", "Gender", gender);
        str += String.format("%-10s: %s\n", "Address", address);        // add address

        return str;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
