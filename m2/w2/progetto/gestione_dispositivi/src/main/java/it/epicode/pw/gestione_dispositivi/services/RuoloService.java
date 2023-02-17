package it.epicode.pw.gestione_dispositivi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.pw.gestione_dispositivi.models.Ruolo;
import it.epicode.pw.gestione_dispositivi.repositories.RuoloRepository;

@Service
public class RuoloService {

	@Autowired
	private RuoloRepository ruoloRepo;
	
	public Ruolo save(Ruolo r) {
		return ruoloRepo.save(r);
	}
}
