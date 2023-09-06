package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public Flux<Book> getBooksByGenre(@RequestParam("genre") String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/search/{copiesAvailable}")
    public Flux<Book> getBooksByGenreAndCopiesAvailable(
            @RequestParam("genre") String genre,
            @PathVariable("copiesAvailable") int copiesAvailable) {
        return bookService.getBooksByGenreAndCopiesAvailable(genre, copiesAvailable);
    }

    @PostMapping("/add")
    public Mono<Book> saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/findByAuthor")
    public Flux<Book> getBooksByAuthor(@RequestParam String authorName){
        return bookService.getBooksByAuthor(authorName);
    }
}
