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

import it.epicode.be.prenotazioni.model.User;
import it.epicode.be.prenotazioni.services.UtenteService;

@RestController
public class UtenteControl {

	@Autowired
	private UtenteService utenteSrv;
	
	@PostMapping("/utente")
	public ResponseEntity<User> addUser(@RequestBody User u) {
	    User newUser = utenteSrv.save(u);
	    if (newUser != null) {
	        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/utente")
	public ResponseEntity<List<User>> getAllUser(){
	    List<User> utenti = utenteSrv.getAll();
	    if (!utenti.isEmpty()) {
	        return new ResponseEntity<>(utenti, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/utente/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
	    Optional<User> utente = utenteSrv.getById(id);
	    if (utente.isPresent()) {
	        return new ResponseEntity<>(utente.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/utente/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	    boolean success = utenteSrv.deleteById(id);
	    if (success) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
