package restcontroller;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import CompetitionSport.exception.TerrainException;
import CompetitionSport.model.Adresse;
import CompetitionSport.model.Discipline;
import CompetitionSport.model.JsonViews;
import CompetitionSport.model.Terrain;
import CompetitionSport.model.TypeTerrain;
import CompetitionSport.services.TerrainService;

@RestController
@RequestMapping("/api/terrain")
public class TerrainRestController {
	
	@Autowired
	private TerrainService terrainService;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Terrain> getAll() {
		return terrainService.getAll();
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Terrain getById(@PathVariable Integer id) {
		return terrainService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		terrainService.delete(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Terrain create(@Valid @RequestBody Terrain terrain, BindingResult br) {
		return save(terrain, br);
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Terrain update(@PathVariable Integer id, @Valid @RequestBody Terrain terrain, BindingResult br) {
		terrain.setId(id);
		return save(terrain, br);
	}
	
	private Terrain save(Terrain terrain, BindingResult br) {
		if (br.hasErrors()) {
			throw new TerrainException();
		}
		return terrainService.save(terrain);
	}
	
	@JsonView(JsonViews.Common.class)
	@PatchMapping("/{id}")
	public Terrain partialTerrain(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Terrain terrain = terrainService.getById(id);
		fields.forEach((key, value) -> {
			if (key.equals("adresse")) {
				LinkedHashMap<String, String> adresseMap = (LinkedHashMap<String, String>) value;
				Adresse adresse = new Adresse();
				adresseMap.forEach((k,v)->{
					Field field = ReflectionUtils.findField(Adresse.class, k);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, adresse, v);
					});
				terrain.setAdresse(adresse);	
			} 
			else if(key.equals("typeTerrain")) {
				terrain.setTypeTerrain(TypeTerrain.valueOf(value.toString()));
				}
			else if(key.equals("disciplines")) {
				List<String> disciplineValue = (List<String>) value;
				Set<Discipline> disciplineMap = new HashSet<>();
				for (String d : disciplineValue) {
					disciplineMap.add(Discipline.valueOf(d));
					}
				terrain.setDisciplines(disciplineMap);
				}
			else {
			Field field = ReflectionUtils.findField(Terrain.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, terrain, value);
			}
		});
		return terrainService.save(terrain);
	}
}