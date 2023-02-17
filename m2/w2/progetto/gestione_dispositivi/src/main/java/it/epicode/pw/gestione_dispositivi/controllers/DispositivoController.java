package it.epicode.pw.gestione_dispositivi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.pw.gestione_dispositivi.models.Dispositivo;
import it.epicode.pw.gestione_dispositivi.models.Utente;
import it.epicode.pw.gestione_dispositivi.services.DispositivoService;

@RestController
@RequestMapping("/api")
public class DispositivoController {

	@Autowired
	private DispositivoService dispositivoSrv;
	
	@GetMapping("/")
	public ResponseEntity<String> getHome(){
		String home = "home page";
		return new ResponseEntity<>(home, HttpStatus.OK);
	}
	
	@GetMapping("/dispositivo")
	public ResponseEntity<List<Dispositivo>> getAllDispositivo(){
		List<Dispositivo> dispositivi = dispositivoSrv.getAll();
		if (!dispositivi.isEmpty()) {
	        return new ResponseEntity<>(dispositivi, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/dispositivo")
	@PreAuthorize("hasRole('AMMINISTRATORE')")
	public ResponseEntity<Dispositivo> aggiungiDispositivo(@RequestBody Dispositivo dispositivo){
	    Dispositivo nuovoDispositivo = dispositivoSrv.save(dispositivo);
	    if (nuovoDispositivo != null) {
	        return new ResponseEntity<>(nuovoDispositivo, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@GetMapping("/dispositivo/{id}")
	public ResponseEntity<Dispositivo> getOneDispositivo(@PathVariable int id){
		Optional<Dispositivo> dispositivo = dispositivoSrv.getById(id);
	    if (dispositivo.isPresent()) {
	        return new ResponseEntity<>(dispositivo.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/dispositivo/{id}")
	public ResponseEntity<Void> deleteDispositivo(@PathVariable int id) {
	    boolean success = dispositivoSrv.deleteById(id);
	    if (success) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/dispositivo/{id}")
	public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable int id, @RequestBody Dispositivo d) {
	    Optional<Dispositivo> dispositivo = dispositivoSrv.getById(id);
	    if (dispositivo.isPresent()) {
	        Dispositivo updatedDispositivo = dispositivoSrv.update(id, d);
	        return new ResponseEntity<>(updatedDispositivo, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
