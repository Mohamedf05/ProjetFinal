package CompetitionSport.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import CompetitionSport.model.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
	
	@Query("select c from Compte c left join fetch c.reservations where c.id=:numero")
	Optional<Athlete> findByNumeroWithReservations(@Param("numero") Integer numero);

}
