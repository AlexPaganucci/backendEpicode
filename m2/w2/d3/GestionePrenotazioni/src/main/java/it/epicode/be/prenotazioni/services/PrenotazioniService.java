package it.epicode.be.prenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.model.Prenotazione;
import it.epicode.be.prenotazioni.repository.PrenotazioneRepository;

@Service
public class PrenotazioniService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;
	
	public Prenotazione save(Prenotazione p) {
		return prenotazioneRepo.save(p);
	}
	
	public List<Prenotazione> getAll(){
		return prenotazioneRepo.findAll();
	}
	
	public Optional<Prenotazione> getById(Long id){
		return prenotazioneRepo.findById(id);
	}
	
    public boolean deleteById(Long id) {
        prenotazioneRepo.deleteById(id);
        return true;
    }
}
