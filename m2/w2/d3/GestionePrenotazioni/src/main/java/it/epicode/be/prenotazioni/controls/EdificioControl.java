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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.prenotazioni.model.Edificio;
import it.epicode.be.prenotazioni.services.EdificioService;

@RestController
public class EdificioControl {

	@Autowired
	private EdificioService edificioSrv;
	
	@PostMapping("/edificio")
	public ResponseEntity<Edificio> addEdificio(@RequestBody Edificio e) {
	    Edificio newEdificio = edificioSrv.save(e);
	    if (newEdificio != null) {
	        return new ResponseEntity<>(newEdificio, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/edificio")
	public ResponseEntity<List<Edificio>> getAllEdifici(){
	    List<Edificio> edifici = edificioSrv.getAll();
	    if (!edifici.isEmpty()) {
	        return new ResponseEntity<>(edifici, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/edificio/{id}")
	public ResponseEntity<Edificio> getEdificio(@PathVariable Long id){
	    Optional<Edificio> edificio = edificioSrv.getById(id);
	    if (edificio.isPresent()) {
	        return new ResponseEntity<>(edificio.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/edificio/{id}")
	public ResponseEntity<Void> deleteEdificio(@PathVariable Long id) {
	    boolean success = edificioSrv.deleteById(id);
	    if (success) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/edificio/{id}")
	public ResponseEntity<Edificio> updateEdificio(@PathVariable Long id, @RequestBody Edificio e) {
	    Optional<Edificio> edificio = edificioSrv.getById(id);
	    if (edificio.isPresent()) {
	        Edificio updatedEdificio = edificioSrv.update(id, e);
	        return new ResponseEntity<>(updatedEdificio, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
    @GetMapping("/edificio/pag")
    public Page<Edificio> getEdifici(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "3") int pageSize) {
        return edificioSrv.getEdificio(pageNumber, pageSize);
    }
	
}
