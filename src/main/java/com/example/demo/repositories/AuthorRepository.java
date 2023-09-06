package com.example.demo.repositories;

import com.example.demo.models.Author;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {
    Flux<Author> findByNameRegex(String nameRegex);

    Flux<Author> findByName(String name);
}