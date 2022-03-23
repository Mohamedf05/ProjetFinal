package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import CompetitionSport.config.AppConfig;
import CompetitionSport.exception.OrganisateurException;
import CompetitionSport.model.Organisateur;
import CompetitionSport.services.OrganisateurService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {AppConfig.class})
public class TestRepos {

	@Autowired
	OrganisateurService organisateurService;
	
	@Test
	void testEchecCreate(){
		assertThrows(OrganisateurException.class, ()->{
			organisateurService.create(new Organisateur());
		});
	}
	
	@Test
	@Transactional
	void creationOrganisateurTest(){
		Organisateur o = new Organisateur("Orga", "orga", "orga@orga", "orga8", "1", "orgavoie", "orgaVilel", "75698", "Ajc");
		organisateurService.create(o);
		assertNotNull(o.getId());
	}
}
