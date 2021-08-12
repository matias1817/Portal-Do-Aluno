package br.ifpe.pp2.entities;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;

@Entity
public class Curso {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String duracao;

	
	@OneToMany//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@Fetch(FetchMode.SUBSELECT)
	private List<Materias> materias;
	
	@OneToMany//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@Fetch(FetchMode.SUBSELECT)
	private List<Alunos> alunos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Materias> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}

	public List<Alunos> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
	}

	public Curso(Integer id, String nome, String duracao, List<Materias> materias, List<Alunos> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
		this.materias = materias;
		this.alunos = alunos;
	}

	public Curso() {
		super();
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	
}
