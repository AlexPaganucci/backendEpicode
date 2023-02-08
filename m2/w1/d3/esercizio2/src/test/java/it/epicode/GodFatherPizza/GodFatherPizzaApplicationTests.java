package it.epicode.GodFatherPizza;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.epicode.GodFatherPizza.beans.BasicPizzas;
import it.epicode.GodFatherPizza.beans.Orders;
import it.epicode.GodFatherPizza.beans.Pizzas;
import it.epicode.GodFatherPizza.beans.Table;
import it.epicode.GodFatherPizza.beans.enums.StatoTavolo;

@SpringBootTest
class GodFatherPizzaApplicationTests {

	private Orders testOrders = new Orders();
	
	@BeforeEach
	public void setUp() {
		Table table = new Table(1, StatoTavolo.LIBERO);

		testOrders = new Orders();
		testOrders.setTable(table);
		testOrders.setNCovered(4);
		testOrders.setNOrders(1);
		testOrders.setPriceForCovered(1d);

	}
	
	@Test
	public void testAddOneItem() {
		this.testOrders.products = new ArrayList<>();
		Pizzas pizza1 = new Pizzas();
		testOrders.products.add(pizza1);
		assertEquals(testOrders.getProducts().size(), 1);
	}
	
	@Test
	void testAddTwoItemSameType() {
		this.testOrders.products = new ArrayList<>();
		Pizzas pizza1 = new Pizzas();
		testOrders.products.add(pizza1);

		pizza1 = new Pizzas();
		testOrders.products.add(pizza1);
		assertEquals(testOrders.getProducts().size(), 1);

	}
	
	@Test
	void testAddTwoItemDifferentType() {
		this.testOrders.products = new ArrayList<>();
		Pizzas pizza1 = new Pizzas();
		testOrders.products.add(pizza1);

		BasicPizzas pizza2 = new BasicPizzas();
		testOrders.products.add(pizza2);
		assertEquals(testOrders.getProducts().size(), 2);
	}
	
	@Test
	void testRemoveItem() {
		this.testOrders.products = new ArrayList<>();
		Pizzas pizza1 = new Pizzas();
		testOrders.products.add(pizza1);

		pizza1 = new Pizzas();
		testOrders.products.add(pizza1);

		testOrders.products.remove(pizza1);
		assertEquals(testOrders.getProducts().size(), 1);
	}
	
	@Test
	void testRemoveLastItem() {
		this.testOrders.products = new ArrayList<>();
		Pizzas pizza1 = new Pizzas();
		testOrders.products.add(pizza1);

		pizza1 = new Pizzas();
		testOrders.products.add(pizza1);

		testOrders.products.remove(pizza1);
		assertEquals(testOrders.getProducts().size(), 1);

		testOrders.products.remove(pizza1);
		assertEquals(testOrders.getProducts().size(), 0);
	}
}
