package CompetitionSport.model;

import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Terrain {

	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(JsonViews.Common.class)
	@NotEmpty
	private String nom;
	@Embedded
	@JsonView(JsonViews.Common.class)
	@NotNull
	private Adresse adresse;
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Discipline.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "terrain_discipline", foreignKey = @ForeignKey(name = "terrain_discipline_terrain_id_fk"))
	@Column(columnDefinition = "ENUM('Athletisme', 'Baseball', 'Basketball', 'Boxe', 'Cyclisme', 'Equitation', 'Handball', 'Football', 'Judo', 'Natation', 'Skate', 'Tennis')")
	@NotNull
	private Set<Discipline> disciplines;
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Courts', 'Dojo', 'Gymnase', 'Hippodrome', 'Piscine', 'Piste', 'Skatepark', 'Stade', 'Velodrome')")
	@NotNull
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

	public Terrain(Integer id, String nom, Adresse adresse, Set<Discipline> disciplines, TypeTerrain typeTerrain) {
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



	public Set<Discipline> getDisciplines() {
		return disciplines;
	}



	public void setDisciplines(Set<Discipline> disciplines) {
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
