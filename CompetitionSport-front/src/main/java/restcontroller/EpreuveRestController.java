package restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import CompetitionSport.model.Athlete;
import CompetitionSport.model.Epreuve;
import CompetitionSport.model.Evenement;
import CompetitionSport.model.JsonViews;
import CompetitionSport.model.Organisateur;
import CompetitionSport.model.Reservation;
import CompetitionSport.services.EpreuveService;

@RestController
@RequestMapping("/api/epreuve")
public class EpreuveRestController {
	@Autowired
	EpreuveService epreuveService;
	
	@GetMapping("")
	public List<Epreuve> getAll()
	{
		return epreuveService.getAll();
	}
	
	@JsonView(JsonViews.EpreuveWithAthlete.class)
	@GetMapping("/{id}/participants")
	public List<Athlete> getAllParticipant(@PathVariable Integer id)
	{
		Epreuve epreuve=epreuveService.getById(id); 
		return epreuve.getParticipants();
	}
	@JsonView(JsonViews.EpreuveWithReservation.class)
	@GetMapping("/{id}/reservations")
	public List<Reservation> getAllReservations(@PathVariable Integer id)
	{
		Epreuve epreuve=epreuveService.getById(id); 
		return epreuve.getReservations();
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		epreuveService.delete(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/{id}")
	public Epreuve create(@PathVariable Integer id,@Valid @RequestBody Epreuve epreuve, BindingResult br) {
		
				return save(evenement, br);
	}
	

}
