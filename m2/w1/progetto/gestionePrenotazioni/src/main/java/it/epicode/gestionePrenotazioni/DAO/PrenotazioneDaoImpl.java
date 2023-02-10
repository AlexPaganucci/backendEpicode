package it.epicode.gestionePrenotazioni.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.Prenotazione;
import it.epicode.gestionePrenotazioni.beans.Utente;

@Service
public class PrenotazioneDaoImpl {

	@Autowired
	public PrenotazioneRepository prenotazioneRepo;
	
    public int countUtentiByPostazione(Postazione postazione) {
        return prenotazioneRepo.countUtentiByPostazione(postazione);
    }
	
    public List<Prenotazione> findByData(LocalDate data) {
        return prenotazioneRepo.findAll().stream()
        		.filter(p -> p.getData().equals(data))
        		.collect(Collectors.toList());
    }

    public List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data) {
        return prenotazioneRepo.findAll().stream()
                .filter(p -> p.getPostazione().equals(postazione) && p.getData().equals(data))
                .collect(Collectors.toList());
    }
    
    public List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data) {
        return prenotazioneRepo.findAll().stream()
                .filter(p -> p.getUtente().equals(utente) && p.getData().equals(data))
                .collect(Collectors.toList());
    } 
}
