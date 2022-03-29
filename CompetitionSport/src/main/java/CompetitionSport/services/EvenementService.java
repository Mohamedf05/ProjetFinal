package CompetitionSport.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import CompetitionSport.exception.EvenementException;
import CompetitionSport.model.Evenement;
import CompetitionSport.repositories.EvenementRepository;

public class EvenementService {

    @Autowired
	private EvenementRepository evenementRepo;

    @Autowired
	private Validator validator;

    public List<Evenement> getAll() {
		return evenementRepo.findAll();
	}

	public Evenement getById(Integer id) {
		return evenementRepo.findById(id).orElseThrow(EvenementException::new);
	}

	public Evenement save(Evenement evenement) {
		Set<ConstraintViolation<Evenement>> constraints = validator.validate(evenement);
		if (!constraints.isEmpty()) {
			throw new EvenementException("erreur de validation");
		}

		if (evenement.getId() != null) {
			Evenement evenementEnBase = getById(evenement.getId());
			evenement.setVersion(evenementEnBase.getVersion());
		}
		return evenementRepo.save(evenement);
	}

	public void delete(Evenement evenement) {
		delete(evenement.getId());
	}

	public void delete(Integer id) {
		evenementRepo.deleteById(id);
	}
}

