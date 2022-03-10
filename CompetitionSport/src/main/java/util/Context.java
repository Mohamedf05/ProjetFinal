package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dao.*;


public class Context {

	private EntityManagerFactory emf  = Persistence.createEntityManagerFactory("competition_sport");

	private static Context _singleton=null;	

	private IDAOClient daoClient = new DAOClient();
	private IDAOEpreuve daoEpreuve = new DAOEpreuve();
	private IDAOEvenement daoEvenement = new DAOEvenement();
	private IDAOLogement daoLogement = new DAOLogement();
	private IDAOReservation daoReservation = new DAOReservation();
	private IDAOTerrain daoTerrain = new DAOTerrain();


	private Context() {}


	public static Context getSingleton() 
	{
		if(_singleton==null) 
		{
			_singleton=new Context();
		}

		return _singleton;
	}


	public IDAOClient getDaoClient() {
		return daoClient;
	}

	public void setDaoClient(IDAOClient daoClient) {
		this.daoClient = daoClient;
	}

	public IDAOEpreuve getDaoEpreuve() {
		return daoEpreuve;
	}

	public void setDaoEpreuve(IDAOEpreuve daoEpreuve) {
		this.daoEpreuve = daoEpreuve;
	}

	public IDAOEvenement getDaoEvenement() {
		return daoEvenement;
	}

	public void setDaoEvenement(IDAOEvenement daoEvenement) {
		this.daoEvenement = daoEvenement;
	}

	public IDAOLogement getDaoLogement() {
		return daoLogement;
	}

	public void setDaoLogement(IDAOLogement daoLogement) {
		this.daoLogement = daoLogement;
	}

	public IDAOReservation getDaoReservation() {
		return daoReservation;
	}

	public void setDaoReservation(IDAOReservation daoReservation) {
		this.daoReservation = daoReservation;
	}

	public IDAOTerrain getDaoTerrain() {
		return daoTerrain;
	}

	public void setDaoTerrain(IDAOTerrain daoTerrain) {
		this.daoTerrain = daoTerrain;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void close() {emf.close();}




}
