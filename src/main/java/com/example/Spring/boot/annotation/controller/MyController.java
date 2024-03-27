package com.example.Spring.boot.annotation.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String testing(){
        return "Testing Controller annotation";
    }
}
