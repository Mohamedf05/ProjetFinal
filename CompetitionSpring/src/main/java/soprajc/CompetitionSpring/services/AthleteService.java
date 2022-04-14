package soprajc.CompetitionSpring.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.AthleteException;
import soprajc.CompetitionSpring.exception.LogementException;
import soprajc.CompetitionSpring.model.Athlete;
import soprajc.CompetitionSpring.model.Epreuve;
import soprajc.CompetitionSpring.model.Reservation;
import soprajc.CompetitionSpring.repositories.AthleteRepository;
import soprajc.CompetitionSpring.repositories.EpreuveRepository;
import soprajc.CompetitionSpring.repositories.ReservationRepository;


@Service
public class AthleteService {


	@Autowired
	private AthleteRepository athleteRepo;	
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private EpreuveRepository epreuveRepo;
	
	@Autowired
	private Validator validator;

	public Athlete save(Athlete athlete) {
		Set<ConstraintViolation<Athlete>> constraints = validator.validate(athlete);
		if (!constraints.isEmpty()) {
			throw new LogementException("erreur de validation");
		}
		
		if (athlete.getId()!=null) {
			Athlete athleteEnBase = getById(athlete.getId());
			athlete.setVersion(athleteEnBase.getVersion());
		}
		return athleteRepo.save(athlete);
	}

	public List<Athlete> getAll() {
		return athleteRepo.findAll();
	}
	
	public List<Athlete> getAllByEpreuve(Integer id) {
		return athleteRepo.findWithEpreuves(id);
	}

	public Athlete getById(Integer id) {
		return athleteRepo.findById(id).orElseThrow(() -> {
			throw new AthleteException("id inconnu");
		});
	}

	public List<Reservation> getByIdWithReservation(Integer id) {
		return reservationRepo.findByIdWithReservations(id);	
	}
	
	public List<Epreuve> getByIdWithEpreuve(Integer id) {
		return epreuveRepo.findByAthleteWithEpreuve(id);
	}

	public void delete(Athlete athlete) {
		reservationRepo.setCompteReservationToNull(athlete);
		Athlete athleteEnBase = getById(athlete.getId());
		reservationRepo.deleteByClient(athleteEnBase);
		athleteRepo.delete(athleteEnBase);
	}

	public void deleteById(Integer id) {
		Athlete athlete = new Athlete();
		athlete.setId(id);
		delete(athlete);
	}
	
}
