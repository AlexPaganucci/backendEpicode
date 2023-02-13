package it.epicode.gestionePrenotazioni;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.gestionePrenotazioni.DAO.EdificioDaoImpl;
import it.epicode.gestionePrenotazioni.DAO.PostazioneDaoImpl;
import it.epicode.gestionePrenotazioni.DAO.PrenotazioneDaoImpl;
import it.epicode.gestionePrenotazioni.DAO.UtenteDaoImpl;
import it.epicode.gestionePrenotazioni.beans.Edificio;
import it.epicode.gestionePrenotazioni.beans.Postazione;
import it.epicode.gestionePrenotazioni.beans.Prenotazione;
import it.epicode.gestionePrenotazioni.beans.Utente;
import it.epicode.gestionePrenotazioni.config.EdificioConfig;
import it.epicode.gestionePrenotazioni.config.PostazioneConfig;
import it.epicode.gestionePrenotazioni.config.UtenteConfig;

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner{
	
	@Autowired
	PrenotazioneDaoImpl prd;
	
	@Autowired
	PostazioneDaoImpl pd;
	
	@Autowired
	EdificioDaoImpl ed;
	
	@Autowired
	UtenteDaoImpl ud;
	
	ApplicationContext ctxp = new AnnotationConfigApplicationContext(PostazioneConfig.class);
	ApplicationContext ctxu = new AnnotationConfigApplicationContext(UtenteConfig.class);
	ApplicationContext ctxe = new AnnotationConfigApplicationContext(EdificioConfig.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Edificio edificio = (Edificio)ctxe.getBean("e");
		ed.insert(edificio);
		Edificio edificio2 = (Edificio)ctxe.getBean("e2");
		ed.insert(edificio2);
		Edificio edificio3 = (Edificio)ctxe.getBean("e3");
		ed.insert(edificio3);
		Postazione postazione = (Postazione)ctxp.getBean("p");
		postazione.setEdificio(edificio);
		pd.insert(postazione);
		Postazione postazione2 = (Postazione)ctxp.getBean("p2");
		postazione2.setEdificio(edificio2);
		pd.insert(postazione2);
		Postazione postazione3 = (Postazione)ctxp.getBean("p3");
		postazione3.setEdificio(edificio3);
		pd.insert(postazione3);
		Utente utente = (Utente)ctxu.getBean("u");
		ud.insert(utente);
		Utente utente2 = (Utente)ctxu.getBean("u2");
		ud.insert(utente2);
		Utente utente3 = (Utente)ctxu.getBean("u3");
		ud.insert(utente3);
		Utente utente4 = (Utente)ctxu.getBean("u4");
		ud.insert(utente4);
		Utente utente5 = (Utente)ctxu.getBean("u5");
		ud.insert(utente5);
		Utente utente6 = (Utente)ctxu.getBean("u6");
		ud.insert(utente6);
		creaPrenotazione(1, 1, LocalDate.now());
		creaPrenotazione(2, 1, LocalDate.now());
		creaPrenotazione(1, 2, LocalDate.now());
		
		
		
		((AnnotationConfigApplicationContext) ctxp).close();
		((AnnotationConfigApplicationContext) ctxu).close();
		((AnnotationConfigApplicationContext) ctxe).close();
		
	}
	
    public boolean postazioneDisponibile(Postazione postazione, LocalDate data) {
        if (prd.countUtentiByPostazione(postazione) >= postazione.getNMaxOccupanti()) {
        	throw new IllegalStateException("La postazione è piena non puoi fare la prenotazione!");
        }
        return prd.findByPostazioneAndData(postazione, data).isEmpty();
    } 
    
    public boolean prenotazioneAttivaPerData(Utente utente, LocalDate data) {
        return prd.findByUtenteAndData(utente, data).isEmpty();
    }
    
    public Prenotazione creaPrenotazione(int idUtente, int idPostazione, LocalDate data) {
        Optional<Utente> optionalUtente = ud.getById(idUtente);
        Optional<Postazione> optionalPostazione = pd.getById(idPostazione);
        Utente utente = optionalUtente.orElseThrow(() -> new EntityNotFoundException("Utente non trovato con id: " + idUtente));
        Postazione postazione = optionalPostazione.orElseThrow(() -> new EntityNotFoundException("Postazione non trovata con id: " + idPostazione));
        try {
            if (!postazioneDisponibile(postazione, data)) {
                throw new IllegalStateException("La postazione non è disponibile per la data selezionata");
            }
        }catch (IllegalStateException e) {
            System.out.println("La postazione è piena, scegli un'altra postazione o un'altra data.");
            return null;
        }

        if (!prenotazioneAttivaPerData(utente, data)) {
            throw new IllegalStateException("L'utente ha già una prenotazione attiva per questa data");
        }
        
        Prenotazione prenotazione = new Prenotazione(utente, postazione, data);
        return prd.prenotazioneRepo.save(prenotazione);
    }
   
}
