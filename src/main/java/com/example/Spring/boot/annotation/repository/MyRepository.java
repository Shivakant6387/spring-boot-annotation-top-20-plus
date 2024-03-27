package com.example.Spring.boot.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
    public String testing (){
        return "Testing repository Annotation";
    }
}
