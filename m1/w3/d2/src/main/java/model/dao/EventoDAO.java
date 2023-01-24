package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import gestione.eventi.Evento;
import utils.JpaUtil;

public class EventoDAO {

	    private static final EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
	    private static final EntityTransaction t = entityManager.getTransaction();

	    public static void save(Evento evento) {
	    	t.begin();
	        entityManager.persist(evento);
	        t.commit();
	    }

	    public static Evento getById(long id) {
	        Evento e = entityManager.find(Evento.class, id);
	        
	        if(e == null) {
				System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
				return null;
	        }
	        return e;
	    }

	    public static void delete(Evento evento) {
	    	t.begin();
	        entityManager.remove(evento);
	        t.commit();
	    }

	    public static void refresh(Evento evento) {
	        entityManager.refresh(evento);
	    }
	    
	    public static void updateEventoById(int id, String titolo, String descrizione, int numeroMassimoPartecipanti) {
	    	Evento e = getById(id);
	    	if(e == null) return;
			try {
				e.setTitolo(titolo);
				e.setDescrizione(descrizione);
				e.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
				
				save(e);
				
				System.out.println("Lo studente con l'id " + id + " è stato aggiornato!");
			}
			catch(Exception ex) {
				System.out.println( "Errore nella modifica dello studente!" );
			}
	    }

}

