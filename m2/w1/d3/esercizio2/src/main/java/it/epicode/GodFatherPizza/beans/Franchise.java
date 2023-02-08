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
@Component("franchise")
@Scope("prototype")
public class Franchise extends Prodotto{

	String article;
	
	public Franchise(double price, String article) {
		super(price);
		this.article = article;
	}
}
