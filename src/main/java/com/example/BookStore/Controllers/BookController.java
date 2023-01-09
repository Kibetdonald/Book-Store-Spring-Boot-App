package com.example.BookStore.Controllers;

import com.example.BookStore.Models.Books;
import com.example.BookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @GetMapping("/getbooks")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<List<Books>> getAllBooks(){
        return ResponseEntity.ok(bookRepo.findAll());
    }

    @PostMapping("/addBook")
    @CrossOrigin("http://localhost:3000")
    public Books addBook(@RequestBody Books book){
        return bookRepo.save(book);
    }

}
