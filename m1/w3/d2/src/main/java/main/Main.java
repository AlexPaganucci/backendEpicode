package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gestione.eventi.Evento;
import gestione.eventi.TipoEvento;
import model.dao.EventoDAO;

public class Main {
	static List<Evento> eventi = new ArrayList<>();
	public static void insertEvento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti ) {
		try {
			Evento e = new Evento();
			e.setTitolo(titolo);
			e.setDataEvento(dataEvento);
			e.setDescrizione(descrizione);
			e.setTipoEvento(tipoEvento);
			e.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
			eventi.add(e);
			EventoDAO.save(e);
		}catch (Exception e) {
			System.out.println("Evento aggiunto con successo");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		insertEvento("ciao",  LocalDate.parse("1970-10-01"), "ciaone", TipoEvento.PUBBLICO, 200);
		insertEvento("ciaassds",  LocalDate.parse("1990-10-01"), "cadfse", TipoEvento.PRIVATO, 150);
		insertEvento("ciaass",  LocalDate.parse("2000-10-01"), "cae", TipoEvento.PUBBLICO, 100);
		
		EventoDAO.delete(eventi.get(0));
		EventoDAO.getById(1);
		EventoDAO.refresh(eventi.get(1));
		EventoDAO.updateEventoById(2, "festa", "descrizione", 300);
	}
	
}
