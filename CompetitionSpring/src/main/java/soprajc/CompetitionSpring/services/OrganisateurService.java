package soprajc.CompetitionSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.OrganisateurException;
import soprajc.CompetitionSpring.model.Organisateur;
import soprajc.CompetitionSpring.repositories.OrganisateurRepository;

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
	
	public Organisateur save(Organisateur organisateur){
		if (organisateur.getId() != null) {
			Organisateur organisateurEnBase = getById(organisateur.getId());
			organisateur.setVersion(organisateurEnBase.getVersion());
		}

		return organisateurRepo.save(organisateur);
	}

	public void delete(Organisateur organisateur) {
		deleteById(organisateur.getId());
	}
	
	public void deleteById(Integer id) {
		organisateurRepo.deleteById(id);
	}
}
