package it.epicode.be.prenotazioni.controls;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AppControl {

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
}
