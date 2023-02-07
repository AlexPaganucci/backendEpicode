package it.epicode.GodFatherPizza.beans;

import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.epicode.GodFatherPizza.beans.enums.PizzasSize;
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
@Component("pizzas")
@Scope("prototype")
public class Pizzas extends BasicPizzas{

	Set<Toppings> toppings;
	
	public Pizzas(int calories, String note, String type, PizzasSize size, Set<Toppings> toppings) {
		super(calories, note);
		this.type = type;
		this.size = size;
		this.toppings = toppings;
	}
	
	public void setPrice() {
		if(this.size == PizzasSize.STANDARD) {
			price = 5.5;
		} else if (this.size == PizzasSize.FAMILY) {
			price = 5.5 + 4.15;
			calories = calories * 2;
		} else {
			price = 5.5 - 2;
			calories = calories - 2;
		}
	}
	
	public double setPriceTotal(){
		if(toppings.size()> 0) {
			for (Toppings t : toppings) {
				price += t.getPrice();
			}
			return price;
		}
		return price;
	}
}
