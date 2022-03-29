package restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CompetitionSport.services.TerrainService;

@RestController
@RequestMapping("/api/terrain")
public class TerrainRestController {
	
	@Autowired
	private TerrainService terrainService;

}
