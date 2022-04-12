package soprajc.CompetitionSpring;

import org.springframework.beans.factory.annotation.Autowired;

import soprajc.CompetitionSpring.model.Athlete;
import soprajc.CompetitionSpring.model.Epreuve;
import soprajc.CompetitionSpring.services.AthleteService;
import soprajc.CompetitionSpring.services.EpreuveService;

public class TestEpreuve {


	@Autowired
	EpreuveService epreuveService;
	@Autowired
	AthleteService athleteService;



	Epreuve epreuve=epreuveService.getById(1);
	//Athlete athlete = athleteService.getById(26);

	







}
