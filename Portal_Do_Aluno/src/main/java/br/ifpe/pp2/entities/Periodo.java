package br.ifpe.pp2.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Periodo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String periodo;
	
	//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OneToMany			//@Fetch(FetchMode.SUBSELECT)
	private List<Avaliacao> avaliacao;
	
	//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OneToMany			//@Fetch(FetchMode.SUBSELECT)
	private List<Frequencia> frequencia;
	
		//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OneToMany			//@Fetch(FetchMode.SUBSELECT)
	private List<Materias> materias;
	
	public Periodo(String periodo) {
		super();
		this.periodo = periodo;
	
	}
	
	public Periodo() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
	public List<Frequencia> getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(List<Frequencia> frequencia) {
		this.frequencia = frequencia;
	}
	public List<Materias> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}
	
	
}
