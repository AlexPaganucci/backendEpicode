package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Evento;
import entity.Partecipazione;
import entity.Stato;
import entity.eventi.Concerto;
import entity.eventi.Genere;
import utils.JpaUtil;

public class PartecipazioneDAO {
	private static final Logger logger = LoggerFactory.getLogger(PartecipazioneDAO.class);

	public void save(Partecipazione object) {
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
	
	public static void getPartecipazioniDaConfermarePerEvento(Evento evento) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT p FROM Partecipazione p WHERE p.evento = :n AND p.stato = p.Stato.DA_CONFERMARE");
		q.setParameter("n", evento);
		List<Partecipazione> res = q.getResultList();
		for (Partecipazione p : res) {
			System.out.println(p);
		}
	}
}
