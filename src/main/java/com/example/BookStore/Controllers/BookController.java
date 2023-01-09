package com.example.BookStore.Controllers;

import com.example.BookStore.Exceptions.BookNotFoundException;
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

//    Fetch all books endpoint
    @GetMapping("/getbooks")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<List<Books>> getAllBooks(){
        return ResponseEntity.ok(bookRepo.findAll());
    }

//    Post book endpoint
    @PostMapping("/addBook")
    @CrossOrigin("http://localhost:3000")
    public Books addBook(@RequestBody Books book){
        return bookRepo.save(book);
    }
//    Get book details by id endpoint
@GetMapping("/book/{id}")
@CrossOrigin("http://localhost:3000")
Books getBookById(@PathVariable String id){
    return bookRepo.findById(id).orElseThrow(()->new BookNotFoundException(id));

}
//Update book details endpoint
@PutMapping("/update/book/{id}")
@CrossOrigin("http://localhost:3000")
Books updateBook(@RequestBody Books newBook, @PathVariable String id){
    return bookRepo.findById(id).map(Books -> {
        Books.setTitle(newBook.getTitle());
        Books.setCategory(newBook.getCategory());
        Books.setAuthor(newBook.getAuthor());
        Books.setPrice(newBook.getPrice());
        Books.setTotalCopies(newBook.getTotalCopies());
        return bookRepo.save(Books);
    }).orElseThrow(()->new BookNotFoundException(id));
}
//Delete book details endpoint
@DeleteMapping("/delete/book/{id}")
@CrossOrigin("http://localhost:3000")
String deleteBook(@PathVariable String id){
    if(!bookRepo.existsById(id)){
        throw new BookNotFoundException(id);
    }
    bookRepo.deleteById(id);
    return "The book with id " +id+ " has been deleted successfully. ";
}
}
