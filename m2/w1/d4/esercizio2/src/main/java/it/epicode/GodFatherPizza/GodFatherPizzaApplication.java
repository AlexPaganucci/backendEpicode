package it.epicode.GodFatherPizza;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import it.epicode.GodFatherPizza.DAO.ProdottoDAOImpl;
import it.epicode.GodFatherPizza.DAO.OrdersDAOImpl;
import it.epicode.GodFatherPizza.DAO.TavoloDAOImpl;
import it.epicode.GodFatherPizza.beans.BasicPizzas;
import it.epicode.GodFatherPizza.beans.Drinks;
import it.epicode.GodFatherPizza.beans.Franchise;
import it.epicode.GodFatherPizza.beans.Orders;
import it.epicode.GodFatherPizza.beans.Pizzas;
import it.epicode.GodFatherPizza.beans.Tavolo;
import it.epicode.GodFatherPizza.config.OrdersConfig;
import it.epicode.GodFatherPizza.config.ProdottoConfig;
import it.epicode.GodFatherPizza.config.TavoloConfig;

@SpringBootApplication
@EnableJpaRepositories("it.epicode.GodFatherPizza.DAO")
public class GodFatherPizzaApplication implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(GodFatherPizzaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GodFatherPizzaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		menu();
		
	}
	
	@Autowired
	static ProdottoDAOImpl md;
	static OrdersDAOImpl od;
	static TavoloDAOImpl td;
	
	
	static ApplicationContext ctx = new AnnotationConfigApplicationContext(ProdottoConfig.class);
	static ApplicationContext ctt = new AnnotationConfigApplicationContext(TavoloConfig.class);
	static ApplicationContext cto = new AnnotationConfigApplicationContext(OrdersConfig.class);
		

	public static void menu() {
        BasicPizzas p = (BasicPizzas)ctx.getBean("p1");
        BasicPizzas p1 = (BasicPizzas)ctx.getBean("p2");
        Pizzas p2 = (Pizzas)ctx.getBean("p3");
        Drinks p3 = (Drinks)ctx.getBean("p4");
        Drinks p4 = (Drinks)ctx.getBean("p5");
        Drinks p5 = (Drinks)ctx.getBean("p6");
        Franchise p6 = (Franchise)ctx.getBean("p7");
        Franchise p7 = (Franchise)ctx.getBean("p8");
        md.insert(p);
        md.insert(p1);
        md.insert(p2);
        md.insert(p3);
        md.insert(p4);
        md.insert(p5);
        md.insert(p6);
        md.insert(p7);
        Tavolo t1 = (Tavolo)ctt.getBean("t1");
        Tavolo t2 = (Tavolo)ctt.getBean("t2");
        Tavolo t3 = (Tavolo)ctt.getBean("t3");
        Tavolo t4 = (Tavolo)ctt.getBean("t4");
        Tavolo t5 = (Tavolo)ctt.getBean("t5");
        Tavolo t6 = (Tavolo)ctt.getBean("t6");
        Tavolo t7 = (Tavolo)ctt.getBean("t7");
        Tavolo t8 = (Tavolo)ctt.getBean("t8");
        td.insert(t1);
        td.insert(t2);
        td.insert(t3);
        td.insert(t4);
        td.insert(t5);
        td.insert(t6);
        td.insert(t7);
        td.insert(t8);
        Orders o1 = (Orders)cto.getBean("o1");
        Orders o2 = (Orders)cto.getBean("o2");
        od.insert(o1);
        od.insert(o2);
		logger.info("                                   Menù");
		logger.info("Pizze                                            quantities          Price");
        logger.info(p1.getType() + "                 size: "+ p1.getSize() + "      " + p1.getPrice()+"€");
        logger.info(p2.getType() + "                                   size: " +p2.getSize() + "        " + (p2.getPrice())+"€");
        logger.info("----------------------------------------------------------------------------------------------------------------------------");
		logger.info("drinks                                           quantities          Price");
        logger.info(p4.getType() + "                                           " + p4.getQuantities() + "             " + p4.getPrice()+"€");
        logger.info(p5.getType() + "                                               " + p5.getQuantities() + "             " + p5.getPrice()+"€");
        logger.info(p3.getType() + "                                               " + p3.getQuantities() + "             " + p3.getPrice()+"€");
        logger.info("----------------------------------------------------------------------------------------------------------------------------");
		logger.info("Franchise                                                   Price");
        logger.info(p6.getArticle() + "                                                   " + p6.getPrice()+"€");
        logger.info(p7.getArticle() + "                                                       " + p7.getPrice()+"€");
        logger.info("----------------------------------------------------------------------------------------------------------------------------");
        logger.info("L'ordine n: " + o1.getNOrders() + " con stato " + o1.getState() + " costa " + o1.getTotalPrice()+"€");
        logger.info("L'ordine n: " + o2.getNOrders() + " con stato " + o2.getState() + " costa " + o2.getTotalPrice()+"€");
		
		((AbstractApplicationContext) ctx).close();
	}

	
}
