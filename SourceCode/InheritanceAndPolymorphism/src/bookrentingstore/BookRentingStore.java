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
package bookrentingstore;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class for the store system
 *
 * @author Yi Wang
 */
public class BookRentingStore {

    private ArrayList<Publication> publications;
    private ArrayList<User> users;

    public BookRentingStore() {
        this.publications = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public BookRentingStore(ArrayList<Publication> publications, ArrayList<User> users) {
        this.publications = publications;
        this.users = users;
    }

    public BookRentingStore(BookRentingStore bookRentingStore) {
        // Deep Copy
        // Array: Arrays.copyOf(array2, array2.length);
        // ArrayList: new ArrayList<>(arrayList2);

        this.publications = new ArrayList<>(bookRentingStore.publications);
        this.users = new ArrayList<>(bookRentingStore.users);
    }

    /**
     * Adds a new publication to the publications
     *
     * @param publication a new publication
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    /**
     * Adds a new user to the users
     *
     * @param user a new user
     */
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.publications);
        hash = 19 * hash + Objects.hashCode(this.users);
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
        final BookRentingStore other = (BookRentingStore) obj;
        if (!Objects.equals(this.publications, other.publications))
            return false;
        if (!Objects.equals(this.users, other.users))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        // Array -> String
        // String[] this is not class, so there is no toString(), equals()
        // 1d -> Arrays.toString()
        // 2d -> Arrays.deepToString()
        // ArrayList -> String
        // ArrayList<Double> this is a real class, so there are toString(), equals()
        str += String.format("%-10s: %s\n", "Publications", publications);      // [xx, xx, xx]
        str += String.format("%-10s: %s\n", "Users", users);      // [xx, xx, xx]

        return str;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BookRentingStore brs = new BookRentingStore();
        Publication p1 = new Magazine(1, "blabla", 3);
        Publication p2 = new Magazine(1, "blabla", 3);
    }

}
