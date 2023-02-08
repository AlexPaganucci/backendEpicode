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
@Component("basicpizzas")
public class BasicPizzas extends Alimentare{

	String type;
	PizzasSize size;
	
	public BasicPizzas(int calories, String note) {
		super(calories, note);
		this.price = 5.50;
		this.type = "margherita(pomodoro, mozzarella)";
		this.size = PizzasSize.STANDARD;
	}
}
