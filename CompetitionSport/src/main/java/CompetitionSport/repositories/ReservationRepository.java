package CompetitionSport.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import CompetitionSport.model.Compte;
import CompetitionSport.model.Epreuve;
import CompetitionSport.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.compte=:compte")
	void deleteByClient(@Param("compte") Compte compte);
	
	@Modifying
	@Transactional
	@Query("update Reservation r set r.compte=null where r.compte=:compte")
	void setCompteReservationToNull(@Param("compte")Compte compte);

	
}
