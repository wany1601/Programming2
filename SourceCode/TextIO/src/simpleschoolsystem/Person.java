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

/**
 * A simple class of Person
 *
 * @author Yi Wang
 */
public class Person implements Serializable {

    private String id;
    private String fname;
    private String lname;
    private String gender;

    public Person(String id, String fname, String lname, String gender) {
        this.id = id;
        this.fname = toTitleCase(fname);
        this.lname = toTitleCase(lname);
        this.gender = gender;
    }

    /**
     * Converts a string to title case
     *
     * @param str the original string
     * @return the string in title case
     */
    public final String toTitleCase(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s: %s\n", "ID", id);
        str += String.format("%-10s: %s %s\n", "Name", fname, lname);
        str += String.format("%-10s: %s\n", "Gender", gender);

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

    public String getName() {
        return fname + " " + lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
