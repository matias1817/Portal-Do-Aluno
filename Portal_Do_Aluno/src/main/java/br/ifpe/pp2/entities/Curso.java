package br.ifpe.pp2.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany
	private List<Materias> materias;
	
	@OneToMany
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
