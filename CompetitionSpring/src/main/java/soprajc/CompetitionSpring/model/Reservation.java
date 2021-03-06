package soprajc.CompetitionSpring.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Reservation {
	
	@JsonView({JsonViews.Common.class, JsonViews.CompteWithReservation.class})
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonView({JsonViews.Common.class, JsonViews.CompteWithReservation.class})
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('En_Cours','A_Venir','Termine')")
	private Statut statut;
	
	@JsonView({JsonViews.Common.class, JsonViews.CompteWithReservation.class})
	//@NotNull
	private LocalDate date;
	
	@JsonView({JsonViews.Common.class, JsonViews.CompteWithReservation.class})
	//@NotNull
	private LocalTime heure;
	
	//@JsonView(JsonViews.Common.class)
	@ManyToOne
	@JoinColumn(name="compte_fk")
	private Compte compte;
	
	@JsonView(JsonViews.ReservationWithEpreuve.class)
	@ManyToOne
	@JoinColumn(name="epreuve_fk")
	private Epreuve epreuve;
	
	@JsonView({JsonViews.Common.class, JsonViews.CompteWithReservation.class})
	@ManyToOne
	@JoinColumn(name="logement_fk")
	private Logement logement;
	
	@JsonView({JsonViews.Common.class, JsonViews.CompteWithReservation.class})
	private LocalDate dateDebut;
	
	@JsonView({JsonViews.Common.class, JsonViews.CompteWithReservation.class})
	private LocalDate dateFin;
	
	@Version
	protected int version;
	
	public Reservation() {
	}
	
	public Reservation(Compte compte, Logement logement) {
		this.compte = compte;
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


	public Logement getLogement() {
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


	public void setLogement(Logement logement) {
		this.logement = logement;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", statut=" + statut + ", date=" + date + ", heure=" + heure + ", compte="
				+ compte + ", epreuve=" + epreuve + ", logement=" + logement + "]";
	}
	
	
	
	

}
