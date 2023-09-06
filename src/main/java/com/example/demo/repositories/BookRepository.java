package com.example.demo.repositories;

import com.example.demo.models.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
    Flux<Book> findByGenre(String genre);
    Flux<Book> findByGenreAndCopiesAvailableGreaterThan(String genre, int copiesAvailable);

    Flux<Book> findByAuthorId(String authorId);
}
