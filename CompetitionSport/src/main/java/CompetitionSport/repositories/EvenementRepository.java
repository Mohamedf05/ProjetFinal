package CompetitionSport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import CompetitionSport.model.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

    @Query("SELECT DISTINCT e from Evenement e JOIN FETCH e.organisateur o where o.id=:identifiant")
	public List<Evenement> findByOrganisateur(@Param("identifiant") Integer numero);
}
