package soprajc.CompetitionSpring.restcontroller;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
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

import soprajc.CompetitionSpring.exception.LogementException;
import soprajc.CompetitionSpring.model.Adresse;
import soprajc.CompetitionSpring.model.JsonViews;
import soprajc.CompetitionSpring.model.Logement;
import soprajc.CompetitionSpring.model.TypeLogement;
import soprajc.CompetitionSpring.services.LogementService;

@RestController
@RequestMapping("/api/logement")
public class LogementRestController {

	@Autowired
	private LogementService logementService;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Logement> getAll() {
		return logementService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Logement getById(@PathVariable Integer id) {
		return logementService.getById(id);
	}

	private Logement save(Logement logement, BindingResult br) {
		if (br.hasErrors()) {
			throw new LogementException();
		}
		return logementService.save(logement);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	public Logement create(@Valid @RequestBody Logement logement, BindingResult br) {
		return save(logement, br);
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Logement update(@PathVariable Integer id, @Valid @RequestBody Logement logement, BindingResult br) {
		logement.setId(id);
		return save(logement, br);
	}

	@JsonView(JsonViews.Common.class)
	@PatchMapping("/{id}")
	public Logement partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Logement logement = logementService.getById(id);
		fields.forEach((key,value)->{
			if (key.equals("adresse")) {
		LinkedHashMap<String, String> adresseMap = (LinkedHashMap<String, String>) value;
				Adresse adresse = new Adresse();
				adresseMap.forEach((k,v)->{
					Field field = ReflectionUtils.findField(Adresse.class, k);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, adresse, v);
					});
				logement.setAdresse(adresse);}
				
			else if(key.equals("typeLogement")){
				logement.setTypeLogement(TypeLogement.valueOf(value.toString()));
			}
				
			else{
			Field field = ReflectionUtils.findField(Logement.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, logement, value);}
		});
		return logementService.save(logement);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		logementService.delete(id);
	}

}