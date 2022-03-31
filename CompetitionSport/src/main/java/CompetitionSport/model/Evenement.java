package CompetitionSport.model;

import java.time.LocalDate;

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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Integer id;
	
	@JsonView(JsonViews.Common.class)
	private String nom;
	
	@Column(name="date_debut")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(JsonViews.Common.class)
	private LocalDate dateDebut;
	
	@Column(name="date_fin")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(JsonViews.Common.class)
	private LocalDate dateFin;
	
	@JsonView(JsonViews.Common.class)
	private String ville;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('A_Venir','En_Cours','Termine')")
	@JsonView(JsonViews.Common.class)
	private Statut statut;
	
	@ManyToOne
	@JoinColumn(name="id_organisateur")
	@JsonView(JsonViews.EvenementWithOrganisateur.class)
	private Organisateur organisateur;
	
	@Version
	protected int version;
	
	public Evenement (){}
	
	public Evenement(Integer id, String nom, LocalDate dateDebut, LocalDate dateFin, String ville, Statut statut) {
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.ville = ville;
		this.statut = statut;
	}

	public Evenement(String nom, LocalDate dateDebut, LocalDate dateFin, String ville, Statut statut) {
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

	public Statut isStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	
	public Organisateur getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Evenement [id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", ville="
				+ ville + ", statut=" + statut + "]";
	}

	
	
}
