package soprajc.CompetitionSpring.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.EpreuveException;
import soprajc.CompetitionSpring.model.Epreuve;
import soprajc.CompetitionSpring.repositories.EpreuveRepository;

@Service
public class EpreuveService {

    @Autowired
	private EpreuveRepository epreuveRepo;

    @Autowired
	private Validator validator;

    public List<Epreuve> getAll() {
		return epreuveRepo.findAll();
	}
    
    public List<Epreuve> getAllByEvenement(Integer id)
    {
    	return epreuveRepo.findByEvenement(id);
    }

	public Epreuve getById(Integer id) {
		return epreuveRepo.findById(id).orElseThrow(EpreuveException::new);
	}

	public Epreuve save(Epreuve epreuve) {
		Set<ConstraintViolation<Epreuve>> constraints = validator.validate(epreuve);
		if (!constraints.isEmpty()) {
			throw new EpreuveException("erreur de validation");
		}

		if (epreuve.getId() != null) {
			Epreuve epreuveEnBase = getById(epreuve.getId());
			epreuve.setVersion(epreuveEnBase.getVersion());
		}
		return epreuveRepo.save(epreuve);
	}

	public void delete(Epreuve epreuve) {
		delete(epreuve.getId());
	}

	public void delete(Integer id) {
		epreuveRepo.deleteById(id);
	}
	
}
