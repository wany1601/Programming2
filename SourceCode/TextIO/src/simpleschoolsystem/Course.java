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
import java.io.FileWriter;
import java.io.IOException;
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

    public Course(String name) {
        this.id = SimpleSchoolSystem.generateID('c');
        this.name = name;
        this.teacher = null;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    /**
     * Generates the ID for the new assignment
     *
     * @return the ID for the new assignment
     */
    public String generateAssignmentId() {
        return String.format("A%d", assignments.size() + 1);
    }

    /**
     * adds assignment to the course
     *
     * @param teacher the teacher who does the operation
     * @param assignment the new assignment
     * @return if the assignment is successfully added
     */
    public boolean addAssignment(Teacher teacher, Assignment assignment) {
        if (!this.teacher.equals(teacher))
            return false;

        assignments.add(assignment);
        SimpleSchoolSystem.serializeALlData();
        return true;
    }

    /**
     * Calculates the mean grade of an assignment
     *
     * @param assignment the assignment
     * @return the mean grade of an assignment
     */
    public Double calcAssignmentMean(Assignment assignment) {
        double mean = 0;
        double count = 0;       // the number of grades that is not null

        for (Double grade : assignment.getGrades())
            if (grade != null) {
                mean += grade;
                count++;
            }

        return (count == 0) ? null : mean / count;
    }

    /**
     * Calculates the final grade of a student, which equals the weighted sum of
     * each assignment
     *
     * @param student the student
     * @return the final grade of a student
     */
    public Double calcStudentFinalGrade(Student student) {
        double finalGrade = 0;
        Double grade;

        // step 1: find the index of the student
        int idx = students.indexOf(student);

        // step 2: go through all assignments and check the grade for that specific student
        for (Assignment assignment : assignments) {
            grade = assignment.getGrades().get(idx);
            if (grade == null)
                grade = 0.0;
            finalGrade += grade * assignment.getWeight();
        }

        return finalGrade;
    }

    /**
     * Exports the scores for the course to a .csv file
     */
    public void exportScores() {
        // step 1
        File file = new File(String.format("%s.csv", name));

        // Step 2
        try ( FileWriter fw = new FileWriter(file)) {
            String str = "";

            // header
            str += String.format("%s,%s,", "Fname", "Lname");
//            for (int i = 0; i < assignments.size(); i++)
//                str += String.format("A%02d,", i);

            for (Assignment assignment : assignments)
                str += String.format("%s,", assignment.getId());

            str += "FinalGrade\n";

            // scores for all students
            for (int i = 0; i < students.size(); i++) {
                // extract the name for a student
                str += String.format("%s,%s,",
                        students.get(i).getFname(), students.get(i).getLname());

                // extract scores of each assignment for a student
                for (Assignment assignment : assignments)
                    str += String.format("%.1f,", assignment.getGrades().get(i));

                str += String.format("%.1f\n", calcStudentFinalGrade(students.get(i)));
            }

            // mean for each assignment
            str += "Mean,,";            // A cell of "Mean" and an empty cell
            for (Assignment assignment : assignments)
                str += String.format("%.1f,", calcAssignmentMean(assignment));
            str += "\n";

            // Step 3
            fw.write(str);

        } catch (IOException e) {
        }
    }

    /**
     * Generates random scores for the course
     */
    public void generateRandomGrade() {
        for (Assignment assignment : assignments)
            for (int i = 0; i < assignment.getGrades().size(); i++)
                assignment.getGrades().set(i, Math.random() * 50 + 50);   // [50, 100)
        SimpleSchoolSystem.serializeALlData();
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
