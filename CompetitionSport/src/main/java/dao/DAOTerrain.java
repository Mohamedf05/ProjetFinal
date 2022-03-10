package dao;

import java.util.List;

import javax.persistence.EntityManager;
import util.Context;
import model.Terrain;

public class DAOTerrain implements IDAOTerrain{

	@Override
	public Terrain findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Terrain t = em.find(Terrain.class, id);
		em.close();
		return t;
	}

	@Override
	public List<Terrain> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Terrain> terrains = em.createQuery("SELECT t from Terrain t").getResultList();
		em.close();
		return terrains;
	}

	@Override
	public Terrain save(Terrain t) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();

		try {
			em.getTransaction().begin();
			t = em.merge(t);
			em.getTransaction().commit();
		} catch(Exception e) {e.printStackTrace();}
		em.close();
		return t;
	}


	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Terrain t = em.find(Terrain.class, id);
		em.remove(t);
		em.getTransaction().commit();
		em.close();

	}

}
