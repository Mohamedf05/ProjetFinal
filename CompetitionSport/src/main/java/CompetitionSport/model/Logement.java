package CompetitionSport.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Logement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	@Embedded
	private Adresse adresse;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Camping', 'Hotel', 'Villa', 'Village_Vacances')")
	private TypeLogement typeLogement;
	
	@Version
	protected int version;
	
	
	public Logement() {}

	public Logement(Integer id, String nom, Adresse adresse, TypeLogement typeLogement) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.typeLogement = typeLogement;
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

	public TypeLogement getTypeLogement() {
		return typeLogement;
	}

	public void setTypeLogement(TypeLogement typeLogement) {
		this.typeLogement = typeLogement;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Logement [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", typeLogement=" + typeLogement + "]";
	}
	
}
