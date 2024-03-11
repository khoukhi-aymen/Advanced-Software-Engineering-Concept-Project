package Pack;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	int id;
	String nom;
	String description;
	public Service() {super();}
	public Service(int i, String m,String desc) {id=i; nom=m;description = desc;}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String toString() {
		return "Service [id=" + id + ", nom=" + nom +", description=" + description + "]";
	}

}
