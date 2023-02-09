package it.epicode.GodFatherPizza.config;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.GodFatherPizza.beans.BasicPizzas;
import it.epicode.GodFatherPizza.beans.Drinks;
import it.epicode.GodFatherPizza.beans.Orders;
import it.epicode.GodFatherPizza.beans.Pizzas;
import it.epicode.GodFatherPizza.beans.Prodotto;
import it.epicode.GodFatherPizza.beans.Toppings;
import it.epicode.GodFatherPizza.beans.enums.PizzasSize;
import it.epicode.GodFatherPizza.beans.enums.StatoOrdine;

@Configuration
public class OrdersConfig {

	@Bean
	public Orders o1() {
		Orders o = new Orders(  1, new ArrayList<Prodotto>() {{
        	add(new BasicPizzas( 700, null));
        	add(new Drinks(3, 150, "Coca-cola", "33cl"));
        }}, StatoOrdine.PRONTO, 1, null);
		return o;
	}
	
	@Bean
	public Orders o2() {
		Orders o = new Orders(  2, new ArrayList<Prodotto>() {{
			add(new BasicPizzas( 700, null));
			add(new Pizzas(700, null, "Hawaian Pizzas", PizzasSize.FAMILY, new HashSet<>(){{
	        	add(new Toppings(3.00, 250, "ananas"));
	        	add(new Toppings(2.50, 250, "prosciutto"));
	        }}));
			add(new Drinks(3, 150, "Coca-cola", "33cl"));
			add(new Drinks(3, 150, "Fanta", "33cl"));
		}}, StatoOrdine.SERVITO, 2, null);
		return o;
	}
}
