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

import soprajc.CompetitionSpring.exception.SpectateurException;
import soprajc.CompetitionSpring.model.Adresse;
import soprajc.CompetitionSpring.model.JsonViews;
import soprajc.CompetitionSpring.model.Spectateur;
import soprajc.CompetitionSpring.services.SpectateurService;


@RestController
@RequestMapping("/api/spectateur")
@CrossOrigin(origins = "*")
public class SpectateurRestController {

	@Autowired
	private SpectateurService spectateurService;
	@Autowired
	private PasswordEncoder passwordEncoder;

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
	
	@GetMapping("/{id}/reservation")
	@JsonView(JsonViews.CompteWithReservation.class)
	public Spectateur getByIdSpectateur(@PathVariable Integer id) {
		return spectateurService.getById(id);
	}

	private Spectateur save(Spectateur spectateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new SpectateurException();
		}
		spectateur.setPassword(passwordEncoder.encode(spectateur.getPassword()));
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
		fields.forEach((key, value) -> {
			if (key.equals("dateNaissance")) {
				List<Integer> dateRecuperee = (List<Integer>) value;
				spectateur.setDateNaissance(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} 
			else if (key.equals("adresse")) {
				LinkedHashMap<String, String> adresseMap = (LinkedHashMap<String, String>) value;
				Adresse adresse = new Adresse();
				adresseMap.forEach((k,v)->{
					Field field = ReflectionUtils.findField(Adresse.class, k);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, adresse, v);
				});

				spectateur.setAdresse(adresse);}


			else{
				Field field = ReflectionUtils.findField(Spectateur.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, spectateur, value);}
		});
		return spectateurService.save(spectateur);
	}
}
