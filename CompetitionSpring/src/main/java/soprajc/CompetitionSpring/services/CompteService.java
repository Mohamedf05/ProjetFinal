package soprajc.CompetitionSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.repositories.CompteRepository;
import soprajc.CompetitionSpring.repositories.ReservationRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository clientRepository;
	
	@Autowired 
	private ReservationRepository reservationRepository;
	
	
}
