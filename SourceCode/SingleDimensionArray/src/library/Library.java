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
import java.util.Random;

/**
 * A class of Library
 *
 * @author Yi Wang
 */
public class Library {

    private Book[] books;

    public Library() {
        this.books = new Book[]{new Book(), new Book(), new Book(), new Book()};
    }

    public Library(Book[] books) {
        this.books = books;
    }

    public Library(Library library) {
        this.books = Arrays.copyOf(library.books, library.books.length);
    }

    /**
     * Selects a random book from books
     *
     * @return a random selected book
     */
    public Book selectBook() {
        Random rand = new Random();
        return books[rand.nextInt(books.length)];
    }

    /**
     * Selects a specific book from books, if the index does not exist, then
     * select a random book instead
     *
     * @return a specific book if the index is valid, or a random book if the
     * index is not valid
     */
    public Book selectBook(int idx) {
        return (idx >= 0 && idx < books.length) ? books[idx] : selectBook();
    }

    /**
     * Calculates the total price of all books
     *
     * @return the total price of all books
     */
    public double calcTotalPrice() {
        double totalPrice = 0;

        for (Book book : books)
            totalPrice += book.getPrice();

        return totalPrice;
    }

    /**
     * Counts the number of authors in the books that have a specific
     * nationality
     *
     * @param nationality the specific nationality
     * @return the number of authors in the books that have a specific
     * nationality
     */
    public int countNationality(String nationality) {
        int count = 0;

        for (Book book : books)
            for (Author author : book.getAuthors())
                if (author.getNationality().equalsIgnoreCase(nationality))
                    count++;

        return count;
    }

    public boolean equals(Library library) {
        return Arrays.equals(this.books, library.books);
    }

    @Override
    public String toString() {
        String str = "";

        for (Book book : books)
            str += book + "\n";

        return str;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public static void main(String[] args) {
        Author a1 = new Author("Yi", "Canadian", "yi@gmail.com");
        Author a2 = new Author("Wang", "Canadian", "wang@gmail.com");

        Book b1 = new Book("Java", new Author[]{a1, a2}, 9.99);
        Book b2 = new Book("Java2", new Author[]{a1}, 19.99);

        Library l1 = new Library(new Book[]{b1, b2});

        System.out.println(l1.selectBook());
        System.out.println("Total price: " + l1.calcTotalPrice());
        System.out.println("Canadian: " + l1.countNationality("Canadian"));
    }

}
