package it.epicode.be.prenotazioni.controls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.epicode.be.prenotazioni.model.Prenotazione;
import it.epicode.be.prenotazioni.services.PrenotazioniService;

@RestController
public class PrenotazioneControl {

	@Autowired
	private PrenotazioniService prenotazioneSrv;
	
	private static final String string_it = "Per effettuare la prenotazione l'utente non deve gia averne una per quel giorno e la postazione deve essere libera";
	private static final String string_en = "To book a reservation the user can't have one on the same date and the station has to be free";
	
	@GetMapping("/istruzioni/{lingua}")
	public String istruzioni( @PathVariable String lingua ) {
		String istruzioni;
		switch(lingua) {
		case "it":
			istruzioni = string_it;
			break;
		case "en":
			istruzioni = string_en;
			break;
		default : 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lingua non supportata: " + lingua);
		}
		return istruzioni;
	}
	
	@PostMapping("/prenotazione")
	public ResponseEntity<Prenotazione> addPrenotazione(@RequestBody Prenotazione p) {
	    Prenotazione newPrenotazione = prenotazioneSrv.save(p);
	    if (newPrenotazione != null) {
	        return new ResponseEntity<>(newPrenotazione, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/prenotazione")
	public ResponseEntity<List<Prenotazione>> getAllPrenotazioni(){
	    List<Prenotazione> prenotazioni = prenotazioneSrv.getAll();
	    if (!prenotazioni.isEmpty()) {
	        return new ResponseEntity<>(prenotazioni, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/prenotazione/{id}")
	public ResponseEntity<Prenotazione> getPrenotazione(@PathVariable Long id){
	    Optional<Prenotazione> prenotazione = prenotazioneSrv.getById(id);
	    if (prenotazione.isPresent()) {
	        return new ResponseEntity<>(prenotazione.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/prenotazione/{id}")
	public ResponseEntity<Void> deletePrenotazione(@PathVariable Long id) {
	    boolean success = prenotazioneSrv.deleteById(id);
	    if (success) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
    @GetMapping("/prenotazione/pag")
    public Page<Prenotazione> getPrenotazioni(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "3") int pageSize) {
        return prenotazioneSrv.getPrenotazione(pageNumber, pageSize);
    }
}
