package CompetitionSport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import CompetitionSport.exception.JournalisteException;
import CompetitionSport.model.Journaliste;
import CompetitionSport.repositories.JournalisteRepository;
import CompetitionSport.repositories.ReservationRepository;

public class JournalisteService {
	

	@Autowired
	private JournalisteRepository journalisteRepo;
	@Autowired
	private ReservationRepository reservationRepo;

	public List<Journaliste> getAll() {
		return journalisteRepo.findAll();
	}

	public Journaliste getById(Integer id) {
		return journalisteRepo.findById(id).orElseThrow(JournalisteException::new);
	}

	public Journaliste save(Journaliste journaliste) {
		if (journaliste.getId() != null) {
			Journaliste journalisteEnBase = getById(journaliste.getId());
			journaliste.setVersion(journalisteEnBase.getVersion());
		}
		return journalisteRepo.save(journaliste);
	}

	public void delete(Journaliste journaliste) {
		reservationRepo.setCompteReservationToNull(journaliste);
		Journaliste journalisteEnBase = getById(journaliste.getId());
		reservationRepo.deleteByClient(journalisteEnBase);
		journalisteRepo.delete(journalisteEnBase);
	}

	public void deleteById(Integer id) {
		Journaliste journaliste = new Journaliste();
		journaliste.setId(id);
		delete(journaliste);
	}

}
