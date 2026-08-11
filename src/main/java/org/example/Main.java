package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling");
        Book book2 = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        Book book3 = new Book("The Hunger Games", "Suzanne Collins");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("Books in library: " + library.getBookCount());
        printBooks(library.getBooks());

        try {
            library.addBook(book1);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        boolean removed = library.removeBook(book2);
        System.out.println("Removed \"" + book2.getTitle() + "\": " + removed);

        System.out.println("Books in library: " + library.getBookCount());
        printBooks(library.getBooks());

        try {
            new Book("", "Unknown");
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }

    private static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(" - " + book);
        }
    }
}
