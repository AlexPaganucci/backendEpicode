package it.epicode.gestionePrenotazioni.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.gestionePrenotazioni.beans.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Integer>{

}
