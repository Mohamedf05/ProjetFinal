package CompetitionSport.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

@Entity
public class Terrain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	private String nom;
	@Embedded
	@NotEmpty
	private Adresse adresse;
	@ElementCollection()
	@Enumerated(EnumType.STRING)
	private List<Discipline> disciplines;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Courts', 'Dojo', 'Gymnase', 'Hippodrome', 'Piscine', 'Piste', 'Skatepark', 'Stade', 'Velodrome')")
	@NotEmpty
	private TypeTerrain typeTerrain;
	
	@Version
	protected int version;
	
	
	public Terrain() {
	}

	public Terrain(Integer id, String nom, Adresse adresse, TypeTerrain typeTerrain) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.typeTerrain = typeTerrain;
	}

	public Terrain(Integer id, String nom, Adresse adresse, List<Discipline> disciplines, TypeTerrain typeTerrain) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.disciplines = disciplines;
		this.typeTerrain = typeTerrain;
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



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



	public List<Discipline> getDisciplines() {
		return disciplines;
	}



	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}



	public TypeTerrain getTypeTerrain() {
		return typeTerrain;
	}



	public void setTypeTerrain(TypeTerrain typeTerrain) {
		this.typeTerrain = typeTerrain;
	}


	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public String toString() {
		return "Terrain [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", disciplines=" + disciplines
				+ ", typeTerrain=" + typeTerrain + "]";
	}

	
}
