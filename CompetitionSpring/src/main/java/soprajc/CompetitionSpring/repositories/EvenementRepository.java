package soprajc.CompetitionSpring.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.CompetitionSpring.model.Evenement;
import soprajc.CompetitionSpring.model.Organisateur;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

    @Query("SELECT DISTINCT e from Evenement e JOIN FETCH e.organisateur o where o.id=:identifiant")
	public List<Evenement> findByOrganisateur(@Param("identifiant") Integer numero);
    
    @Modifying
	@Transactional
	@Query("update Evenement e set e.organisateur=null where e.organisateur=:organisateur")
	void setOrganisateurEvenementToNull(@Param("organisateur")Organisateur organisateur);
    public Evenement findByNom(String nom);
}
