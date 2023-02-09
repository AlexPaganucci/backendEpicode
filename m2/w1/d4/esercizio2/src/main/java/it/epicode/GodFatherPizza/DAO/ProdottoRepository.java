package it.epicode.GodFatherPizza.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.GodFatherPizza.beans.Prodotto;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer>{

}
