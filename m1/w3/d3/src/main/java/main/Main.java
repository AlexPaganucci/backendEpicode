package main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.GregorianCalendar;

import entity.Evento;
import entity.Location;
import entity.Partecipazione;
import entity.Persona;
import entity.Sesso;
import entity.Stato;
import entity.TipoEvento;
import model.dao.EventoDAO;
import model.dao.LocationDAO;
import model.dao.PartecipazioneDAO;
import model.dao.PersonaDAO;



public class Main {

	public static void main(String[] args) {
		
		Location location = saveLocation();
		Evento evento = saveEvento(location);
		Persona persona = savePersona();
		Partecipazione partecipazione = savePartecipazione(persona, evento);
	}
	
	private static Location saveLocation() {
		Location l = new Location();
		l.setCitta("Milano");
		l.setNome("San siro");
		
		LocationDAO lDao = new LocationDAO();
		lDao.save(l);
		return l;
	}

	private static Evento saveEvento(Location l) {
		Evento ev = new Evento();
		ev.setDataEvento(new GregorianCalendar(2022, 9, 23).getTime());
		ev.setTitolo("Partita");
		ev.setDescrizione("Finale di coppa");
		ev.setNumeroMassimoPartecipanti(10);
		ev.setTipoEvento(TipoEvento.PUBBLICO);
		ev.setLocation(l);
		
		EventoDAO evDao = new EventoDAO();
		evDao.save(ev);
		return ev;
	}
	
	private static Persona savePersona() {
		Persona p = new Persona();
		p.setNome("Alex");
		p.setCognome("Paganucci");
		p.setEmail("alex.paganucci@gmail.com");
		p.setDataDiNascita(new GregorianCalendar(1990, 9, 23).getTime());
		p.setSesso(Sesso.MASCHIO);
		p.setListaPartecipazioni(null);
		
		PersonaDAO pDao = new PersonaDAO();
		pDao.save(p);
		return p;
	}
	
	private static Partecipazione savePartecipazione(Persona p, Evento ev) {
		Partecipazione pa = new Partecipazione();
		pa.setPersona(p);
		pa.setEvento(ev);
		pa.setStato(Stato.CONFERMATA);
		
		PartecipazioneDAO paDao = new PartecipazioneDAO();
		paDao.save(pa);
		return pa;
	}

}
