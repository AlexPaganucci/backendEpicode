package entity.eventi;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import entity.Evento;
import entity.Persona;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class GaraDiAtletica extends Evento{
	
	@ManyToMany
	private Set<Persona> setAtleti;
	@ManyToOne
	private Persona vincitore;
}
