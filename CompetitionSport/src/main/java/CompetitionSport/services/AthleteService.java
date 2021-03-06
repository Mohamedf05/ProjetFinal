package CompetitionSport.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CompetitionSport.exception.AthleteException;
import CompetitionSport.model.Athlete;
import CompetitionSport.model.Epreuve;
import CompetitionSport.model.Reservation;
import CompetitionSport.repositories.AthleteRepository;
import CompetitionSport.repositories.CompteRepository;
import CompetitionSport.repositories.EpreuveRepository;
import CompetitionSport.repositories.ReservationRepository;


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
			throw new AthleteException("erreur de validation");
		}

		if (athlete.getId() != null) {
			Athlete participantEnBase = getById(athlete.getId());
			athlete.setVersion(participantEnBase.getVersion());
		}
		return athleteRepo.save(athlete);
	}

	public List<Athlete> getAll() {
		return athleteRepo.findAll();
	}

	public Athlete getById(Integer id) {
		return athleteRepo.findByIdWithEpreuves(id).orElseThrow(() -> {
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
