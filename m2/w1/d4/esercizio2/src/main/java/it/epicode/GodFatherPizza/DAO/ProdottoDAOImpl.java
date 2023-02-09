package it.epicode.GodFatherPizza.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.GodFatherPizza.beans.Prodotto;

@Service
public class ProdottoDAOImpl{

	@Autowired
	private ProdottoRepository menuRepo;
	
	public List<Prodotto> getAll() {
		return menuRepo.findAll();
	}
	
	public Optional<Prodotto> getById(int id) {
		return menuRepo.findById(id);
	}
	
	public void insert(Prodotto p) {
		menuRepo.save(p);
	}
	
	public void update(int id, double price) {
		Optional<Prodotto> productOpt = this.getById(id);
		if( productOpt.isPresent() ) {
			Prodotto p = productOpt.get();
			p.setPrice(price);
			
			menuRepo.save(p);
			System.out.println("Prezzo aggiornato");
		}
		else {
			System.out.println("Nessun oggetto del menù trovato con id #" + id);
		}
	}
}
