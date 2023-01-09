package com.example.BookStore.Exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String id){
        super("Could not find book with Id"+ id);
    }
}
