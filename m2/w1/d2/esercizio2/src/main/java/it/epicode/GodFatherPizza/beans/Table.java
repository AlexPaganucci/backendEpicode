package it.epicode.GodFatherPizza.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.epicode.GodFatherPizza.beans.enums.StatoTavolo;
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
@Component("table")
@Scope("prototype")
public class Table {

	int id;
	StatoTavolo state;
}
