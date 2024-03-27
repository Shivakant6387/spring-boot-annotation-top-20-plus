package com.example.Spring.boot.annotation.controller;

import com.example.Spring.boot.annotation.service.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class PizzaController {
//    @Autowired//field

    private Pizza pizza;

    public PizzaController(Pizza pizza) {
        this.pizza=pizza;
    }


//        @Autowired //constructor
//    public PizzaController(@Qualifier("vegPizza") Pizza pizzaServiceImp) {
//        this.pizzaServiceImp= pizzaServiceImp;
//    }
//    @Autowired //setter
//    public void setVegPizzaService(VegPizzaService vegPizzaService) {
//        this.vegPizzaService = vegPizzaService;
//    }

    public String getPizza() {
        return pizza.getPizza();
    }
    public void init(){
        System.out.println("Initailization Logic");
    }
    public void destroy(){
        System.out.println("Destruction Logic");
    }
}
