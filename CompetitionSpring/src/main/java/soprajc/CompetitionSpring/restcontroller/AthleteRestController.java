package soprajc.CompetitionSpring.restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import soprajc.CompetitionSpring.exception.AthleteException;
import soprajc.CompetitionSpring.model.Adresse;
import soprajc.CompetitionSpring.model.Athlete;
import soprajc.CompetitionSpring.model.Epreuve;
import soprajc.CompetitionSpring.model.JsonViews;
import soprajc.CompetitionSpring.model.Reservation;
import soprajc.CompetitionSpring.repositories.CompteRepository;
import soprajc.CompetitionSpring.services.AthleteService;


@RestController
@RequestMapping("/api/athlete")
@CrossOrigin(origins = "*")
public class AthleteRestController {

	@Autowired
	private AthleteService athleteService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CompteRepository compteRepo;

	@GetMapping("/search/{email}")
	@JsonView(JsonViews.Common.class)
	public boolean checkEmail(@PathVariable String email) {
		return compteRepo.findByMail(email).isPresent();
	}

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Athlete> getAll() {
		return athleteService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Athlete getById(@PathVariable Integer id) {
		return (Athlete) athleteService.getById(id);
	}

	@GetMapping("/{id}/epreuve")
	@JsonView(JsonViews.AthleteEpreuve.class)
	public List<Epreuve> getByIdWithEpreuve(@PathVariable Integer id) {
		return athleteService.getByIdWithEpreuve(id);
	}

	@GetMapping("/{id}/reservation")
	@JsonView(JsonViews.CompteWithReservation.class)
	public List<Reservation> getByIdWithReservation(@PathVariable Integer id) {
		return athleteService.getByIdWithReservation(id);
	}

	private Athlete save(Athlete athlete, BindingResult br) {
		if (br.hasErrors()) {
			throw new AthleteException();
		}
		return athleteService.save(athlete);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Athlete create(@Valid @RequestBody Athlete athlete, BindingResult br) {
		athlete.setPassword(passwordEncoder.encode(athlete.getPassword()));
		return save(athlete, br);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		athleteService.deleteById(id);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Athlete update(@PathVariable Integer id, @Valid @RequestBody Athlete athlete, BindingResult br) {
		athlete.setId(id);
		athlete.setPassword(athleteService.getById(id).getPassword());
		return save(athlete, br);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Athlete partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Athlete athlete = athleteService.getById(id);
		fields.forEach((key, value) -> {

			if (key.equals("dateNaissance")) {
				List<Integer> dateRecuperee = (List<Integer>) value;
				athlete.setDateNaissance(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} 
			else if (key.equals("adresse")) {
				LinkedHashMap<String, String> adresseMap = (LinkedHashMap<String, String>) value;
				Adresse adresse = new Adresse();
				adresseMap.forEach((k,v)->{
					Field field = ReflectionUtils.findField(Adresse.class, k);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, adresse, v);
				});

				athlete.setAdresse(adresse);}


			else{
				Field field = ReflectionUtils.findField(Athlete.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, athlete, value);}

		});
		return athleteService.save(athlete);
	}
}
