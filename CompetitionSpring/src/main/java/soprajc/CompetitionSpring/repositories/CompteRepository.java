package soprajc.CompetitionSpring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.CompetitionSpring.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {

	Optional<Compte> findByMailAndPassword(String mail, String password);
	
	@Query("select c from Compte c left join fetch c.reservations where c.id=:numero")
	Optional<Compte> findByIdWithReservations(@Param("numero") Integer numero);
}
