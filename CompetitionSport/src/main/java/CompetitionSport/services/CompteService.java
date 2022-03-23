package CompetitionSport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CompetitionSport.repositories.*;

@Service
public class CompteService {

	@Autowired
	private CompteRepository clientRepository;
	
	@Autowired 
	private ReservationRepository reservationRepository;
	
	
}
