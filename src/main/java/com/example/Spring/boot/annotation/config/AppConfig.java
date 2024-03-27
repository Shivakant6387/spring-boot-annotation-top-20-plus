package com.example.Spring.boot.annotation.config;

import com.example.Spring.boot.annotation.controller.PizzaController;
import com.example.Spring.boot.annotation.service.NonVegPizza;
import com.example.Spring.boot.annotation.service.Pizza;
import com.example.Spring.boot.annotation.service.VegPizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Pizza vegPizza() {
        return new VegPizza();
    }

    @Bean
    public Pizza nonVegPizza() {
        return new NonVegPizza();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public PizzaController pizzaController() {
        return new PizzaController(nonVegPizza());
    }
}
