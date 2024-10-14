package se.lnu.jesan.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static final transient Logger log = LoggerFactory.getLogger(Library.class);

    private List<Book> availableBooks;
    private List<Book> borrowedBooks;

    public Library() {
        availableBooks = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
        log.info("Library initialized with no books.");
    }

    public void addBook(Book book) {
        availableBooks.add(book);
        log.info("Added book: " + book);
    }

    public void borrowBook(String title) {
        for (Book book : availableBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                availableBooks.remove(book);
                borrowedBooks.add(book);
                log.info("Book borrowed: " + book);
                return;
            }
        }
        log.error("Book not found: " + title);
    }

    public void returnBook(String title) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                borrowedBooks.remove(book);
                availableBooks.add(book);
                log.info("Book returned: " + book);
                return;
            }
        }
        log.error("Cannot return, book not found in borrowed list: " + title);
    }

    public void listAvailableBooks() {
        log.debug("Listing all available books.");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }
}

