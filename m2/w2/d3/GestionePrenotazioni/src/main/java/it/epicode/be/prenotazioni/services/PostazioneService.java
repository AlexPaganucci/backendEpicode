package it.epicode.be.prenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.model.Postazione;
import it.epicode.be.prenotazioni.repository.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository postazioneRepo;
	
	public Postazione save(Postazione p) {
		return postazioneRepo.save(p);
	}
	
	public List<Postazione> getAll(){
		return postazioneRepo.findAll();
	}
	
	public Optional<Postazione> getById(Long id){
		return postazioneRepo.findById(id);
	}
	
    public boolean deleteById(Long id) {
        postazioneRepo.deleteById(id);
        return true;
    }
}
