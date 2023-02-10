package it.epicode.gestionePrenotazioni.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="prenotazioni")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private Utente utente;
	
	@OneToOne
	private Postazione postazione;
	
	private LocalDate data;
	
	public Prenotazione (Utente utente2, Postazione postazione2, LocalDate data) {
		this.utente = utente2;
		this.postazione = postazione2;
		this.data = data;
	}
}
