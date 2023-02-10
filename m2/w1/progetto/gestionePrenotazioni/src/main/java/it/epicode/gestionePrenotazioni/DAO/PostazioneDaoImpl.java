package it.epicode.gestionePrenotazioni.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.enums.StatoPostazione;

@Service
public class PostazioneDaoImpl {

	@Autowired
	private PostazioneRepository postazioneRepo;
	
	public List<Postazione> getAll() {
		return postazioneRepo.findAll();
	}
	
	public Optional<Postazione> getById(int id) {
		return postazioneRepo.findById(id);
	}
	
	public void insert(Postazione p) {
		postazioneRepo.save(p);
		System.out.println("Postazione salvata correttamente");
	}
	
	public void update(int id, StatoPostazione stato) {
		Optional<Postazione> postazioneOpt = this.getById(id);
		if( postazioneOpt.isPresent() ) {
			Postazione p = postazioneOpt.get();
			p.setStato(stato);
			
			postazioneRepo.save(p);
			System.out.println("Stato della postazione aggiornato correttamente");
		}
		else {
			System.out.println("Nessuna postazione trovata con id #" + id);
		}
	}
}
