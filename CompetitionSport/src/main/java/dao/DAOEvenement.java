package dao;

import java.util.List;

import javax.persistence.EntityManager;
import util.Context;
import model.Evenement;

public class DAOEvenement implements IDAOEvenement{

	@Override
	public Evenement findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Evenement e = em.find(Evenement.class, id);
		em.close();
		return e;
	}

	@Override
	public List<Evenement> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Evenement> Evenements = em.createQuery("SELECT e from Evenement e").getResultList();
		em.close();
		return Evenements;
	}

	@Override
	public Evenement save(Evenement ev) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();

		try {
			em.getTransaction().begin();

			ev = em.merge(ev);
			em.getTransaction().commit();
		}catch(Exception e) {e.printStackTrace();}
		em.close();
		return ev;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Evenement e = em.find(Evenement.class, id);
		em.remove(e);
		em.getTransaction().commit();
		em.close();

	}


}
