package CompetitionSport.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@JsonView(JsonViews.Common.class)
	protected Integer id;
	
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	protected String nom;
	
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	protected String prenom;
	
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	protected String mail;
	
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	protected String password;
	
	@Embedded
	@JsonView(JsonViews.Common.class)
	protected Adresse adresse;
	
	@OneToMany(mappedBy = "compte")
	@JsonView(JsonViews.CompteWithReservation.class)
	protected List<Reservation> reservations;
	
	@Version
	protected int version;
	
	public Compte() {
	}
	
	public Compte(Integer id, String nom, String prenom, String mail, String password, String numero, String voie, String ville, String cp) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.adresse = new Adresse(numero,voie,ville,cp);
	}

	public Compte(String nom, String prenom, String mail, String password, String numero, String voie, String ville, String cp) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.adresse = new Adresse(numero,voie,ville,cp);
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Reservation> getReservations() {
		return reservations;
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
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", password=" + password
				+ ", adresse=" + adresse + "]";
	}
	
}

