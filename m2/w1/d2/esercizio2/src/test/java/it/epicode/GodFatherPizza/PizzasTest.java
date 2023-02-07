package it.epicode.GodFatherPizza;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import it.epicode.GodFatherPizza.beans.Pizzas;
import it.epicode.GodFatherPizza.beans.Toppings;
import it.epicode.GodFatherPizza.beans.enums.PizzasSize;

public class PizzasTest {

	@Test
	public void testSetPriceTotal() {
		  Pizzas pizza = new Pizzas();
		    pizza.setSize(PizzasSize.STANDARD);
		    Set<Toppings> toppings = new HashSet<>();
		    toppings.add(new Toppings(2, 200, "extra cheese"));
		    toppings.add(new Toppings(2, 150, "olives"));
		    pizza.setToppings(toppings);
		    pizza.setPrice();
		    double result = pizza.setPriceTotal();
		    assertEquals();
	}

}
