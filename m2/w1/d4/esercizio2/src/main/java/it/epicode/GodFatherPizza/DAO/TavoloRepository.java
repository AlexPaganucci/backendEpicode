package it.epicode.GodFatherPizza.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.GodFatherPizza.beans.Tavolo;

@Repository
public interface TavoloRepository extends JpaRepository<Tavolo, Integer>{

}
