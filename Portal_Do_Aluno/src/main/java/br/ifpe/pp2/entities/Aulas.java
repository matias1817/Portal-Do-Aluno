package br.ifpe.pp2.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aulas {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String material;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
