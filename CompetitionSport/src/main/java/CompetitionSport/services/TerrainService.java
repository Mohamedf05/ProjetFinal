package CompetitionSport.services;

import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

import CompetitionSport.exception.TerrainException;
import CompetitionSport.model.Terrain;
import CompetitionSport.repositories.TerrainRepository;

public class TerrainService {
	
	@Autowired
	private TerrainRepository terrainRepository;
	
	@Autowired
	private Validator validator;
	
	public List<Terrain> getAll() {
		return terrainRepository.findAll();
	}
	
	public Terrain getById(Integer id) {
		return terrainRepository.findById(id).orElseThrow(TerrainException::new);
	}
	
	public Terrain save(Terrain terrain) {
		Set<ConstraintViolation<Terrain>> constraints = validator.validate(terrain);
		if (!constraints.isEmpty()) {
			throw new TerrainException("erreur de validation");
		}
		
		if (terrain.getId()!=null) {
			Terrain terrainEnBase = getById(terrain.getId());
			terrain.setVersion(terrainEnBase.getVersion());
		}
		return terrainRepository.save(terrain);
	}
	
	public void delete(Terrain terrain) {
		delete(terrain.getId());
	}
	
	public void delete(Integer id) {
		terrainRepository.deleteById(id);
	}
	
	/*
	public void create(Terrain t) {
		if (t.getNom() == null) {
			throw new TerrainException("Le nom doit être défini");
		}
		if (t.getAdresse() == null) {
			throw new TerrainException("L'adresse doit être définie");
		}
		if (t.getTypeTerrain() == null) {
			throw new TerrainException("Le type de terrain doit être défini");
		}
		terrainRepository.save(t);
	}
	
	public void update(Terrain t) {
		if (t.getNom() == null) {
			throw new TerrainException("Le nom doit être défini");
		}
		if (t.getAdresse() == null) {
			throw new TerrainException("L'adresse doit être définie");
		}
		if (t.getTypeTerrain() == null) {
			throw new TerrainException("Le type de terrain doit être défini");
		}
		terrainRepository.save(t);
	}
	
*/

}
