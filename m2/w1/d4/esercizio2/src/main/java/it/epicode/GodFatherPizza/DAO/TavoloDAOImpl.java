package it.epicode.GodFatherPizza.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.GodFatherPizza.beans.Tavolo;
import it.epicode.GodFatherPizza.beans.enums.StatoTavolo;

@Service
public class TavoloDAOImpl {

	@Autowired
	private TavoloRepository tableRepo;
	
	public List<Tavolo> getAll() {
		return tableRepo.findAll();
	}
	
	public Optional<Tavolo> getById(int id) {
		return tableRepo.findById(id);
	}
	
	public void insert(Tavolo t) {
		tableRepo.save(t);
	}
	
	public void update(int id, StatoTavolo stato) {
		Optional<Tavolo> tavoloOpt = this.getById(id);
		if( tavoloOpt.isPresent() ) {
			Tavolo o = tavoloOpt.get();
			o.setState(stato);
			
			tableRepo.save(o);
			System.out.println("Lo stato è stato aggiornato");
		}
		else {
			System.out.println("Lo stato del tavolo non è stato trovato con id #" + id);
		}
	}
}
