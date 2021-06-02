package br.ifpe.pp2.entities;

import java.util.List;

public class Professores {
	private Integer id;
	private String email;
	private String senha;
	private String nome;
	private List<Aulas> aulas;
	private List<Materias> materias;
	private List<HorarioP> horarioP;
	
	
	public Professores(Integer id, String email, String senha, String nome, List<Aulas> aulas, List<Materias> materias,
			List<HorarioP> horarioP) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.aulas = aulas;
		this.materias = materias;
		this.horarioP = horarioP;
	}

	public Professores() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aulas> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aulas> aulas) {
		this.aulas = aulas;
	}

	public List<Materias> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}

	public List<HorarioP> getHorarioP() {
		return horarioP;
	}

	public void setHorarioP(List<HorarioP> horarioP) {
		this.horarioP = horarioP;
	}
	
}
