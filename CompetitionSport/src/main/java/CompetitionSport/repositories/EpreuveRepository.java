package CompetitionSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import CompetitionSport.model.Epreuve;

public interface EpreuveRepository extends JpaRepository<Epreuve, Integer> {

}
