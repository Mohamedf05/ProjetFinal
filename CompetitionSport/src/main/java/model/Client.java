package model;

public abstract class Client {

	protected Integer id;
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String password;
	protected Adresse adresse;
	
	public Client(Integer id, String nom, String prenom, String mail, String password, Adresse adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.adresse = adresse;
	}

	public Client(String nom, String prenom, String mail, String password, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.adresse = adresse;
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
		prenom = prenom;
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
	
	
}

