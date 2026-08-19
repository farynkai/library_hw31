package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Library {

    private final HashSet<Book> books = new HashSet<>();

    public void addBook(Book book) {
        Objects.requireNonNull(book, "Book cannot be null");

        if (!books.add(book)) {
            throw new IllegalArgumentException("Book already exists: " + book);
        }
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            return false;
        }

        return books.remove(book);
    }

    public Set<Book> getBooks() {
        return Set.copyOf(books);
    }

    public int getBookCount() {
        return books.size();
    }
}
