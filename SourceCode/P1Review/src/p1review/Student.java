/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public Student() {
        this.lname = null;
        this.fname = null;
        this.age = -1;
        this.gender = null;
    }
    
    public Student(String lname, String fname, int age, String gender) {
        this.lname = lname;
        this.fname = fname;
        this.age = age;
        this.gender = gender;
    }
    
    public Student(Student student) {
        this.lname = student.lname;
        this.fname = student.fname;
        this.age = student.age;
        this.gender = student.gender;
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
