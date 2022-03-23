package CompetitionSport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CompetitionSport.exception.OrganisateurException;
import CompetitionSport.repositories.OrganisateurRepository;
import CompetitionSport.model.Organisateur;

@Service
public class OrganisateurService {
@Autowired
private OrganisateurRepository organisateurRepository;

public void create(Organisateur o){
    if (o.getId() != null) {
			throw new OrganisateurException("le numero ne doit pas etre defini");
		}
		if (o.getMail() == null || o.getMail().isEmpty()) {
			throw new OrganisateurException("le mail doit etre defini");
		}
		organisateurRepository.save(o);
	}

public void update(Organisateur o) {
		if (o.getId() == null) {
			throw new OrganisateurException("le numero doit etre defini");
		}
		if (o.getMail() == null ||o.getMail().isEmpty()) {
			throw new OrganisateurException("le mail doit etre defini");
		}
		organisateurRepository.save(o);
	}


}
