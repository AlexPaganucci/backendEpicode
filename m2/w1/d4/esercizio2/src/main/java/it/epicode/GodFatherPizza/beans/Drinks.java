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
public class Drinks extends Alimentare{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String type;
	String quantities;
	String alchool;
	
	public Drinks(double price, int calories, String type, String quantities) {
		super(price, calories);
		this.type = type;
		this.quantities = quantities;
	}
}
