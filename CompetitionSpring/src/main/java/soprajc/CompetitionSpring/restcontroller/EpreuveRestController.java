package soprajc.CompetitionSpring.restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import soprajc.CompetitionSpring.exception.EpreuveException;
import soprajc.CompetitionSpring.model.Athlete;
import soprajc.CompetitionSpring.model.Discipline;
import soprajc.CompetitionSpring.model.Epreuve;
import soprajc.CompetitionSpring.model.Evenement;
import soprajc.CompetitionSpring.model.JsonViews;
import soprajc.CompetitionSpring.model.Reservation;
import soprajc.CompetitionSpring.model.Terrain;
import soprajc.CompetitionSpring.services.AthleteService;
import soprajc.CompetitionSpring.services.EpreuveService;
import soprajc.CompetitionSpring.services.EvenementService;
import soprajc.CompetitionSpring.services.TerrainService;

@RestController
@RequestMapping("/api/epreuve")
@CrossOrigin(origins = "*")
public class EpreuveRestController {
	@Autowired
	EpreuveService epreuveService;
	@Autowired
	EvenementService evenementService;
	@Autowired
	TerrainService terrainService;
	
	@Autowired
	AthleteService athleteService;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Epreuve> getAll()
	{
		return epreuveService.getAll();
	}
	
	@JsonView(JsonViews.EpreuveWithEvenement.class)
	@GetMapping("/evenement/{id}")
	public List<Epreuve> getByEvenement(@PathVariable Integer id)
	{
		return epreuveService.getAllByEvenement(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Epreuve getById(@PathVariable Integer id)
	{
		return epreuveService.getById(id);
	}
	
	@JsonView(JsonViews.EpreuveWithAthlete.class)
	@GetMapping("/participants/{id}")
	public List<Athlete> getAllParticipant(@PathVariable Integer id)
	{
		return athleteService.getAllByEpreuve(id);
	}
	@JsonView(JsonViews.EpreuveWithReservation.class)
	@GetMapping("/{id}/reservations")
	public List<Reservation> getAllReservations(@PathVariable Integer id)
	{
		Epreuve epreuve=epreuveService.getById(id); 
		return epreuve.getReservations();
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		epreuveService.delete(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/{id}")//id de l'evenement
	public Epreuve create(@PathVariable Integer id,@Valid @RequestBody Epreuve epreuve, BindingResult br) {
		Evenement evenementEnBase=evenementService.getById(id);
		epreuve.setEvenement(evenementEnBase);
		return save(epreuve,br);
				
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")//id de l'epreuve
	public Epreuve update(@PathVariable Integer id,@Valid @RequestBody Epreuve epreuve, BindingResult br)
	{
		Epreuve epreuveEnBase=epreuveService.getById(id);
		epreuve.setEvenement(epreuveEnBase.getEvenement());
		epreuve.setId(id);
		return save(epreuve,br);
	}
	
	private Epreuve save(Epreuve epreuve,BindingResult br)
	{
		if(br.hasErrors()) {
			throw new EpreuveException();
		}
		return epreuveService.save(epreuve);
	}
	
	@JsonView(JsonViews.Common.class)
	@PatchMapping("/{id}")
	public Epreuve partialUpdate(@PathVariable Integer id,@RequestBody Map<String,Object> fields)
	{
		Epreuve epreuve=epreuveService.getById(id);
		fields.forEach((k,v) ->
		{
			if(!k.equals("evenement"))
			{
				if (k.equals("date")) {
					List<Integer> dateRecuperee = (List<Integer>) v;
					epreuve.setDate(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
				}
				else if(k.equals("discipline")){
					epreuve.setDiscipline(Discipline.valueOf(v.toString()));
				}
				else if(k.equals("terrain"))
				{
					LinkedHashMap<String, Integer> terrainMap = (LinkedHashMap<String, Integer>) v;
					Integer idTerrain=terrainMap.get("id");
					Terrain terrain=terrainService.getById(idTerrain);
					epreuve.setTerrain(terrain);
				}
				else {
					Field field=ReflectionUtils.findField(Epreuve.class, k);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, epreuve, v);
				}
			}
			
		});
		
		return epreuveService.save(epreuve);
	}

}
