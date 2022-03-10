package dao;

import model.Client;

public interface IDAOClient extends IDAO<Client, Integer>{
	public Client seConnecter(String mail,String password);

}
