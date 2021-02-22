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

import java.util.ArrayList;

/**
 * A class of Library
 *
 * @author Yi Wang
 */
public class Library {

    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public Library(Library library) {
//        this.books = library.books; // shallow copy
        this.books = new ArrayList<Book>(library.books);        // deep copy
    }

    /**
     * Adds a new book to the books
     *
     * @param book a new book
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from books if you know the book
     *
     * @param book a specific book you want to remove
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * Removes a book from books if you know the idx of the book
     *
     * @param idx the index of the book you want to remove
     */
    public void removeBook(int idx) {
        books.remove(idx);
    }

    /**
     * Searches for books that contains a specific keyword, add a book to the
     * search result if either the title of the book or the authors of the book
     * contains the keyword
     *
     * @param keyword the keyword for searching
     * @return the search results
     */
    public ArrayList<Book> search(String keyword) {
        keyword = keyword.toLowerCase();
        ArrayList<Book> searchResults = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword))
                searchResults.add(book);
            for (Author author : book.getAuthors())
                if (author.getName().toLowerCase().contains(keyword))
                    searchResults.add(book);
        }

        return searchResults;
    }

}
