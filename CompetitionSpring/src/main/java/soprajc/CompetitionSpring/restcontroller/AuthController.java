package soprajc.CompetitionSpring.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soprajc.CompetitionSpring.model.Compte;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	
	@GetMapping("")
	public String auth(@AuthenticationPrincipal Compte compte) {
		return compte.getClass().getSimpleName().toLowerCase();
	}
	
	@GetMapping("/obj")
	public Compte authObj(@AuthenticationPrincipal Compte compte) {
		return compte;
	}
}
