package com.example.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "author")
public class Author {
    @Id
    private String id;
    private String name;
    private Address address;
}

