package it.epicode.gestionePrenotazioni.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.epicode.gestionePrenotazioni.beans.enums.StatoPostazione;
import it.epicode.gestionePrenotazioni.beans.enums.TipoPostazione;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="postazioni")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	
	@Enumerated(EnumType.STRING)
	private StatoPostazione stato;
	
	private int nMaxOccupanti;

	@ManyToOne
	private Edificio edificio;
}
