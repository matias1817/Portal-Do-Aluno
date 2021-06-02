package br.ifpe.pp2.entities;

import java.util.List;

public class Periodo {
	private Integer id;
	private String periodo;
	private List<Avaliacao> avaliacao;
	private List<Frequencia> frequencia;
	private List<Materias> materias;
	private List<HorarioA> horarioA;
	private List<HorarioP> horarioP;
	
	public Periodo(Integer id, String periodo, List<Avaliacao> avaliacao, List<Frequencia> frequencia,
			List<Materias> materias, List<HorarioA> horarioA, List<HorarioP> horarioP) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.avaliacao = avaliacao;
		this.frequencia = frequencia;
		this.materias = materias;
		this.horarioA = horarioA;
		this.horarioP = horarioP;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
	public List<Frequencia> getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(List<Frequencia> frequencia) {
		this.frequencia = frequencia;
	}
	public List<Materias> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
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
	
	
}
