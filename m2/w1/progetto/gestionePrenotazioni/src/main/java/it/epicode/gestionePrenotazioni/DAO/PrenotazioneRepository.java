package it.epicode.gestionePrenotazioni.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer>{

	@Query
	("SELECT COUNT(p) FROM Prenotazione p WHERE p.postazione = :postazione")
	int countUtentiByPostazione(@Param("postazione") Postazione postazione);
}
