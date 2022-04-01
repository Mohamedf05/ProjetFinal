package CompetitionSport.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Athlete extends Compte {
	
	@NotNull
	@JsonView(JsonViews.Common.class)
	private LocalDate dateNaissance;
	
	@ManyToMany(mappedBy = "participants")
	@JsonView(JsonViews.AthleteEpreuve.class)
	private List<Epreuve> epreuves;

	public Athlete() {
	}
	
	public Athlete(Integer id, String nom, String prenom, String mail, String password, String numero, String voie, String ville, String cp,
			LocalDate dateNaissance) {
		super(id, nom, prenom, mail, password, numero,voie,ville,cp);
		this.setDateNaissance(dateNaissance);
	}
	
	public Athlete(String nom, String prenom, String mail, String password,String numero, String voie, String ville, String cp,
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

	public List<Epreuve> getEpreuves() {
		return epreuves;
	}

	public void setEpreuves(List<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}
	
	@Override
	public String toString() {
		return "Athlete [dateNaissance=" + dateNaissance + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", mail=" + mail + ", password=" + password + ", adresse=" + adresse + "]";
	}
	
}
