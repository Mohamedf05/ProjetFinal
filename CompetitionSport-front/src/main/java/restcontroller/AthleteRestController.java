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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import CompetitionSport.exception.AthleteException;
import CompetitionSport.model.Adresse;
import CompetitionSport.model.Athlete;
import CompetitionSport.model.JsonViews;
import CompetitionSport.services.AthleteService;


@RestController
@RequestMapping("/api/athlete")
public class AthleteRestController {

	@Autowired
	private AthleteService athleteService;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Athlete> getAll() {
		return athleteService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Athlete getById(@PathVariable Integer id) {
		return athleteService.getById(id);
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
		return save(athlete, br);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@JsonView(JsonViews.Common.class)
	public void delete(@PathVariable Integer id) {
		athleteService.deleteById(id);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Athlete partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Athlete athlete = athleteService.getById(id);
		fields.forEach((k, v) -> {
			if (k.equals("dateNaissance")) {
				List<Integer> dateRecuperee = (List<Integer>) v;
				athlete.setDateNaissance(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} else if (k.equals("adresse")) {
				List <String> adresseRecuperee = (List<String>) v;
				Adresse adresse = new Adresse();
				adresse.setNumero(adresseRecuperee.get(0));
				adresse.setVoie(adresseRecuperee.get(1));
				adresse.setVille(adresseRecuperee.get(2));
				adresse.setCp(adresseRecuperee.get(3));
				athlete.setAdresse(adresse);
				
			} else {
				Field field = ReflectionUtils.findField(Athlete.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, athlete, v);
			}
		});
		return athleteService.save(athlete);
	}
}
