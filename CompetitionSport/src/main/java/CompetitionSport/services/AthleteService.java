package CompetitionSport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.xdevapi.Client;

import CompetitionSport.exception.AthleteException;
import CompetitionSport.model.Athlete;
import CompetitionSport.repositories.AthleteRepository;
import CompetitionSport.repositories.ReservationRepository;

@Service
public class AthleteService {


	@Autowired
	private AthleteRepository athleteRepository;
	@Autowired
	private ReservationRepository reservationRepository;

	public void create(Athlete a) {
		if (a.getId() != null) {
			throw new AthleteException("le numero ne doit pas etre defini");
		}
		if (a.getMail() == null || a.getMail().isEmpty()) {
			throw new AthleteException("le mail doit etre defini");
		}
		athleteRepository.save(a);
	}

	public void update(Athlete a) {
		if (a.getId() == null) {
			throw new AthleteException("le numero doit etre defini");
		}
		if (a.getMail() == null ||a.getMail().isEmpty()) {
			throw new AthleteException("le mail doit etre defini");
		}
		athleteRepository.save(a);
	}

	public List<Athlete> getAll() {
		return athleteRepository.findAll();
	}

	public Athlete getByNumero(Integer numero) {
		return athleteRepository.findById(numero).orElseThrow(() -> {
			throw new AthleteException("numero inconnu");
		});
	}

	public Athlete getByNumeroWithReservation(Integer numero) {
		return athleteRepository.findByNumeroWithReservations(numero).orElseThrow(() -> {
			throw new AthleteException("numero inconnu");
		});
	}

	public void delete(Athlete c) {
//		Athlete athleteEnBaseAvecReservations = getByNumeroWithReservation(c.getNumero());
//		reservationRepository.deleteAll(athleteEnBaseAvecReservations.getReservations());
//		athleteRepository.delete(athleteEnBaseAvecReservations);

		Athlete athleteEnBase = getByNumero(c.getId());
		reservationRepository.deleteByClient((Client) athleteEnBase);
		athleteRepository.delete(athleteEnBase);
	}

	public void deleteByNumero(Integer numero) {
		Athlete athlete = new Athlete();
		athlete.setId(numero);
		delete(athlete);
	}
	
}
