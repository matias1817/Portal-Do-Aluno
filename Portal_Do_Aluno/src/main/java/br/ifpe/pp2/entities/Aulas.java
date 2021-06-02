package br.ifpe.pp2.entities;

import java.time.LocalDate;

public class Aulas {
	private Integer id;
	private String material;
	private LocalDate data;
	private Materias materias;
	private Professores professores;
	
	
	public Aulas(Integer id, String material, LocalDate data, Materias materias, Professores professores) {
		this.id = id;
		this.material = material;
		this.data = data;
		this.materias = materias;
		this.professores = professores;
	}
	
	public Aulas() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Materias getMaterias() {
		return materias;
	}
	public void setMaterias(Materias materias) {
		this.materias = materias;
	}
	public Professores getProfessores() {
		return professores;
	}
	public void setProfessores(Professores professores) {
		this.professores = professores;
	}
	
	
	
	
	
}
