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
 * A simple class for Member
 *
 * @author Yi Wang
 */
public class Member extends User {

    private ArrayList<Publication> currentBooks;
    private ArrayList<Publication> rentHistory;
    private int credit;

    public Member() {
        super();
        this.currentBooks = new ArrayList<>();
        this.rentHistory = new ArrayList<>();
        this.credit = 0;
    }

    public Member(ArrayList<Publication> currentBooks, ArrayList<Publication> rentHistory,
            int credit, String id, String name, String gender, String email) {
        super(id, name, gender, email);
        this.currentBooks = currentBooks;
        this.rentHistory = rentHistory;
        this.credit = credit;
    }

    public Member(Member member) {
        super(member);
        this.rentHistory = new ArrayList<>(member.currentBooks);
        this.rentHistory = new ArrayList<>(member.rentHistory);
        this.credit = member.credit;
    }

    /**
     * rents a publication, add it to currentBooks
     *
     * @param publication the publication the member want to rent
     */
    public void rentBook(Publication publication) {
        currentBooks.add(publication);
    }

    /**
     * returns a book, remove it from currentBooks and add it to rentHistory
     */
    public void returnBook(Publication publication) {
        currentBooks.remove(publication);
        rentHistory.add(publication);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + super.hashCode();
        hash = 47 * hash + Objects.hashCode(this.rentHistory);
        hash = 47 * hash + this.credit;
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
        final Member other = (Member) obj;
        if (!super.equals(other))
            return false;
        if (this.credit != other.credit)
            return false;
        if (!Objects.equals(this.rentHistory, other.rentHistory))
            return false;
        return true;
    }

    public ArrayList<Publication> getRentHistory() {
        return rentHistory;
    }

    public void setRentHistory(ArrayList<Publication> rentHistory) {
        this.rentHistory = rentHistory;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

}
