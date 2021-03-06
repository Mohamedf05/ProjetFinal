package soprajc.CompetitionSpring.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.LogementException;
import soprajc.CompetitionSpring.model.Logement;
import soprajc.CompetitionSpring.repositories.LogementRepository;

@Service
public class LogementService {

	@Autowired
	private LogementRepository logementRepository;
	
	@Autowired
	private Validator validator;
	
	public List<Logement> getAll() {
		return logementRepository.findAll();
	}
	
	public Logement getById(Integer id) {
		return logementRepository.findById(id).orElseThrow(LogementException::new);
	}
	
	public Logement save(Logement logement) {
		Set<ConstraintViolation<Logement>> constraints = validator.validate(logement);
		if (!constraints.isEmpty()) {
			throw new LogementException("erreur de validation");
		}
		
		if (logement.getId()!=null) {
			Logement logementEnBase = getById(logement.getId());
			logement.setVersion(logementEnBase.getVersion());
		}
		return logementRepository.save(logement);
	}
	
	public void delete(Logement logement) {
		delete(logement.getId());
	}
	
	public void delete(Integer id) {
		logementRepository.deleteById(id);
	}
}
