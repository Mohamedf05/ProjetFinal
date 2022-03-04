package model;

import java.time.LocalDate;
import java.util.List;

public class Epreuve {
	private Integer id;
	private  int maxParticipant;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Discipline discipline;
	private List<Athlete> participants;
	private List<Reservation> reservations;
	private Score score;
	private Terrain terrain;
	
	public Epreuve(Integer id, int maxParticipant, LocalDate dateDebut, LocalDate dateFin, Discipline discipline,
			List<Athlete> participants, Score score, Terrain terrain) {
		this.id = id;
		this.maxParticipant = maxParticipant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.discipline = discipline;
		this.participants = participants;
		this.score = score;
		this.terrain = terrain;
	}

	public Epreuve(int maxParticipant, LocalDate dateDebut, LocalDate dateFin, Discipline discipline,
			List<Athlete> participants, Terrain terrain) {
		this.maxParticipant = maxParticipant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.discipline = discipline;
		this.participants = participants;
		this.terrain = terrain;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getMaxParticipant() {
		return maxParticipant;
	}


	public LocalDate getDateDebut() {
		return dateDebut;
	}


	public LocalDate getDateFin() {
		return dateFin;
	}


	public Discipline getDiscipline() {
		return discipline;
	}


	public List<Athlete> getParticipants() {
		return participants;
	}


	public List<reservation> getReservations() {
		return reservations;
	}


	public Score getScore() {
		return score;
	}


	public Terrain getTerrain() {
		return terrain;
	}


	public void setMaxParticipant(int maxParticipant) {
		this.maxParticipant = maxParticipant;
	}


	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}


	public void setParticipants(List<Athlete> participants) {
		this.participants = participants;
	}


	public void setReservations(List<reservation> reservations) {
		this.reservations = reservations;
	}


	public void setScore(Score score) {
		this.score = score;
	}


	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	@Override
	public String toString() {
		return "Epreuve [id=" + id + ", maxParticipant=" + maxParticipant + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", discipline=" + discipline + ", participants=" + participants + ", terrain=" + terrain
				+ "]";
	}

}
