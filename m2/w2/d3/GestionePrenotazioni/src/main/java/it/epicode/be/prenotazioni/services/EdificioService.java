package it.epicode.be.prenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.model.Edificio;
import it.epicode.be.prenotazioni.repository.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRepo;
	
	public Edificio save(Edificio e) {
		return edificioRepo.save(e);
	}
	
	public List<Edificio> getAll(){
		return edificioRepo.findAll();
	}
	
	public Optional<Edificio> getById(Long id){
		return edificioRepo.findById(id);
	}
	
    public boolean deleteById(Long id) {
        edificioRepo.deleteById(id);
        return true;
    }
    
    public Edificio update(Long id, Edificio edificio) {
        Optional<Edificio> edificioDaAggiornare = edificioRepo.findById(id);
        if (edificioDaAggiornare.isPresent()) {
            Edificio edificioAggiornato = edificioDaAggiornare.get();
            edificioAggiornato.setNome(edificio.getNome());
            edificioAggiornato.setIndirizzo(edificio.getIndirizzo());
            edificioAggiornato.setCitta(edificio.getCitta());
            return edificioRepo.save(edificioAggiornato);
        } else {
            return null;
        }
    }
}
