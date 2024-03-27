package com.example.Spring.boot.annotation.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class EagerLoader {
    public EagerLoader(){
        System.out.println("EagerLoader.........");
    }
}
