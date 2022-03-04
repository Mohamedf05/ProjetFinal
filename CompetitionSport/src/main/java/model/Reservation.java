package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
	private Integer id;
	private Statut statut;
	private LocalDate date;
	private LocalTime heure;
	private Client client;
	private Epreuve epreuve;
	private Logement logement;
	
	
	public Reservation(Client client, Epreuve epreuve, Logement logement) {
		this.client = client;
		this.epreuve = epreuve;
		this.logement = logement;
		this.statut=Statut.A_Venir;
		this.date=LocalDate.now();
		this.heure=LocalTime.now();
	}
	

	public Reservation(Client client, Epreuve epreuve) {
		this.client = client;
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


	public Client getClient() {
		return client;
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


	public void setClient(Client client) {
		this.client = client;
	}


	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}


	public void setLogement(Logement logement) {
		this.logement = logement;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", statut=" + statut + ", date=" + date + ", heure=" + heure + ", client="
				+ client + ", epreuve=" + epreuve + ", logement=" + logement + "]";
	}
	
	
	
	

}
