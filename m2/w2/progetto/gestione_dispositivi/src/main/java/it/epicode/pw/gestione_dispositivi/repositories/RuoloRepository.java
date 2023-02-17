package it.epicode.pw.gestione_dispositivi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.pw.gestione_dispositivi.models.Ruolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Integer>{

}
