package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="LOCAIS")
public class Locais implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCINEMA")
	private Cinemas cinemas;
	
	@Column(name="LOCAL", length=45)
	private String local;
	
	@Column(name="NUMSALAS")
	private int salas;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="locais")
	private Set<Filmes> filmes = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cinemas getCinemas() {
		return cinemas;
	}

	public void setCinemas(Cinemas cinemas) {
		this.cinemas = cinemas;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getSalas() {
		return salas;
	}

	public void setSalas(int salas) {
		this.salas = salas;
	}

	public Set<Filmes> getFilmes() {
		return filmes;
	}

	public void setFilmes(Set<Filmes> filmes) {
		this.filmes = filmes;
	}
}
