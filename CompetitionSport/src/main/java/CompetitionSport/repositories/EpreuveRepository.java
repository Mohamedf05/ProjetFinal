package CompetitionSport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import CompetitionSport.model.Epreuve;
import CompetitionSport.model.Evenement;

public interface EpreuveRepository extends JpaRepository<Epreuve, Integer> {
	@Query("SELECT DISTINCT e from Epreuve e JOIN FETCH e.evenement ev where ev.id=:identifiant")
	public List<Epreuve> findByEvenement(@Param("identifiant") Integer numero);

}
