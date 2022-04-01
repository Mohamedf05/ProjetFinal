package CompetitionSport.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Epreuve {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	@NotEmpty
	private Integer id;
	
	@NotEmpty
	@ManyToOne
	@JsonView(JsonViews.Common.class)
	@JoinColumn(name="evenement_fk")
	private Evenement evenement;
	
	@JsonView(JsonViews.Common.class)
	@NotEmpty
	private  int maxParticipant;
	
	@JsonView(JsonViews.Common.class)
	@NotEmpty
	private LocalDate date;
	
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "Enum('Athletisme', 'Baseball', 'Basketball', 'Boxe', 'Cyclisme', 'Equitation', 'Handball', 'Football', 'Judo', 'Natation', 'Skate', 'Tennis')")
	private Discipline discipline;
	
	@JsonView(JsonViews.EpreuveWithAthlete.class)
	@ManyToMany
	private List<Athlete> participants;
	
	@OneToMany(mappedBy = "epreuve")
	@JsonView(JsonViews.EpreuveWithReservation.class)
	private List<Reservation> reservations;
	
	private transient Score score;

	@JsonView(JsonViews.Common.class)
	@OneToOne
	private Terrain terrain;
	
	@Version
	protected int version;
	
	public Epreuve() {}
	
	public Epreuve(Integer id,Evenement evenement, int maxParticipant, LocalDate date, Discipline discipline,
			 Score score) {
		this.id = id;
		this.evenement=evenement;
		this.maxParticipant = maxParticipant;
		this.date = date;
		this.discipline = discipline;
		this.score = score;
	}

	public Epreuve(Evenement evenement,int maxParticipant, LocalDate date, Discipline discipline) {
		this.evenement=evenement;
		this.maxParticipant = maxParticipant;
		this.date = date;
		this.discipline = discipline;
	}
	
	
/* 	public void confirmer()
	{
		
	} */
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getMaxParticipant() {
		return maxParticipant;
	}


	public LocalDate getDate() {
		return date;
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


	public Terrain getTerrain() {
		return terrain;
	}


	public void setMaxParticipant(int maxParticipant) {
		this.maxParticipant = maxParticipant;
	}


	public void setDate(LocalDate date) {
		this.date = date;
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


	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Epreuve [id=" + id + ", maxParticipant=" + maxParticipant + ", date=" + date
				 + ", discipline=" + discipline + ", participants=" + participants + ", terrain=" + terrain
				+ "]";
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

}
