package dao;

import java.util.List;

import javax.persistence.EntityManager;

import util.Context;
import model.Logement;

public class DAOLogement implements IDAOLogement{

	@Override
	public Logement findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Logement l = em.find(Logement.class, id);
		em.close();
		return l;
	}

	@Override
	public List<Logement> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Logement> Logements = em.createQuery("SELECT l from Logement l").getResultList();
		em.close();
		return Logements;
	}

	@Override
	public Logement save(Logement l) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();

		try {
			em.getTransaction().begin();

			l = em.merge(l);
			em.getTransaction().commit();
		}catch(Exception e) {e.printStackTrace();}
		em.close();
		return l;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Logement l = em.find(Logement.class, id);
		em.remove(l);
		em.getTransaction().commit();
		em.close();

	}


}
