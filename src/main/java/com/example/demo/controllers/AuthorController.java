package com.example.demo.controllers;


import com.example.demo.repositories.AuthorRepository;
import com.example.demo.models.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;


    @PostMapping
    public Mono<Author> saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @GetMapping("/search")
    public Flux<Author> getAuthorsByNameRegex(@RequestParam("nameRegex") String nameRegex) {
        return authorService.getAuthorsByNameRegex(nameRegex);
    }
}
