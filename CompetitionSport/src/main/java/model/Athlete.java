package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Athlete extends Client {
	
	private LocalDate dateNaissance;
	
	@ManyToMany(mappedBy = "participants")
	private List<Epreuve> epreuves;

	public Athlete() {
	}
	
	public Athlete(Integer id, String nom, String prenom, String mail, String password, Adresse adresse,
			LocalDate dateNaissance) {
		super(id, nom, prenom, mail, password, adresse);
		this.setDateNaissance(dateNaissance);
	}
	
	public Athlete(String nom, String prenom, String mail, String password, Adresse adresse,
			LocalDate dateNaissance) {
		super(nom, prenom, mail, password, adresse);
		this.setDateNaissance(dateNaissance);
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Epreuve> getEpreuves() {
		return epreuves;
	}

	public void setEpreuves(List<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}
	
	@Override
	public String toString() {
		return "Athlete [dateNaissance=" + dateNaissance + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", mail=" + mail + ", password=" + password + ", adresse=" + adresse + "]";
	}
	
}
