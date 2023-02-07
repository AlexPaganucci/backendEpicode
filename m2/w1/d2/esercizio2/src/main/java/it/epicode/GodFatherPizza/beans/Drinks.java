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
@Component("drinks")
@Scope("prototype")
public class Drinks extends Alimentare{

	String type;
	String quantities;
	String alchool;
	
	public Drinks(double price, int calories, String type, String quantities) {
		super(price, calories);
		this.type = type;
		this.quantities = quantities;
	}
}
