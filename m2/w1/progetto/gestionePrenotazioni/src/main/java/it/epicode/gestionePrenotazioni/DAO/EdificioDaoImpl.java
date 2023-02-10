package it.epicode.gestionePrenotazioni.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.gestionePrenotazioni.beans.Edificio;

@Service
public class EdificioDaoImpl {

	@Autowired
	private EdificioRepository edificioRepo;
	
	public List<Edificio> getAll() {
		return edificioRepo.findAll();
	}
	
	public Optional<Edificio> getById(int id) {
		return edificioRepo.findById(id);
	}
	
	public void insert(Edificio e) {
			edificioRepo.save(e);
			System.out.println("Edificio salvato correttamente");
	}
}
