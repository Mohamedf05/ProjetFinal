package dao;

import java.util.List;

import model.Athlete;
import model.Epreuve;

public interface IDAOEpreuve extends IDAO<Epreuve,Integer>{
public List<Epreuve> findByAthleteId(Integer id);
}
