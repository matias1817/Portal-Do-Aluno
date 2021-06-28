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
	
	@OneToMany//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@Fetch(FetchMode.SUBSELECT)
	private List<Materias> materias;
	
	@OneToMany//( orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@Fetch(FetchMode.SUBSELECT)
	private List<Alunos> alunos;
	
	public List<Materias> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}
	
	public Curso(Integer id, String nome, List<Materias> materias, List<Alunos> alunos) {
		this.id = id;
		this.nome = nome;
		this.materias = materias;
		this.alunos = alunos;
	}
	public Curso() {
		
	}
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
	public List<Alunos> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
	}
	

}
