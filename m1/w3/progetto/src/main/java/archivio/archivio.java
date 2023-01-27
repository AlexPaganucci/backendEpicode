package archivio;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Autore;
import entity.CatalogoBibliotecario;
import entity.GenereLibro;
import entity.Libro;
import entity.PeriodicitaRiviste;
import entity.Prestito;
import entity.Rivista;

public class archivio {

	private static final String persistenceUnit = "catalogo_bibliotecario";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
    private static final EntityManager em = emf.createEntityManager();
    private static final EntityTransaction t = em.getTransaction();
	
	public static void salvaElemento(CatalogoBibliotecario object) {
		try {
			t.begin();
			em.persist(object);
			t.commit();
			System.out.println("Elemento salvato correttamente nel database!");
		} catch (Exception ex) {
			System.out.println("L'elemento non è stato salvato correttamente nel database!");
		}
	}
	
	public static void salvaAutore(Autore object) {
		try {
			t.begin();
			em.persist(object);
			t.commit();
			System.out.println("Autore salvato correttamente nel database!");
		} catch (Exception ex) {
			System.out.println("L'autore non è stato salvato correttamente nel database!");
		}
	}
	
	public static Libro rimuoviLibroDatoUnCodiceISBN(String codiceISBN) {
		try {
			t.begin();
			TypedQuery<Libro> q = em.createQuery("SELECT l FROM Libro l WHERE l.codiceISBN = :n", Libro.class);
			q.setParameter("n", codiceISBN);
			em.remove(q.getSingleResult());
			t.commit();
			return q.getSingleResult();
		} catch (Exception ex) {
			System.out.println("Il libro non è stato rimosso correttamente dal database!");
			return null;
		}
	}
	
	public static Rivista rimuoviRivistaDatoUnCodiceISBN(String codiceISBN) {
		try {
			t.begin();
			TypedQuery<Rivista> q = em.createQuery("SELECT r FROM Rivista r WHERE r.codiceISBN = :n", Rivista.class);
			q.setParameter("n", codiceISBN);
			em.remove(q.getSingleResult());
			t.commit();
			return q.getSingleResult();
		} catch (Exception ex) {
			System.out.println("La rivista non è stata rimossa correttamente dal database!");
			return null;
		}
	}
	
	
	public static Libro getLibroPerCodiceISBN(String codiceISBN) {
		try {
			t.begin();
			TypedQuery<Libro> q = em.createQuery("SELECT l FROM Libro l WHERE l.codiceISBN = :n", Libro.class);
			q.setParameter("n", codiceISBN);
			return q.getSingleResult();
		} catch (Exception ex) {
			System.out.println("Il libro non è stato trovato!");
			return null;
		}
	}
	
	public static Rivista getRivistaPerCodiceISBN(String codiceISBN) {
		try {
			t.begin();
			TypedQuery<Rivista> q = em.createQuery("SELECT r FROM Rivista r WHERE r.codiceISBN = :n", Rivista.class);
			q.setParameter("n", codiceISBN);
			return q.getSingleResult();
		} catch (Exception ex) {
			System.out.println("La rivista non è stata trovata!");
			return null;
		}
	}
	
	public static List<Libro> getLibroPerAnnoDiPubblicazione(int anno) {
		try {
			t.begin();
			Query q = em.createQuery("SELECT l FROM Libro l WHERE l.annoDiPubblicazione = :n");
			q.setParameter("n", anno);
			return q.getResultList();
		} catch (Exception ex) {
			System.out.println("Il libro non è stato trovato!");
			return null;
		}
	}
	
	public static List<Rivista> getRivistaPerAnnoDiPubblicazione(int anno) {
		try {
			t.begin();
			Query q = em.createQuery("SELECT r FROM Rivista r WHERE r.annoDiPubblicazione = :n");
			q.setParameter("n", anno);
			return q.getResultList();
		} catch (Exception ex) {
			System.out.println("La rivista non è stata trovata!");
			return null;
		}
	}
	
	public static List<Libro> getLibroPerAutore(Autore autore) {
		try {
			t.begin();
			Query q = em.createQuery("SELECT l FROM Libro l WHERE l.autore = :n");
			q.setParameter("n", autore);
			return q.getResultList();
		} catch (Exception ex) {
			System.out.println("Questo autore non ha scritto libri!");
			return null;
		}
	}
	
	public static List<Libro> getLibroPerParteDiTitolo(String titolo) {
		try {
			t.begin();
			Query q = em.createQuery("SELECT l FROM Libro l WHERE l.titolo LIKE :n");
			q.setParameter("n", "%" + titolo + "%");
			return q.getResultList();
		} catch (Exception ex) {
			System.out.println("Il libro non è stato cercato correttamente!");
			return null;
		}
	}
	
	public static List<Rivista> getRivistaPerParteDiTitolo(String titolo) {
		try {
			t.begin();
			Query q = em.createQuery("SELECT r FROM Rivista r WHERE r.titolo LIKE :n");
			q.setParameter("n", "%" + titolo + "%");
			return q.getResultList();
		} catch (Exception ex) {
			System.out.println("La rivista non è stata cercata correttamente!");
			return null;
		}
	}
	
