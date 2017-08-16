package schoolboard.metier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Utilisateur {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	
	@OneToOne
	@JoinColumn(name="id_Utilisateur_Login", referencedColumnName="id")
	private Login login;
	
	
	
	public Login getLogin() {
		return login;
	}




	public void setLogin(Login login) {
		this.login = login;
	}











	@Column(name="Numero_de_telephone")
	private String numeroTel;
	
	@Column
	private String email;
	
	
	
	@OneToOne(mappedBy= "user")
	private Adresse adresse;
	
	@JoinColumn(name="id_etablissement", referencedColumnName="id")
	@ManyToOne
	private Etablissement etablissement;
	
	
	
	public Adresse getAdresse() {
		return adresse;
	}




	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}




	public Etablissement getEtablissement() {
		return etablissement;
	}




	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}




	public Utilisateur(String nom, String prenom,  String numeroTel, String email, 
			Adresse adresse, Etablissement etablissement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		
		this.numeroTel = numeroTel;
		this.email = email;
		
		this.adresse = adresse;
		this.etablissement = etablissement;
		
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	






	@Version
	private int version;




	@Autowired
	public Utilisateur() {
	}



	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
