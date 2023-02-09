package it.epicode.GodFatherPizza.beans;

import javax.persistence.Entity;

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
@Entity
public abstract class Alimentare extends Prodotto{

	int calories;
	String note;
	
	public Alimentare(double price, int calories) {
		super(price);
		this.calories = calories;
		this.note = null;
	}
}
