package plane.flight.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Avion {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String constructeur;
	private String model;
	private Integer capacite;
	private String site;
	
	public Avion() {}

	public Avion(Integer id, String constructeur, String model, Integer capacite, String site) {
		super();
		this.id = id;
		this.constructeur = constructeur;
		this.model = model;
		this.capacite = capacite;
		this.site = site;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	
	
}
