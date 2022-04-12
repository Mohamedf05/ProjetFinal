package soprajc.CompetitionSpring.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.OrganisateurException;
import soprajc.CompetitionSpring.model.Organisateur;
import soprajc.CompetitionSpring.model.Reservation;
import soprajc.CompetitionSpring.repositories.EvenementRepository;
import soprajc.CompetitionSpring.repositories.OrganisateurRepository;
import soprajc.CompetitionSpring.repositories.ReservationRepository;

@Service
public class OrganisateurService {
	@Autowired
	private OrganisateurRepository organisateurRepo;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private EvenementRepository evenementRepository;
	@Autowired
	private Validator validator;

	public List<Organisateur> getAll() {
		return organisateurRepo.findAll();
	}

	public Organisateur getById(Integer id) {
		return organisateurRepo.findById(id).orElseThrow(() -> {
			throw new OrganisateurException("numero inconnu");
		});
	}
	
	public List<Reservation> getByIdWithReservation(Integer id) {
		return reservationRepository.findByIdWithReservations(id);	
	}
	
	public Organisateur save(Organisateur organisateur) {
		Set<ConstraintViolation<Organisateur>> constraints = validator.validate(organisateur);
		if (!constraints.isEmpty()) {
			throw new OrganisateurException("erreur de validation");
		}
		
		if (organisateur.getId()!=null) {
			Organisateur organisateurEnBase = getById(organisateur.getId());
			organisateur.setVersion(organisateurEnBase.getVersion());
		}
		return organisateurRepo.save(organisateur);
	}

	public void delete(Organisateur organisateur) {
		evenementRepository.setOrganisateurEvenementToNull(organisateur);
		Organisateur organisateurEnBase = getById(organisateur.getId());
		reservationRepository.deleteByClient(organisateurEnBase);
		organisateurRepo.delete(organisateurEnBase);
	}

	public void deleteById(Integer id) {
		Organisateur organisateur = new Organisateur();
		organisateur.setId(id);
		delete(organisateur);
	}
}
