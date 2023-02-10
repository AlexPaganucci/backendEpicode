package it.epicode.gestionePrenotazioni.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.gestionePrenotazioni.beans.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer>{

}
