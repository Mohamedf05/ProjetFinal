package soprajc.CompetitionSpring.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.CompetitionSpring.model.Compte;
import soprajc.CompetitionSpring.model.Evenement;
import soprajc.CompetitionSpring.model.Organisateur;
import soprajc.CompetitionSpring.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.compte=:compte")
	void deleteByClient(@Param("compte") Compte compte);
	
	@Modifying
	@Transactional
	@Query("update Reservation r set r.compte=null where r.compte=:compte")
	void setCompteReservationToNull(@Param("compte")Compte compte);

	@Query("select r from Reservation r JOIN FETCH r.compte c where c.id=:id")
	List<Reservation> findByIdWithReservations(@Param("id")Integer id);
	
	@Query("select DISTINCT r from Reservation r LEFT JOIN FETCH r.epreuve e where e.evenement =:event")
	List<Reservation> findByEvenement(@Param("event")Evenement evenement);
	
	@Query("select DISTINCT r from Reservation r LEFT JOIN FETCH r.epreuve e LEFT JOIN FETCH e.evenement ev where ev.organisateur =:organisateur")
	List<Reservation> findByOrganisateur (@Param("organisateur")Organisateur organisateur);
}
