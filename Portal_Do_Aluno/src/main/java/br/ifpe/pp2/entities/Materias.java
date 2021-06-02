package br.ifpe.pp2.entities;

import java.util.List;

public class Materias {
	private Integer id;
	private String nome;
	private Professores professores;
	private Curso curso;
	private List<Aulas> aulas;
	private List<HorarioA> horarioA;
	private List<HorarioP> horarioP;
	private List<Frequencia> frequencia;
	private List<Avaliacao> avaliacao;
	
	
	
	public Materias(Integer id, String nome, Professores professores, Curso curso, List<Aulas> aulas,
			List<HorarioA> horarioA, List<HorarioP> horarioP, List<Frequencia> frequencia, List<Avaliacao> avaliacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.professores = professores;
		this.curso = curso;
		this.aulas = aulas;
		this.horarioA = horarioA;
		this.horarioP = horarioP;
		this.frequencia = frequencia;
		this.avaliacao = avaliacao;
	}

	public Materias() {
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
	public Professores getProfessores() {
		return professores;
	}
	public void setProfessores(Professores professores) {
		this.professores = professores;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Aulas> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aulas> aulas) {
		this.aulas = aulas;
	}

	public List<HorarioA> getHorarioA() {
		return horarioA;
	}

	public void setHorarioA(List<HorarioA> horarioA) {
		this.horarioA = horarioA;
	}

	public List<HorarioP> getHorarioP() {
		return horarioP;
	}

	public void setHorarioP(List<HorarioP> horarioP) {
		this.horarioP = horarioP;
	}

	public List<Frequencia> getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(List<Frequencia> frequencia) {
		this.frequencia = frequencia;
	}

	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
}
