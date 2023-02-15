package it.epicode.be.prenotazioni.controls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.prenotazioni.model.Postazione;
import it.epicode.be.prenotazioni.services.PostazioneService;

@RestController
public class PostazioneControl {

	@Autowired
	private PostazioneService postazioneSrv;
	
	@PostMapping("/postazione")
	public ResponseEntity<Postazione> addPostazione(@RequestBody Postazione p) {
	    Postazione newPostazione = postazioneSrv.save(p);
	    if (newPostazione != null) {
	        return new ResponseEntity<>(newPostazione, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/postazione")
	public ResponseEntity<List<Postazione>> getAllPostazioni(){
	    List<Postazione> postazioni = postazioneSrv.getAll();
	    if (!postazioni.isEmpty()) {
	        return new ResponseEntity<>(postazioni, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/postazione/{id}")
	public ResponseEntity<Postazione> getPostazione(@PathVariable Long id){
	    Optional<Postazione> postazione = postazioneSrv.getById(id);
	    if (postazione.isPresent()) {
	        return new ResponseEntity<>(postazione.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/postazione/{id}")
	public ResponseEntity<Void> deletePostazione(@PathVariable Long id) {
	    boolean success = postazioneSrv.deleteById(id);
	    if (success) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
