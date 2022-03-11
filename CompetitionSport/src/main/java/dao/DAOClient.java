package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Context;
import model.Client;

public class DAOClient implements IDAOClient{

	@Override
	public Client findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Client c = em.find(Client.class, id);
		em.close();
		return c;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Client> clients = em.createQuery("SELECT c from Client c").getResultList();
		em.close();
		return clients;
	}

	@Override
	public Client save(Client c) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();

		try {
			em.getTransaction().begin();
			c = em.merge(c);
			em.getTransaction().commit();
		}catch(Exception e) {e.printStackTrace();}
		em.close();
		return c;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Client c = em.find(Client.class, id);
		em.remove(c);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public Client seConnecter(String mail, String password) {

		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT c from Client c where c.mail = :mail and c.password = :password");
		q.setParameter("mail", mail);
		q.setParameter("password", password);
		Client c=null;
		try {
			c = (Client) q.getSingleResult();



		} catch (Exception e) {

		}
		em.close();
		return c;

	}


}
