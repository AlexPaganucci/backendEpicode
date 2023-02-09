package it.epicode.GodFatherPizza.config;

import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.GodFatherPizza.beans.BasicPizzas;
import it.epicode.GodFatherPizza.beans.Drinks;
import it.epicode.GodFatherPizza.beans.Franchise;
import it.epicode.GodFatherPizza.beans.Pizzas;
import it.epicode.GodFatherPizza.beans.Toppings;
import it.epicode.GodFatherPizza.beans.enums.PizzasSize;

@Configuration
public class ProdottoConfig {
	
	@Bean
	public BasicPizzas p1() {
		BasicPizzas p1 = new BasicPizzas( 700, null);
		return p1;
	}
	
	@Bean
	public BasicPizzas p2() {
		BasicPizzas p = new BasicPizzas( 700, null);
		return p;
	}
	
	@Bean
	public Pizzas p3() {
		Pizzas p = new Pizzas(700, null, "Hawaian Pizzas", PizzasSize.FAMILY, new HashSet<>(){{
        	add(new Toppings(3.00, 250, "ananas"));
        	add(new Toppings(2.50, 250, "prosciutto"));
        }});
		return p;
	}
	
	@Bean
	public Drinks p4() {
		Drinks d1 = new Drinks(3, 150, "Coca-cola", "33cl");
		return d1;
	}
	@Bean
	public Drinks p5() {
		Drinks d2 = new Drinks(5, 300, "becks", "33cl");
		d2.setAlchool("5%");
		return d2;
	}
	
	@Bean
	public Drinks p6() {
		Drinks d3 = new Drinks(3, 150, "Fanta", "33cl");
		return d3;
	}
	
	@Bean
	public Franchise p7() {
		Franchise f1 = new Franchise( 15, "maglietta");
		return f1;
	}
	
	@Bean
	public Franchise p8() {
		Franchise f2 = new Franchise( 30, "felpa");
		return f2;
	}
}
