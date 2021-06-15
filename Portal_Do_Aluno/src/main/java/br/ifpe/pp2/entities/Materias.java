package br.ifpe.pp2.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materias {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Professores professores;
	private Curso curso;
	private Periodo periodo;
	private String horario;
	private List<Aulas> aulas;
	private List<Frequencia> frequencia;
	private List<Avaliacao> avaliacao;
	
	public Materias(Integer id, String nome, Professores professores, Curso curso, Periodo periodo, String horario,
			List<Aulas> aulas, List<Frequencia> frequencia, List<Avaliacao> avaliacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.professores = professores;
		this.curso = curso;
		this.periodo = periodo;
		this.horario = horario;
		this.aulas = aulas;
		this.frequencia = frequencia;
		this.avaliacao = avaliacao;
	}

	public Materias() {
		super();
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

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Aulas> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aulas> aulas) {
		this.aulas = aulas;
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
