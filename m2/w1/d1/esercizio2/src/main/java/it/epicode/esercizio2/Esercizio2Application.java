package it.epicode.esercizio2;

import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.esercizio2.beans.BasicPizzas;
import it.epicode.esercizio2.beans.Pizzas;
import it.epicode.esercizio2.beans.Toppings;
import it.epicode.esercizio2.beans.enums.PizzasSize;

@SpringBootApplication
public class Esercizio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio2Application.class, args);
		makePizza();
	}

	public static void makePizza() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("it.epicode.esercizio2.beans");
        ctx.refresh();
        Toppings t1 = (Toppings)ctx.getBean("toppings", 2.50, 250, "prosciutto");
        Toppings t2 = (Toppings)ctx.getBean("toppings", 3.00, 250, "ananas");
        BasicPizzas p1 = (BasicPizzas)ctx.getBean("basicpizzas", 700);
        Pizzas p2 = (Pizzas)ctx.getBean("pizzas", 700, "Hawaian Pizzas", PizzasSize.FAMILY, new HashSet<>(){{
        	add(t1);
        	add(t2);
        }
        });
        p2.setPrice();
        System.out.println("Basic pizzas: " + p1.getType() + " calorie: " + p1.getCalories() + " price: " + p1.getPrice());
        System.out.println("Pizzas: " + p2.getType() + " calorie: " + p2.getCalories() + " price: " + (p2.getPrice() + t2.getPrice()));
        ctx.close();
	}
}
