package br.ifpe.pp2.entities;

import java.time.LocalDate;

public class Avaliacao {
	private Integer id;
	private double nota;
	private Alunos alunos;
	private Materias materias;
	private LocalDate data; 
	private Periodo periodo;
	
	
	public Avaliacao(Integer id, double nota, Alunos alunos, Materias materias, LocalDate data, Periodo periodo) {
		this.id = id;
		this.nota = nota;
		this.alunos = alunos;
		this.materias = materias;
		this.data = data;
		this.periodo = periodo;
	}
	
	public Avaliacao() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Alunos getAlunos() {
		return alunos;
	}
	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}
	public Materias getMaterias() {
		return materias;
	}
	public void setMaterias(Materias materias) {
		this.materias = materias;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	
}
