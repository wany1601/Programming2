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
package bookstore;

import java.util.ArrayList;

/**
 *
 * @author Yi Wang
 */
public class Book extends Item {

    protected String title;
    protected ArrayList<Person> authors;
    private static int nextBookNo = 1;

    public Book() {
        super();
        setItemNo(String.format("B%04d", nextBookNo++));
        this.title = "";
        this.authors = new ArrayList<>();
    }

    public Book(String title, ArrayList<Person> authors, String itemNo, double price, int amount, String category, boolean isGift) {
        super(itemNo, price, amount, category, isGift);
        this.title = title;
        this.authors = authors;
        setItemNo(String.format("B%04d", nextBookNo++));
    }

    public Book(Book book) {
        super(book);
        this.title = book.title;
        this.authors = new ArrayList<>(book.authors);
        setItemNo(String.format("B%04d", nextBookNo++));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Person> authors) {
        this.authors = authors;
    }

    public static int getNextBookNo() {
        return nextBookNo;
    }

    public static void setNextBookNo(int nextBookNo) {
        Book.nextBookNo = nextBookNo;
    }

}
