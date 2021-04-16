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
package textio;

import java.io.Serializable;
import java.util.Arrays;

/**
 * A class of Student for the textIO
 *
 * @author Yi Wang
 */
// by default, a user-defined class is not serializable
// you can turn it to serializable by adding "implements Serializable"
public class Student implements Serializable {

    private String id;
    private String fname;
    private String lname;
    private boolean registered;
    private double[] scores;

    public Student(String id, String fname, String lname, boolean registered, double[] scores) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.registered = registered;
        this.scores = scores;
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s: %s\t", "ID", id);
        str += String.format("%-10s: %s\t", "Name", fname + " " + lname);
        str += String.format("%-10s: %s\t", "Registered", registered);
        str += String.format("%-10s: %s\n", "Scores", Arrays.toString(scores));

        return str;
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

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

}
