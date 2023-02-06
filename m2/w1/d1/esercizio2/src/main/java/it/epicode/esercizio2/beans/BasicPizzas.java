package it.epicode.esercizio2.beans;

import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.epicode.esercizio2.beans.enums.PizzasSize;
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
@Component("basicpizzas")
@Scope("prototype")
public class BasicPizzas extends Alimentare{

	String type;
	PizzasSize size;
	
	public BasicPizzas(int calories) {
		super(calories);
		this.price = 5.50;
		this.type = "margherita(pomodoro, mozzarella)";
		this.size = PizzasSize.STANDARD;
	}
}
