package br.ifpe.pp2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frequencia {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer faltas;
	private Alunos alunos;
	private Materias materias;
	private Periodo periodo;
	
	
	public Frequencia(Integer id, Integer faltas, Alunos alunos, Materias materias, Periodo periodo) {
		this.id = id;
		this.faltas = faltas;
		this.alunos = alunos;
		this.materias = materias;
		this.periodo = periodo;
	}
	
	public Frequencia() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFaltas() {
		return faltas;
	}
	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
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

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	
}
