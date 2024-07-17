package com.example.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.library.models.Book;
import com.example.library.models.Library;

import static org.junit.Assert.*;

import java.util.List;


class LibraryApplicationTests {

	private Library library;
    private Book sampleBook1;
    private Book sampleBook2;
	private Book sampleBook3;
    private Book sampleBook4;
	private Book sampleBook5;

    @BeforeEach
    public void setUp() {
        library = new Library();
        sampleBook1 = new Book("Title1", "Nitin", "ISBN1", "Genre1", 2000, "Department1", true);
        sampleBook2 = new Book("Title2", "Arun", "ISBN2", "Genre2", 2004, "Department2", true);
		sampleBook3 = new Book("Title1", "Palak", "ISBN3", "Genre1", 2012, "Department1", false);
        sampleBook4 = new Book("Title2", "Arun", "ISBN4", "Genre2", 2007, "Department2", false);
		sampleBook5 = new Book("Title1", "ritu", "ISBN5", "Genre1", 2008, "Department1", true);
        library.addBook(sampleBook1);
        library.addBook(sampleBook2);
		library.addBook(sampleBook3);
        library.addBook(sampleBook4);
		library.addBook(sampleBook5);
    }


    @Test
    public void testAddBookDuplicateISBN() {
        Book duplicateBook = new Book("TitleDuplicate", "AuthorDuplicate", "ISBN1", "GenreDuplicate", 2003, "DepartmentDuplicate", true);
        library.addBook(duplicateBook);
        assertEquals(5, library.listAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("ISBN1");
        assertEquals(4, library.listAllBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        List<Book> books = library.findBookByTitle("Title1");
        assertEquals(3, books.size());
    }

    @Test
    public void testFindBookByAuthor() {
        List<Book> books = library.findBookByAuthor("Arun");
        assertEquals(2, books.size());
    }

    @Test
    public void testListAllBooks() {
        List<Book> books = library.listAllBooks();
        assertEquals(5, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        assertEquals(3, books.size());
    }

}
