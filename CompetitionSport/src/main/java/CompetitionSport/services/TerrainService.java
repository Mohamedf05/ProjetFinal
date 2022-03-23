package CompetitionSport.services;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import CompetitionSport.exception.TerrainException;
import CompetitionSport.model.Terrain;
import CompetitionSport.repositories.TerrainRepository;

public class TerrainService {
	
	@Autowired
	private TerrainRepository terrainRepository;
	
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
	
	 	List<Terrain> getAll() {
		int nombreElementParPage=1;
		int numeroDeLaPageARemonter=1;
		Pageable page=(Pageable) PageRequest.of(numeroDeLaPageARemonter, nombreElementParPage);
		
		Page<Terrain> resultat= terrainRepository.findAll(page);
		resultat.forEach(a->{
			System.out.println(a.getId());
		});
		return resultat;
	}

}
