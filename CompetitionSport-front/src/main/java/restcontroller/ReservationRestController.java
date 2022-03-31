package restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import CompetitionSport.exception.ReservationException;
import CompetitionSport.model.JsonViews;
import CompetitionSport.model.Reservation;
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
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}
	
	@JsonView(JsonViews.Common.class)
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
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Reservation create(@Valid @RequestBody Reservation reservation, BindingResult br) {
		return save(reservation, br);}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Reservation update(@PathVariable Integer id, @Valid @RequestBody Reservation reservation, BindingResult br) {
		reservation.setId(id);
		return save(reservation, br);
	}
	
	
	
	
	
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		reservationService.delete(id);
	}
	
}
