package com.example.library.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){

        System.out.println("this book "+book.toString());
        for(Book b: books){
            if(b.getISBN().equals(book.getISBN())){
                System.out.println("This is an duplicate ISBN try with another ISBN");
                return;
            }
        }

        books.add(book);
    }

    public void removeBook(String ISBN) {
        Book bookToBeRemv = books.stream().filter(item-> item.getISBN().equals(ISBN)).findFirst().get();
        books.remove(bookToBeRemv);
    }

    public List<Book> listAllBooks() {
        return this.books;
    }

    public List<Book> findBookByTitle(String title) {

        return books.stream().filter(item -> item.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    public List<Book> findBookByAuthor(String author) {
        return books.stream().filter(item -> item.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    public List<Book> listAvailableBooks() {
        return books.stream().filter(item -> item.getAvailable() == true).collect(Collectors.toList());
    }
}
