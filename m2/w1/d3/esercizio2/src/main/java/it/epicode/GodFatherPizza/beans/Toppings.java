package it.epicode.GodFatherPizza.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
@Component("toppings")
@Scope("prototype")
public class Toppings extends Alimentare{

	String type;

	public Toppings(double price, int calories, String type) {
		super(price, calories);
		this.type = type;
	}
	
	public double getPrice() {
		return this.price;
	}
}
