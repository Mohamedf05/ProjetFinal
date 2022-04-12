package soprajc.CompetitionSpring.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.SpectateurException;
import soprajc.CompetitionSpring.model.Reservation;
import soprajc.CompetitionSpring.model.Spectateur;
import soprajc.CompetitionSpring.repositories.ReservationRepository;
import soprajc.CompetitionSpring.repositories.SpectateurRepository;

@Service
public class SpectateurService {

	@Autowired
	private SpectateurRepository spectateurRepo;

	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private Validator validator;

	public List<Spectateur> getAll() {
		return spectateurRepo.findAll();
	}

	public Spectateur getById(Integer id) {
		return spectateurRepo.findById(id).orElseThrow(SpectateurException::new);
	}
	
	public List<Reservation> getByIdWithReservations(Integer id) {
		return reservationRepo.findByIdWithReservations(id);
	}

	public Spectateur save(Spectateur spectateur) {
		Set<ConstraintViolation<Spectateur>> constraints = validator.validate(spectateur);
		if (!constraints.isEmpty()) {
			throw new SpectateurException("erreur de validation");
		}
		
		if (spectateur.getId()!=null) {
			Spectateur spectateurEnBase = getById(spectateur.getId());
			spectateur.setVersion(spectateurEnBase.getVersion());
		}
		return spectateurRepo.save(spectateur);
	}

	public void delete(Spectateur spectateur) {
		reservationRepo.setCompteReservationToNull(spectateur);
		Spectateur spectateurEnBase = getById(spectateur.getId());
		reservationRepo.deleteByClient(spectateurEnBase);
		spectateurRepo.delete(spectateurEnBase);
	}

	public void deleteById(Integer id) {
		Spectateur spectateur = new Spectateur();
		spectateur.setId(id);
		delete(spectateur);
	}
	
}
