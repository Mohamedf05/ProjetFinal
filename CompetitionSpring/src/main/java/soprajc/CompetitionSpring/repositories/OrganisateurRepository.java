package soprajc.CompetitionSpring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.CompetitionSpring.model.Compte;
import soprajc.CompetitionSpring.model.Organisateur;

public interface OrganisateurRepository extends JpaRepository<Organisateur, Integer> {
	Optional<Organisateur> findByMail(String mail);

	@Query("select o from Organisateur o left join fetch o.evenements where o.id=:id")
	Optional<Organisateur> findByIdWithEvenements(@Param("id") Integer id);
}