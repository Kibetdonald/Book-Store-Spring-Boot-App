package com.example.BookStore.Repository;

import com.example.BookStore.Models.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Books, String> {
}
