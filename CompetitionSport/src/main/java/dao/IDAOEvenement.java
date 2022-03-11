package dao;

import java.util.List;

import model.Evenement;

public interface IDAOEvenement extends IDAO<Evenement,Integer>{
	public List<Evenement> findAllByOrganisateur(Integer idO);
}
