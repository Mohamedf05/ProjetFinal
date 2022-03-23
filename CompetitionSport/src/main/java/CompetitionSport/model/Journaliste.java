package CompetitionSport.model;

import javax.persistence.Entity;

@Entity
public class Journaliste extends Compte {
	
	private String entreprise;

	public Journaliste() {
	}
	
	public Journaliste(Integer id, String nom, String prenom, String mail, String password, String numero, String voie, String ville, String cp,
			String entreprise) {
		super(id, nom, prenom, mail, password, numero,voie,ville,cp);
		this.setEntreprise(entreprise);
	}
	
	public Journaliste(String nom, String prenom, String mail, String password, String numero, String voie, String ville, String cp,
			String entreprise) {
		super(nom, prenom, mail, password, numero,voie,ville,cp);
		this.setEntreprise(entreprise);
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	@Override
	public String toString() {
		return "Journaliste [entreprise=" + entreprise + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", mail=" + mail + ", password=" + password + ", adresse=" + adresse + "]";
	}

}
