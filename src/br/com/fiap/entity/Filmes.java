package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="FILMES")
public class Filmes implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDLOCAL")
	private Locais locais;
	
	@Column(name="DURACAO")
	private double duracao;
	
	@Column(name="NUMEROSALA")
	private int numSala;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Locais getLocais() {
		return locais;
	}

	public void setLocais(Locais locais) {
		this.locais = locais;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}
}
