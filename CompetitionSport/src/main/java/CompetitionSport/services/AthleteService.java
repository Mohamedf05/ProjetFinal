package CompetitionSport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CompetitionSport.exception.AthleteException;
import CompetitionSport.model.Athlete;
import CompetitionSport.repositories.AthleteRepository;
import CompetitionSport.repositories.ReservationRepository;

@Service
public class AthleteService {


	@Autowired
	private AthleteRepository athleteRepo;
	@Autowired
	private ReservationRepository reservationRepo;

	public void create(Athlete athlete) {
		if (athlete.getId() != null) {
			throw new AthleteException("le numero ne doit pas etre defini");
		}
		if (athlete.getMail() == null || athlete.getMail().isEmpty()) {
			throw new AthleteException("le mail doit etre defini");
		}
		athleteRepo.save(athlete);
	}

	public void update(Athlete athlete) {
		if (athlete.getId() == null) {
			throw new AthleteException("le numero doit etre defini");
		}
		if (athlete.getMail() == null ||athlete.getMail().isEmpty()) {
			throw new AthleteException("le mail doit etre defini");
		}
		athleteRepo.save(athlete);
	}

	public List<Athlete> getAll() {
		return athleteRepo.findAll();
	}

	public Athlete getById(Integer id) {
		return athleteRepo.findById(id).orElseThrow(() -> {
			throw new AthleteException("id inconnu");
		});
	}

	public Athlete getByNumeroWithReservation(Integer id) {
		return athleteRepo.findByIdWithReservations(id).orElseThrow(() -> {
			throw new AthleteException("id inconnu");
		});
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
