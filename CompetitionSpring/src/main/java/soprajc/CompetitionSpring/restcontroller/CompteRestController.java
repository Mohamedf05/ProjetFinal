package soprajc.CompetitionSpring.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprajc.CompetitionSpring.model.Compte;
import soprajc.CompetitionSpring.model.JsonViews;


@RestController
@RequestMapping("/api/auth/obj")
@CrossOrigin(origins = "*")
public class CompteRestController {
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public Compte authObj(@AuthenticationPrincipal Compte compte) {
		return compte;
	}
	
}
