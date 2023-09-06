package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

        private final BookRepository bookRepository;
        private final AuthorRepository authorRepository;

        public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
            this.bookRepository = bookRepository;
            this.authorRepository = authorRepository;
        }

        public Flux<Book> getAllBooks() {
            return bookRepository.findAll();
        }

        public Flux<Book> getBooksByGenre(String genre) {
            return bookRepository.findByGenre(genre);
        }

        public Flux<Book> getBooksByGenreAndCopiesAvailable(
                String genre, int copiesAvailable) {
            return bookRepository.findByGenreAndCopiesAvailableGreaterThan(genre, copiesAvailable);
        }

        public Mono<Book> saveBook(Book book) {
            return bookRepository.save(book);
        }

        public Flux<Book> getBooksByAuthor(String authorName) {
            return authorRepository
                    .findByName(authorName)//Flux<Author>
                    .flatMap(author -> bookRepository.findByAuthorId(author.getId()));
        }
    }

