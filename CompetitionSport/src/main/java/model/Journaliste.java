package model;

public class Journaliste extends Client {
	
	private String entreprise;

	public Journaliste(Integer id, String nom, String prenom, String mail, String password, Adresse adresse,
			String entreprise) {
		super(id, nom, prenom, mail, password, adresse);
		this.setEntreprise(entreprise);
	}
	
	public Journaliste(String nom, String prenom, String mail, String password, Adresse adresse,
			String entreprise) {
		super(nom, prenom, mail, password, adresse);
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
