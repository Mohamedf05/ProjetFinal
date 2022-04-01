package soprajc.CompetitionSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.CompetitionSpring.exception.SpectateurException;
import soprajc.CompetitionSpring.model.Spectateur;
import soprajc.CompetitionSpring.repositories.CompteRepository;
import soprajc.CompetitionSpring.repositories.ReservationRepository;
import soprajc.CompetitionSpring.repositories.SpectateurRepository;

@Service
public class SpectateurService {

	@Autowired
	private SpectateurRepository spectateurRepo;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ReservationRepository reservationRepo;

	public List<Spectateur> getAll() {
		return spectateurRepo.findAll();
	}

	public Spectateur getById(Integer id) {
		return (Spectateur) compteRepository.findByIdWithReservations(id).orElseThrow(SpectateurException::new);
	}

	public Spectateur save(Spectateur spectateur) {
		if (spectateur.getId() != null) {
			Spectateur spectateurEnBase = getById(spectateur.getId());
			spectateur.setVersion(spectateurEnBase.getVersion());
		}
		return spectateurRepo.save(spectateur);
	}

	public void delete(Spectateur spectateur) {
		reservationRepo.setCompteReservationToNull(spectateur);
		Spectateur spectateurEnBase = getById(spectateur.getId());
		reservationRepo.deleteByClient(spectateurEnBase);
		spectateurRepo.delete(spectateurEnBase);
	}

	public void deleteById(Integer id) {
		Spectateur spectateur = new Spectateur();
		spectateur.setId(id);
		delete(spectateur);
	}
	
}
