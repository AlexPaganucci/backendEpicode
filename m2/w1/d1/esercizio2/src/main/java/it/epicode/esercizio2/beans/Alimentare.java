package it.epicode.esercizio2.beans;

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
@Component("alimentare")
@Scope("prototype")
public abstract class Alimentare extends Prodotto{

	int calories;
	
	public Alimentare(double price, int calories) {
		super(price);
		this.calories = calories;
	}
}
