package it.epicode.GodFatherPizza.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Scope("prototype")
public class Toppings extends Alimentare{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String type;

	public Toppings(double price, int calories, String type) {
		super(price, calories);
		this.type = type;
	}
	
	public double getPrice() {
		return this.price;
	}
}
