package soprajc.CompetitionSpring.restcontroller;

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

import soprajc.CompetitionSpring.exception.EvenementException;
import soprajc.CompetitionSpring.model.Epreuve;
import soprajc.CompetitionSpring.model.Evenement;
import soprajc.CompetitionSpring.model.JsonViews;
import soprajc.CompetitionSpring.model.Organisateur;
import soprajc.CompetitionSpring.model.Statut;
import soprajc.CompetitionSpring.services.EpreuveService;
import soprajc.CompetitionSpring.services.EvenementService;
import soprajc.CompetitionSpring.services.OrganisateurService;


@RestController
@RequestMapping("/api/evenement")
public class EvenementRestController {
	@Autowired
	EvenementService evenementService;
	@Autowired
	OrganisateurService organisateurService;
	@Autowired
	EpreuveService epreuveService;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Evenement> getAll()
	{
		return evenementService.getAll();
	}
	
	@JsonView(JsonViews.EvenementWithOrganisateur.class)
	@GetMapping("/{id}")
	public Evenement getAllByOrganisateur(@PathVariable Integer id)
	{
		return evenementService.getById(id);
	}
	
	@JsonView(JsonViews.EvenementWithEpreuve.class)
	@GetMapping("/epreuves/{id}")
	public List<Epreuve> getAllByEvenement(Integer id)
	{
		return epreuveService.getAllByEvenement(id);
	}
	
//	@JsonView(JsonViews.EvenementWithOrganisateur.class)
//	@GetMapping("/{id}")
//	public List<Evenement> getAllByOrganisateur(@PathVariable Integer id)
//	{
//		return evenementService.getAllbyOrganisateur(id);
//	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		evenementService.delete(id);
	}
	
	@JsonView(JsonViews.EvenementWithOrganisateur.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/{id}")//id organisateur
	public Evenement create(@PathVariable Integer id,@Valid @RequestBody Evenement evenement, BindingResult br) {
		Organisateur organisateur=organisateurService.getById(id);
		evenement.setOrganisateur(organisateur);
				return save(evenement, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.EvenementWithOrganisateur.class)
	public Evenement update(@PathVariable Integer id, @Valid @RequestBody Evenement evenement, BindingResult br) {
		evenement.setId(id);
		Evenement evenementEnBase=evenementService.getById(id);
		evenement.setOrganisateur(evenementEnBase.getOrganisateur());
		return save(evenement, br);
	}

	private Evenement save(Evenement evenement, BindingResult br) {
		if (br.hasErrors()) {
			throw new EvenementException();
		}
		return evenementService.save(evenement);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.EvenementWithOrganisateur.class)
	public Evenement partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields)
	{
		Evenement evenement=evenementService.getById(id);
		fields.forEach((k, v) ->
		{
			if (!k.equals("organisateur"))
			{
				if (k.equals("dateDebut")) {
					List<Integer> dateRecuperee = (List<Integer>) v;
					evenement.setDateDebut(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
				}
				else if(k.equals("dateFin")) {
					List<Integer> dateRecuperee = (List<Integer>) v;
					evenement.setDateFin(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
				}
				else if(k.equals("statut")){
					evenement.setStatut(Statut.valueOf(v.toString()));
				}
				else{
					Field field = ReflectionUtils.findField(Evenement.class, k);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, evenement, v);
				}
			}
			
		});
		
		return evenementService.save(evenement);
	}
	

}
