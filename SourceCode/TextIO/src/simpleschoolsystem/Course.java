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
 * A simple class of Course
 *
 * @author Yi Wang
 */
public class Course implements Serializable {

    private String id;
    private String name;
    private Teacher teacher;
    private ArrayList<Student> students;
    private ArrayList<Assignment> assignments;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        this.teacher = null;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    // TODO
    public void addAssignment(Teacher teacher, Assignment assignment) {
//        if (!this.teacher.equals(teacher))
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.teacher);
        hash = 67 * hash + Objects.hashCode(this.students);
        hash = 67 * hash + Objects.hashCode(this.assignments);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.id, other.id))
            return false;
        if (!Objects.equals(this.name, other.name))
            return false;
        if (!Objects.equals(this.teacher, other.teacher))
            return false;
        if (!Objects.equals(this.students, other.students))
            return false;
        if (!Objects.equals(this.assignments, other.assignments))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s: %s\n", "ID", id);
        str += String.format("%-10s: %s\n", "Name", name);
        str += String.format("%-10s: %s\n", "Teacher",
                (teacher == null) ? null : teacher.getName());

        str += "Reg Students:\n";
        for (Student student : students)
            str += String.format("%-10s: %s\n", "", student.getName());

        return str;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

}
