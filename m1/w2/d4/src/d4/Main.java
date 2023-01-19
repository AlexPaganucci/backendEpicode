package d4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Customer c1 = new Customer((long) 546465, "Mario Rossi", 1);
		Customer c2 = new Customer((long) 455545, "Anna Neri", 2);
		Customer c3 = new Customer((long) 549965, "Luca Verdi", 1);
		Customer c4 = new Customer((long) 451245, "Andrea Bianchi", 2);
		Product p1 = new Product((long) 878878, "scarpe", Category.BOYS, 25);
		Product p2 = new Product((long) 887558, "maglia", Category.BABY, 30);
		Product p3 = new Product((long) 846982, "Harry Potter", Category.BOOKS, 30);
		Product p4 = new Product((long) 822874, "Il signore degli anelli", Category.BOOKS, 101);
		Product p5 = new Product((long) 822774, "cappello", Category.BABY, 5);
		Product p6 = new Product((long) 827774, "felpa", Category.BABY, 55);
		List<Product> cart1 = new ArrayList<>();
		cart1.add(p1);
		cart1.add(p2);
		cart1.add(p3);
		cart1.add(p4);
		List<Product> cart2 = new ArrayList<>();
		cart2.add(p2);
		cart2.add(p4);
		List<Product> cart3 = new ArrayList<>();
		cart3.add(p1);
		cart3.add(p3);
		Order o1 = new Order((long) 58965, "good", LocalDate.of(2021,03,28), LocalDate.of(2021,04,13), cart1, c1);
		Order o2 = new Order((long) 45879, "ciao", LocalDate.of(2021,02,05), LocalDate.of(2021,03,20), cart2, c2);
		Order o3 = new Order((long) 87888, "buonasera", LocalDate.of(2021,05,02), LocalDate.of(2021,05,12), cart3, c3);
		List<Product> totProd = new ArrayList<>();
		totProd.add(p1);
		totProd.add(p2);
		totProd.add(p3);
		totProd.add(p4);
		totProd.add(p5);
		totProd.add(p6);
		List<Order> totOrders = new ArrayList<>();
		totOrders.add(o1);
		totOrders.add(o2);
		totOrders.add(o3);
		esercizio1(totProd);
		esercizio2(totOrders);
		esercizio3(totProd);
		esercizio4(totOrders);
	}


	public static void esercizio1(List<Product> totProd ) {
		List<Product> book = totProd.stream()
					.filter(c -> c.category == Category.BOOKS)
					.filter(p -> p.price > 100)
					.collect(Collectors.toList());
		for (Product product : book) {
			System.out.println(product.getName());
		}
	}
	
	public static void esercizio2(List<Order> totOrders) {
		List<Order> b = totOrders.stream()
				.filter(o -> o.products.stream()
				.filter(c -> c.category == Category.BABY).count() > 0)
				.collect(Collectors.toList());
		for (Order order : b) {
			System.out.println(order.getId() + " " + order.getStatus());
		}
		
	}
	
	public static void esercizio3 (List<Product> totProd) {
		List<Product> boys = totProd.stream()
				.filter(b -> b.category == Category.BOYS)
				.collect(Collectors.toList());
		for (Product product : boys) {
			double sale = product.price * 10 / 100;
			double newPrice = product.price - sale;
			System.out.println(product.getName() + " " + newPrice + "€");
		}
	}
	
	public static void esercizio4 (List<Order> totOrders) {
		List<Order> tier2 = totOrders.stream()
				.filter(o -> o.customer.tier == 2)
				//.filter(c -> c.orderDate.isBefore(LocalDate.of(2021, 02,01)))
				//.filter(d -> d.orderDate.isAfter(LocalDate.of(2021, 02, 01)))
				.collect(Collectors.toList());
		for (Order order : tier2) {
			System.out.println(order.getProducts());
		}
	}


}
