package soprajc.CompetitionSpring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.CompetitionSpring.model.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
	
	@Query("select a from Athlete a left join fetch a.epreuves where a.id=:id")
	Optional<Athlete> findByIdWithEpreuves(@Param("id") Integer id);

}
