package model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Organisateur extends Client {

	private String raisonSoc;
	
	@ManyToMany
	private List<Terrain> terrains;
	
	@ManyToMany
	private transient List<Logement> logements;
	
	@ElementCollection()
	@Enumerated(EnumType.STRING)
	private List<Discipline> disciplines;
	
	@OneToMany(mappedBy = "organisateur")
	private List<Evenement> evenements;
	
	
	public Organisateur() {
	}

	public Organisateur(Integer id, String nom, String prenom, String mail, String password, Adresse adresse, String raisonSoc) {
		super(id, nom, prenom, mail, password, adresse);
		this.raisonSoc = raisonSoc;
	}

	public Organisateur(String nom, String prenom, String mail, String password, Adresse adresse, String raisonSoc) {
		super(nom, prenom, mail, password, adresse);
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

	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
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
				+ ", disciplines=" + disciplines + "]";
	}


}
