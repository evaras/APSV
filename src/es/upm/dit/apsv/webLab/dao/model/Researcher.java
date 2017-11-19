/**
 * 
 */
package es.upm.dit.apsv.webLab.dao.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import sun.security.util.Password;

/**
 * @author evara
 *
 */

@Entity

public class Researcher implements Serializable {
	@Id 
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String name;
	private String email;
	private String affiliation;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="researchers", cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	private Collection<Publication> publications;
	
	public Researcher() {
	}
	
	public Researcher (String id, String name, String email, String affiliation, String password, Collection<Publication> publications) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.affiliation=affiliation;
		this.password=password;
		this.publications=publications;
	}

	public Researcher(String id, String name, String email, String affiliation, String password) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.affiliation=affiliation;
		this.password=password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Collection<Publication> publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return "Researcher [id=" + id + ", name=" + name + ", email=" + email + ", affiliation=" + affiliation
				+ ", password=" + password + ", publications=" + publications + "]";
	}
	

}
