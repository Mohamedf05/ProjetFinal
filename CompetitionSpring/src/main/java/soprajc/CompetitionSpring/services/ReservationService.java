package soprajc.CompetitionSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.ReservationException;
import soprajc.CompetitionSpring.model.Athlete;
import soprajc.CompetitionSpring.model.Reservation;
import soprajc.CompetitionSpring.repositories.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepo;

	public List<Reservation> getAll() {
		return reservationRepo.findAll();
	}

	public Reservation getById(Integer id) {
		Reservation reservation = reservationRepo.findById(id).orElseThrow(ReservationException::new);
		return reservation;
	}
	
	public List<Reservation> getAllbyOrganisateur(Integer id)
    {
    	return reservationRepo.findByIdWithReservations(id);
    	
    }
	
	public Reservation save(Reservation reservation) {
		if (reservation.getId() != null) {
			Reservation reservationEnBase = getById(reservation.getId());
			reservation.setVersion(reservationEnBase.getVersion());
		}
		return reservationRepo.save(reservation);
	}

	public void delete(Reservation reservation) {
		if(reservation.getCompte().getClass().getSimpleName().toLowerCase().equals("athlete")) {
			((Athlete) reservation.getCompte()).RemoveEpreuve(reservation.getEpreuve());
		}
		reservation.getEpreuve().RemoveParticipant((Athlete)reservation.getCompte());
		
		delete(reservation.getId());
	}

	public void delete(Integer id) {
		reservationRepo.deleteById(id);
	}

}