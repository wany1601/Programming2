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
package library;

/**
 * A simple class of Author
 *
 * @author Yi Wang
 */
public class Author {

    private String name;
    private String nationality;
    private String email;

    private static final String[] VALID_NATIONALITIES = {"Canadian", "French", "US"};

    public Author() {
        this.name = "";
        this.nationality = "";
        this.email = "";
    }

    public Author(String name, String nationality, String email) {
        this.name = name;
        this.nationality = nationality;
        this.email = email;
    }

    public Author(Author author) {
        this.name = author.name;
        this.nationality = author.nationality;
        this.email = author.email;
    }

    /**
     * Checks if a nationality is valid or not, all valid nationalities are
     * stored in VALID_NATIONALITIES
     *
     * @param nationality the nationality the user wants to check
     * @return true if a nationality is valid
     */
    public boolean isNationalityValid(String nationality) {
        for (String validNationality : VALID_NATIONALITIES)
            if (validNationality.equalsIgnoreCase(nationality))
                return true;

        return false;
    }

    /**
     * Converts a string to title case
     *
     * @param str the input string that needs to be converted
     * @return the string in title case
     */
    public String toTitleCase(String str) {
        String str2 = "";
        //xxx xxx xxx xxxx
        //X
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0)
                str2 += Character.toUpperCase(c);
            else
                str2 += (c == ' ') ? " " + Character.toUpperCase(str.charAt(++i)) : str.charAt(i);
        }

        return str2;
    }

    public String toTitleCase2(String str) {
        String str2 = "";
        //xxx xxx xxx xxxx
        //X
        str = str.toLowerCase();
        boolean upper = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            str2 += (upper) ? Character.toUpperCase(c) : str.charAt(i);

            upper = c == ' ';
        }

        return str2;
    }

    public String toTitleCase3(String str) {
        String str2 = "";
        //xxx xxx xxx xxxx   -> {xxx, xxx, xxx, xxxx}
        //X
        str = str.toLowerCase();
        String[] words = str.split(" ");

        for (String word : words)
            str2 += Character.toUpperCase(word.charAt(0)) + word.substring(1);

        return str2;
    }

    public boolean equals(Author author) {
        return this.name.equals(author.name)
                && this.nationality.equals(author.nationality)
                && this.email.equals(author.email);
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s: %s", "Name", name);
        str += String.format("%-10s: %s", "Nationality", nationality);
        str += String.format("%-10s: %s", "Email", email);

        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if (isNationalityValid(nationality))
            this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
