package plane.flight.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pilote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String nom;
	private String site;
	
	public Pilote() {}
	
	public Pilote (Integer id, String nom, String site) {
		this.id = id;
		this.nom = nom;
		this.site = site;
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getNom() { return nom; }

	public void setNom(String nom) { this.nom = nom; }

	public String getSite() { return site; }

	public void setSite(String site) { this.site = site; }
	
	
	
}
