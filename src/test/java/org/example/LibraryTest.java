package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private final Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling");
    private final Book book2 = new Book("The Lord of the Rings", "J.R.R. Tolkien");

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    @DisplayName("Add book successfully")
    void addBook_shouldAddBook_whenBookIsValid() {
        library.addBook(book1);

        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    @DisplayName("Add already existing book to library")
    void addBook_shouldThrowException_whenBookAlreadyExists() {
        library.addBook(book1);
        assertThrows(IllegalArgumentException.class, () -> library.addBook(book1));
    }

    @Test
    @DisplayName("Get list of books")
    void getBooks_shouldReturnImmutableList() {
        library.addBook(book1);
        List<Book> books = library.getBooks();
        assertThrows(UnsupportedOperationException.class, () -> books.add(book2));
    }

    @Test
    @DisplayName("Add null book to library")
    void addBook_shouldThrowException_whenBookIsNull() {
        NullPointerException ex = assertThrows(NullPointerException.class, () -> library.addBook(null));
        assertEquals("Book cannot be null", ex.getMessage());
    }

    @Test
    @DisplayName("Remove book successfully")
    void removeBook_shouldRemoveBook_whenBookExists() {
        library.addBook(book1);

        boolean result = library.removeBook(book1);

        assertTrue(result);
        assertEquals(0, library.getBookCount());
        assertFalse(library.getBooks().contains(book1));
    }

    @Test
    @DisplayName("Remove book that does not exist in library")
    void removeBook_shouldReturnFalse_whenBookNotInLibrary() {
        boolean result = library.removeBook(book1);
        assertFalse(result);
    }

    @Test
    @DisplayName("Remove null book from library")
    void removeBook_shouldReturnFalse_whenBookIsNull() {
        assertFalse(library.removeBook(null));
    }

    @Test
    @DisplayName("Get book count when library is empty")
    void getBookCount_shouldReturnZero_whenLibraryIsEmpty() {
        assertEquals(0, library.getBookCount());
    }

    @Test
    @DisplayName("Get book count after adding books")
    void getBookCount_shouldReturnCorrectCount_afterAddingBooks() {
        library.addBook(book1);
        library.addBook(book2);

        assertEquals(2, library.getBookCount());
    }

    @Test
    @DisplayName("Get books when library is empty")
    void getBooks_shouldReturnEmptyList_whenLibraryIsEmpty() {
        List<Book> books = library.getBooks();

        assertTrue(books.isEmpty());
    }
}
