package restcontroller;

import java.lang.reflect.Field;
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

import CompetitionSport.exception.JournalisteException;
import CompetitionSport.model.Adresse;
import CompetitionSport.model.Journaliste;
import CompetitionSport.model.JsonViews;
import CompetitionSport.services.JournalisteService;


@RestController
@RequestMapping("/api/journaliste")
public class JournalisteRestController {

	@Autowired
	private JournalisteService journalisteService;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Journaliste> getAll() {
		return journalisteService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Journaliste getById(@PathVariable Integer id) {
		return journalisteService.getById(id);
	}
	
	private Journaliste save(Journaliste journaliste, BindingResult br) {
		if (br.hasErrors()) {
			throw new JournalisteException();
		}
		return journalisteService.save(journaliste);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Journaliste create(@Valid @RequestBody Journaliste journaliste, BindingResult br) {
		return save(journaliste, br);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@JsonView(JsonViews.Common.class)
	public void delete(@PathVariable Integer id) {
		journalisteService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Journaliste update(@PathVariable Integer id, @Valid @RequestBody Journaliste journaliste, BindingResult br) {
		journaliste.setId(id);
		return save(journaliste, br);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Journaliste partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Journaliste journaliste = journalisteService.getById(id);
		fields.forEach((k, v) -> {
		
			if (k.equals("adresse")) {
				List <String> adresseRecuperee = (List<String>) v;
				Adresse adresse = new Adresse();
				adresse.setNumero(adresseRecuperee.get(0));
				adresse.setVoie(adresseRecuperee.get(1));
				adresse.setVille(adresseRecuperee.get(2));
				adresse.setCp(adresseRecuperee.get(3));
				journaliste.setAdresse(adresse);
				
			} else {
				Field field = ReflectionUtils.findField(Journaliste.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, journaliste, v);
			}
		});
		return journalisteService.save(journaliste);
	}
}
