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
import java.util.HashSet;
import java.util.LinkedList;

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
        this.books = new ArrayList<>(library.books);        // deep copy
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

    /**
     * Counts the number of authors with a certain nationality, an author will
     * only be counted for maximum 1 time no matter how many books the author
     * writes
     *
     * @param nationality the nationality you want to check
     * @return the number of authors with the nationality
     */
    public int countAuthors(String nationality) {
        LinkedList<Author> countedAuthors = new LinkedList<>();

        for (Book book : books)
            for (Author author : book.getAuthors())
                if (!countedAuthors.contains(author)
                        && author.getName().equalsIgnoreCase(nationality))
                    countedAuthors.add(author);

        return countedAuthors.size();
    }

    /**
     * Counts the number of authors with a certain nationality, an author will
     * only be counted for maximum 1 time no matter how many books the author
     * writes, using Set
     *
     * @param nationality the nationality you want to check
     * @return the number of authors with the nationality
     */
    public int countAuthors2(String nationality) {
        // ArrayList belongs to a family "List", List allows to have repeated values
        // List also has order {1, 2, 3}, add(4)

        // Set, does not have an order, set does not allows repeated values
        // {"female", "male"} == {"male", "female"},
        // {0,1,2,3,4,5,6,7,8,9}, {3,1,2,6,4,5,8,9,0,7}
        HashSet<Author> countedAuthors = new HashSet<>();

        for (Book book : books)
            for (Author author : book.getAuthors())
                if (author.getName().equalsIgnoreCase(nationality))
                    countedAuthors.add(author);

        return countedAuthors.size();
    }

}
