package CompetitionSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import CompetitionSport.model.Spectateur;

public interface SpectateurRepository extends JpaRepository<Spectateur, Integer> {

}
