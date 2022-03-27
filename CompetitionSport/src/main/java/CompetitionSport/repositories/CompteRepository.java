package CompetitionSport.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import CompetitionSport.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {

	Optional<Compte> findByMailAndPassword(String mail, String password);
}
