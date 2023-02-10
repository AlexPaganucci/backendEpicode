package it.epicode.gestionePrenotazioni.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.gestionePrenotazioni.beans.Utente;

@Service
public class UtenteDaoImpl {
	
	@Autowired
	private UtenteRepository utenteRepo;
	
	public List<Utente> getAll() {
		return utenteRepo.findAll();
	}
	
	public Optional<Utente> getById(int id) {
		return utenteRepo.findById(id);
	}
	
	public void insert(Utente u) {
		utenteRepo.save(u);
		System.out.println("Utente salvato correttamente");
	}
	
	public void update(int id, String email) {
		Optional<Utente> utenteOpt = this.getById(id);
		if( utenteOpt.isPresent() ) {
			Utente u = utenteOpt.get();
			u.setEmail(email);
			
			utenteRepo.save(u);
			System.out.println("Email aggiornata correttamente");
		}
		else {
			System.out.println("Nessun utente trovato con id #" + id);
		}
	}
}
