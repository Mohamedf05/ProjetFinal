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

import CompetitionSport.exception.ReservationException;
import CompetitionSport.model.Evenement;
import CompetitionSport.model.JsonViews;
import CompetitionSport.model.Reservation;
import CompetitionSport.model.Statut;
import CompetitionSport.services.CompteService;
import CompetitionSport.services.EpreuveService;
import CompetitionSport.services.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private CompteService compteService;
	
	@Autowired
	private EpreuveService epreuveService;
	
	@JsonView(JsonViews.ReservationWithEpreuve.class)
	@GetMapping("")
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}
	
	@JsonView(JsonViews.ReservationWithEpreuve.class)
	@GetMapping("/{id}")
	public Reservation getById(@PathVariable Integer id) {
		return reservationService.getById(id);
	}

	
	public Reservation save(Reservation reservation, BindingResult br) {
		if(br.hasErrors()) {
			throw new ReservationException();	
		}
		return reservationService.save(reservation);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.ReservationWithEpreuve.class)
	@PostMapping("")
	public Reservation create(@Valid @RequestBody Reservation reservation, BindingResult br) {
		return save(reservation, br);}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Reservation update(@PathVariable Integer id, @Valid @RequestBody Reservation reservation, BindingResult br) {
		reservation.setId(id);
		return save(reservation, br);
	}
	
	
	@JsonView(JsonViews.Common.class)
	@PatchMapping("/{id}")
	public Reservation partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields)
	{
		Reservation reservation=reservationService.getById(id);
		fields.forEach((k, v) ->
		{
				if (k.equals("dateDebut")) {
					List<Integer> dateRecuperee = (List<Integer>) v;
					reservation.setDateDebut(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
				}
				else if(k.equals("dateFin")) {
					List<Integer> dateRecuperee = (List<Integer>) v;
					reservation.setDateFin(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
				}
				else if (k.equals("statut")){
					reservation.setStatut(Statut.valueOf(v.toString()));
				}
				
			
		});
		
		return reservationService.save(reservation);
	}
	
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		reservationService.delete(id);
	}
	
}
