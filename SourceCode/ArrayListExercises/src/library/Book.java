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

import java.util.Arrays;

/**
 * A class of Book
 *
 * @author Yi Wang
 */
public class Book {

    private String title;
    private Author[] authors;
    private double price;

    public Book() {
        this.title = "";
        this.authors = new Author[0];
        this.price = 0;
    }

    public Book(String title, Author[] authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public Book(Book book) {
        this.title = book.title;
        this.authors = Arrays.copyOf(book.authors, book.authors.length);
        this.price = book.price;
    }

    public boolean equals(Book book) {
        return this.title.equals(book.title)
                && Arrays.equals(authors, book.authors)
                && this.price == book.price;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", authors=" + authors + ", price=" + price + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
