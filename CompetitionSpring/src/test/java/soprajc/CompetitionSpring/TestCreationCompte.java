package soprajc.CompetitionSpring;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import soprajc.CompetitionSpring.model.Athlete;
import soprajc.CompetitionSpring.model.Journaliste;
import soprajc.CompetitionSpring.model.Organisateur;
import soprajc.CompetitionSpring.model.Spectateur;
import soprajc.CompetitionSpring.services.AthleteService;
import soprajc.CompetitionSpring.services.JournalisteService;
import soprajc.CompetitionSpring.services.OrganisateurService;
import soprajc.CompetitionSpring.services.SpectateurService;

@SpringBootTest
class TestCreationCompte {
	
	@Autowired
	AthleteService athleteService;
	
	@Autowired
	JournalisteService journalisteService;
	
	@Autowired
	OrganisateurService organisateurService;
	
	@Autowired
	SpectateurService spectateurService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Disabled
	@org.junit.jupiter.api.Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	@Transactional
	@Commit
	void creationAthleteTest() {
		Athlete a = new Athlete("AthleteN", "AthleteP", "athlete@athlete", passwordEncoder.encode("athlete"), "5", "allee de l'athlete", "AthleteV", "42000", LocalDate.parse("2000-03-12"));
		athleteService.save(a);
	}
	
	@Test
	@Transactional
	@Commit
	void creationJournalisteTest() {
		Journaliste j = new Journaliste("JournalisteN", "JournalisteP", "journaliste@journaliste", passwordEncoder.encode("journaliste"), "12bis", "champs des journalistes", "JournalisteV", "97005", "AJC-News");
		journalisteService.save(j);
	}
	
	@Test
	@Transactional
	@Commit
	void creationOrganisateurTest() {
		Organisateur o = new Organisateur("OrganisateurN", "OrganisateurP", "organisateur@organisateur", passwordEncoder.encode("organisateur"), "7bis", "avenue de l'organisateur", "OrganisateurV", "25780", "Jaxx's CREW");
		organisateurService.save(o);
	}
	
	@Test
	@Transactional
	@Commit
	void creationSpectateurTest() {
		Spectateur s = new Spectateur("SpectateurN", "SpectateurP", "spectateur@spectateur", passwordEncoder.encode("spectateur"), "20", "rue du spectateur", "SpectateurV", "85230", LocalDate.parse("1997-03-12"));
		spectateurService.save(s);
	}
}
