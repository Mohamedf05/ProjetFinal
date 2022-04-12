package soprajc.CompetitionSpring.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private String titre;
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private String corps;
	@JsonView(JsonViews.Common.class)
	private String image;
	@JsonView(JsonViews.Common.class)
	private LocalDate date;
	@ManyToOne
	@JsonView(JsonViews.Common.class)
	private Journaliste journaliste;
	
	@Version
	protected int version;
	
	public Article() {
		
	}
	
	public Article(String titre, String corps, String image, LocalDate date, Journaliste journaliste) {
		super();
		this.titre = titre;
		this.corps = corps;
		this.image = image;
		this.date = LocalDate.now();
		this.journaliste = journaliste;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Journaliste getJournaliste() {
		return journaliste;
	}

	public void setJournaliste(Journaliste journaliste) {
		this.journaliste = journaliste;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
}
