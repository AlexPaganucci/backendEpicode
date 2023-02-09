package it.epicode.GodFatherPizza.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.epicode.GodFatherPizza.beans.enums.PizzasSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Scope("prototype")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="basic_pizzas")
public class BasicPizzas extends Alimentare{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String type;
	PizzasSize size;
	
	public BasicPizzas(int calories, String note) {
		super(calories, note);
		this.price = 5.50;
		this.type = "margherita(pomodoro, mozzarella)";
		this.size = PizzasSize.STANDARD;
	}
}
