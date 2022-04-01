package CompetitionSport.model;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Organisateur extends Compte {

	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private String raisonSoc;
	
	@OneToMany
	private List<Terrain> terrains;
	
	@OneToMany
	private List<Logement> logements;
	/*
	@ElementCollection()
	@Enumerated(EnumType.STRING)
	private List<Discipline> disciplines;*/
	
	@OneToMany(mappedBy = "organisateur")
	@JsonView(JsonViews.OrganisteurWithEvenements.class)
	private List<Evenement> evenements;
	
	
	public Organisateur() {
	}

	public Organisateur(Integer id, String nom, String prenom, String mail, String password, String numero, String voie, String ville, String cp, String raisonSoc) {
		super(id, nom, prenom, mail, password, numero,voie,ville,cp);
		this.raisonSoc = raisonSoc;
	}

	public Organisateur(String nom, String prenom, String mail, String password, String numero, String voie, String ville, String cp, String raisonSoc) {
		super(nom, prenom, mail, password, numero,voie,ville,cp);
		this.raisonSoc = raisonSoc;
	}

	public String getRaisonSoc() {
		return raisonSoc;
	}

	public void setRaisonSoc(String raisonSoc) {
		this.raisonSoc = raisonSoc;
	}

	public List<Terrain> getTerrains() {
		return terrains;
	}

	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}

	public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	@Override
	public String toString() {
		return "Organisateur [raisonSoc=" + raisonSoc + ", terrains=" + terrains + ", logements=" + logements
				+ "]";
	}


}
