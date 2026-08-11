package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        Objects.requireNonNull(book, "Book cannot be null");
        if (books.contains(book)) {
            throw new IllegalArgumentException("Book already exists: " + book);
        }
        books.add(book);
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            return false;
        }
        return books.remove(book);
    }

    public List<Book> getBooks() {
        return List.copyOf(books);
    }

    public int getBookCount() {
        return books.size();
    }
}
