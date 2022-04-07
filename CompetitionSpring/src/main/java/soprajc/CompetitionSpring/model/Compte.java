package soprajc.CompetitionSpring.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Compte implements UserDetails {

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
	@Column(unique=true)
	@JsonView(JsonViews.Common.class)
	protected String mail;
	
	@NotEmpty
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		GrantedAuthority authority = null;
		if (getClass().getSimpleName().equals("Athlete")) {
			authority = new SimpleGrantedAuthority("ROLE_ATHLETE");
		}	else if (getClass().getSimpleName().equals("Journaliste")) {
			authority = new SimpleGrantedAuthority("ROLE_JOURNALISTE");
		}	else if (getClass().getSimpleName().equals("Organisateur")) {
			authority = new SimpleGrantedAuthority("ROLE_ORGANISATEUR");
		}	else if (getClass().getSimpleName().equals("Spectateur")) {
			authority = new SimpleGrantedAuthority("ROLE_SPECTATEUR");
		}
		return Arrays.asList(authority);
	}
	
	@Override
	public String getUsername() {
		return mail;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}

