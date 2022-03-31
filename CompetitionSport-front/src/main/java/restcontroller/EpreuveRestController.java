package restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import CompetitionSport.exception.AthleteException;
import CompetitionSport.model.Adresse;
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

	private Epreuve save(Epreuve epreuve, BindingResult br) {
		if (br.hasErrors()) {
			throw new AthleteException();
		}
		return epreuveService.save(epreuve);
	}

	@JsonView(JsonViews.EpreuveWithAthlete.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		epreuveService.delete(id);
	}

	@JsonView(JsonViews.EpreuveWithAthlete.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/{id}")
	public Epreuve create(@PathVariable Integer id,@Valid @RequestBody Epreuve epreuve, BindingResult br) {

		return save(epreuve, br);
	}

	@JsonView(JsonViews.EpreuveWithAthlete.class)
	@PutMapping("/{id}")
	public Epreuve update(@PathVariable Integer id, @Valid @RequestBody Epreuve epreuve, BindingResult br) {
		epreuve.setId(id);
		return save(epreuve, br);
	}

	@PatchMapping("/{id}")
	public Epreuve partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Epreuve epreuve = epreuveService.getById(id);
		fields.forEach((k, v) -> {
			if (k.equals("dateDebut")) {
				List<Integer> dateRecuperee = (List<Integer>) v;
				epreuve.setDateDebut(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			}else if (k.equals("dateFin")) {
				List<Integer> dateRecuperee = (List<Integer>) v;
				epreuve.setDateFin(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
		} else {
			Field field = ReflectionUtils.findField(Epreuve.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, epreuve, v);
		}
	});
		return epreuveService.save(epreuve);
}

}
