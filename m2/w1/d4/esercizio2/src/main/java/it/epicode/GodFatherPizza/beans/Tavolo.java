package it.epicode.GodFatherPizza.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Scope("prototype")
@Entity
@Table(name="tavoli")
public class Tavolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	StatoTavolo state;
	
	public Tavolo (StatoTavolo state) {
		this.state = state;
	}
}
