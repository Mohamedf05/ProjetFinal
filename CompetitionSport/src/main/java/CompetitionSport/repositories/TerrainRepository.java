package CompetitionSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import CompetitionSport.model.Terrain;

public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
	

}
