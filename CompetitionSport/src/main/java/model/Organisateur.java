package model;

import java.time.LocalDate;

public class Organisateur {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String password;
	private String raisonSoc;
	private Terrain terrain;
	private Logement logement;
	
	
	
	public Organisateur(Integer id, String nom, String prenom, String password, String raisonSoc,
			Terrain terrain, Logement logement) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.raisonSoc = raisonSoc;
		this.terrain = terrain;
		this.logement = logement;
	}

	public Organisateur(String nom, String prenom, String password, String raisonSoc, Terrain terrain, Logement logement) {
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.raisonSoc = raisonSoc;
		this.terrain = terrain;
		this.logement = logement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRaisonSoc() {
		return raisonSoc;
	}


	public void setRaisonSoc(String raisonSoc) {
		this.raisonSoc = raisonSoc;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	@Override
	public String toString() {
		return "Organisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password
				+ ", raisonSoc=" + raisonSoc + ", terrain=" + terrain + ", logement=" + logement + "]";
	}
	
	
	
}
