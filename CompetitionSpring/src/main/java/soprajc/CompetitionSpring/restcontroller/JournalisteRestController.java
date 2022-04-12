package soprajc.CompetitionSpring.restcontroller;

import java.lang.reflect.Field;
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

import soprajc.CompetitionSpring.exception.JournalisteException;
import soprajc.CompetitionSpring.model.Adresse;
import soprajc.CompetitionSpring.model.Journaliste;
import soprajc.CompetitionSpring.model.JsonViews;
import soprajc.CompetitionSpring.model.Reservation;
import soprajc.CompetitionSpring.repositories.CompteRepository;
import soprajc.CompetitionSpring.services.JournalisteService;


@RestController
@RequestMapping("/api/journaliste")
@CrossOrigin(origins = "*")
public class JournalisteRestController {

	@Autowired
	private JournalisteService journalisteService;
	
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
	public List<Journaliste> getAll() {
		return journalisteService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Journaliste getById(@PathVariable Integer id) {
		return journalisteService.getById(id);
	}
	
	@GetMapping("/{id}/reservation")
	@JsonView(JsonViews.CompteWithReservation.class)
	public List<Reservation> getByIdWithReservation(@PathVariable Integer id) {
		return journalisteService.getByIdWithReservations(id);
	}
	
	private Journaliste save(Journaliste journaliste, BindingResult br) {
		if (br.hasErrors()) {
			throw new JournalisteException();
		}
		if(journaliste.getPassword()!=null) {
			journaliste.setPassword(passwordEncoder.encode(journaliste.getPassword()));
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
		fields.forEach((key, value) -> {
			if (key.equals("adresse")) {
				LinkedHashMap<String, String> adresseMap = (LinkedHashMap<String, String>) value;
				Adresse adresse = new Adresse();
				adresseMap.forEach((k,v)->{
					Field field = ReflectionUtils.findField(Adresse.class, k);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, adresse, v);
				});

				journaliste.setAdresse(adresse);}


			else{
				Field field = ReflectionUtils.findField(Journaliste.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, journaliste, value);}
		});
		return journalisteService.save(journaliste);
	}
}
