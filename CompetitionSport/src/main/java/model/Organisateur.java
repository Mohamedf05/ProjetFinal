package model;

import java.time.LocalDate;

public class Organisateur {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String password;
	private Adresse adresse;
	private String raisonSoc;
	private Terrain terrain;
	private Logement logement;
	
	
	
	public Organisateur(Integer id, String nom, String prenom, String password, Adresse adresse, String raisonSoc,
			Terrain terrain, Logement logement) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.adresse = adresse;
		this.raisonSoc = raisonSoc;
		this.terrain = terrain;
		this.logement = logement;
	}

	public Organisateur(String nom, String prenom, String password, String numero, String voie, String ville, String cp, String raisonSoc, Terrain terrain, Logement logement) {
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.adresse = new Adresse(numero,voie,ville,cp);
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


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public String getRaisonSoc() {
		return raisonSoc;
	}


	public void setRaisonSoc(String raisonSoc) {
		this.raisonSoc = raisonSoc;
	}
	
	public static Evenement creer(String nom, LocalDate dateDebut, LocalDate dateFin, String ville, boolean statut)
	{
		Evenement event = new Evenement(nom, dateDebut, dateFin, ville, statut);
		return event;
	}
	
	public static void modifier(Evenement)
	{
		
	}
	
	public static void supprimer(Evenement)
	{
		
	}
	
	@Override
	public String toString() {
		return "Organisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password
				+ ", adresse=" + adresse + ", raisonSoc=" + raisonSoc+ "]";
	
}
