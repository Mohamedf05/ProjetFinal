package soprajc.CompetitionSpring.services;

import java.util.List;
import java.util.Set;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.JournalisteException;
import soprajc.CompetitionSpring.model.Journaliste;
import soprajc.CompetitionSpring.model.Reservation;
import soprajc.CompetitionSpring.repositories.JournalisteRepository;
import soprajc.CompetitionSpring.repositories.ReservationRepository;

@Service
public class JournalisteService {
	

	@Autowired
	private JournalisteRepository journalisteRepo;

	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private Validator validator;

	public List<Journaliste> getAll() {
		return journalisteRepo.findAll();
	}

	public Journaliste getById(Integer id) {
		return journalisteRepo.getById(id);
	}
	
	public List<Reservation> getByIdWithReservations(Integer id) {
		return reservationRepo.findByIdWithReservations(id);
	}

	public Journaliste save(Journaliste journaliste) {
		Set<ConstraintViolation<Journaliste>> constraints = validator.validate(journaliste);
		if (!constraints.isEmpty()) {
			throw new JournalisteException("erreur de validation");
		}
		
		if (journaliste.getId()!=null) {
			Journaliste journalisteEnBase = getById(journaliste.getId());
			journaliste.setVersion(journalisteEnBase.getVersion());
		}
		return journalisteRepo.save(journaliste);
	}

	public void delete(Journaliste journaliste) {
		reservationRepo.setCompteReservationToNull(journaliste);
		Journaliste journalisteEnBase = getById(journaliste.getId());
		reservationRepo.deleteByClient(journalisteEnBase);
		journalisteRepo.delete(journalisteEnBase);
	}

	public void deleteById(Integer id) {
		Journaliste journaliste = new Journaliste();
		journaliste.setId(id);
		delete(journaliste);
	}

}
