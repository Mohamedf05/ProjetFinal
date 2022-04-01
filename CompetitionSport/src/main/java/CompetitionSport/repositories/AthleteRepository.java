package CompetitionSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import CompetitionSport.model.Athlete;
import CompetitionSport.model.Epreuve;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
	
	@Query("select a from Athlete a left join fetch a.epreuves where a.id=:id")
	Optional<Athlete> findByIdWithEpreuves(@Param("id") Integer id);

}
