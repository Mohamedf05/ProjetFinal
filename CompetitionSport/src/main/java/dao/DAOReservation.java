package dao;

import java.util.List;

import javax.persistence.EntityManager;

import util.Context;
import model.Reservation;

public class DAOReservation implements IDAOReservation{

	@Override
	public Reservation findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Reservation r = em.find(Reservation.class, id);
		em.close();
		return r;
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Reservation> reservations = em.createQuery("SELECT r from Reservation r").getResultList();
		em.close();
		return reservations;
	}

	@Override
	public Reservation save(Reservation r) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();

		try {
			em.getTransaction().begin();

			r = em.merge(r);
			em.getTransaction().commit();
		}catch(Exception e) {e.printStackTrace();}
		em.close();
		return r;
	}


	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Reservation r = em.find(Reservation.class, id);
		em.remove(r);
		em.getTransaction().commit();
		em.close();
		
	}

}
