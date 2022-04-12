package soprajc.CompetitionSpring.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.TerrainException;
import soprajc.CompetitionSpring.model.Terrain;
import soprajc.CompetitionSpring.repositories.TerrainRepository;

@Service
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

}
