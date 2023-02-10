package it.epicode.gestionePrenotazioni.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.gestionePrenotazioni.beans.Postazione;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer>{

}
