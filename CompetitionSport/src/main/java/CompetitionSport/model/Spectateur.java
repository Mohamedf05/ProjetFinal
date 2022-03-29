package CompetitionSport.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Spectateur extends Compte {
	
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private LocalDate dateNaissance;

	public Spectateur() {
	}
	
	public Spectateur(Integer id, String nom, String prenom, String mail, String password, String numero, String voie, String ville, String cp,
			LocalDate dateNaissance) {
		super(id, nom, prenom, mail, password, numero,voie,ville,cp);
		this.setDateNaissance(dateNaissance);
	}
	
	public Spectateur(String nom, String prenom, String mail, String password, String numero, String voie, String ville, String cp,
			LocalDate dateNaissance) {
		super(nom, prenom, mail, password, numero,voie,ville,cp);
		this.setDateNaissance(dateNaissance);
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Spectateur [dateNaissance=" + dateNaissance + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", mail=" + mail + ", password=" + password + ", adresse=" + adresse + "]";
	}

}
