package com.example.demo.service;

import com.example.demo.models.Author;
import com.example.demo.repositories.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Mono<Author> saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Flux<Author> getAuthorsByNameRegex(String nameRegex) {
        return authorRepository.findByNameRegex(nameRegex);
    }
}
