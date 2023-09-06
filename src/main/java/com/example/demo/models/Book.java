package com.example.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "book")
public class Book {
    @Id
    private String id;
    private int copiesAvailable;
    private String authorId;
    private String genre;
}
