package CompetitionSport.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import CompetitionSport.model.Organisateur;

public interface OrganisateurRepository extends JpaRepository<Organisateur, Integer> {

	@Query("select o from Organisateur o left join fetch o.evenements where o.id=:id")
	Optional<Organisateur> findByIdWithEvenements(@Param("id") Integer id);
}