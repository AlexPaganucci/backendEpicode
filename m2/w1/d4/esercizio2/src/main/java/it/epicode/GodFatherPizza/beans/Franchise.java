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
@Entity
public class Franchise extends Prodotto{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String article;
	
	public Franchise(double price, String article) {
		super(price);
		this.article = article;
	}
}
