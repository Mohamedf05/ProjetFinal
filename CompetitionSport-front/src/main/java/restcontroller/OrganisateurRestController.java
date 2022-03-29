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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import CompetitionSport.exception.OrganisateurException;
import CompetitionSport.model.Adresse;
import CompetitionSport.model.JsonViews;
import CompetitionSport.model.Organisateur;
import CompetitionSport.model.Spectateur;
import CompetitionSport.services.OrganisateurService;


@RestController
@RequestMapping("/api/organisateur")
public class OrganisateurRestController {

	@Autowired
	private OrganisateurService organisateurService;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Organisateur> getAll() {
		return organisateurService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Organisateur getById(@PathVariable Integer id) {
		return organisateurService.getById(id);
	}
	
	private Organisateur save(Organisateur organisateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new OrganisateurException();
		}
		return organisateurService.save(organisateur);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Organisateur create(@Valid @RequestBody Organisateur organisateur, BindingResult br) {
		return save(organisateur, br);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@JsonView(JsonViews.Common.class)
	public void delete(@PathVariable Integer id) {
		organisateurService.deleteById(id);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Organisateur partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Organisateur organisateur = organisateurService.getById(id);
		fields.forEach((k, v) -> {
			if (k.equals("adresse")) {
				List <String> adresseRecuperee = (List<String>) v;
				Adresse adresse = new Adresse();
				adresse.setNumero(adresseRecuperee.get(0));
				adresse.setVoie(adresseRecuperee.get(1));
				adresse.setVille(adresseRecuperee.get(2));
				adresse.setCp(adresseRecuperee.get(3));
				organisateur.setAdresse(adresse);
				
			} else {
				Field field = ReflectionUtils.findField(Spectateur.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, organisateur, v);
			}
		});
		return organisateurService.save(organisateur);
	}
	
}
