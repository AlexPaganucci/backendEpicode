package model.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Evento;
import entity.Persona;
import entity.eventi.Concerto;
import entity.eventi.GaraDiAtletica;
import entity.eventi.Genere;
import entity.eventi.PartitaDiCalcio;
import utils.JpaUtil;

public class EventoDAO {
	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);

	public void save(Evento object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	public void refresh(Evento object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	public Evento getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(Evento.class, id);

		} finally {
			em.close();
		}

	}

	public void delete(Evento object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	/*
	 * private <T> List<T> executeNamedQuery(String namedQuery, Class<T>
	 * returnClass) { EntityManager em =
	 * JpaUtil.getEntityManagerFactory().createEntityManager(); try {
	 * 
	 * Query query = em.createNamedQuery(namedQuery);
	 * 
	 * return query.getResultList();
	 * 
	 * } finally { em.close(); } }
	 * 
	 * public List<Evento> getEventiSoldout(){
	 * 
	 * return executeNamedQuery("eventiSoldout", Evento.class);
	 * 
	 * }
	 */

	public static void getConcertiInStreaming(boolean isStreaming) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT c FROM Concerto c WHERE c.isStreaming = :n");
			q.setParameter("n", isStreaming);
			List<Concerto> res = q.getResultList();
			for (Concerto c : res) {
				System.out.println(c);
			} 
		} finally {
			em.close();	
		}

	}

	public static void getConcertiPerGenere(Genere genere) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :n");
			q.setParameter("n", genere);
			List<Concerto> res = q.getResultList();
			for (Concerto c : res) {
				System.out.println(c);
			}
		} finally {
			em.close();
		}

	}

	public static void getPartiteVinteInCasa() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa");
			List<PartitaDiCalcio> res = q.getResultList();
			for (PartitaDiCalcio p : res) {
				System.out.println(p);
			}
		} finally {
			em.close();
		}

	}

	public static void getPartiteVinteInTrasferta() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite");
			List<PartitaDiCalcio> res = q.getResultList();
			for (PartitaDiCalcio p : res) {
				System.out.println(p);
			}
		} finally {
			em.close();
		}

	}

	public static void getPartitePareggiate() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente IS NULL");
			List<PartitaDiCalcio> res = q.getResultList();
			for (PartitaDiCalcio p : res) {
				System.out.println(p);
			}
		} finally {
			em.close();
		}


	}
	
	public static void getGareDiAtleticaVincitore(Persona vincitore) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :n");
			q.setParameter("n", vincitore);
			List<GaraDiAtletica> res = q.getResultList();
			for (GaraDiAtletica g : res) {
				System.out.println(g);
			}
		} finally {
			em.close();
		}

	}
	
	public static void getGareDiAtleticaPerPartecipante(Set<Persona> setAtleti) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT g FROM GaraDiAtletica g WHERE :n MEMBER OF g.setAtleti");
			q.setParameter("n", setAtleti);
			List<GaraDiAtletica> res = q.getResultList();
			for (GaraDiAtletica g : res) {
				System.out.println(g);
			}
		} finally {
			em.close();
		}

	}
	
	public static void getEventiSoldout() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT e FROM Evento e WHERE SIZE(e.setPartecipazioni) >= e.numeroMassimoPartecipanti");
			List<Evento> res = q.getResultList();
			for (Evento e : res) {
				System.out.println(e);
			}
		} finally {
			em.close();
		}

	}
	
	public static void getEventiPerInvitato(Persona invitato) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT e FROM Evento e WHERE EXIST(SELECT 1 FROM e.setPartecipazioni p WHERE p.persona = :n");
			q.setParameter("n", invitato);
			List<Evento> res = q.getResultList();
			for (Evento e : res) {
				System.out.println(e);
			}
		} finally {
			em.close();
		}

	}

}
