package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Epreuve {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private  int maxParticipant;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	@Enumerated
	@Column(columnDefinition = "Enum('Athletisme', 'Baseball', 'Basketball', 'Boxe', 'Cyclisme', 'Equitation', 'Handball', 'Football', 'Judo', 'Natation', 'Skate', 'Tennis')")
	private Discipline discipline;
	@ManyToMany
	private List<Athlete> participants;
	@OneToMany(mappedBy = "epreuve")
	private List<Reservation> reservations;
	private transient Score score;
	@Enumerated
	@Column(columnDefinition = "Enum('Courts', 'Dojo', 'Gymnase', 'Hippodrome', 'Piscine', 'Piste', 'Skatepark', 'Stade', 'Velodrome')")
	private TypeTerrain terrain;
	
	public Epreuve() {}
	
	public Epreuve(Integer id, int maxParticipant, LocalDate dateDebut, LocalDate dateFin, Discipline discipline,
			 Score score, TypeTerrain terrain) {
		this.id = id;
		this.maxParticipant = maxParticipant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.discipline = discipline;
		this.score = score;
		this.terrain = terrain;
	}

	public Epreuve(int maxParticipant, LocalDate dateDebut, LocalDate dateFin, Discipline discipline,
			 TypeTerrain terrain) {
		this.maxParticipant = maxParticipant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.discipline = discipline;
		this.terrain = terrain;
	}
	
	
	public void confirmer()
	{
		
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


	public List<Reservation> getReservations() {
		return reservations;
	}


	public Score getScore() {
		return score;
	}


	public TypeTerrain getTerrain() {
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

	public void setScore(Score score) {
		this.score = score;
	}


	public void setTerrain(TypeTerrain terrain) {
		this.terrain = terrain;
	}

	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Epreuve [id=" + id + ", maxParticipant=" + maxParticipant + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", discipline=" + discipline + ", participants=" + participants + ", terrain=" + terrain
				+ "]";
	}

}
