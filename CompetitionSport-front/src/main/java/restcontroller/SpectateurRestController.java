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

import CompetitionSport.exception.SpectateurException;
import CompetitionSport.model.Adresse;
import CompetitionSport.model.JsonViews;
import CompetitionSport.model.Organisateur;
import CompetitionSport.model.Spectateur;
import CompetitionSport.services.SpectateurService;


@RestController
@RequestMapping("/api/spectateur")
public class SpectateurRestController {

	@Autowired
	private SpectateurService spectateurService;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Spectateur> getAll() {
		return spectateurService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Spectateur getById(@PathVariable Integer id) {
		return spectateurService.getById(id);
	}
	
	private Spectateur save(Spectateur spectateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new SpectateurException();
		}
		return spectateurService.save(spectateur);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Spectateur create(@Valid @RequestBody Spectateur spectateur, BindingResult br) {
		return save(spectateur, br);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@JsonView(JsonViews.Common.class)
	public void delete(@PathVariable Integer id) {
		spectateurService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Spectateur update(@PathVariable Integer id, @Valid @RequestBody Spectateur spectateur, BindingResult br) {
		spectateur.setId(id);
		return save(spectateur, br);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Spectateur partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Spectateur spectateur = spectateurService.getById(id);
		fields.forEach((k, v) -> {
			if (k.equals("dateNaissance")) {
				List<Integer> dateRecuperee = (List<Integer>) v;
				spectateur.setDateNaissance(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} else if (k.equals("adresse")) {
				List <String> adresseRecuperee = (List<String>) v;
				Adresse adresse = new Adresse();
				adresse.setNumero(adresseRecuperee.get(0));
				adresse.setVoie(adresseRecuperee.get(1));
				adresse.setVille(adresseRecuperee.get(2));
				adresse.setCp(adresseRecuperee.get(3));
				spectateur.setAdresse(adresse);
				
			} else {
				Field field = ReflectionUtils.findField(Spectateur.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, spectateur, v);
			}
		});
		return spectateurService.save(spectateur);
	}
}
