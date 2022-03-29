package CompetitionSport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CompetitionSport.exception.OrganisateurException;
import CompetitionSport.repositories.OrganisateurRepository;
import CompetitionSport.model.Organisateur;

@Service
public class OrganisateurService {
	@Autowired
	private OrganisateurRepository organisateurRepo;

	public List<Organisateur> getAll() {
		return organisateurRepo.findAll();
	}

	public Organisateur getById(Integer id) {
		return organisateurRepo.findById(id).orElseThrow(() -> {
			throw new OrganisateurException("numero inconnu");
		});
	}
	
	public void save(Organisateur organisateur){
		if (organisateur.getId() != null) {
			Organisateur organisateurEnBase = getById(organisateur.getId());
			organisateur.setVersion(organisateurEnBase.getVersion());
		}

		organisateurRepo.save(organisateur);
	}

	public void delete(Organisateur organisateur) {
		delete(organisateur.getId());
	}
	
	public void delete(Integer id) {
		organisateurRepo.deleteById(id);
	}
}
