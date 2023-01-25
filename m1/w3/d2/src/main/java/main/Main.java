package main;

import java.time.LocalDate;

import gestione.eventi.Evento;
import gestione.eventi.TipoEvento;
import model.dao.EventoDAO;



public class Main {

	public static void main(String[] args) {
		
		Evento evento = saveEvento();
	}

	private static Evento saveEvento() {
		Evento ev = new Evento();
		ev.setDataEvento(LocalDate.of(2021, 02, 02));
		ev.setTitolo("Partita");
		ev.setDescrizione("Finale di coppa");
		ev.setNumeroMassimoPartecipanti(10);
		ev.setTipoEvento(TipoEvento.PUBBLICO);
		
		EventoDAO evDao = new EventoDAO();
		evDao.save(ev);
		return ev;
	}

}
