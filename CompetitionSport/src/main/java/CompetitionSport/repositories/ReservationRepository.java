package CompetitionSport.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mysql.cj.xdevapi.Client;

import CompetitionSport.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.client=:client")
	void deleteByClient(@Param("client") Client client);
	
	@Modifying
	@Transactional
	@Query("update Reservation r set r.client=null where r.client=:client")
	void setClientReservationToNull(@Param("client")Client client);
	
}