	public static List<Libro> getElementoInPrestito(int numeroDiTessera){
		try {
			t.begin();
			Query q = em.createQuery("SELECT c FROM Prestito p JOIN p.utente u JOIN p.elementoPrestato c "
					+ "WHERE u.numeroDiTessera = :n AND p.dataRestituzioneEffettiva IS NULL");
			q.setParameter("n", numeroDiTessera);
			return q.getResultList();
		}catch (Exception ex) {
			System.out.println("L'elemento non è stato cercato correttamente!");
			return null;
		}
	}
	
	public static List<Prestito> getPrestitiScaduti(){
		try {
			t.begin();
			Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva = NULL");
			return q.getResultList();
		}catch (Exception ex) {
			System.out.println("Il prestito non è stato cercato correttamente!");
			return null;
		}
	}
	
	
	
	public static Autore salvaAutore() {
		Autore a = new Autore();
		a.setName("J.K.Rowling");
		salvaAutore(a);
		return a;
	}
	
	public static Libro salvaLibro(Autore autore) {
		Libro l = new Libro();
		l.setCodiceISBN(UUID.randomUUID().toString());
		l.setTitolo("Harry Potter");
		l.setAnnoDiPubblicazione(2001);
		l.setNumeroPagine(510);
		l.setAutore(autore);
		l.setGenere(GenereLibro.AVVENTURA);
		salvaElemento(l);
		return l;
	}
	
	public static Rivista salvaRivista() {
		Rivista r = new Rivista();
		r.setCodiceISBN(UUID.randomUUID().toString());
		r.setTitolo("ciao");
		r.setAnnoDiPubblicazione(2010);
		r.setNumeroPagine(35);
		r.setPeriodicita(PeriodicitaRiviste.SETTIMANALE);
		salvaElemento(r);
		return r;
	}
	
	public static void main(String[] args) {
		
		//Salva un autore
		//Autore autore = salvaAutore();
		
		//Salva un libro
		//Libro libro = salvaLibro(autore);
		
		//Salva una rivista
		//Rivista rivista = salvaRivista();
		
		//prende il titolo dei libri dell'autore
		/*List<Libro> listaLibri = new ArrayList<Libro>();
		listaLibri = getLibroPerAutore(autore);
		listaLibri.forEach(l -> System.out.println(libro.getTitolo()));*/
		
		//rimuove un libro dato un codiceISBN
		/*Libro libro = rimuoviLibroDatoUnCodiceISBN("30a28307-ccc6-421c-b90a-4366a1564dae");
		System.out.println(libro.getTitolo());*/
		
		//rimuove una rivista dato un codiceISBN
		/*Rivista rivista = rimuoviRivistaDatoUnCodiceISBN("0b59f0e4-2dbe-4ded-83ce-0d53594a9092");
		System.out.println(rivista.getTitolo());*/
		
		//prende il titolo del libro dal codice isbn
		/*Libro libro = getLibroPerCodiceISBN("30a28307-ccc6-421c-b90a-4366a1564dae");
		System.out.println(libro.getTitolo());*/
		
		//prende il titolo delle riviste dal codice isbn
		/*Rivista rivista = getRivistaPerCodiceISBN("2553cbbc-5a0c-4f52-b39b-a879f12343df");
		System.out.println(rivista.getTitolo());*/
		
		//prende il titolo dei libri dall'anno di pubblicazione
		/*List<Libro> listaLibri = new ArrayList<Libro>();
		listaLibri = getLibroPerAnnoDiPubblicazione(2001);
		listaLibri.forEach(l -> System.out.println(l.getTitolo()));*/
		
		//prende il titolo dei libri dall'anno di pubblicazione
		/*List<Rivista> listaRiviste = new ArrayList<Rivista>();
		listaRiviste = getRivistaPerAnnoDiPubblicazione(2010);
		listaRiviste.forEach(r -> System.out.println(r.getTitolo()));*/
		
		//prende il titolo dei libri da una parte di titolo
		/*List<Libro> listaLibri = new ArrayList<Libro>();
		listaLibri = getLibroPerParteDiTitolo("arr");
		listaLibri.forEach(l -> System.out.println(l.getTitolo()));*/
		
		//prende il titolo delle riviste da una parte di titolo
		/*List<Rivista> listaRiviste = new ArrayList<Rivista>();
		listaRiviste = getRivistaPerParteDiTitolo("eo");
		listaRiviste.forEach(r -> System.out.println(r.getTitolo()));*/
		
		// Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
		/*List<Libro> listaLibri = new ArrayList<Libro>();
		listaLibri = getElementoInPrestito(1);
		listaLibri.forEach(l -> System.out.println(l.getTitolo()));*/
		
		//Ricerca di tutti i prestiti scaduti e non ancora restituiti
		/*List<Prestito> prestiti = new ArrayList<Prestito>();
		prestiti = getPrestitiScaduti();
		prestiti.forEach(l -> System.out.println(l.getElementoPrestato()));*/
		
		em.close();
		emf.close();
	}

}
