package CompetitionSport.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Reservation {
	
	@Id
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('En_Cours','A_Venir','Termine')")
	private Statut statut;
	
	private LocalDate date;
	private LocalTime heure;
	
	@ManyToOne
	@JoinColumn(name="compte_fk")
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name="epreuve_fk")
	private Epreuve epreuve;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('En_Cours','A_Venir','Termine')")
	private TypeLogement logement;
	
	@Version
	protected int version;
	
	public Reservation() {
	}
	
	public Reservation(Compte compte, Epreuve epreuve, TypeLogement logement) {
		this.compte = compte;
		this.epreuve = epreuve;
		this.logement = logement;
		this.statut=Statut.A_Venir;
		this.date=LocalDate.now();
		this.heure=LocalTime.now();
	}
	

	public Reservation(Compte compte, Epreuve epreuve) {
		this.compte = compte;
		this.epreuve = epreuve;
		this.statut=Statut.A_Venir;
		this.date=LocalDate.now();
		this.heure=LocalTime.now();
	}


	public Integer getId() {
		return id;
	}


	public Statut getStatut() {
		return statut;
	}


	public LocalDate getDate() {
		return date;
	}


	public LocalTime getHeure() {
		return heure;
	}


	public Compte getCompte() {
		return compte;
	}


	public Epreuve getEpreuve() {
		return epreuve;
	}


	public TypeLogement getLogement() {
		return logement;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setStatut(Statut statut) {
		this.statut = statut;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}


	public void setLogement(TypeLogement logement) {
		this.logement = logement;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", statut=" + statut + ", date=" + date + ", heure=" + heure + ", compte="
				+ compte + ", epreuve=" + epreuve + ", logement=" + logement + "]";
	}
	
	
	
	

}
