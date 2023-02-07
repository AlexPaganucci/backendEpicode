package it.epicode.GodFatherPizza.beans;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.epicode.GodFatherPizza.beans.enums.StatoOrdine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component("orders")
@Scope("prototype")
public class Orders {

	int nOrders;
	List<Prodotto> products;
	Table table;
	StatoOrdine state;
	double nCovered;
	double priceForCovered;
	String acquisitionTime;
	
	public Orders(int nOrders, List<Prodotto> products, StatoOrdine state, double nCovered, String acquisitionTime) {
		this.priceForCovered = 2;
		this.nOrders = nOrders;
		this.products = products;
		this.state = state;
		this.nCovered = nCovered;
		this.acquisitionTime = acquisitionTime;
	}
	
	public double getTotalPrice(){
		double i = this.nCovered * this.priceForCovered;
		double totalPrice = 0;
		for (Prodotto p : products) {
			totalPrice += p.getPrice();
		}
		return totalPrice + i;
	}
}
