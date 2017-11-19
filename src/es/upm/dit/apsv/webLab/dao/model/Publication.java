package es.upm.dit.apsv.webLab.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.*;


@Entity
public class Publication implements Serializable {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String title;
	private int citeCount;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Collection<Researcher> researchers;
	
	public Publication(){	
	}
	
	public Publication (String id, Object title, int citeCount, Collection<Researcher> researchers) {
		this.id=id;
		this.title=(String)title;
		this.citeCount=citeCount;
		this.researchers=researchers;
	}

	

	public Publication(String id, Object title, Integer citeCount) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.title=(String)title;
		this.citeCount=citeCount;
		this.researchers=new ArrayList();
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", citeCount=" + citeCount + ", researchers="
				+ researchers + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCiteCount() {
		return citeCount;
	}

	public void setCiteCount(int citeCount) {
		this.citeCount = citeCount;
	}

	public Collection<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(Collection<Researcher> researchers) {
		this.researchers = researchers;
	}

	public Collection<Researcher> getAuthors() {
		// TODO Auto-generated method stub
		
		return researchers;
	}

}
