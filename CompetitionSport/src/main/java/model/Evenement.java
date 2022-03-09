package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	@Column(name="date_debut")
	private LocalDate dateDebut;
	@Column(name="date_fin")
	private LocalDate dateFin;
	private String ville;
	private boolean statut;
	@ManyToOne
	@JoinColumn(name="id_organisateur")
	private Organisateur organisateur;
	
	public Evenement (){}
	
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
