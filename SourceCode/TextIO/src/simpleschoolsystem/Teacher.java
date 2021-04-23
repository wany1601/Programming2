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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple class of Teacher
 *
 * @author Yi Wang
 */
public class Teacher extends Person implements Serializable {

    private ArrayList<Course> courses;

    public Teacher(String fname, String lname, String gender) {
        super(SimpleSchoolSystem.generateID('t'), fname, lname, gender);
        this.courses = new ArrayList<>();
    }

    /**
     * Register a course for the teacher
     *
     * @param course the course to be registered
     * @return if the course is registered successfully: 0: success, 1:
     * registered already, 2: course is taken by someone else
     */
    public int registerCourse(Course course) {
        if (courses.contains(course))           // calling equals() in Course
            return 1;           // registered the course already

        if (course.getTeacher() != null)    // has been taken by someone else
            return 2;

        courses.add(course);                // add the course on the teacher side
        course.setTeacher(this);            // set myself as the teacher of the course
        SimpleSchoolSystem.serializeALlData();      // serialize all data
        return 0;               // register successfully
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + super.hashCode();
        hash = 37 * hash + Objects.hashCode(this.courses);
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
        final Teacher other = (Teacher) obj;
        if (!super.equals(other))
            return false;
        if (!Objects.equals(this.courses, other.courses))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();

        str += "Teaching Courses:\n";
        for (Course course : courses)
            str += String.format("%-10s: %s\n", "", course.getName());

        return str;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

}
