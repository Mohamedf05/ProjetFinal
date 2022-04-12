package soprajc.CompetitionSpring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Journaliste extends Compte {
	
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private String entreprise;
	@OneToMany(mappedBy = "journaliste")
	private List<Article> articles;

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
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Journaliste [entreprise=" + entreprise + ", articles=" + articles + ", id=" + id + ", nom=" + nom
				+ ", prenom=" + prenom + ", mail=" + mail + ", password=" + password + ", adresse=" + adresse
				+ ", reservations=" + reservations + "]";
	}



}
