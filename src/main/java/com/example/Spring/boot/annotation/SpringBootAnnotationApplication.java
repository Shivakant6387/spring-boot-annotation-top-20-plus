package com.example.Spring.boot.annotation;

import com.example.Spring.boot.annotation.controller.MyController;
import com.example.Spring.boot.annotation.lazy.LazyLoader;
import com.example.Spring.boot.annotation.repository.MyRepository;
import com.example.Spring.boot.annotation.service.MyService;
import com.example.Spring.boot.annotation.service.VegPizza;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAnnotationApplication {

	public static void main(String[] args) {

		var context =SpringApplication.run(SpringBootAnnotationApplication.class, args);
//		PizzaController pizzaController=context.getBean(PizzaController.class);
//		PizzaController pizzaController= (PizzaController) context.getBean("pizzaController");
//		System.out.println(pizzaController.getPizza());

		MyController myController=context.getBean(MyController.class);
		System.out.println(myController.testing());

		MyService myService=context.getBean(MyService.class);
		System.out.println(myService.testing());

		MyRepository myRepository=context.getBean(MyRepository.class);
		System.out.println(myRepository.testing());
		LazyLoader lazyLoader=context.getBean(LazyLoader.class);
		System.out.println(lazyLoader);
		VegPizza vegPizza=context.getBean(VegPizza.class);
		System.out.println(vegPizza.getPizza());
	}

}
