package soprajc.CompetitionSpring.restcontroller;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import soprajc.CompetitionSpring.exception.OrganisateurException;
import soprajc.CompetitionSpring.model.Adresse;
import soprajc.CompetitionSpring.model.Compte;
import soprajc.CompetitionSpring.model.Evenement;
import soprajc.CompetitionSpring.model.JsonViews;
import soprajc.CompetitionSpring.model.Logement;
import soprajc.CompetitionSpring.model.Organisateur;
import soprajc.CompetitionSpring.model.Reservation;
import soprajc.CompetitionSpring.repositories.CompteRepository;
import soprajc.CompetitionSpring.repositories.OrganisateurRepository;
import soprajc.CompetitionSpring.services.EvenementService;
import soprajc.CompetitionSpring.services.OrganisateurService;


@RestController
@RequestMapping("/api/organisateur")
@CrossOrigin(origins = "*")
public class OrganisateurRestController {

	@Autowired
	private OrganisateurService organisateurService;
	@Autowired
	private EvenementService evenementService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private OrganisateurRepository organisateurRepo;
	
	@GetMapping("/search/{email}")
	@JsonView(JsonViews.Common.class)
	public boolean checkEmail(@PathVariable String email) {
		return compteRepo.findByMail(email).isPresent();
	}

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
	@GetMapping("/login/{login}")
	@JsonView(JsonViews.Common.class)
	public Optional<Organisateur> getByLogin(@PathVariable String login) {
		return organisateurRepo.findByMail(login);
	}
	
	@GetMapping("/{id}/reservation")
	@JsonView(JsonViews.CompteWithReservation.class)
	public List<Reservation> getByIdWithReservation(@PathVariable Integer id) {
		return organisateurService.getByIdWithReservation(id);
	}
	
	@GetMapping("/{id}/evenement")
	@JsonView(JsonViews.OrganisteurWithEvenements.class)
	public List<Evenement> getByIdWithEvenement(@PathVariable Integer id) {
		return evenementService.getAllbyOrganisateur(id);
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
		organisateur.setPassword(passwordEncoder.encode(organisateur.getPassword()));
		return save(organisateur, br);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		organisateurService.deleteById(id);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Organisateur update(@PathVariable Integer id, @Valid @RequestBody Organisateur organisateur, BindingResult br) {

		Organisateur organisateurEnBase = organisateurService.getById(id);
		organisateur.setTerrains(organisateurEnBase.getTerrains());	

		organisateur.setLogements(organisateurEnBase.getLogements());	

		organisateur.setEvenements(organisateurEnBase.getEvenements());	

		organisateur.setId(id);
		
		organisateur.setPassword(organisateurService.getById(id).getPassword());
		return save(organisateur, br);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Organisateur partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Organisateur organisateur = organisateurService.getById(id);
		fields.forEach((key, value) -> {

			if (!(key.equals("terrains") || key.equals("logements") || key.equals("evenements"))) {
				if (key.equals("adresse")) {
					LinkedHashMap<String, String> adresseMap = (LinkedHashMap<String, String>) value;
					Adresse adresse = new Adresse();
					adresseMap.forEach((k,v)->{
						Field field = ReflectionUtils.findField(Adresse.class, k);
						ReflectionUtils.makeAccessible(field);
						ReflectionUtils.setField(field, adresse, v);
					});

					organisateur.setAdresse(adresse);}


				else{
					Field field = ReflectionUtils.findField(Logement.class, key);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, organisateur, value);}
			}

		});
		return organisateurService.save(organisateur);
	}

}
