package dao;

import java.util.List;

import javax.persistence.EntityManager;
import util.Context;
import model.Epreuve;

public class DAOEpreuve implements IDAOEpreuve{

	@Override
	public Epreuve findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Epreuve ep = em.find(Epreuve.class, id);
		em.close();
		return ep;
	}

	@Override
	public List<Epreuve> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Epreuve> epreuves = em.createQuery("SELECT ep from Epreuve ep").getResultList();
		em.close();
		return epreuves;
	}

	@Override
	public Epreuve save(Epreuve ep) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();

		try {
			em.getTransaction().begin();
			ep = em.merge(ep);
			em.getTransaction().commit();
		} catch(Exception e) {e.printStackTrace();}
		em.close();
		return ep;
	}


	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Epreuve ep = em.find(Epreuve.class, id);
		em.remove(ep);
		em.getTransaction().commit();
		em.close();

	}

}
