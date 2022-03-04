package model;

import java.time.LocalDate;

public class Evenement {
	
	private Integer id;
	private String nom;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String ville;
	private boolean statut;
	
	
	
	public Evenement(Integer id, String nom, LocalDate dateDebut, LocalDate dateFin, String ville, boolean statut) {
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.ville = ville;
		this.statut = statut;
	}

	public Evenement(String nom, LocalDate dateDebut, LocalDate dateFin, String ville, boolean statut) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.ville = ville;
		this.statut = statut;
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

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Evenement [id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", ville="
				+ ville + ", statut=" + statut + "]";
	}
	
}
