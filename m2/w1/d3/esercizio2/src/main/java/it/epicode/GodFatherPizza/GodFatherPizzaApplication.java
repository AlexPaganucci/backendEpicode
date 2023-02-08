package it.epicode.GodFatherPizza;

import java.util.ArrayList;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.GodFatherPizza.beans.BasicPizzas;
import it.epicode.GodFatherPizza.beans.Drinks;
import it.epicode.GodFatherPizza.beans.Franchise;
import it.epicode.GodFatherPizza.beans.Orders;
import it.epicode.GodFatherPizza.beans.Pizzas;
import it.epicode.GodFatherPizza.beans.Prodotto;
import it.epicode.GodFatherPizza.beans.Table;
import it.epicode.GodFatherPizza.beans.Toppings;
import it.epicode.GodFatherPizza.beans.enums.PizzasSize;
import it.epicode.GodFatherPizza.beans.enums.StatoOrdine;
import it.epicode.GodFatherPizza.beans.enums.StatoTavolo;

@SpringBootApplication
public class GodFatherPizzaApplication {

	private static final Logger logger = LoggerFactory.getLogger(GodFatherPizzaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GodFatherPizzaApplication.class, args);
		menu();
	}

	public static void menu() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("it.epicode.GodFatherPizza.beans");
        ctx.refresh();
		Toppings to1 = (Toppings)ctx.getBean("toppings", 2.50, 250, "prosciutto");
        Toppings to2 = (Toppings)ctx.getBean("toppings", 3.00, 250, "ananas");
        BasicPizzas p1 = (BasicPizzas)ctx.getBean("basicpizzas", 700, null);
        Pizzas p2 = (Pizzas)ctx.getBean("pizzas", 700, null, "Hawaian Pizzas", PizzasSize.FAMILY, new HashSet<>(){{
        	add(to1);
        	add(to2);
        }});
        p2.setPriceTotal();
        Drinks d1 = (Drinks)ctx.getBean("drinks", 3, 150, "Coca-cola", "33cl");
        Drinks d2 = (Drinks)ctx.getBean("drinks", 5, 300, "becks", "33cl");
        Drinks d3 = (Drinks)ctx.getBean("drinks", 3, 150, "Fanta", "33cl");
        d2.setAlchool("5%");
        Franchise f1 = (Franchise)ctx.getBean("franchise", 15, "maglietta");
        Franchise f2 = (Franchise)ctx.getBean("franchise", 30, "felpa");
        Table t1 = (Table)ctx.getBean("table", 1, StatoTavolo.LIBERO);
        Table t2 = (Table)ctx.getBean("table", 2, StatoTavolo.OCCUPATO);
        Table t3 = (Table)ctx.getBean("table", 3, StatoTavolo.LIBERO);
        Table t4 = (Table)ctx.getBean("table", 4, StatoTavolo.LIBERO);
        Table t5 = (Table)ctx.getBean("table", 5, StatoTavolo.OCCUPATO);
        Table t6 = (Table)ctx.getBean("table", 6, StatoTavolo.LIBERO);
        Table t7 = (Table)ctx.getBean("table", 7, StatoTavolo.LIBERO);
        Table t8 = (Table)ctx.getBean("table", 8, StatoTavolo.OCCUPATO);
        Table t9 = (Table)ctx.getBean("table", 9, StatoTavolo.LIBERO);
        Orders o1 = (Orders)ctx.getBean("orders", 1, new ArrayList<Prodotto>() {{
        	add(p2);
        	add(d2);
        }}, StatoOrdine.PRONTO, 1, null);
        Orders o2 = (Orders)ctx.getBean("orders", 2, new ArrayList<Prodotto>() {{
        	add(p1);
        	add(p2);
        	add(d3);
        	add(d1);
        }}, StatoOrdine.SERVITO, 1, "12.05");
		logger.info("                                   Menù");
		logger.info("Pizze                                            quantities          Price");
        logger.info(p1.getType() + "                 size: "+ p1.getSize() + "      " + p1.getPrice()+"€");
        logger.info(p2.getType() + "                                   size: " +p2.getSize() + "        " + (p2.getPrice() + to2.getPrice())+"€");
        logger.info("----------------------------------------------------------------------------------------------------------------------------");
		logger.info("drinks                                           quantities          Price");
        logger.info(d1.getType() + "                                           " + d1.getQuantities() + "             " + d1.getPrice()+"€");
        logger.info(d2.getType() + "                                               " + d2.getQuantities() + "             " + d2.getPrice()+"€");
        logger.info(d3.getType() + "                                               " + d3.getQuantities() + "             " + d3.getPrice()+"€");
        logger.info("----------------------------------------------------------------------------------------------------------------------------");
		logger.info("Franchise                                                   Price");
        logger.info(f1.getArticle() + "                                                   " + f1.getPrice()+"€");
        logger.info(f2.getArticle() + "                                                       " + f2.getPrice()+"€");
        logger.info("----------------------------------------------------------------------------------------------------------------------------");
        logger.info("L'ordine n: " + o1.getNOrders() + " con stato " + o1.getState() + " costa " + o1.getTotalPrice()+"€");
        logger.info("L'ordine n: " + o2.getNOrders() + " con stato " + o2.getState() + " costa " + o2.getTotalPrice()+"€");
		
		ctx.close();
	}
}
