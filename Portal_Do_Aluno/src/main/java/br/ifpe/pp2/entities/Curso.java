package br.ifpe.pp2.entities;

import java.util.List;

public class Curso {
	private Integer id;
	private String nome;
	private List<Materias> materias;
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
