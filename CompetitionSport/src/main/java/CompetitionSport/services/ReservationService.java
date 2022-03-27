package CompetitionSport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import CompetitionSport.exception.ReservationException;
import CompetitionSport.model.Reservation;
import CompetitionSport.repositories.ReservationRepository;

public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepo;

	public List<Reservation> getAll() {
		return reservationRepo.findAll();
	}

	public Reservation getById(Integer id) {
		return reservationRepo.findById(id).orElseThrow(ReservationException::new);
	}

	public Reservation save(Reservation reservation) {
		if (reservation.getId() != null) {
			Reservation reservationEnBase = getById(reservation.getId());
			reservation.setVersion(reservationEnBase.getVersion());
		}
		return reservationRepo.save(reservation);
	}

	public void delete(Reservation reservation) {
		delete(reservation.getId());
	}

	public void delete(Integer id) {
		reservationRepo.deleteById(id);
	}

}