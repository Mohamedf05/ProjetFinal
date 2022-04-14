package soprajc.CompetitionSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.CompetitionSpring.model.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
	
	@Query("select a from Athlete a left join fetch a.epreuves where a.id=:id")
	Optional<Athlete> findByIdWithEpreuves(@Param("id") Integer id);
	
	@Query("select Distinct a from Athlete a LEFT JOIN FETCH a.epreuves e where e.id=:id")
	List<Athlete> findWithEpreuves(@Param("id") Integer id);
//	@Query("select Distinct a from Athlete a LEFT JOIN FETCH a.reservations a LEFT JOIN FETCH a.epreuve e where e.id=:id")
//	List<Athlete> findWithEpreuves(@Param("id") Integer id);

}
